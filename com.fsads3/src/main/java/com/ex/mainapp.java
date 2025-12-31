package com.ex;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.entity.Employee;
import com.example.util.hiberu;

public class mainapp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int ch;
        do {
            System.out.println("\n=== HQL MENU ===");
            System.out.println("1. Insert Sample Data");
            System.out.println("2. Select - Show All Employees");
            System.out.println("3. Update Salary (Positional Parameter)");
            System.out.println("4. Delete Employee (Named Parameter)");
            System.out.println("5. Sort Employees (ORDER BY Salary)");
            System.out.println("6. Aggregate Functions");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            ch = sc.nextInt();

            switch (ch) {
                case 1: insertSampleData(); break;
                case 2: showAll(); break;
                case 3: updateSalary(); break;
                case 4: deleteEmployee(); break;
                case 5: sortEmployees(); break;
                case 6: aggregate(); break;
                case 0: System.out.println("Exited"); break;
                default: System.out.println("Invalid choice");
            }

        } while (ch != 0);
    }

    // 1. Insert
    static void insertSampleData() {
        Session s = hiberu.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        s.save(new Employee("Ravi", 25000));
        s.save(new Employee("Kiran", 30000));
        s.save(new Employee("Anil", 20000));

        tx.commit();
        s.close();

        System.out.println("Sample data inserted");
    }

    // 2. Select
    static void showAll() {
        Session s = hiberu.getSessionFactory().openSession();

        Query<Employee> q = s.createQuery("from Employee", Employee.class);
        List<Employee> list = q.list();

        for (Employee e : list) {
            System.out.println(e.getEmpId() + " " + e.getEmpName() + " " + e.getSalary());
        }

        s.close();
    }

    // 3. Update
    static void updateSalary() {
        System.out.print("Enter EmpId: ");
        int id = sc.nextInt();
        System.out.print("Enter new salary: ");
        double sal = sc.nextDouble();

        Session s = hiberu.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        Query q = s.createQuery("update Employee set salary=?1 where empId=?2");
        q.setParameter(1, sal);
        q.setParameter(2, id);

        int res = q.executeUpdate();
        tx.commit();
        s.close();

        System.out.println(res + " record updated");
    }

    // 4. Delete
    static void deleteEmployee() {
        System.out.print("Enter EmpId: ");
        int id = sc.nextInt();

        Session s = hiberu.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        Query q = s.createQuery("delete from Employee where empId=:id");
        q.setParameter("id", id);

        int res = q.executeUpdate();
        tx.commit();
        s.close();

        System.out.println(res + " record deleted");
    }

    // 5. Order By
    static void sortEmployees() {
        Session s = hiberu.getSessionFactory().openSession();

        Query<Employee> q = s.createQuery(
                "from Employee order by salary desc", Employee.class);

        List<Employee> list = q.list();
        for (Employee e : list) {
            System.out.println(e.getEmpName() + " " + e.getSalary());
        }

        s.close();
    }

    // 6. Aggregate
    static void aggregate() {
        Session s = hiberu.getSessionFactory().openSession();

        Query q = s.createQuery(
                "select count(*), avg(salary), max(salary), min(salary) from Employee");

        Object[] row = (Object[]) q.uniqueResult();

        System.out.println("Count : " + row[0]);
        System.out.println("Average Salary : " + row[1]);
        System.out.println("Max Salary : " + row[2]);
        System.out.println("Min Salary : " + row[3]);

        s.close();
    }
}
