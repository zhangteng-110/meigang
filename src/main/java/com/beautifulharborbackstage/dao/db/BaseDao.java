package com.beautifulharborbackstage.dao.db;

import com.beautifulharborbackstage.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BaseDao {

    public SqlSession getSqlSession() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        return sqlSessionFactory.openSession();
    }

}