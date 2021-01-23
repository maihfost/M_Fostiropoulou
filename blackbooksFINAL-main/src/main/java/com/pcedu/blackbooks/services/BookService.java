package com.pcedu.blackbooks.services;

import com.pcedu.blackbooks.dao.BookDao;
import com.pcedu.blackbooks.entities.Book;
import com.pcedu.blackbooks.entities.Categorie;
import com.pcedu.blackbooks.entities.ShoppingCartDetail;
import com.pcedu.blackbooks.entities.dto.BookDTO;
import com.pcedu.blackbooks.services.interfaces.IBookService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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
    public List<BookDTO> findAllByHotBooks() {
        List<Book> books = bookDao.findAllByHotBooks();
        List<BookDTO> booksDTO = new ArrayList<BookDTO>();
        for (Book book : books) {
            booksDTO.add(new BookDTO(book));
        }
        return(booksDTO);
    }

    @Override
    public List<BookDTO> findAllByPriceDesc() {
        List<Book> books = bookDao.findAll();
        List<BookDTO> booksDTO = new ArrayList<BookDTO>();
        for (Book book : books) {
            booksDTO.add(new BookDTO(book));
        }
        return(sortingBooks(booksDTO, -1));
    }

    @Override
    public List<BookDTO> findAllByPriceAsc() {
        List<Book> books = bookDao.findAll();
        List<BookDTO> booksDTO = new ArrayList<BookDTO>();
        for (Book book : books) {
            booksDTO.add(new BookDTO(book));
        }
        return(sortingBooks(booksDTO, 1));
    }
    
    private List<BookDTO> sortingBooks(List<BookDTO> books, int type){
        BookDTO m = new BookDTO();
        for(int i=0; i<books.size()-1; i++){
            for (int j =i+1; j<books.size(); j++){
                if(books.get(i).getRegularPrice().compareTo(books.get(j).getRegularPrice()) == type){
                    changePlaces(m, books.get(j));
                    changePlaces(books.get(j), books.get(i));
                    changePlaces(books.get(i), m);
                }
            }
        }
        return(books);
    }
    
    private void changePlaces(BookDTO b1, BookDTO b2){
        b1.setId(b2.getId());
        b1.setCountReviews(b2.getCountReviews());
        b1.setCountSales(b2.getCountSales());
        b1.setDescription(b2.getDescription());
        b1.setImage(b2.getImage());
        b1.setIsbn(b2.getIsbn());
        b1.setNoofpages(b2.getNoofpages());
        b1.setRegularPrice(b2.getRegularPrice());
        b1.setStoreQuantity(b2.getStoreQuantity());
        b1.setTitle(b2.getTitle());
        b1.setTotalRating(b2.getTotalRating());
    }
    
    public List<BookDTO> findAllByCountSalesOrderByDesc(){
        List<Book> books = bookDao.findAllByCountSalesOrderByDesc();
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
