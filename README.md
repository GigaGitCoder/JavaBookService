<div align="center">
  
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Docker](https://img.shields.io/badge/docker-%232496ED.svg?style=for-the-badge&logo=docker&logoColor=white)

[![License](https://img.shields.io/badge/license-GNU%20GPL%20v3.0-brightgreen)](LICENSE) ![Stars](https://img.shields.io/github/stars/GigaGitCoder/JavaBookService)
</div>

JavaBookService is a microservice for managing books in library projects. The service provides a REST API for performing CRUD operations (Create, Read, Update, Delete) on books.

## Service Ports

| Service | Port |
|---------|------|
| Books Service API | 8090 |
| PostgreSQL Database | 5432 |

## API Endpoints

**Base URL:** `http://localhost:8090/api/books/`

### 1. Get All Books
```http
GET /getAll
```
Returns a list of all books in the library.

---

### 2. Get Book by ID
```http
GET /getById/{id}
```
**Path Parameters:**
- `id` — unique book identifier

---

### 3. Search Books
```http
GET /search?title=value&author=value&genre=value
```
**Query Parameters:**
- `title` — search by title (partial match)
- `author` — search by author (partial match)
- `genre` — search by genre (partial match)
- `minReleaseDate` — minimum publication date (format: YYYY-MM-DD)
- `maxReleaseDate` — maximum publication date (format: YYYY-MM-DD)

**Example:**
```
GET /search?author=Tolkien&minReleaseDate=1950-01-01&maxReleaseDate=1960-12-31
```

---

### 4. Create Book
```http
POST /create
Content-Type: application/json
```
**Request Body:**
```json
{
    "fileLink": "https://example.com/book.pdf",
    "author": "J.R.R. Tolkien",
    "date": "1954-07-29",
    "title": "The Lord of the Rings",
    "description": "An epic high-fantasy novel",
    "genre": "Fantasy"
}
```

---

### 5. Update Book
```http
PUT /update/{id}
Content-Type: application/json
```
**Path Parameters:**
- `id` — identifier of the book to update

**Request Body:**
```json
{
    "fileLink": "https://example.com/book-updated.pdf",
    "author": "J.R.R. Tolkien",
    "date": "1954-07-29",
    "title": "The Lord of the Rings (Revised Edition)",
    "description": "Updated version of the novel",
    "genre": "Fantasy"
}
```

---

### 6. Delete Book
```http
DELETE /delete/{id}
```
**Path Parameters:**
- `id` — identifier of the book to delete

---

## Data Format

### Book Object
| Field | Type | Description |
|-------|------|-------------|
| `fileLink` | String | URL link to the book file |
| `author` | String | Book author |
| `date` | Date | Publication date (format: YYYY-MM-DD) |
| `title` | String | Book title |
| `description` | String | Content description |
| `genre` | String | Book genre |

## Notes
- All dates must be in ISO 8601 format: `YYYY-MM-DD`
- Search fields support partial matching (case-insensitive)
- When updating a book, all fields must be provided, even if unchanged

## Localizations

- [Русский](./README-files/README_RU.md)
- [中文](./README-files/README_ZH.md)