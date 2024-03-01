package com.wk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wk.controller.untils.R;
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
@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping
    public R getAll(){
        return  new R(true,iBookService.list());
    }

    @PostMapping
    public R save(@RequestBody  Book book) throws Exception {
        if(false) throw new Exception();//先啥也不做
        boolean flag = iBookService.save(book);
        return new R(flag,flag?"添加成功":"添加失败");
    }
    @PutMapping
    public R update(@RequestBody Book book){
        return new R(iBookService.updateById(book));
    }

    @DeleteMapping("{id}")//这里写成/{}  与{}一样
    public R delete(@PathVariable Integer id){
        return new R(iBookService.removeById(id));
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,iBookService.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
//
//        IPage<Book> iPage = iBookService.getPage(currentPage, pageSize);
//        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值，
//        //用于解决第n页只有一个数据是，若删除该数据，页码值还是当前页（此时为空页）的问题
//        if(currentPage> iPage.getPages()){
//            iPage = iBookService.getPage((int) iPage.getPages(),pageSize);
//        }
//        return new R(true,iPage);
//    }

    /**
     * 为了完成查询操作，所以进一步改进
     * @param currentPage
     * @param pageSize
     *        book:接受查询细腻
     * @return
     */
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){

        IPage<Book> iPage = iBookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值，
        //用于解决第n页只有一个数据是，若删除该数据，页码值还是当前页（此时为空页）的问题
        if(currentPage> iPage.getPages()){
            iPage = iBookService.getPage((int) iPage.getPages(),pageSize,book);
        }
        return new R(true,iPage);
    }
}
