package com.wtr.cultivate.business.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wtr.cultivate.entity.master.test.Test;

@Mapper
@DS("master")
public interface TestMapper extends BaseMapper<Test> {

}
