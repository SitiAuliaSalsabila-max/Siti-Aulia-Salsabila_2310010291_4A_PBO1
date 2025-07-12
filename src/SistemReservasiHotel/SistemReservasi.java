package SistemReservasiHotel;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SistemReservasi {
    public static void main(String[] args) {
        // PERSIAPAN DATA - Menggunakan ArrayList (Array)
        ArrayList<Kamar> daftarKamar = new ArrayList<>();
        ArrayList<Reservasi> daftarReservasi = new ArrayList<>();

        // Membuat beberapa objek Kamar dan menambahkannya ke daftar
        daftarKamar.add(new KamarStandard("101"));
        daftarKamar.add(new KamarStandard("102"));
        daftarKamar.add(new KamarDeluxe("201"));
        daftarKamar.add(new KamarDeluxe("202"));

        Scanner scanner = new Scanner(System.in);
        int pilihanMenu = 0;

        // MENU UTAMA - Menggunakan Perulangan (do-while)
        do {
            System.out.println("\n===== SISTEM RESERVASI HOTEL =====");
            System.out.println("1. Lihat Daftar Kamar");
            System.out.println("2. Buat Reservasi Baru");
            System.out.println("3. Tampilkan Seluruh Reservasi");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan Anda: ");

            // ERROR HANDLING: Mengantisipasi jika user tidak memasukkan angka
            try {
                pilihanMenu = scanner.nextInt();
                scanner.nextLine(); // Membersihkan newline character dari buffer

                // SELEKSI: Menentukan aksi berdasarkan pilihan user
                switch (pilihanMenu) {
                    case 1:
                        lihatDaftarKamar(daftarKamar);
                        break;
                    case 2:
                        buatReservasi(scanner, daftarKamar, daftarReservasi);
                        break;
                    case 3:
                        tampilkanReservasi(daftarReservasi);
                        break;
                    case 4:
                        System.out.println("\nTerima kasih telah menggunakan sistem kami!");
                        break;
                    default:
                        System.out.println("\nPilihan tidak valid. Silakan coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR] Input tidak valid! Mohon masukkan hanya angka.");
                scanner.nextLine(); // Wajib untuk membersihkan input yang salah
            }

        } while (pilihanMenu != 4);

        scanner.close();
    }

    public static void lihatDaftarKamar(ArrayList<Kamar> daftarKamar) {
        System.out.println("\n--- Daftar Semua Kamar ---");
        // PERULANGAN: Menampilkan setiap kamar di dalam ArrayList
        for (Kamar kamar : daftarKamar) {
            // Di baris inilah POLYMORPHISM terjadi.
            // Method getInfoDetail() yang dipanggil akan sesuai dengan objek aslinya
            // (KamarStandard atau KamarDeluxe).
            System.out.println(kamar.getInfoDasar() + " | " + kamar.getInfoDetail());
        }
        System.out.println("--------------------------");
    }

    public static void buatReservasi(Scanner scanner, ArrayList<Kamar> daftarKamar, ArrayList<Reservasi> daftarReservasi) {
        System.out.println("\n--- Buat Reservasi Baru ---");
        System.out.print("Masukkan nomor kamar yang ingin dipesan: ");
        String noKamar = scanner.nextLine();

        Kamar kamarDipesan = null;
        for (Kamar kamar : daftarKamar) {
            if (kamar.getNomorKamar().equals(noKamar)) {
                kamarDipesan = kamar;
                break;
            }
        }

        // SELEKSI: Pengecekan kondisi kamar
        if (kamarDipesan == null) {
            System.out.println("[GAGAL] Kamar dengan nomor " + noKamar + " tidak ditemukan.");
            return;
        }
        if (!kamarDipesan.isTersedia()) {
            System.out.println("[GAGAL] Kamar nomor " + noKamar + " sudah dipesan.");
            return;
        }

        try {
            System.out.println("Kamar ditemukan! Detail: " + kamarDipesan.getInfoDasar());
            System.out.print("Masukkan Nama Anda: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan No. KTP: ");
            String noKtp = scanner.nextLine();
            System.out.print("Berapa malam Anda akan menginap? ");
            int jumlahMalam = scanner.nextInt();
            scanner.nextLine();

            if (jumlahMalam <= 0) {
                System.out.println("[GAGAL] Jumlah malam harus lebih dari 0.");
                return;
            }

            // Membuat objek baru dari data yang diinputkan
            Pelanggan pelangganBaru = new Pelanggan(nama, noKtp);
            Reservasi reservasiBaru = new Reservasi(pelangganBaru, kamarDipesan, jumlahMalam);

            kamarDipesan.setTersedia(false); // Mengubah status kamar
            daftarReservasi.add(reservasiBaru); // Menambah reservasi baru ke daftar

            System.out.println("\n[SUKSES] Reservasi berhasil dibuat!");
            reservasiBaru.tampilkanDetail();

        } catch (InputMismatchException e) {
            System.out.println("\n[ERROR] Input jumlah malam tidak valid. Mohon masukkan angka.");
            scanner.nextLine();
        }
    }

    public static void tampilkanReservasi(ArrayList<Reservasi> daftarReservasi) {
        System.out.println("\n--- Laporan Seluruh Reservasi ---");
        if (daftarReservasi.isEmpty()) {
            System.out.println("Belum ada data reservasi yang masuk.");
        } else {
            for (Reservasi r : daftarReservasi) {
                r.tampilkanDetail();
            }
        }
    }
}
