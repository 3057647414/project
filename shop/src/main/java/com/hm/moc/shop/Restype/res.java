package com.hm.moc.shop.Restype;

public enum res {
    ERRORFORDELETE("1004", "删除失败"),
    ERRORFORGANDER("1005", "权限不足"),
    ERRORFORINSERT("1002", "添加失败"),
    ERRORFORSELECT("1001", "查询失败"),
    ERRORFORPAY("1006","支付失败"),
    SUCCER("1000","成功"),
    ERRORFORUPDATE("1003", "更新失败");


    private String code;
    private String msg;
//
//    res(String code, String msg) {
//        this.code = code;
//        this.msg = msg;
//    }

    res(String code, String msg) {
        this.code = code;
        this.msg = msg;

    }
}
