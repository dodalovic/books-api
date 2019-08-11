package rs.dodalovic.kotlin.booksapi.books

import javax.validation.constraints.Size

data class NewAuthor(@field:Size(min = 3) val name: String)
data class AuthorDTO(val id: String, val name: String)
data class NewBook(@field:Size(min = 3) val name: String, val authorId: String)
data class BookDTO(val id: String, val name: String, val author: AuthorDTO)