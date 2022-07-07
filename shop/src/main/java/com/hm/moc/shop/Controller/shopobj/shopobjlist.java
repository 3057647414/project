package com.hm.moc.shop.Controller.shopobj;

import com.hm.moc.shop.Dao.layjson;
import com.hm.moc.shop.Mapper.ShopobjMapper;
import com.hm.moc.shop.Pojo.Shopobj;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/shopobj")
public class shopobjlist {
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/fandbyshow")
    public Object shopobjbyshow(int show) throws IOException {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ShopobjMapper mapper = sqlSession.getMapper(ShopobjMapper.class);
        List<Shopobj> fandall = mapper.fandshopobjbyshow(show);
        layjson l=new layjson();
        Map lay = l.lay(fandall);
        return lay;
    }
    @RequestMapping("/fandall")
    public Object shopobjall() throws IOException {

        SqlSession sqlSession=sqlSessionFactory.openSession();
        ShopobjMapper mapper = sqlSession.getMapper(ShopobjMapper.class);
        List<Shopobj> fandall = mapper.fandshopobjall();
        layjson l=new layjson();
        Map lay = l.lay(fandall);
        return lay;
    }
    @RequestMapping("/fandbytag")
    public Object shopobjbytag(String tag) throws IOException {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ShopobjMapper mapper = sqlSession.getMapper(ShopobjMapper.class);
        List<Shopobj> fand1 = mapper.fandshopobjbytag(tag);
        List<Shopobj> fand2 = mapper.fandshopobjbytag1(tag);
        List<Shopobj> fand3 = mapper.fandshopobjbytag2(tag);
        List<Shopobj> fand4 = mapper.fandshopobjbytag3(tag);
        List<List<Shopobj>> fandall = null;
        fandall.add(fand1);
        fandall.add(fand2);
        fandall.add(fand3);
        fandall.add(fand4);
        layjson l=new layjson();
        Map lay = l.lay(fandall);
        return lay;
    }
    @RequestMapping("/fandbyname")
    public Object shopobjbyname(String name) throws IOException {
        String name1='%'+name+'%';
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ShopobjMapper mapper = sqlSession.getMapper(ShopobjMapper.class);
        List<Shopobj> fandall = mapper.fandshopobjbyname(name1);
        layjson l=new layjson();
        Map lay = l.lay(fandall);
        return lay;
    }
    @RequestMapping("/fandbysort")
    public Object shopobjbysort(String sort) throws IOException {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ShopobjMapper mapper = sqlSession.getMapper(ShopobjMapper.class);
        List<Shopobj> fandall = mapper.fandshopobjbysort(sort);
        layjson l=new layjson();
        Map lay = l.lay(fandall);
        return lay;
    }
    @RequestMapping("/fandbysort1")
    public Object shopobjbysort1(String sort) throws IOException {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ShopobjMapper mapper = sqlSession.getMapper(ShopobjMapper.class);
        List<Shopobj> fandall = mapper.fandshopobjbysort1(sort);
        layjson l=new layjson();
        Map lay = l.lay(fandall);
        return lay;
    }
    @RequestMapping("/fandbysort2")
    public Object shopobjbysort2(String sort) throws IOException {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ShopobjMapper mapper = sqlSession.getMapper(ShopobjMapper.class);
        List<Shopobj> fandall = mapper.fandshopobjbysort2(sort);
        layjson l=new layjson();
        Map lay = l.lay(fandall);
        return lay;
    }
    @RequestMapping("/fandbyid")
    public Object shopobjbysort2(double id) throws IOException {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ShopobjMapper mapper = sqlSession.getMapper(ShopobjMapper.class);
        List<Shopobj> fandall = mapper.fandshopobjbyid(id);
        layjson l=new layjson();
        Map lay = l.lay(fandall);
        return lay;
    }
    @RequestMapping("/fandbyshopid")
    public Object shopobjbyshopid(double shopid) throws IOException {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ShopobjMapper mapper = sqlSession.getMapper(ShopobjMapper.class);
        List<Shopobj> fandall = mapper.fandshopobjbyshopid(shopid);
        layjson l=new layjson();
        Map lay = l.lay(fandall);
        return lay;
    }
    @RequestMapping("/fandbybaoyou")
    public Object shopobjbybaoyou(String B) throws IOException {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        ShopobjMapper mapper = sqlSession.getMapper(ShopobjMapper.class);
        List<Shopobj> fandall = mapper.fandshopobjbybaoyou(B);
        layjson l=new layjson();
        Map lay = l.lay(fandall);
        return lay;
    }

}
