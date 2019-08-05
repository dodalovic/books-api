package rs.dodalovic.kotlin.booksapi.books

import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/books")
class BooksController(private val booksService: BooksService) {
    @PostMapping
    fun newBook(@Valid @RequestBody newBook: NewBook) = booksService.insertBook(newBook)

    @GetMapping
    fun getAllBooks() = booksService.getAllBooks()

    @GetMapping("/{bookId}")
    fun getBook(@PathVariable bookId: String) = booksService.getBook(bookId)
}

@RestController
@RequestMapping("/authors")
class AuthorsControllers(private val authorsService: AuthorsService) {
    @PostMapping
    fun newAuthor(@Valid @RequestBody newAuthor: NewAuthor): AuthorDTO = authorsService.insertAuthor(newAuthor)

    @GetMapping
    fun getAllAuthors() = authorsService.getAllAuthors()

    @GetMapping("/{authorId}")
    fun getBook(@PathVariable authorId: String) = authorsService.getAuthor(authorId)
}