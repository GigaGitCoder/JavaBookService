<div align="center">
  
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Docker](https://img.shields.io/badge/docker-%232496ED.svg?style=for-the-badge&logo=docker&logoColor=white)

[![License](https://img.shields.io/badge/license-GNU%20GPL%20v3.0-brightgreen)](LICENSE) ![Stars](https://img.shields.io/github/stars/GigaGitCoder/JavaBookService)
</div>

JavaBookService 是一个用于图书馆项目中管理图书的微服务。该服务提供 REST API 用于执行图书的 CRUD 操作（创建、读取、更新、删除）。

## 服务端口

| 服务 | 端口 |
|------|------|
| Books Service API | 8090 |
| PostgreSQL 数据库 | 5432 |

## API 端点

**基础 URL:** `http://localhost:8090/api/books/`

### 1. 获取所有图书
```http
GET /getAll
```
返回图书馆中所有图书的列表。

---

### 2. 根据 ID 获取图书
```http
GET /getById/{id}
```
**路径参数：**
- `id` — 图书的唯一标识符

---

### 3. 搜索图书
```http
GET /search?title=value&author=value&genre=value
```
**查询参数：**
- `title` — 按标题搜索（部分匹配）
- `author` — 按作者搜索（部分匹配）
- `genre` — 按类型搜索（部分匹配）
- `minReleaseDate` — 最早出版日期（格式：YYYY-MM-DD）
- `maxReleaseDate` — 最晚出版日期（格式：YYYY-MM-DD）

**示例：**
```
GET /search?author=金庸&minReleaseDate=1955-01-01&maxReleaseDate=1972-12-31
```

---

### 4. 创建图书
```http
POST /create
Content-Type: application/json
```
**请求体：**
```json
{
    "fileLink": "https://example.com/book.pdf",
    "author": "金庸",
    "date": "1957-01-01",
    "title": "射雕英雄传",
    "description": "一部武侠小说",
    "genre": "武侠小说"
}
```

---

### 5. 更新图书
```http
PUT /update/{id}
Content-Type: application/json
```
**路径参数：**
- `id` — 要更新的图书标识符

**请求体：**
```json
{
    "fileLink": "https://example.com/book-updated.pdf",
    "author": "金庸",
    "date": "1957-01-01",
    "title": "射雕英雄传（修订版）",
    "description": "小说的更新版本",
    "genre": "武侠小说"
}
```

---

### 6. 删除图书
```http
DELETE /delete/{id}
```
**路径参数：**
- `id` — 要删除的图书标识符

---

## 数据格式

### 图书对象（Book）
| 字段 | 类型 | 描述 |
|------|------|------|
| `fileLink` | String | 图书文件的 URL 链接 |
| `author` | String | 图书作者 |
| `date` | Date | 出版日期（格式：YYYY-MM-DD） |
| `title` | String | 图书标题 |
| `description` | String | 内容描述 |
| `genre` | String | 图书类型 |

## 注意事项
- 所有日期必须使用 ISO 8601 格式：`YYYY-MM-DD`
- 搜索字段支持部分匹配（不区分大小写）
- 更新图书时必须提供所有字段，即使它们未更改