import ge.vulk.entities.Company;
import ge.vulk.entities.Event;
import ge.vulk.entities.Product;
import ge.vulk.entities.User;
import ge.vulk.entities.embeddables.Address;
import ge.vulk.entities.enums.UserRight;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = factory.createEntityManager();

//        User user = new User();
//        user.setFullName("Anna Chiriac");
//        user.setUserRight(UserRight.USER);
//        entityManager.persist(user);

//        Product product = new Product();
//        product.setExpirationDate(LocalDate.now());
//        entityManager.persist(product);

//        Event event = new Event();
//        event.setEventTime(LocalDateTime.now());
//        entityManager.persist(event);

        Company company = new Company();
        company.setName("Vulk");
        company.setAddress(new Address());

        company.getAddress().setNumber("26");
        company.getAddress().setStreet("Lazo");
        company.getAddress().setCity("Moscow");

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(company); // adding the instance in the context

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            entityManager.close();
        }
    }
}
