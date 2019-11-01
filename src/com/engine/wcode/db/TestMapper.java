package com.engine.wcode.db;

import com.engine.wcode.mapper.HrmMapper;
import com.wcode.db.MapperUtil;

/**
 * @author Y-Aron
 * @version 1.0.0
 * @create 2019/10/4 19:52
 */
public class TestMapper {
    public static void main(String[] args) {
        HrmMapper mapper = MapperUtil.getMapper(HrmMapper.class);
        mapper.selectHrm();
    }
}
