-- src/main/resources/sql/data.sql

-- Insert sample genres
INSERT INTO genres (name) VALUES ('Science Fiction');
INSERT INTO genres (name) VALUES ('Fantasy');
INSERT INTO genres (name) VALUES ('Mystery');
INSERT INTO genres (name) VALUES ('Thriller');
INSERT INTO genres (name) VALUES ('Romance');
INSERT INTO genres (name) VALUES ('Horror');
INSERT INTO genres (name) VALUES ('Historical Fiction');
INSERT INTO genres (name) VALUES ('Non-Fiction');
INSERT INTO genres (name) VALUES ('Biography');
INSERT INTO genres (name) VALUES ('Self-Help');
INSERT INTO genres (name) VALUES ('Health');
INSERT INTO genres (name) VALUES ('Travel');
INSERT INTO genres (name) VALUES ('Guide / How-to');
INSERT INTO genres (name) VALUES ('Religion');
INSERT INTO genres (name) VALUES ('Science');
INSERT INTO genres (name) VALUES ('History');
INSERT INTO genres (name) VALUES ('Poetry');
INSERT INTO genres (name) VALUES ('Comics');
INSERT INTO genres (name) VALUES ('Art');
INSERT INTO genres (name) VALUES ('Cookbooks');

-- Insert sample authors
INSERT INTO authors (name) VALUES ('Isaac Asimov');
INSERT INTO authors (name) VALUES ('J.K. Rowling');
INSERT INTO authors (name) VALUES ('Agatha Christie');
INSERT INTO authors (name) VALUES ('Stephen King');
INSERT INTO authors (name) VALUES ('Jane Austen');
INSERT INTO authors (name) VALUES ('George Orwell');
INSERT INTO authors (name) VALUES ('Mark Twain');
INSERT INTO authors (name) VALUES ('J.R.R. Tolkien');
INSERT INTO authors (name) VALUES ('Ernest Hemingway');
INSERT INTO authors (name) VALUES ('Charles Dickens');

-- Insert sample books
INSERT INTO books (title, isbn, publication_date, purchase_date, price) VALUES 
('Foundation', '9780553293357', '1951-06-01', '2023-01-01', 15.99);
INSERT INTO books (title, isbn, publication_date, purchase_date, price) VALUES 
('Harry Potter and the Philosopher''s Stone', '9780747532699', '1997-06-26', '2023-01-01', 20.99);
INSERT INTO books (title, isbn, publication_date, purchase_date, price) VALUES 
('Murder on the Orient Express', '9780062693662', '1934-01-01', '2023-01-01', 12.99);
INSERT INTO books (title, isbn, publication_date, purchase_date, price) VALUES 
('The Shining', '9780385121675', '1977-01-28', '2023-01-01', 14.99);
INSERT INTO books (title, isbn, publication_date, purchase_date, price) VALUES 
('Pride and Prejudice', '9780141439518', '1813-01-28', '2023-01-01', 9.99);

-- Insert sample author_book relationships
INSERT INTO author_book (author_id, book_id) VALUES (1, 1);
INSERT INTO author_book (author_id, book_id) VALUES (2, 2);
INSERT INTO author_book (author_id, book_id) VALUES (3, 3);
INSERT INTO author_book (author_id, book_id) VALUES (4, 4);
INSERT INTO author_book (author_id, book_id) VALUES (5, 5);

-- Insert sample book_genre relationships
INSERT INTO book_genre (book_id, genre_id) VALUES (1, 1);
INSERT INTO book_genre (book_id, genre_id) VALUES (2, 2);
INSERT INTO book_genre (book_id, genre_id) VALUES (3, 3);
INSERT INTO book_genre (book_id, genre_id) VALUES (4, 6);
INSERT INTO book_genre (book_id, genre_id) VALUES (5, 5);
