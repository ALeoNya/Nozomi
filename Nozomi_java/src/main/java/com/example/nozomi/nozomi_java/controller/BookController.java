package com.example.nozomi.nozomi_java.controller;

import com.example.nozomi.nozomi_java.pojo.Book;
import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.UserAuth;
import com.example.nozomi.nozomi_java.response.Code;
import com.example.nozomi.nozomi_java.response.Msg;
import com.example.nozomi.nozomi_java.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookController {
    @Resource
    private BookService bookService;
    @PostMapping("/Book/AddReservation")
    public ResponseDTO AddReservation(@RequestBody Book book){
        return new ResponseDTO(Code.SUCCESS, Msg.ADD_SUCCESS_MSG,bookService.AddReservation(book));
    }
    @PostMapping("/Book/UpdateReservation")
    public ResponseDTO UpdateReservation(@RequestBody Book book){
        return new ResponseDTO(Code.SUCCESS, Msg.ADD_SUCCESS_MSG,bookService.UpdateReservation(book));
    }
    @GetMapping("/Book/SelectReservationListByCarId")
    public ResponseDTO SelectReservationListByCarId(){
        return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG,bookService.SelectReservationListByCarId());
    }
    @GetMapping("/Book/SelectReservationByUserId")
    public ResponseDTO SelectReservationByUserId(){
        return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG,bookService.SelectReservationByUserId());
    }
}
