package com.engine.wcode.util;

import com.wcode.util.RequestUtils;
import weaver.soa.workflow.request.MainTableInfo;
import weaver.soa.workflow.request.Property;
import weaver.soa.workflow.request.RequestInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Y-Aron
 * @version 1.0.0
 * @create 2019/10/8 9:52
 */
public class TestRequestUtils {

    public static void main(String[] args) {
        RequestInfo request = new RequestInfo();
        MainTableInfo mt = new MainTableInfo();
        mt.addProperty(new Property(){{
            setName("xm");
            setValue("123456");
        }});
        mt.addProperty(new Property(){{
            setName("mm");
            setValue("_！@#！￥！@%");
        }});
        request.setMainTableInfo(mt);
//        UserDTO userDTO = RequestUtils.convert(request, UserDTO.class);
//        System.out.println(userDTO);

        List<String> list = new ArrayList<>();
        list.add("xm");
        Map<String, String> map = RequestUtils.convertToMap(request, list);
        System.out.println(map.toString());

    }
}
