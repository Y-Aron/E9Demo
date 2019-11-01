package com.engine.wcode.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TestMapper {

	@Select("select * from hrmresourceManager")
	List<Map<String, String>> selectAll();
}