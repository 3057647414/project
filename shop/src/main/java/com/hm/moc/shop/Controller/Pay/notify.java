package com.hm.moc.shop.Controller.Pay;


import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class notify {
    private  final SqlSessionFactory sqlSessionFactory;

//
/*
    par->gmt_create    ret->[2022-05-16 22:39:15]
    par->charset    ret->[utf-8]
    par->seller_email    ret->[rrmcip4086@sandbox.com]
    par->subject    ret->[123456]
    par->sign    ret->[PWlkbujiJxnyYpRxFWNySJcYUYVAzhFf8Krg3zSKk174tquGz0nLqR+YtAQILZPqkHKCsEOq5pVk634E+xmidYdJvg1WHOmp6ruQGA8rVjt9Hl5OdrA37OBV+iEF90iTVmWXc78EkeqLHYN3SaidMVjcdyvp4mEeK+RPPoY14y9EDxFFCcg3SBmvTzbV48h2JR05WLvzZnmh91rynMTZOqtq340L4DEl3zTByR/eqTc/K76ZChY6rX8jWLfp9FxCLOoOIqtsPIXUCRm3f+Oz4slp3L6qkRUDZqlbUWjnvJ/62WvQUXK8YgeQ/ipv2h6MlYLZ+kTLip665G3HkmS/3Q==]
    par->buyer_id    ret->[2088622958186203]
    par->invoice_amount    ret->[1000.00]
    par->notify_id    ret->[2022051600222223919086200542425632]
    par->fund_bill_list    ret->[[{"amount":"1000.00","fundChannel":"ALIPAYACCOUNT"}]]
    par->notify_type    ret->[trade_status_sync]
    par->trade_status    ret->[TRADE_SUCCESS]
    par->receipt_amount    ret->[1000.00]
    par->buyer_pay_amount    ret->[1000.00]
    par->app_id    ret->[2021000119649086]
    par->sign_type    ret->[RSA2]
    par->seller_id    ret->[2088621958165111]
    par->gmt_payment    ret->[2022-05-16 22:39:18]
    par->notify_time    ret->[2022-05-16 22:39:20]
    par->version    ret->[1.0]
    par->out_trade_no    ret->[2022051610384110]
    par->total_amount    ret->[1000.00]
    par->trade_no    ret->[2022051622001486200503104236]
    par->auth_app_id    ret->[2021000119649086]
    par->buyer_logon_id    ret->[ore***@sandbox.com]
    par->point_amount    ret->[0.00]*/


    @RequestMapping("/rt")
    public String returnHtml(HttpServletRequest request,HttpServletResponse response) throws AlipayApiException, IOException, SQLException, ClassNotFoundException {
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }
        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        //商户订单号

        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
        //支付宝交易号

        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

        //交易状态
        String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
        //计算得出通知验证结果
//        Alipayconfig alipayconfig = new Alipayconfig();
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean verify_result = AlipaySignature.rsaCheckV1(params, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnJfa9PmJyMVxafWOE0w4m8GjMU84tOnxzvapcExIsGkLRvCNt84PvPI48xX0X4ARO+s9phPMqG+CgJgrQ+EA5ZxziUPIi++oPySsEgDN7z6lhANwYDGlaChawgcR6eSYjjKOLzkIXoPAtpJ7fHsEDu9E03tFm1WumTP7+Sb/1yoDntooXzaaANXOLXcGbgYERK7xVV6MmEdfBWvVP071fN7I8ZcleC5TWpZDdODu/s3PV9giey71KCE2/WeJDiUM5Ujv3K3OPIz2xSm6bTn39TTaFtqMdc77cKYKyzRxIpjEteFk/XoEO3VLQyOxsFZfZTLeL4v4gTjA3vaqun0PEQIDAQAB", "utf-8", "RSA2");

        if (verify_result) {//验证成功
            //////////////////////////////////////////////////////////////////////////////////////////
            //请在这里加上商户的业务逻辑程序代码

            //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
            System.out.println("验证成功");
            System.out.println("商户订单号" + out_trade_no);
            System.out.println("支付宝交易号" + trade_no);
            System.out.println("交易状态" + trade_status);

            if (trade_status.equals("TRADE_FINISHED")) {
                System.out.println("暂时未支付");
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                //如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
            } else if (trade_status.equals("TRADE_SUCCESS")) {
                System.out.println("用户已完成支付");
//                SqlSession sqlSession = sqlSessionFactory.openSession();
////                return_url return_url = new return_url();
////                return_url.setPay("支付成功");
//                orderdate orderdate = new orderdate();
//                orderdate.setOrdernumber(out_trade_no);
//                orderdate.setPay("true");
//                int updataorderbynumber = sqlSession.update("updataorderbynumber", orderdate);
//                sqlSession.commit();
//                System.out.println(updataorderbynumber);
//                if (updataorderbynumber==1){
//                    log.info("订单号"+out_trade_no+"订单完成");
////                    List<orderdate> selectorderbynumber = sqlSession.selectList("selectorderbyordernumber", orderdate);
////                    orderdate orderdate1 = selectorderbynumber.get(0);
////                    String uid = orderdate1.getUid();
////                    String shop = orderdate1.getShop();
//                    System.out.println(shop);
//                    String[] split = shop.split("\\,");
//                    String s1 = split[6];
//                    String s = split[1];
//                    String[] split2 = s1.split("=");
//                    boolean test = split2[1].equals("1");
//                    if (test){
//
////                        if (s.equals("鸿蒙智能套餐【鸿蒙空间物基】")||s.equals("鸿蒙智能套餐【高血糖一个疗程】")||s.equals("鸿蒙智能套餐【高尿酸一个疗程】")||s.equals("鸿蒙智能套餐【氿台贵族酒+百花蜂蜜】")||s.equals("鸿蒙智能套餐【鸿蒙智能套装】")||s.equals("鸿蒙智能套餐【高血压一个疗程】")){
////                            user user = new user();
////                            user.setUid(uid);
////                            user.setGander(1);
////                            log.info(user.getUid()+"通过购买物基套餐成为物基用户");
////                            sqlSession.update("updatauserganderbyuid", user);
////                            sqlSession.commit();
//
//
//                        }
//
//                    }else{
//                        ////////接入配送、、、、、、、
//                    }
//
//
//                    ////////////开始分润、、、、、、、、、、
////                    String substr3ing = out_trade_no.substring(25,out_trade_no.length());
////                    float price = orderdate1.getPrice();
////                    LR lr=new LR(sqlSessionFactory);
////                    lr.yepro(price-Float.parseFloat(substr3ing));
//
////                    if (v>=0){
////                        lr.yepro((float)v );
////                        lr.jfpro(jf);
////                    }else {
////                        double v1 = jf + v;
////                        lr.jfpro(v1);
////                    }
////                    LR lr=new LR(sqlSessionFactory);
////                    lr.yepro();
//
//
//                //判断该笔订单是否在商户网站中已经做过处理
//                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//                //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
//                //如果有做过处理，不执行商户的业务程序
//
//                //注意：
//                //如果签约的是可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
//            }

            //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
//            out.clear();
//            out.println("success");	//请不要修改或删除
            response.getWriter().write("success");

            //////////////////////////////////////////////////////////////////////////////////////////
        } else {
            //验证失败
            log.info("商户单号："+out_trade_no+"验证失败");
            System.out.println("验证失败");
            return "fail";
        }
//            response.getWriter().write("fail");

//
//            out.println("fail");

//
//        //支付状态 TRADE_SUCCESS
//        System.out.println(request.getParameter("trade_status"));
//        //订单号
//        System.out.println(request.getParameter("trade_no "));
//        return "success";
        return null;
    }
        return null;
}
}

//@RequestMapping("/notify")
//    public void notify1(HttpServletRequest request, HttpServletResponse response) throws IOException, AlipayApiException {
//        Map<String, String> params = new HashMap<String, String>();
//        Map requestParams = request.getParameterMap();
//        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
//            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
//            params.put(name, valueStr);
//        }
//        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
//        //商户订单号
//
//        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
//        //支付宝交易号
//
//        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
//
//        //交易状态
//        String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
//
//        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
//        //计算得出通知验证结果
//        Alipayconfig alipayconfig = new Alipayconfig();
//        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
//        boolean verify_result = AlipaySignature.rsaCheckV1(params, alipayconfig.getAlipay_public_key(), alipayconfig.getCharset(), "RSA2");
//
//        if (verify_result) {//验证成功
//            //////////////////////////////////////////////////////////////////////////////////////////
//            //请在这里加上商户的业务逻辑程序代码
//
//            //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
//            System.out.println("验证成功");
//            System.out.println("商户订单号" + out_trade_no);
//            System.out.println("支付宝交易号" + trade_no);
//            System.out.println("交易状态" + trade_status);
//
//            if (trade_status.equals("TRADE_FINISHED")) {
//                //判断该笔订单是否在商户网站中已经做过处理
//                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//                //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
//                //如果有做过处理，不执行商户的业务程序
//
//                //注意：
//                //如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
//                //如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
//            } else if (trade_status.equals("TRADE_SUCCESS")) {
//                //判断该笔订单是否在商户网站中已经做过处理
//                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//                //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
//                //如果有做过处理，不执行商户的业务程序
//
//                //注意：
//                //如果签约的是可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
//            }
//
//            //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
////            out.clear();
////            out.println("success");	//请不要修改或删除
//            response.getWriter().write("success");
//
//            //////////////////////////////////////////////////////////////////////////////////////////
//        } else {//验证失败
//            response.getWriter().write("fail");
//            System.out.println("验证失败");
////            out.println("fail");
//        }
//
//    }