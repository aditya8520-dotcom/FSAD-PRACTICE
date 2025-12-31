package com.klu.app;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.klu.model.Department;
import com.klu.model.Employee;
import com.klu.util.HibernateUtil;

public class MainApp {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Insert Employee");
            System.out.println("2.View Employee");
            System.out.println("3.Update Employee");
            System.out.println("4.Delete Employee");
            System.out.println("5.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertEmployee(sc);
                    break;
                case 2:
                    viewEmployee(sc);
                    break;
                case 3:
                    updateEmployee(sc);
                    break;
                case 4:
                    deleteEmployee(sc);
                    break;
                case 5:
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 5);

        HibernateUtil.shutdown();
        sc.close();
    }

    // INSERT
    private static void insertEmployee(Scanner sc) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Dept Name: ");
        String deptName = sc.next();

        Department dept = session.createQuery(
                "from Department where deptname = :name", Department.class)
                .setParameter("name", deptName)
                .uniqueResult();

        if (dept == null) {
            dept = new Department();
            dept.setDeptname(deptName);
        }

        System.out.print("Enter Emp Name: ");
        String empName = sc.next();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee();
        emp.setEmpname(empName);
        emp.setSalary(salary);
        emp.setDepartment(dept);

        session.persist(emp);

        tx.commit();
        session.close();
    }

    // VIEW
    private static void viewEmployee(Scanner sc) {

        Session session = factory.openSession();

        System.out.print("Enter Emp ID: ");
        int id = sc.nextInt();

        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            System.out.println(
                    emp.getEmpname() + " | " +
                    emp.getSalary() + " | " +
                    emp.getDepartment().getDeptname());
        } else {
            System.out.println("Employee Not Found");
        }

        session.close();
    }

    // UPDATE
    private static void updateEmployee(Scanner sc) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Emp ID: ");
        int id = sc.nextInt();

        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            System.out.print("Enter New Salary: ");
            emp.setSalary(sc.nextDouble());
            tx.commit();
        } else {
            System.out.println("Employee Not Found");
        }

        session.close();
    }

    // DELETE
    private static void deleteEmployee(Scanner sc) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Emp ID: ");
        int id = sc.nextInt();

        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            session.delete(emp);
            tx.commit();
        } else {
            System.out.println("Employee Not Found");
        }

        session.close();
    }
}
