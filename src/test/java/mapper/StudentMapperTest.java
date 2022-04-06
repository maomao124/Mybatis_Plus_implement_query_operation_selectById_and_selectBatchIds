package mapper;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import data.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Mybatis_Plus实现查询操作之selectById和selectBatchIds
 * Package(包名): mapper
 * Class(测试类名): StudentMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/6
 * Time(创建时间)： 18:40
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class StudentMapperTest
{
    @Test
    public void selectById() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.selectById(202012341049L);
        System.out.println(student);

        sqlSession.close();

    }

    @Test
    public void selectBatchIds() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        List<Long> list = new ArrayList<>();
        list.add(202012341049L);
        list.add(202012341050L);
        list.add(202012341051L);
        list.add(202012341052L);
        list.add(202012341053L);
        list.add(202012341054L);

        List<Student> students = studentMapper.selectBatchIds(list);
        for (Student student : students)
        {
            System.out.print(student);
        }

        sqlSession.close();

    }

    @Test
    public void selectBatchIds1() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

//        List<Long> list = new ArrayList<>();
//        list.add(202012341049L);
//        list.add(202012341050L);
//        list.add(202012341051L);
//        list.add(202012341052L);
//        list.add(202012341053L);
//        list.add(202012341054L);

        List<Student> students = studentMapper.selectBatchIds(Arrays.asList(202012341049L, 202012341050L));
        for (Student student : students)
        {
            System.out.print(student);
        }

        sqlSession.close();

    }
}