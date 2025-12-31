package com.klu;
import java.util.List;
import java.util.Scanner;
import org.hibernate.*;
import org.hibernate.query.Query;
import jakarta.persistence.criteria.*;
public class MainApp {
 static Scanner sc = new Scanner(System.in);
 public static void main(String[] args) {
 int ch;
 do {
 System.out.println("\n=== MENU (HQL + HCQL) ===");
 System.out.println("1. Insert Student");
 System.out.println("2. Show Students (HQL)");
 System.out.println("3. HCQL - Students marks > 50");
 System.out.println("0. Exit");
 System.out.print("Enter: ");
 ch = sc.nextInt();
 switch(ch) {
 case 1: insert(); break;
 case 2: showHQL(); break;
 case 3: showHCQL(); break;
 }
 } while(ch != 0);
 }
 static void insert() {
 System.out.print("Enter name: ");
 String name = sc.next();
 System.out.print("Enter marks: ");
 int marks = sc.nextInt();
 Session session = HibernateUtil.getSessionFactory().openSession();
 Transaction tx = session.beginTransaction();
 student s = new student(name, marks);
 session.persist(s);
 tx.commit();
 session.close();
 System.out.println("Inserted!");
 }
 // ===== HQL Example =====
 static void showHQL() {
 Session session = HibernateUtil.getSessionFactory().openSession();
 Query<student> q = session.createQuery("from Student", student.class); // HQL
 List<student> list = q.list();
 System.out.println("\nID NAME MARKS");
 for(student s : list) {
 System.out.println(s.getId()+" "+s.getName()+" "+s.getMarks());
 }
 session.close();
 }
 // ===== HCQL Example =====
 static void showHCQL() {
 Session session = HibernateUtil.getSessionFactory().openSession();
 CriteriaBuilder cb = session.getCriteriaBuilder();
 CriteriaQuery<student> cq = cb.createQuery(student.class);
 Root<student> root = cq.from(student.class);
 cq.select(root).where(cb.gt(root.get("marks"), 50)); // marks > 50
 Query<student> q = session.createQuery(cq);
 List<student> list = q.getResultList();
 System.out.println("\nStudents (marks > 50):");
 for(student s : list) {
 System.out.println(s.getId() + " | " + s.getName() + " | " + s.getMarks());
 }
 session.close();
 }
}
