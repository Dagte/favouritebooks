package com.miku.hibernate;

import com.miku.hibernate.entity.AuthorEntity;
import com.miku.hibernate.entity.BookEntity;
import com.miku.hibernate.entity.SeriesEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfig {
    public static SessionFactory buildSessionFactory() {
        try {
            final Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            configuration.addAnnotatedClass(AuthorEntity.class);
            configuration.addAnnotatedClass(BookEntity.class);
            configuration.addAnnotatedClass(SeriesEntity.class);
//            configuration.addAnnotatedClass(BankEntity.class);
//            configuration.addAnnotatedClass(IdentityEntity.class);
//            configuration.addAnnotatedClass(CurrencyEntity.class);

            return configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed." + ex.getMessage());
            throw ex;
        }
    }
}
