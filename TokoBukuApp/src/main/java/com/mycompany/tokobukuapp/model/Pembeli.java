/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tokobukuapp.model;

public class Pembeli {
    private int id;
    private String nama;
    private String namaPembeli;

    public Pembeli(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }
    public String getNamaPembeli() {
       return namaPembeli;
    }

    public void tampilkanPembeli() {
        System.out.println("ID Pembeli: " + id);
        System.out.println("Nama Pembeli: " + nama);
    }
}
