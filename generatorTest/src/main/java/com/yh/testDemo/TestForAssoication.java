package com.yh.testDemo;

import com.yh.mapper.UserMapper;
import com.yh.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
public class TestForAssoication {
    @Test
    public void test() throws IOException {
        InputStream resourceAsStream= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build=new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession=build.openSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
//执行增删改查
        mapper.insert(new User(null,"张三",new Date(),"男","北京"));
        mapper.deleteByPrimaryKey(79);
        mapper.updateByPrimaryKey(new User(80,"李四",new Date(),"女","上海"));
        System.out.println(mapper.selectByPrimaryKey(80));
        sqlSession.commit();
        sqlSession.close();
       }
}
