package com.yh.testDemo;

import com.yh.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestForAssoication {

    @Test
    public void test() throws IOException {
        InputStream resourceAsStream= Resources.getResourceAsStream("generatorConfig.xml");
        SqlSessionFactory build=new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession=build.openSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        System.out.println(mapper.selectByPrimaryKey(80));

//        UserExample userExample = new UserExample();
//        userExample.setOrderByClause("id desc,username");
//        userExample.setDistinct(true);//去重
//
//        UserExample.Criteria criteria = userExample.createCriteria();
//        criteria.andIdEqualTo(1);


        sqlSession.commit();
        sqlSession.close();
}
}
