package factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
    private static SessionFactory sessionFactory;

    private HibernateFactory() {
    }

    public static SessionFactory getFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration()
                    .configure("config/hibernate.cfg.xml")
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void shutdown() {
        sessionFactory.close();
    }
}
