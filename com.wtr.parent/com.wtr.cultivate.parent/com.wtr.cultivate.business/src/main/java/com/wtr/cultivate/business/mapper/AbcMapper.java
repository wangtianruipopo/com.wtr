package com.wtr.cultivate.business.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wtr.cultivate.entity.master.test.Abc;
import com.wtr.jdbctemplate.common.DSType;

@Mapper
@DS(DSType.SLAVE)
public interface AbcMapper extends BaseMapper<Abc> {

}
