package com.mycompany.tokobukuapp;

import com.mycompany.tokobukuapp.model.Buku;
import com.mycompany.tokobukuapp.model.Pembeli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TokoBukuApp {
    public static void main(String[] args) {
        List<Buku> daftarBuku = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat Datang di Toko Buku Pintar");

        boolean ulang = true;
        while (ulang) {
            System.out.println("Menu Utama:");
            System.out.println("1. Menampilkan Daftar Buku");
            System.out.println("2. Menampilkan Pelanggan");
            System.out.println("3. Mencari Buku");
            System.out.println("4. Menambah Buku");
            System.out.println("5. Mengupdate Buku");
            System.out.println("6. Menghapus Buku");
            System.out.println("7. Keluar");
            System.out.print("Silahkan pilih menu: ");
            String pilih = scanner.nextLine();

            switch (pilih) {
                case "1":
                    tampilkanDaftarBuku(daftarBuku);
                    break;

                case "2":
                    tampilkanDaftarPembeli();
                    break;

                case "3":
                    mencariBuku(daftarBuku);
                    break;

                case "4":
                    menambahBuku(daftarBuku);
                    break;

                case "5":
                    mengupdateBuku(daftarBuku);
                    break;

                case "6":
                    menghapusBuku(daftarBuku);
                    break;

                case "7":
                    System.out.println("Terima kasih!");
                    ulang = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                    break;
            }
        }
    }

    private static void tampilkanDaftarBuku(List<Buku> daftarBuku) {
        System.out.println("Daftar Buku:");
        for (Buku buku : daftarBuku) {
            System.out.println("ID: " + buku.getId());
            System.out.println("Judul Buku: " + buku.getJudul());
            System.out.println("Harga: Rp" + buku.getHarga());
            System.out.println();
        }
    }

    private static void tampilkanDaftarPembeli() {
        Pembeli pembeli1 = new Pembeli(101, "Alice");
        Pembeli pembeli2 = new Pembeli(102, "Bob");

        System.out.println("Daftar Pembeli:");
        pembeli1.tampilkanPembeli();
        pembeli2.tampilkanPembeli();
    }

    private static void mencariBuku(List<Buku> daftarBuku) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID Buku yang Ingin Dicari: ");
        int idBukuCari = scanner.nextInt();
        Buku bukuDitemukan = null;

        for (Buku buku : daftarBuku) {
            if (buku.getId() == idBukuCari) {
                bukuDitemukan = buku;
                break;
            }
        }

        if (bukuDitemukan != null) {
            System.out.println("Buku ditemukan: " + bukuDitemukan.getJudul());
        } else {
            System.out.println("Buku dengan ID " + idBukuCari + " tidak ditemukan.");
        }
    }

    private static void menambahBuku(List<Buku> daftarBuku) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID Buku: ");
        int idBuku = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Judul Buku: ");
        String judulBuku = scanner.nextLine();
        System.out.print("Masukkan Harga Buku: ");
        double hargaBuku = scanner.nextDouble();

        Buku bukuBaru = new Buku(idBuku, judulBuku, hargaBuku);
        daftarBuku.add(bukuBaru);
        System.out.println("Buku berhasil ditambahkan.");
    }

    private static void mengupdateBuku(List<Buku> daftarBuku) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID Buku yang Ingin Diupdate: ");
        int idBukuUpdate = scanner.nextInt();

        Buku bukuUpdate = null;
        for (Buku buku : daftarBuku) {
            if (buku.getId() == idBukuUpdate) {
                bukuUpdate = buku;
                break;
            }
        }

        if (bukuUpdate != null) {
            System.out.println("Buku yang akan diupdate: " + bukuUpdate.getJudul());
            scanner.nextLine();
            System.out.print("Masukkan Judul Buku yang Baru: ");
            String judulBukuBaru = scanner.nextLine();
            System.out.print("Masukkan Harga Buku yang Baru: ");
            double hargaBukuBaru = scanner.nextDouble();

            bukuUpdate.setJudul(judulBukuBaru);
            bukuUpdate.setHarga(hargaBukuBaru);
            System.out.println("Buku berhasil diupdate.");
        } else {
            System.out.println("Buku dengan ID " + idBukuUpdate + " tidak ditemukan.");
        }
    }

    private static void menghapusBuku(List<Buku> daftarBuku) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID Buku yang Ingin Dihapus: ");
        int idBukuHapus = scanner.nextInt();

        Buku bukuHapus = null;
        for (Buku buku : daftarBuku) {
            if (buku.getId() == idBukuHapus) {
                bukuHapus = buku;
                break;
            }
        }

        if (bukuHapus != null) {
            System.out.println("Buku yang akan dihapus: " + bukuHapus.getJudul());
            System.out.print("Apakah Anda yakin ingin menghapus buku ini? (Y/N): ");
            String konfirmasi = scanner.next();

            if (konfirmasi.equalsIgnoreCase("Y")) {
                daftarBuku.remove(bukuHapus);
                System.out.println("Buku berhasil dihapus.");
            } else {
                System.out.println("Penghapusan buku dibatalkan.");
            }
        } else {
            System.out.println("Buku dengan ID " + idBukuHapus + " tidak ditemukan.");
        }
    }
}
