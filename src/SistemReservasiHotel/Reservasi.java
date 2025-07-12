package SistemReservasiHotel;

// 1. CLASS UTAMA - Harus public karena nama file Reservasi.java
public class Reservasi {
     // Atribut
    private static int nextId = 1; // ID unik untuk setiap reservasi
    private int idReservasi;
    private Pelanggan pelanggan; // Object Pelanggan di dalam Reservasi
    private Kamar kamar;         // Object Kamar di dalam Reservasi
    private int jumlahMalam;
    private double totalBiaya;

    // Constructor
    public Reservasi(Pelanggan pelanggan, Kamar kamar, int jumlahMalam) {
        this.idReservasi = nextId++;
        this.pelanggan = pelanggan;
        this.kamar = kamar;
        this.jumlahMalam = jumlahMalam;
        this.totalBiaya = kamar.getHargaPerMalam() * jumlahMalam; // Kalkulasi biaya
    }

    // Method untuk menampilkan detail
    public void tampilkanDetail() {
        System.out.println("--- Detail Reservasi ID: " + idReservasi + " ---");
        System.out.println("Pelanggan     : " + pelanggan.getNama());
        System.out.println("Kamar         : No. " + kamar.getNomorKamar() + " (" + kamar.getClass().getSimpleName() + ")");
        System.out.println("Lama Menginap : " + jumlahMalam + " malam");
        System.out.println("Total Biaya   : Rp" + String.format("%,.0f", totalBiaya));
        System.out.println("---------------------------------");
    }
}


// 2. CLASS PENDUKUNG - Tidak perlu 'public'
class Pelanggan {
    // Atribut
    private String nama;
    private String noKtp;

    // Constructor
    public Pelanggan(String nama, String noKtp) {
        this.nama = nama;
        this.noKtp = noKtp;
    }

    // Accessor (Getter)
    public String getNama() {
        return nama;
    }
}
