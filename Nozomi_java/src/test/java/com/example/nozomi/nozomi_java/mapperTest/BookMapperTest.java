package com.example.nozomi.nozomi_java.mapperTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.nozomi.nozomi_java.mapper.BookMapper;
import com.example.nozomi.nozomi_java.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BookMapperTest {
    @Resource
    private BookMapper bookMapper;
    @Test
    public void bookMapper() {
        List<Integer> carIds = new ArrayList<>();
        carIds.add(1);
        carIds.add(2);
        carIds.add(3);
        carIds.add(4);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("car_id", carIds);
        System.out.println(bookMapper.selectList(queryWrapper));
    }
}
