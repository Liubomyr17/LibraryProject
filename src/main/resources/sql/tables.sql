DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS publishers;

CREATE TABLE "authors" (
"id"           SERIAL       NOT NULL PRIMARY KEY,
"first_name"   VARCHAR(128) NOT NULL,
"last_name"    VARCHAR(128),
"created_date" DATE         NOT NULL DEFAULT now()
);

CREATE TABLE "books" (
    "id"           SERIAL       NOT NULL PRIMARY KEY,
    "name"         VARCHAR(512) NOT NULL,
    "year"         DATE,
    "isbn"         CHAR(13)     NOT NULL UNIQUE,
    "created_date" DATE         NOT NULL DEFAULT now(),
    "publisher_id" INT REFERENCES publishers(id),
    CONSTRAINT books_fkey FOREIGN KEY (publisher_id) REFERENCES publishers(id)

);

CREATE TABLE "books_authors" (
    "book_id"   BIGINT,
    "author_id" BIGINT,
    CONSTRAINT books_authors_pkey PRIMARY KEY (book_id, author_id),
    CONSTRAINT books_fkey FOREIGN KEY (book_id) REFERENCES books (id),
    CONSTRAINT authors_fkey FOREIGN KEY (author_id) REFERENCES authors (id)
);

CREATE TABLE "publishers" (
    "id"      SERIAL       NOT NULL PRIMARY KEY,
    "name"    VARCHAR(512) NOT NULL
)