package com.example.nozomi.nozomi_java.serviceTest;

import com.example.nozomi.nozomi_java.mapper.UserLikeMapper;
import com.example.nozomi.nozomi_java.pojo.Book;
import com.example.nozomi.nozomi_java.pojo.UserLike;
import com.example.nozomi.nozomi_java.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.Resource;

import static com.example.nozomi.nozomi_java.util.UserUtil.getUserDetailsDTO;

@SpringBootTest
public class BookServiceTest {
    @Resource
    BookService bookService;
    @Test
    public void AddReservation() {
        Book book = new Book();
        book.setCarId(1);
        bookService.AddReservation(book);
    }
}
