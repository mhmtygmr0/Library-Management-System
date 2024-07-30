# Publisher Endpoint

| Method | URL                                         | Description                                             |
|--------|---------------------------------------------|---------------------------------------------------------|
| GET    | /v1/publishers/{id}                         | Returns all publishers.                                 |
| GET    | /v1/publishers?page={id}&pageSize={pageSizeId} | Returns publishers based on page id and page size.   |
| PUT    | /v1/publishers                              | Updates publisher information.                          |
| POST   | /v1/publishers                              | Creates a new publisher.                                |
| DELETE | /v1/publishers/{id}                         | Deletes information for the publisher with the specified ID. |

# Category Endpoint

| Method | URL                                         | Description                                             |
|--------|---------------------------------------------|---------------------------------------------------------|
| GET    | /v1/categories/{id}                         | Retrieves all categories.                               |
| GET    | /v1/categories?page={id}&pageSize={pageSizeId} | Retrieves categories based on page id and page size. |
| PUT    | /v1/categories                              | Updates category information.                           |
| POST   | /v1/categories                              | Creates a new category.                                 |
| DELETE | /v1/categories/{id}                         | Deletes the specified category with the given ID.       |

# Book Endpoint

| Method | URL                                         | Description                                             |
|--------|---------------------------------------------|---------------------------------------------------------|
| GET    | /v1/books/{id}                              | Returns all books.                                      |
| GET    | /v1/books?page={id}&pageSize={pageSizeId}   | Returns books based on page id and page size.           |
| PUT    | /v1/books                                   | Updates book information.                               |
| POST   | /v1/books                                   | Creates a new book.                                     |
| DELETE | /v1/books/{id}                              | Deletes the specified book with the given ID.           |

# Author Endpoint

| Method | URL                                         | Description                                             |
|--------|---------------------------------------------|---------------------------------------------------------|
| GET    | /v1/authors/{id}                            | Retrieves all authors.                                  |
| GET    | /v1/authors?page={id}&pageSize={pageSizeId} | Retrieves authors based on page id and page size.       |
| PUT    | /v1/authors                                 | Updates author information.                             |
| POST   | /v1/authors                                 | Creates a new author.                                   |
| DELETE | /v1/authors/{id}                            | Deletes information for the author with the specified ID. |

# Book-Borrowing Endpoint

| Method | URL                                         | Description                                             |
|--------|---------------------------------------------|---------------------------------------------------------|
| GET    | /v1/book-borrowings/{id}                    | Lists all books borrowed by users.                      |
| GET    | /v1/book-borrowings?page={id}&pageSize={pageSizeId} | Lists books borrowed by users based on page id and page size. |
| PUT    | /v1/book-borrowings                         | Updates the status of the specified borrowing transaction. |
| POST   | /v1/book-borrowings                         | Requests the borrowing of a specific book by a user.    |
| DELETE | /v1/book-borrowings/{id}                    | Cancels the borrowing transaction with the specified ID. |
