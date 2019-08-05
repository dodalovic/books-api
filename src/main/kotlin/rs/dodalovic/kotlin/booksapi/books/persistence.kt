package rs.dodalovic.kotlin.booksapi.books

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Document("books")
class Book(@Id var id: String? = null, val name: String, val authorId: String)

@Document("authors")
class Author(@Id var id: String? = null, val name: String)

@Repository
interface BooksRepo : CrudRepository<Book, String>

@Repository
interface AuthorsRepo : CrudRepository<Author, String>