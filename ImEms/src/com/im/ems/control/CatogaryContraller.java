/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.im.ems.control;

import com.im.ems.model.Category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author CsSamarE
 */
public class CatogaryContraller {

    public static boolean create(Category catogary) {
        String name = catogary.getName();

        String sql = "INSERT INTO catogary (name) VALUES ('" + name + "')";

        try {

            String url = "jdbc:mysql://localhost:3306/dbexpense";
            String un = "root";
            String pw = "123";

            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, un, pw);

            Statement stmt = c.createStatement();
            stmt.executeUpdate(sql);
//            JOptionPane.showMessageDialog(this, "Saved!");//
//            JOptionPane.showMessageDialog(null,"Saved");

            return true;
        } catch (Exception e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error");
            return false;

        }

    }

    public static Category retrieve(int id) {
        Category category = new Category();

        String sql = "select * from catogary where id='" + id + "'";

        try {

            String url = "jdbc:mysql://localhost:3306/dbexpense";
            String un = "root";
            String pw = "123";

            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, un, pw);

            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

//            JOptionPane.showMessageDialog(this, "Saved!");//
//            JOptionPane.showMessageDialog(null,"Saved");
            if (rs.next()) {
                String name = rs.getString("name");
                System.out.println("DATAAA +++ " + name);
                category.setName(name);
                category.setId(id);
            }
            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error");

        }
        return category;

    }
}
