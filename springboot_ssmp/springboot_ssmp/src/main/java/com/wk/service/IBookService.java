package com.wk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.entity.Book;

/**
 * @author： 魏凯
 * @version: 1.0
 * @desc： TODO
 */
public interface IBookService  extends IService<Book> {

    IPage<Book> getPage(int currentPage,int pageSize);

    IPage<Book> getPage(int currentPage,int pageSize,Book book);
}
