package com.wk.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wk.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author： 魏凯
 * @version: 1.0
 * @desc： TODO
 */
@Mapper
@Repository//别忘了，这是数据层的那个
public interface BookDao extends BaseMapper<Book> {//注意：指定泛型

}
