package com.engine.wcode.db;

import weaver.conn.RecordSet;

/**
 * @author Y-Aron
 * @version 1.0.0
 * @create 2019/10/4 11:15
 */
public class TestRecordSet {

    public static void main(String[] args) {
        RecordSet rs = new RecordSet();
        String sql = "select loginid, lastname from hrmresource where id=?";
        // 防止sql注入, objects 为动态参数
        rs.executeQuery(sql, 2);
        if (rs.next()) {
            String loginid = rs.getString("loginid");
            String lastname = rs.getString("lastname");
        }
        String updateSql = "update hrmresource lastname=? where id=?";
        // 返回是否更新成功
        boolean bool = rs.executeUpdate(sql, "孙悟空", 2);
    }
}
