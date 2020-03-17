package net.vulk.shkola;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BookManager {

	protected SessionFactory sessionFactory;

	protected void setUp() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
			;
		}
	}

	protected void exit() {
		sessionFactory.close();
	}

	protected void create() {
		Book book = new Book("title", "author", 10.99F);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(book);

		session.getTransaction().commit();
		session.close();
	}

	protected void read(long bookID) {
		Session session = sessionFactory.openSession();

		Book book = session.get(Book.class, bookID);

		if (book != null) {
			System.out.println(book);
		}
		session.close();
	}
	
	protected void update() {
		Book book = new Book();
		book.setTitle("title2432");
		book.setAuthor("vasea");
		book.setPrice(12.90F);
		book.setId(2);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(book);

		session.getTransaction().commit();
		session.close();
	}
	
	protected void delete() {
		
		Book book = new Book();
		
		book.setId(3);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(book);

		session.getTransaction().commit();
		session.close();
	}

	public static void main(String[] args) {

		BookManager manager = new BookManager();

		manager.setUp();
//		manager.create();
		manager.read(1);
		manager.delete();
		manager.exit();
	}

}
