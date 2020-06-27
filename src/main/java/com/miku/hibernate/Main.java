package com.miku.hibernate;

import com.miku.hibernate.entity.AuthorEntity;
import com.miku.hibernate.entity.BookEntity;
import org.hibernate.jpa.internal.QueryImpl;
import org.hibernate.query.NativeQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        AuthorEntity author = new AuthorEntity();
        author.setName("Jerome");
        author.setSurname("K. Jerome");
        author.setIsActive(0);

        BookEntity book = new BookEntity();
        book.setTitle("Three men in a boat");
        book.setGenre("Comedy");
        book.setRating(4);
        book.setAuthorId(6);
        book.setAuthorOfBooks(author);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        /*
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
         */

        entityManager.getTransaction().begin();
        NativeQuery q1 =  entityManager.createNativeQuery(
                "SELECT * b.title, b.rating, a.name, a.surname FROM books as b INNER JOIN authors as a ON b.authorId = a.id WHERE b.rating>4");
        Stream<Object[]> things = q1.getResultStream();
        things.forEach(System.out::println);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
   /* entityManager.createQuery("from AuthorEntity", AuthorEntity.class).getResultList().stream().
            forEach(custEnt -> System.out.println(custEnt));
        entityManager.createQuery("from BookEntity", BookEntity.class).getResultList().stream().
                forEach(System.out::println);
    */
        entityManager.getTransaction().commit();

       /* int i = 1;
        Scanner sc = new Scanner(System.in);
        entityManager.getTransaction().begin();
        while (i < 5) {
            final BookEntity bookEntity1 = entityManager.find(BookEntity.class, i);
            System.out.println("Write the next series Id");
            bookEntity1.setSeriesId(sc.nextInt());
            entityManager.persist(bookEntity1);
            i++;
        System.out.println("Customer entity with Id : " + i + " = " + bookEntity1);
        }

        entityManager.getTransaction().commit();
        */

        /*
        final BookEntity bookEntity = entityManager.getReference(BookEntity.class, 4);
        if (bookEntity != null) {
            entityManager.getTransaction().begin();
            bookEntity.setRating(4);
            entityManager.persist(bookEntity);
            entityManager.getTransaction().commit();
        }
        System.out.println("Customer entity with Id : 1 = " + bookEntity);

         */
/*
        entityManager.getTransaction().begin();
        BookEntity book2 = new BookEntity();
        book2 = entityManager.find(BookEntity.class, 2);
        System.out.println(book);
 */

        entityManagerFactory.close();
    }
}
