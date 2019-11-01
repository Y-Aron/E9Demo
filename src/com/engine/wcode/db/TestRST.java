package com.engine.wcode.db;

import weaver.conn.RecordSetTrans;

/**
 * @author Y-Aron
 * @version 1.0.0
 * @create 2019/10/4 11:21
 */
public class TestRST {
    public static void main(String[] args) {
        RecordSetTrans rst = new RecordSetTrans();
        // 开启事务
        rst.setAutoCommit(false);
        String sql = "update hrmresource lastname=? where id=?";
        try {
            int a = 1/0;
            rst.executeUpdate(sql, "猪八戒", 2);
            // 提交事务
            rst.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 事务回滚
            rst.rollback();
        }
    }
}
