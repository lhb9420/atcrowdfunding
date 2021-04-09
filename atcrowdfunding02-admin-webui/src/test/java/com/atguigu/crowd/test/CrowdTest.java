package com.atguigu.crowd.test;


import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import com.github.pagehelper.PageInfo;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.ibatis.jdbc.Null;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
// 加载 Spring 配置文件的注解
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void testLog() {

        // 1.获取Logger对象，这里传入的Class对象就是当前打印日志的类
        Logger logger = LoggerFactory.getLogger(CrowdTest.class);

        // 2.根据不同日志级别打印日志
        logger.debug("Hello I am Debug level!!!");
//        logger.debug("Hello I am Debug level!!!");
//        logger.debug("Hello I am Debug level!!!");

//        logger.info("Info level!!!");
//        logger.info("Info level!!!");
//        logger.info("Info level!!!");

//        logger.warn("Warn level!!!");
//        logger.warn("Warn level!!!");
//        logger.warn("Warn level!!!");
//
//        logger.error("Error level!!!");
//        logger.error("Error level!!!");
//        logger.error("Error level!!!");
    }

    @Test
    public void testAdmin(){
        Admin admin=new Admin(null,"jerry","12345","杰瑞","jerry@qq.com",null);
        adminService.saveAdmin(admin);
    }
    @Test
    public void testInsert(){
        Admin admin=new Admin(null,"tom","123123","汤姆","@qq.com",null);
        int count=adminMapper.insert(admin);
        System.out.println("受影响行数:"+count);
    }
    @Test
    public void testDataSource() throws SQLException {
// 1.通过数据源对象获取数据源连接
        Connection connection = dataSource.getConnection();
// 2.打印数据库连接
        System.out.println(connection);
    }

    @Test
    public void admininsert(){
        PageInfo<Admin> pageInfo=adminService.getPageHelper("",1,5);
        System.out.println(pageInfo.getPageSize());
        List<Admin> adminList= pageInfo.getList();
        for (Admin a : adminList) {
            System.out.println(a.getLoginAcct());
        }
    }
}