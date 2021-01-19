package com.pcedu.blackbooks.services;

import com.pcedu.blackbooks.dao.BookDao;
import com.pcedu.blackbooks.entities.Book;
import com.pcedu.blackbooks.entities.Categorie;
import com.pcedu.blackbooks.entities.ShoppingCartDetail;
import com.pcedu.blackbooks.entities.dto.BookDTO;
import com.pcedu.blackbooks.services.interfaces.IBookService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookService")
@Transactional
public class BookService implements IBookService{

    @Autowired
    BookDao bookDao; 
    
    @Override
    public Book findById(int id) {
        return bookDao.findById(id);
    }
    
    @Override
    public BookDTO findByIdDTO(int id) {
        Book book = findById(id);
        return (new BookDTO(book));
    }
    
    @Override
    public BookDTO findByTitle(String title){
        Book book = bookDao.findByTitle(title);
        return(new BookDTO(book));
    }

    @Override
    public List<BookDTO> findAll(){
        List<Book> books = bookDao.findAll();
        List<BookDTO> booksDTO = new ArrayList<BookDTO>();
        for (Book book : books) {
            booksDTO.add(new BookDTO(book));
        }
        return(booksDTO);
    }
    
    @Override
    public List<BookDTO> findAllByAuthor(int authorId){
        List<Book> books = bookDao.findAllByAuthor(authorId);
        List<BookDTO> booksDTO = new ArrayList<BookDTO>();
        for (Book book : books) {
            booksDTO.add(new BookDTO(book));
        }
        return(booksDTO);
    }
    
    @Override
    public List<BookDTO> findAllByCategorie(Categorie categorieId){
        List<Book> books = bookDao.findAllByCategorie(categorieId);
        List<BookDTO> booksDTO = new ArrayList<BookDTO>();
        for (Book book : books) {
            booksDTO.add(new BookDTO(book));
        }
        return(booksDTO);
    }
    
    @Override
    public BookDTO findByShoppingCartDetail(ShoppingCartDetail detail){
        Book book = bookDao.findByShoppingCartDetail(detail);
        return(new BookDTO(book));
    }
      
    @Override
    public List<BookDTO> findAllByPriceRange(BigDecimal min, BigDecimal max){
        List<Book> books = bookDao.findAllByPriceRange(min, max);
        List<BookDTO> booksDTO = new ArrayList<BookDTO>();
        for (Book book : books) {
            booksDTO.add(new BookDTO(book));
        }
        return(booksDTO);
    }
    
    @Override
    public List<BookDTO> findAllByFirstLetter(String fLetter){
        List<Book> books = bookDao.findAllByFirstLetter(fLetter);
        List<BookDTO> booksDTO = new ArrayList<BookDTO>();
        for (Book book : books) {
            booksDTO.add(new BookDTO(book));
        }
        return(booksDTO);
    }
    
    @Override
    public boolean save(Book book) {
        boolean result = false;
        result = bookDao.save(book);
        return (result);
    }
    
    @Override
    public boolean update(Book book) {
        boolean result = false;
        result = bookDao.update(book);
        return (result);
    }
    
    @Override
    public boolean delete(Book book){
        boolean result = false;
        result = bookDao.deleteBook(book);
        return (result);
    }
}
