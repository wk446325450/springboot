package com.wk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wk.entity.Book;

import java.util.List;

/**
 * @author： 魏凯
 * @version: 1.0
 * @desc： TODO
 */
public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
     Book getById (Integer id);
     List<Book> getAll();

    /**
     *
     * @param currentPage:当前页码值
     *        pageSize  :每页显示数
     * @return
     */
     IPage<Book> getPage(int currentPage,int pageSize);

    /**
     *
     * @param currentPage:当前页码值
     *        pageSize  :每页显示数
     * @return
     */
//    IPage<Book> getPage(int currentPage,int pageSize,Book book);
}
