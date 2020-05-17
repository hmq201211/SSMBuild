package com.hmq.dao;

import com.hmq.pojo.Books;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BookMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addBookTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        int i = bookMapper.addBook(new Books(4, "hmq", 2, "detail"));
        System.out.println(i);
    }


    public void deleteBookTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        int i = bookMapper.deleteBookById(9);
        System.out.println(i);
    }

    public void updateBookTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        int i = bookMapper.updateBook(new Books(10, "hmq11111", 2, "detail"));
        System.out.println(i);
    }

    @Test
    public void queryBookTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Books books = bookMapper.queryBookById(1);
        System.out.println(books);
    }

    @Test
    public void queryBooksTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        List<Books> books = bookMapper.queryAllBooks();
        books.forEach(System.out::println);
    }
}
