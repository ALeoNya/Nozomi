package com.example.nozomi.nozomi_java.service;

import com.example.nozomi.nozomi_java.pojo.Book;

import java.util.List;

public interface BookService {
    // 店家查询
    public List<Book> SelectReservationListByCarId();
    // 买家查询
    public List<Book> SelectReservationByUserId();
    public boolean AddReservation(Book book);
    public boolean UpdateReservation(Book book);
}
