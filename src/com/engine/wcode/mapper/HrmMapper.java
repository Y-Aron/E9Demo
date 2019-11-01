package com.engine.wcode.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface HrmMapper {
    @Select("select loginid, password, lastname from hrmresource")
    List<Map<String, String>> selectHrm();

    @Update("update hrmresource set lastname=#{lastName} where id=3")
    int updateLastName(String lastName);
}
