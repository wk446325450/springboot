package com.wk.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author： 魏凯
 * @version: 1.0
 * @desc： TODO
 */
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }

}
