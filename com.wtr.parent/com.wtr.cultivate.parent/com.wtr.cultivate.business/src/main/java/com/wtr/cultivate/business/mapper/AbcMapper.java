package com.wtr.cultivate.business.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wtr.cultivate.entity.master.test.Abc;

@Mapper
@DS("slave")
public interface AbcMapper extends BaseMapper<Abc> {

}
