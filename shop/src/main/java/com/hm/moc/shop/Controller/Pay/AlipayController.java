package com.hm.moc.shop.Controller.Pay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.hm.moc.shop.Pojo.Order;
import com.hm.moc.shop.Pojo.Shopobj;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class AlipayController {

    private static String URL="https://openapi.alipaydev.com/gateway.do";
    private static String APP_ID="2021000119649086";
    private static String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm6W3Xiez5e27Y/H3Cd4M5noOsm+5yAxRclXUJsYHo/aL5NSfnXevI710NOPMnKs1CE39C+lzjlQXsSu44SNs3Ec+JQfUmcowULkzroOSfIKeT1ShVQHXAk0DAqcedjVd5LlymKVUGKUxRcpe5CYmBeVS/q/LLpF3PCTu4Jq2gCqHdDAwoA6r6FMRveRmmz0dSoJZ9hLT2cIFL4UMrXpQRK8tqBeWAdPpp8HrVMD47UkIk3QLl2ceZ0uwyhzy7einslfo6imy4GE3t4SRs+2wQY61nxdXYiN2VlzVYRBcrYNhtWoHRr05DBgMiHcEMsm+XzrwI6ZchWyFMY3VJuT2mwIDAQAB";
    private static String APP_PRIVATE_KEY="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCbpbdeJ7Pl7btj8fcJ3gzmeg6yb7nIDFFyVdQmxgej9ovk1J+dd68jvXQ048ycqzUITf0L6XOOVBexK7jhI2zcRz4lB9SZyjBQuTOug5J8gp5PVKFVAdcCTQMCpx52NV3kuXKYpVQYpTFFyl7kJiYF5VL+r8sukXc8JO7gmraAKod0MDCgDqvoUxG95GabPR1Kgln2EtPZwgUvhQytelBEry2oF5YB0+mnwetUwPjtSQiTdAuXZx5nS7DKHPLt6KeyV+jqKbLgYTe3hJGz7bBBjrWfF1diI3ZWXNVhEFytg2G1agdGvTkMGAyIdwQyyb5fOvAjplyFbIUxjdUm5PabAgMBAAECggEAQcxPdT1Bfsz+L+UlMwWs3G3y8pnqptgWQkhoVC/ZIQZj40vDYjUrU+eOTaGTaROzapxVggihsiR4k4xRLtPj/EcdzVe/F3hy7l0srPSwI3Swagbz4NTTSQS3ZhKx/PTYiY2gFUmnAHgtGTzQ2pAJ+OoWKNa2BSy3hDR0y3x79DfdnBFR+HIW6fs0uV7VGy9HF9feHVhgLg0TGEGhvJp8dq6D9VXct1DZ6vouypGEXqYyKYqPzYCby1R1tLIDWhKovoxTQwTlTLzdRYfFRBZarGJmRBNhaxN1UUizfueRiGBu/8aJG/rYqsP0QLiDxYrFJdTGLJFdPpWJprnwx3d64QKBgQDKQo6QSs8OYivWNDR58VyQ/M9OkkgeH6LpzHy1HQxlM6na5z65bRTFdfWLrHrHVL9uPG+U0Cn3Yu4v2idWQRmSv24eKic3uvVWzoTXUipWp0B02rwl2r7n/7P918tKYtWBMwuTQnBdJzBQColjTSwI8Ruw9ElEkcRsglEsAzuMMQKBgQDFAKGUalDMfcotWUqEnANmScXNcQTv01Xv4YF/7rbjNfRALDE5rKxthGVIZIzDBEhJHJW8QTvKlnpz8bVa68DMVAI77iBJeWUYnaBMC72Az7aiNbpFShqHcD7ZevTFHjTWBQn/rYQ/f3qb+CjteFO8BamGyMO+qgOgtQsn/o9YiwKBgDbQXNSMAZtTTbAKi+I0YDLG4OPZTwQi7MLR8UYgLjjLDJBPtTcJceSluDr3LnsQ46Rbap344Da0L/r1800z7VtQ1+YC5If8+fphk6zLDsBXKWfB09Wqd6xmJwB3WBe7u0L9c3igO9VzBmvavysTQgjWVvvY6HZVztbdZmQ4KA4xAoGAQRUTTGfPJ6+K4m50StkL2ngWy+dBnUVxR511XeFsNCX3+ldfL9GW6Vtq5n6pbif1BYpXAWl/qk8KR1Gb+1yVRiuezVO/AOcE+hvhAB6EzZBRoscjMY7ossPnT4vqX1C6XdYuVnRpk1y3Ed3rD4DIEP7B4dBjspKSPj5xYBYeHz8CgYBLVcPZ+4oJcK5+OpotxPt7h8+QEbNnXx+/bKN/2ft7CkOe+SyF8A6oP4/ohlmd8Z9sumeFzjcVD2g8c5l1MByiqhzhYy1EME+VJK6RuiTFKTJdeqpJYHaF4wx61vNaio6GUIVDuR4m5pG3mQRm6QxjyJgWMMggU+IWdk9NBjz57A==";
    private static String FORMAT="JSON";
    private static String CHARSET="utf-8";
    @GetMapping("/alipay")
    public Object doPost(Order orderdate) throws IOException{
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2021000119649086","MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCbpbdeJ7Pl7btj8fcJ3gzmeg6yb7nIDFFyVdQmxgej9ovk1J+dd68jvXQ048ycqzUITf0L6XOOVBexK7jhI2zcRz4lB9SZyjBQuTOug5J8gp5PVKFVAdcCTQMCpx52NV3kuXKYpVQYpTFFyl7kJiYF5VL+r8sukXc8JO7gmraAKod0MDCgDqvoUxG95GabPR1Kgln2EtPZwgUvhQytelBEry2oF5YB0+mnwetUwPjtSQiTdAuXZx5nS7DKHPLt6KeyV+jqKbLgYTe3hJGz7bBBjrWfF1diI3ZWXNVhEFytg2G1agdGvTkMGAyIdwQyyb5fOvAjplyFbIUxjdUm5PabAgMBAAECggEAQcxPdT1Bfsz+L+UlMwWs3G3y8pnqptgWQkhoVC/ZIQZj40vDYjUrU+eOTaGTaROzapxVggihsiR4k4xRLtPj/EcdzVe/F3hy7l0srPSwI3Swagbz4NTTSQS3ZhKx/PTYiY2gFUmnAHgtGTzQ2pAJ+OoWKNa2BSy3hDR0y3x79DfdnBFR+HIW6fs0uV7VGy9HF9feHVhgLg0TGEGhvJp8dq6D9VXct1DZ6vouypGEXqYyKYqPzYCby1R1tLIDWhKovoxTQwTlTLzdRYfFRBZarGJmRBNhaxN1UUizfueRiGBu/8aJG/rYqsP0QLiDxYrFJdTGLJFdPpWJprnwx3d64QKBgQDKQo6QSs8OYivWNDR58VyQ/M9OkkgeH6LpzHy1HQxlM6na5z65bRTFdfWLrHrHVL9uPG+U0Cn3Yu4v2idWQRmSv24eKic3uvVWzoTXUipWp0B02rwl2r7n/7P918tKYtWBMwuTQnBdJzBQColjTSwI8Ruw9ElEkcRsglEsAzuMMQKBgQDFAKGUalDMfcotWUqEnANmScXNcQTv01Xv4YF/7rbjNfRALDE5rKxthGVIZIzDBEhJHJW8QTvKlnpz8bVa68DMVAI77iBJeWUYnaBMC72Az7aiNbpFShqHcD7ZevTFHjTWBQn/rYQ/f3qb+CjteFO8BamGyMO+qgOgtQsn/o9YiwKBgDbQXNSMAZtTTbAKi+I0YDLG4OPZTwQi7MLR8UYgLjjLDJBPtTcJceSluDr3LnsQ46Rbap344Da0L/r1800z7VtQ1+YC5If8+fphk6zLDsBXKWfB09Wqd6xmJwB3WBe7u0L9c3igO9VzBmvavysTQgjWVvvY6HZVztbdZmQ4KA4xAoGAQRUTTGfPJ6+K4m50StkL2ngWy+dBnUVxR511XeFsNCX3+ldfL9GW6Vtq5n6pbif1BYpXAWl/qk8KR1Gb+1yVRiuezVO/AOcE+hvhAB6EzZBRoscjMY7ossPnT4vqX1C6XdYuVnRpk1y3Ed3rD4DIEP7B4dBjspKSPj5xYBYeHz8CgYBLVcPZ+4oJcK5+OpotxPt7h8+QEbNnXx+/bKN/2ft7CkOe+SyF8A6oP4/ohlmd8Z9sumeFzjcVD2g8c5l1MByiqhzhYy1EME+VJK6RuiTFKTJdeqpJYHaF4wx61vNaio6GUIVDuR4m5pG3mQRm6QxjyJgWMMggU+IWdk9NBjz57A==","json","utf-8","MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm6W3Xiez5e27Y/H3Cd4M5noOsm+5yAxRclXUJsYHo/aL5NSfnXevI710NOPMnKs1CE39C+lzjlQXsSu44SNs3Ec+JQfUmcowULkzroOSfIKeT1ShVQHXAk0DAqcedjVd5LlymKVUGKUxRcpe5CYmBeVS/q/LLpF3PCTu4Jq2gCqHdDAwoA6r6FMRveRmmz0dSoJZ9hLT2cIFL4UMrXpQRK8tqBeWAdPpp8HrVMD47UkIk3QLl2ceZ0uwyhzy7einslfo6imy4GE3t4SRs+2wQY61nxdXYiN2VlzVYRBcrYNhtWoHRr05DBgMiHcEMsm+XzrwI6ZchWyFMY3VJuT2mwIDAQAB","RSA2");
//        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
//        String ordername = orderdate.getOrdername();
        String ordernumber = orderdate.getOrdernum();
        List<Shopobj> shopobj = orderdate.getShopobj();
        double price=0;
        double cost=0;
        for (Shopobj s:shopobj){
            price=s.getPrice()+price;
            cost=s.getCost()+cost;
        }
//        double price = orderdate.getPrice();
//        float cost=0;
//        List<shopobj> list = orderdate.getList();
//        for (shopobj s:list){
//            cost=s.getCostprice()+cost;
//        }
        String c="\""+cost+"\"";

        alipayRequest.setBizContent("{" +
                " \"out_trade_no\":"+ordernumber+"," +
                " \"total_amount\":"+price+"," +
                " \"subject\":"+"123456"+"," +
                " \"product_code\":"+c +
                " }");//填充业务参数
        String form="";
        alipayRequest.setNotifyUrl("http://k3832c6783.qicp.vip/rt");
        alipayRequest.setReturnUrl("http://k3832c6783.qicp.vip/return.html");
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }
}
