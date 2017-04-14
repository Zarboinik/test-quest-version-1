package foo.bar;

import foo.bar.domain.Desktop;
import foo.bar.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) throws Exception {
        HibernateUtil.initSessionFactory("jdbc:mysql://localhost:3306/lesson", "root", "Lidercool1");

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
        Desktop d = new Desktop("Laptop",2352351,"Russia",52,7);
        session.save(d);

        transaction.commit();
    }

    private static List<Desktop> getContent() throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("From Desktop ");
        List<Desktop> employees = query.list();

        transaction.commit();

        return employees;
    }
}
