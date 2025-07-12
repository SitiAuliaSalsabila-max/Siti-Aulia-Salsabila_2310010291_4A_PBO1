package SistemReservasiHotel;

// 1. CLASS INDUK (PARENT CLASS) - Harus public karena nama file adalah Kamar.java
public abstract class Kamar {
     // ATRIBUT (dibuat private untuk Encapsulation)
    private String nomorKamar;
    private double hargaPerMalam;
    private boolean isTersedia;

    // CONSTRUCTOR: Method yang pertama kali dijalankan saat object dibuat
    public Kamar(String nomorKamar, double hargaPerMalam) {
        this.nomorKamar = nomorKamar;
        this.hargaPerMalam = hargaPerMalam;
        this.isTersedia = true; // Defaultnya, setiap kamar baru pasti tersedia
    }

    // ACCESSOR (GETTER): Method untuk mengambil nilai atribut private
    public String getNomorKamar() {
        return nomorKamar;
    }

    public double getHargaPerMalam() {
        return hargaPerMalam;
    }

    public boolean isTersedia() {
        return isTersedia;
    }

    // MUTATOR (SETTER): Method untuk mengubah nilai atribut private
    public void setTersedia(boolean tersedia) {
        this.isTersedia = tersedia;
    }

    // Method abstract ini WAJIB diimplementasikan oleh setiap class anak
    // (Polymorphism)
    public abstract String getInfoDetail();

    // Method biasa untuk menampilkan info dasar
    public String getInfoDasar() {
        return "No: " + nomorKamar +
                " | Harga: Rp" + String.format("%,.0f", hargaPerMalam) +
                " | Status: " + (isTersedia ? "Tersedia" : "Dipesan");
    }
}

// 2. CLASS ANAK (CHILD CLASS) - Tidak perlu 'public'
class KamarStandard extends Kamar {
    // CONSTRUCTOR: Wajib memanggil constructor induknya menggunakan 'super()'
    public KamarStandard(String nomorKamar) {
        super(nomorKamar, 500000.0); // Mengirim nilai spesifik untuk Kamar Standard
    }

    // OVERRIDE: Implementasi spesifik dari method abstract induk (Polymorphism)
    @Override
    public String getInfoDetail() {
        return "Tipe: Standard | Fasilitas: TV, AC, Kamar Mandi Dalam.";
    }
}

// 3. CLASS ANAK LAINNYA (CHILD CLASS) - Tidak perlu 'public'
class KamarDeluxe extends Kamar {
    // CONSTRUCTOR
    public KamarDeluxe(String nomorKamar) {
        super(nomorKamar, 850000.0); // Mengirim nilai spesifik untuk Kamar Deluxe
    }

    // OVERRIDE: Implementasi spesifik dari method abstract induk (Polymorphism)
    @Override
    public String getInfoDetail() {
        return "Tipe: Deluxe  | Fasilitas: TV, AC, Air Panas, Kulkas Mini.";
    }
}
