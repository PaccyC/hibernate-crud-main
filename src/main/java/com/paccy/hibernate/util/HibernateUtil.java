package com.paccy.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static  SessionFactory getSessionFactory() {
        if (sessionFactory==null){
        try {
            Configuration configuration = new Configuration();

            Properties settings= new Properties();

            settings.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
            settings.put(Environment.URL,"jdbc:mysql://localhost:3306/hibernate_db?useSSL=false");
            settings.put(Environment.USER,"root");
            settings.put(Environment.PASS,"");
            settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");

            settings.put(Environment.SHOW_SQL,"true");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
            settings.put(Environment.HBM2DDL_AUTO,"create-drop");

            configuration.setProperties(settings);
            ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        }
        return sessionFactory;
    }
}
