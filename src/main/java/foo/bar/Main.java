package foo.bar;

import foo.bar.domain.Desktop;
import foo.bar.domain.Display;
import foo.bar.domain.Hdd;
import foo.bar.domain.Laptop;
import foo.bar.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) throws Exception {
        HibernateUtil.initSessionFactory();

        saveItems();

        getContent().forEach(e -> {
            log.warn("----------------------------------------------------------------------------------------------");
            log.warn("{}", e);
            log.warn("----------------------------------------------------------------------------------------------");
        });
    }

    private static void saveItems() throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        // method body start
        Desktop d = new Desktop("NetTop",2352351,"Russia",52,7);
        session.save(d);

        Laptop l = new Laptop(12,23535235,"China",134,3);
        session.save(l);
        Laptop l2 = new Laptop(14,2355,"Russia",100,4);
        session.save(l2);

        Display display1 = new Display(17,235321,"Russia",50,2);
        session.save(display1);
        Display display2 = new Display(21,44444,"China",25,5);
        session.save(display2);

        Hdd hdd1 = new Hdd(1000,44223,"Russia",10,2);
        session.save(hdd1);
        Hdd hdd2 = new Hdd(2000,333252,"China",7,23);
        session.save(hdd2);

        transaction.commit();
    }

    private static List getContent() throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("From Desktop ");
        List employees = query.list();

        transaction.commit();

        return employees;
    }
}
