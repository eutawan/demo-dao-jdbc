package org.example.application;

import org.example.model.dao.DaoFactory;
import org.example.model.dao.SellerDao;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById === ");
        Seller seller = sellerDao.findById(7);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment === ");
        Department department = new Department(4, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

//        System.out.println("\n=== TEST 4: seller insert ===");
//        Seller newSeller = new Seller(null, "Bruna Bernardo", "bruninha@gmail.com", new Date(),
//                4000.0, department);
//        sellerDao.insert(newSeller);
//        System.out.println("Inserted! new id: " + newSeller.getId());

//        System.out.println("\n === TEST 5: seller update ===");
//        seller = sellerDao.findById(1);
//        seller.setName("Ciciana Souza");
//        sellerDao.update(seller);
//        System.out.println("Update completed!");
//
        System.out.println("\n=== TEST 6: seller delete ===");
        System.out.println("Enter id for delete test: ");
        int idDeleted = sc.nextInt();
        sellerDao.deleteById(idDeleted);

        System.out.println("Delete completed!");

        sc.close();

    }
}
