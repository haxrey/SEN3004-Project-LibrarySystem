-- Insert data into the books table
INSERT INTO books (title, author, isbn, publication_date, price) VALUES
('1984', 'George Orwell', '9780451524935', '1949-06-08', 9.99),
('To Kill a Mockingbird', 'Harper Lee', '9780060935467', '1960-07-11', 14.99),
('The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', '1925-04-10', 13.99),
('Brave New World', 'Aldous Huxley', '9780060850524', '1932-01-01', 15.99),
('The Catcher in the Rye', 'J.D. Salinger', '9780316769488', '1951-07-16', 12.99);

-- Insert data into the authors table
INSERT INTO authors (name) VALUES
('George Orwell'),
('Harper Lee'),
('F. Scott Fitzgerald'),
('Aldous Huxley'),
('J.D. Salinger');

-- Insert data into the author_book join table
INSERT INTO author_book (author_id, book_id) VALUES
(1, 1),  -- George Orwell wrote 1984
(2, 2),  -- Harper Lee wrote To Kill a Mockingbird
(3, 3),  -- F. Scott Fitzgerald wrote The Great Gatsby
(4, 4),  -- Aldous Huxley wrote Brave New World
(5, 5);  -- J.D. Salinger wrote The Catcher in the Rye



-- Insert data into the transactions table
INSERT INTO transactions (user_id, book_id, transaction_date) VALUES
(1, 1, '2022-01-01'),
(2, 2, '2022-01-02'),
(3, 3, '2022-01-03'),
(4, 4, '2022-02-01'),
(5, 5, '2022-02-02');
