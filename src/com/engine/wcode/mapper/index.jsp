<%@ page contentType="text/html; UTF-8" %>
<%@ page import="com.wcode.db.MapperUtil" %>
<%@ page import="com.engine.wcode.mapper.HrmMapper" %>
<%@ page import="com.engine.wcode.mapper.TestMapper" %>
<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page import="weaver.conn.ConnectionPool" %>
<%@ page import="weaver.conn.RecordSet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%
    ConnectionPool pool = ConnectionPool.getInstance();
    pool.closeAllConnection();
    RecordSet rs = new RecordSet();

    long start = System.currentTimeMillis();
    HrmMapper mapper = MapperUtil.getMapper(HrmMapper.class);

    for (int i = 0; i < 3; i++) {
        long _start = System.currentTimeMillis();
//        rs.executeUpdate("update hrmresource set lastname=? where id=3", "林苍生" + i);
//        mapper.updateLastName("林苍生Mapper" + i);
        testMapper();
        testRecordSet();
        out.println("第" + i + "次耗时：" + (System.currentTimeMillis() - _start));
        out.println("<br>");
//        MapperUtil.getCurrentSqlSession().clearCache();
    }
    out.println("总耗时：" + (System.currentTimeMillis() -  start));
%>

<%!
    private void testRecordSet() {
        Logger logger = LoggerFactory.getLogger("debug");
        RecordSet rs = new RecordSet();
        rs.executeQuery("select loginid, password, lastname from hrmresource");

        while (rs.next()) {
            if (!"lcs".equals(rs.getString("loginid"))) continue;
            logger.debug("key: loginid, value: {}", rs.getString("loginid"));
            logger.debug("key: password, value: {}", rs.getString("password"));
            logger.debug("key: lastname, value: {}", rs.getString("lastname"));
        }

        rs.executeQuery("select * from hrmresourceManager");
        while (rs.next()) {
            logger.debug("loginid: {}", rs.getString("loginid"));
        }
    }

    private void testMapper() {
        Logger logger = LoggerFactory.getLogger("debug");
        HrmMapper mapper = MapperUtil.getMapper(HrmMapper.class);
        List<Map<String, String>> list = mapper.selectHrm();
        for (Map<String, String> map : list) {
            if (!"lcs".equals(map.get("loginid"))) continue;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                logger.debug("key: {}, value: {}", entry.getKey(), entry.getValue());
            }
        }

        TestMapper testMapper = MapperUtil.getMapper(TestMapper.class);
        for (Map<String, String> map : testMapper.selectAll()) {
            logger.debug("map: {}", map);
        }
    }
%>