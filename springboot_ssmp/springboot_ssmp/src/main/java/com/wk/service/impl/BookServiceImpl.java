package com.wk.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wk.dao.BookDao;
import com.wk.entity.Book;
import com.wk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： 魏凯
 * @version: 1.0
 * @desc： 注意：数据层与业务层的接口名称大概率对应不上
 */
@Service//别忘了，这是业务层的那个
public class BookServiceImpl implements BookService {


    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book)>0;
        //注意，返回后的数据都是影响行，用于判断操作是否成功
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> bookPage = new Page<>(currentPage,pageSize);
        return bookDao.selectPage(bookPage,null);
    }
}
