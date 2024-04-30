package com.example.demo.reps;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import sen3004.app5.model.Book;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private RowMapper<Book> rowMapper = new RowMapper<Book>() {
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setId(rs.getLong("id"));
            book.setBookTitle(rs.getString("title"));
            book.setBookAuthor(rs.getString("author")); // Assuming you have author's name in a 'author' column
            book.setDateOfPublishing(rs.getDate("publication_date").toLocalDate()); // Converting SQL Date to LocalDate
            book.setIsbn(rs.getString("isbn")); // ISBN should be a string
            // Add any additional fields you have in your entity
            return book;
        }
    };
    
    public List<Book> findAll() {
        String sql = "select * from books";
        return jdbcTemplate.query(sql, rowMapper);
    }
    
    public Book findById(long id) {
        String sql = "select * from books where id = ?";
        return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper, id));
    }
    
    public void create(Book book) {
        String sql = "insert into books(title, author, publication_date, isbn) values(?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getBookTitle(), book.getBookAuthor(), book.getDateOfPublishing(), book.getIsbn());
    }
    
    public void update(Book book) {
        String sql = "update books set title = ?, author = ?, publication_date = ?, isbn = ? where id = ?";
        jdbcTemplate.update(sql, book.getBookTitle(), book.getBookAuthor(), book.getDateOfPublishing(), book.getIsbn(), book.getId());
    }

    public void delete(long id) {
        String sql = "delete from books where id = ?";
        jdbcTemplate.update(sql, id);
    } 
}
