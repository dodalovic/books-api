package rs.dodalovic.kotlin.booksapi.books

import mu.KotlinLogging
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

private val log = KotlinLogging.logger {}

@Service
class BooksService(private val booksRepo: BooksRepo, private val authorsRepo: AuthorsRepo) {
    fun getAllBooks() = booksRepo.findAll().map {
        val author = authorsRepo.findByIdOrNull(it.authorId) ?: error("Author ${it.authorId} must be there!")
        BookDTO(it.id!!, it.name, AuthorDTO(author.id!!, author.name))
    }.toList().also { log.info { "Total books: ${it.size}" } }

    fun getBook(bookId: String) = booksRepo.findByIdOrNull(bookId)?.let {
        val author = authorsRepo.findByIdOrNull(it.authorId) ?: error("Author ${it.authorId} must be there!")
        BookDTO(it.id!!, it.name, AuthorDTO(author.id!!, author.name)).also { log.info { "Returning book $it" } }
    }

    fun insertBook(newBook: NewBook) =
        with(booksRepo.save(Book(name = newBook.name, authorId = newBook.authorId))) {
            val author =
                authorsRepo.findByIdOrNull(newBook.authorId) ?: error("Author ${newBook.authorId} must be there!")
            BookDTO(
                id = id!!,
                name = name,
                author = AuthorDTO(author.id!!, author.name)
            ).also { log.info { "Book successfully inserted!" } }
        }
}

@Service
class AuthorsService(private val authorsRepo: AuthorsRepo) {
    fun getAllAuthors() =
        authorsRepo.findAll().map {
            AuthorDTO(
                it.id!!,
                it.name
            )
        }.toList().also { log.info { "Total authors: ${it.size}" } }

    fun getAuthor(authorId: String) =
        authorsRepo.findByIdOrNull(authorId)?.let {
            AuthorDTO(
                it.id!!,
                it.name
            ).also { log.info { "Returning author $it" } }
        }

    fun insertAuthor(newAuthor: NewAuthor) =
        with(authorsRepo.save(Author(name = newAuthor.name))) { AuthorDTO(id!!, name) }
}

