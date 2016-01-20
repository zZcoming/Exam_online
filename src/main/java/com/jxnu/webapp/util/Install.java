package com.jxnu.webapp.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Connection;

/**
 * Created by puchunwei on 15/12/20.
 * 安装程序
 */
@Component
public class Install {

    @Resource
    private SqlSessionFactory sessionFactory;

    /**
     * 执行安装
     */
    @Transactional
    public void install() {
        SqlSession session = sessionFactory.openSession();
        Connection conn = session.getConnection();

        System.out.print(conn);


    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring/spring.xml");
        Install installer = (Install) ac.getBean("install");
        installer.install();
    }
}
