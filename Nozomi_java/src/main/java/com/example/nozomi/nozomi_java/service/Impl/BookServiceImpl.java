package com.example.nozomi.nozomi_java.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.nozomi.nozomi_java.mapper.BookMapper;
import com.example.nozomi.nozomi_java.mapper.CarMapper;
import com.example.nozomi.nozomi_java.mapper.UserCarMapper;
import com.example.nozomi.nozomi_java.pojo.Book;
import com.example.nozomi.nozomi_java.service.BookService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.example.nozomi.nozomi_java.util.UserUtil.getUserDetailsDTO;

/**
 * 预定实现类
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;
    @Resource
    private UserCarMapper userCarMapper;
    @Override
    public List<Book> SelectReservationListByCarId() {
        // userId获取所有carId
        List<Integer> carIds = userCarMapper.getCarIdByUserId(getUserDetailsDTO().getUser().getId());
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("car_id", carIds);
        return bookMapper.selectList(queryWrapper);
    }

    @Override
    public List<Book> SelectReservationByUserId() {
        return bookMapper.SelectReservationByUserId(getUserDetailsDTO().getUser().getId());
    }

    @Override
    public boolean AddReservation(Book book) {
        // userId,carId,createTime
        try {
            bookMapper.autoIncrement();
            book.setUserId(getUserDetailsDTO().getUser().getId());
            bookMapper.insert(book);
            return true;
        } catch (RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean UpdateReservation(Book book) {
        try {
            // id,bookTime,bookPlace,bookStatus
            bookMapper.updateById(book);
            return true;
        } catch (RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }
}
