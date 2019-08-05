package rs.dodalovic.kotlin.booksapi.books

class NewAuthor(val name: String)
class AuthorDTO(val id: String, val name: String)
class NewBook(val name: String, val authorId: String)
class BookDTO(val id: String, val name: String, author: AuthorDTO)