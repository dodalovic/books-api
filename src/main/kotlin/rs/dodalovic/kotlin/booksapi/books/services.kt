package rs.dodalovic.kotlin.booksapi.books

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class BooksService(
    private val booksRepo: BooksRepo,
    private val authorsRepo: AuthorsRepo
) {
    fun getAllBooks() = booksRepo.findAll().map {
        val author = authorsRepo.findByIdOrNull(it.authorId) ?: error("Author ${it.authorId} must be there!")
        BookDTO(it.id!!, it.name, AuthorDTO(author.id!!, author.name))
    }.toList()

    fun getBook(bookId: String) = booksRepo.findByIdOrNull(bookId)?.let {
        val author = authorsRepo.findByIdOrNull(it.authorId) ?: error("Author ${it.authorId} must be there!")
        BookDTO(it.id!!, it.name, AuthorDTO(author.id!!, author.name))
    }

    fun insertBook(newBook: NewBook) =
        with(booksRepo.save(Book(name = newBook.name, authorId = newBook.authorId))) {
            val author =
                authorsRepo.findByIdOrNull(newBook.authorId) ?: error("Author ${newBook.authorId} must be there!")
            BookDTO(id = id!!, name = name, author = AuthorDTO(author.id!!, author.name))
        }
}

@Service
class AuthorsService(
    private val authorsRepo: AuthorsRepo
) {
    fun getAllAuthors() = authorsRepo.findAll().map { AuthorDTO(it.id!!, it.name) }.toList()
    fun getAuthor(authorId: String) = authorsRepo.findByIdOrNull(authorId)?.let { AuthorDTO(it.id!!, it.name) }
    fun insertAuthor(newAuthor: NewAuthor) =
        with(authorsRepo.save(Author(name = newAuthor.name))) { AuthorDTO(id!!, name) }
}

