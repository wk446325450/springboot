package com.wk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.dao.BookDao;
import com.wk.entity.Book;
import com.wk.service.BookService;
import com.wk.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： 魏凯
 * @version: 1.0
 * @desc： 注意：数据层与业务层的接口名称大概率对应不上
 * /////////////mybatis-plus简化开发
 */
@Service//别忘了，这是业务层的那个
public class IBookServiceImpl extends ServiceImpl<BookDao,Book>implements IBookService {


    @Autowired
    private BookDao bookDao;

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> bookPage = new Page<>(currentPage,pageSize);
        return bookDao.selectPage(bookPage,null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        //用于完成查询操作
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        IPage<Book> bookPage = new Page<>(currentPage,pageSize);
        return bookDao.selectPage(bookPage,lqw);
    }
}
