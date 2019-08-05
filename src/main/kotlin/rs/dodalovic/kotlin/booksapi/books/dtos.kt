package rs.dodalovic.kotlin.booksapi.books

data class NewAuthor(val name: String)
data class AuthorDTO(val id: String, val name: String)
data class NewBook(val name: String, val authorId: String)
data class BookDTO(val id: String, val name: String, val author: AuthorDTO)