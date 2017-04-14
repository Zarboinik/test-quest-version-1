package foo.bar.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

/**
 * Created by Zarboinik on 14.04.2017.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static void initSessionFactory(String url, String username, String password) throws Exception {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactoryWithoutXml(url, username, password);
        } else {
            throw new Exception("session factory already exist");
        }
    }

    public static SessionFactory getSessionFactory() throws Exception {
        if (sessionFactory != null) {
            return sessionFactory;
        } else {
            throw new Exception("session factory doesn't start");
        }
    }

    public static void shutdown() {
        // Close caches and connection pools
        try {
            getSessionFactory().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Build sessionFactory with properties from resources/hibernate.cfg.xml
     * @return SessionFactory
     */
    private static SessionFactory buildSessionFactoryTroughXml() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Build sessionFactory without xml files, with hardcoded properties and url, username, password parameters
     * @return SessionFactory
     */
    private static SessionFactory createSessionFactoryWithoutXml(String url, String username, String password) {
        try {
            Properties p = new Properties();

            p.setProperty("hibernate.connection.url", url);
            p.setProperty("hibernate.connection.username", username);
            p.setProperty("hibernate.connection.password", password);
            p.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");

            // print all sql queries into stdout
            p.setProperty("show_sql", "true");
            // format queries in stdout
            p.setProperty("format_sql", "true");

            // that means, if table doesn't exist yet, hibernate will create them automatically
            p.setProperty("hbm2ddl.auto", "create");

            // amount of connection in one session
            p.setProperty("connection.pool_size", "5");
            p.setProperty("current_session_context_class", "thread");

            return new Configuration().configure()
                    .addPackage("foo.bar.domain")
                    .addProperties(p)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
}
