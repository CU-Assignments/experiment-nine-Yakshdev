import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class MainHibernateCRUD {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // CREATE
        Transaction tx = session.beginTransaction();
        Student s1 = new Student("Ravi", 20);
        session.save(s1);
        tx.commit();

        // READ
        Student student = session.get(Student.class, s1.getId());
        System.out.println("Read: " + student);

        // UPDATE
        tx = session.beginTransaction();
        student.setAge(21);
        session.update(student);
        tx.commit();

        // DELETE
        tx = session.beginTransaction();
        session.delete(student);
        tx.commit();

        session.close();
        factory.close();
    }
}
