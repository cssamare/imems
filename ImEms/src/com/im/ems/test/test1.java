/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.im.ems.test;

import com.im.ems.control.CatogaryContraller;
import com.im.ems.model.Category;

/**
 *
 * @author CsSamarE
 */
public class test1 {
    public static void main(String[] args) {
        Category cat =new Category();
        cat.setName("Food");
        CatogaryContraller.create(cat);
    }
}
