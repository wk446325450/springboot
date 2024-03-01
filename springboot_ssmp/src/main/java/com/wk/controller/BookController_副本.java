package com.wk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wk.entity.Book;
import com.wk.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author： 魏凯
 * @version: 1.0
 * @desc： TODO
 */
//@RestController
//@RequestMapping("/books")
public class BookController_副本 {

    @Autowired
    private IBookService iBookService;

    @GetMapping
    public List<Book> getAll(){
        return iBookService.list();
    }
    @PostMapping
    public boolean save(@RequestBody  Book book){
        return iBookService.save(book);
    }
    @PutMapping
    public boolean update(@RequestBody Book book){
        return iBookService.updateById(book);
    }
    @DeleteMapping("{id}")//这里写成/{}  与{}一样
    public Boolean delete(@PathVariable Integer id){
        return iBookService.removeById(id);
    }
    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        return iBookService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return iBookService.getPage(currentPage,pageSize);
    }
}
