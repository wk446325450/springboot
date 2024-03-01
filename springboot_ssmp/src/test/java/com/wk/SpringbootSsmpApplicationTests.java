package com.wk;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wk.dao.BookDao;
import com.wk.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootSsmpApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        System.out.println(bookDao.selectById(1));
    }

    /**
     * 分页
     */
    @Test
    void testGetPage(){
        IPage page = new Page<>(1,5);
        bookDao.selectPage(page,null);
    }

    /**
     * 按条件查询
     */
    @Test
    void testGetBy(){
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        //添加条件
        wrapper.like("name","Spring");
        bookDao.selectList(wrapper);
    }

    /**
     * 条件查询，推荐
     */
    @Test
    void testGetBy2(){
        String name = null;//传进来的数据
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加条件
        //要判断传进来的数据是否为空,若不为空则查询name = name（传进来的数据）的数据
        lambdaQueryWrapper.like(name!=null,Book::getName,name);
        bookDao.selectList(lambdaQueryWrapper);
    }
}
