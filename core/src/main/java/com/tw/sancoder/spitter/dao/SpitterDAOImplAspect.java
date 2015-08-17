package com.tw.sancoder.spitter.dao;//Created by SanCoder on 8/7/15.

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Aspect
@Service
public class SpitterDAOImplAspect {

    @Pointcut("execution(* com.tw.sancoder.spitter.dao.SpitterJdbcDAOImpl.*Spitter*(..))")
    public void jdbcDaoOperator(){
    }

    @Pointcut("execution(* com.tw.sancoder.spitter.dao.SpitterJpaDAOImpl.*Spitter*(..))")
    public void jpaDaoOperator(){
    }

    @Pointcut("execution(* com.tw.sancoder.spitter.dao.SpitterHibernateDAOImpl.*Spitter*(..))")
    public void hibernateDaoOperator(){
    }

    @Before("jpaDaoOperator()")
    public void beforeJpaOperator(){
        System.out.println("======= Jpa_Aop =======");
    }

    @Before("hibernateDaoOperator()")
    public void beforeHibernateOperator(){
        System.out.println("======= Hibernate_Aop =======");
    }

    @Before("jdbcDaoOperator()")
    public void beforeJdbcOperator(){
        System.out.println("======= Jdbc_Aop =======");
    }
}
