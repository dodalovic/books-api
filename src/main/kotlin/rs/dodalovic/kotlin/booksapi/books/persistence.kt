package rs.dodalovic.kotlin.booksapi.books

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Document("books")
class Book(@Id val id: String? = null, val name: String, val authorId: String)

@Document("authors")
class Author(@Id val id: String? = null, val name: String)

@Repository
interface BooksRepo : PagingAndSortingRepository<Book, String>

@Repository
interface AuthorsRepo : PagingAndSortingRepository<Author, String>