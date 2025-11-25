<div align="center">
  
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Docker](https://img.shields.io/badge/docker-%232496ED.svg?style=for-the-badge&logo=docker&logoColor=white)

[![License](https://img.shields.io/badge/license-GNU%20GPL%20v3.0-brightgreen)](LICENSE) ![Stars](https://img.shields.io/github/stars/GigaGitCoder/JavaBookService)
</div>

JavaBookService — это микросервис для управления книгами в библиотечных проектах. Сервис предоставляет REST API для выполнения операций CRUD (создание, чтение, обновление, удаление) с книгами.

## Используемые порты

| Сервис | Порт |
|--------|------|
| Books Service API | 8090 |
| PostgreSQL Database | 5432 |

## API Эндпоинты

**Базовый URL:** `http://localhost:8090/api/books/`

### 1. Получить все книги
```http
GET /getAll
```
Возвращает список всех книг в библиотеке.

---

### 2. Получить книгу по ID
```http
GET /getById/{id}
```
**Параметры пути:**
- `id` — уникальный идентификатор книги

---

### 3. Поиск книг
```http
GET /search?title=value&author=value&genre=value
```
**Параметры запроса:**
- `title` — поиск по названию (частичное совпадение)
- `author` — поиск по автору (частичное совпадение)
- `genre` — поиск по жанру (частичное совпадение)
- `minReleaseDate` — минимальная дата публикации (формат: YYYY-MM-DD)
- `maxReleaseDate` — максимальная дата публикации (формат: YYYY-MM-DD)

**Пример:**
```
GET /search?author=Толстой&minReleaseDate=1860-01-01&maxReleaseDate=1880-12-31
```

---

### 4. Создать книгу
```http
POST /create
Content-Type: application/json
```
**Тело запроса:**
```json
{
    "fileLink": "https://example.com/book.pdf",
    "author": "Лев Толстой",
    "date": "1869-01-01",
    "title": "Война и мир",
    "description": "Эпический роман о русском обществе во время наполеоновских войн",
    "genre": "Исторический роман"
}
```

---

### 5. Обновить книгу
```http
PUT /update/{id}
Content-Type: application/json
```
**Параметры пути:**
- `id` — идентификатор книги для обновления

**Тело запроса:**
```json
{
    "fileLink": "https://example.com/book-updated.pdf",
    "author": "Лев Толстой",
    "date": "1869-01-01",
    "title": "Война и мир (исправленное издание)",
    "description": "Обновленная версия романа",
    "genre": "Исторический роман"
}
```

---

### 6. Удалить книгу
```http
DELETE /delete/{id}
```
**Параметры пути:**
- `id` — идентификатор книги для удаления

---

## Формат данных

### Объект книги (Book)
| Поле | Тип | Описание |
|------|-----|----------|
| `fileLink` | String | URL-ссылка на файл книги |
| `author` | String | Автор книги |
| `date` | Date | Дата публикации (формат: YYYY-MM-DD) |
| `title` | String | Название книги |
| `description` | String | Описание содержания |
| `genre` | String | Жанр книги |

## Примечания
- Все даты должны быть в формате ISO 8601: `YYYY-MM-DD`
- Поля поиска поддерживают частичное совпадение (регистр не учитывается)
- При обновлении книги необходимо передавать все поля, даже если они не изменились