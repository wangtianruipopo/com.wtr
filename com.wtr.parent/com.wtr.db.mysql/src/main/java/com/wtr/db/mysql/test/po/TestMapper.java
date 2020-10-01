package com.wtr.db.mysql.test.po;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
@Component
public interface TestMapper extends BaseMapper<Test> {

}
