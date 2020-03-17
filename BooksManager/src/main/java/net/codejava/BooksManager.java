package net.codejava;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.codejava.models.Book;

public class BooksManager {
	static EntityManagerFactory factory;
	static EntityManager entityManager;

	public static void main(String[] args) {
		begin();

//		createBook();

//		findByID(6);
//		update();
		query();

		close();
	}

	private static void query() {
		String jpql = "SELECT book FROM Book book WHERE book.price < 100";
		Query query = entityManager.createQuery(jpql);
		List<Book> resultList = query.getResultList();
		for (Book book : resultList) {
			System.out.println(book);
		}
	}

	private static void findByID(Integer id) {
		Book book = entityManager.find(Book.class, id);
		System.out.println(book);
	}

	private static void update() {
		Book book = new Book();
		book.setBookId(6);
		book.setTitle("some book");
		book.setAuthor("Me");
		book.setPrice(99.99f);
		entityManager.merge(book);

	}

	private static void close() {
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

	private static void begin() {
		factory = Persistence.createEntityManagerFactory("BookUnit");
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
	}

	private static void createBook() {

		Book book = new Book();
		book.setTitle("Title");
		book.setAuthor("Me");
		book.setPrice(99.99f);
		entityManager.persist(book);
	}

}
