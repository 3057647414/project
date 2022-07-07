package com.hm.moc.shop.Mapper;

import com.hm.moc.shop.Pojo.Shop;
import com.hm.moc.shop.Pojo.User;
import org.apache.ibatis.annotations.*;

import java.lang.ref.PhantomReference;
import java.util.List;

@Mapper
public interface UserMapper {
    //------查询------
    @Select("select * from Users")
    List<User> fanduserall();

    @Select("select * from users where uid=#{uid}")
    User fanduserbyuid(String uid);
    @Select("select * from users where gander=#{gander}")
    List<User> fanduserbygander(int gander);
    @Select("select * from users where name=#{name}")
    List<User> fanduserbyname(String name);
    @Select("select * from users where id=#{id}")
    User fanduserbyid(double id);
    @Select("select * from users where job=#{job}")
    List<User> fanduserbyjob(String job);
    @Select("select * from users where phone=#{phone}")
    User fanduserbyphone(String phone);

    //------增加---------
    @Insert("insert into users (phone,pwd,name) values (#{phone},#{pwd},#{name})")
    int adduser(String phone,String pwd,String name);
    //-----删除------
    @Delete("delete from users where phone=#{phone}")
    int deluser(String phone);
    //------修改------
    @Update("update users set pwd=#{pwd} where phone=#{phone}")
    int uppwd(String pwd ,String phone);
    @Update("update users set gander=#{gander} where phone=#{phone}")
    int upgander(String phone,int gander);
    @Update("update users set jobgander=#{jobgander} where phone=#{phone}")
    int upjobgander(String phone,int jobgander);
    @Update("update users set jf=#{jf} where phone=#{phone}")
    int upjf(String phone,double jf);
    @Update("update users set ye=#{ye} where phone=#{phone}")
    int upye(String phone,double ye);
    @Update("update users set head=#{head} where phone=#{phone}")
    int uphead(String phone,String head);
    @Update("update users set job=#{job} where phone=#{phone}")
    int upjob(String phone,String job);
    @Update("update users set name=#{name} where phone=#{phone}")
    int upname(String phone,String name);
    @Update("update users set uid=#{uid} where phone=#{phone}")
    int upuid(String phone, String uid);
    @Update("update users set careshop=#{shop} where phone=#{phone}")
    int addshop(String phone, String shop);//需要json
    @Update("update users set order=#{order} where phone=#{phone}")
    int addorder(String phone,String order);//需要json
    @Update("update users set shopcart=#{shopcart} where phone=#{phone}")
    int addshopcart(String phone,String shopcart);//需要json
    @Update("update users set homeaddress=#{where} where phone=#{phone}")
    int addwhere(String phone,String where);//需要json
    @Update("update users set phone=#{phone} where uid=#{uid}")
    int upphone(String phone,String uid);








}
