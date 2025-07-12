
# Proyek Sistem Reservasi Hotel

Proyek ini adalah aplikasi sederhana untuk **reservasi hotel** menggunakan **Java**. Aplikasi ini memungkinkan pengguna untuk melihat daftar kamar yang tersedia, melakukan reservasi, dan melihat laporan seluruh reservasi yang sudah dibuat.

## Deskripsi

Aplikasi ini mengelola data kamar hotel dan proses reservasi dengan informasi pelanggan. Pengguna dapat memilih kamar berdasarkan nomor kamar, memasukkan data pelanggan, dan melakukan reservasi kamar sesuai dengan jumlah malam menginap. Aplikasi ini menggunakan **konsep Pemrograman Berbasis Objek** (OOP) seperti **Inheritance**, **Polymorphism**, **Encapsulation**, dan **Abstraction**.

## Fitur Utama
- Melihat daftar kamar yang tersedia.
- Membuat reservasi baru dengan input nama pelanggan dan jumlah malam.
- Menampilkan seluruh reservasi yang telah dibuat.
- Mengelola status kamar (tersedia atau tidak).

## Deskripsi Kode

### 1. **Class** dan **Object**
- **Class** adalah blueprint untuk objek. Pada aplikasi ini, `Kamar`, `Reservasi`, dan `Pelanggan` adalah class yang masing-masing mendefinisikan atribut dan metode untuk operasi yang terkait.
  
```java
public abstract class Kamar {
    private String nomorKamar;
    private double hargaPerMalam;
    private boolean isTersedia;
    
    public Kamar(String nomorKamar, double hargaPerMalam) {
        this.nomorKamar = nomorKamar;
        this.hargaPerMalam = hargaPerMalam;
        this.isTersedia = true;
    }
}
```

### 2. **Constructor**
- Constructor adalah metode yang dijalankan pertama kali saat objek dibuat. Pada contoh ini, `Kamar` dan `Reservasi` memiliki constructor untuk menginisialisasi objek mereka.
  
```java
public Kamar(String nomorKamar, double hargaPerMalam) {
    this.nomorKamar = nomorKamar;
    this.hargaPerMalam = hargaPerMalam;
    this.isTersedia = true;
}
```

### 3. **Encapsulation**
- Atribut `nomorKamar`, `hargaPerMalam`, dan `isTersedia` dienkapsulasi (private) dan hanya bisa diakses melalui getter dan setter.
  
```java
private String nomorKamar;
private double hargaPerMalam;
private boolean isTersedia;
```

### 4. **Inheritance**
- `KamarStandard` dan `KamarDeluxe` adalah subclass yang mewarisi atribut dan metode dari class induk `Kamar`.

```java
class KamarStandard extends Kamar {
    public KamarStandard(String nomorKamar) {
        super(nomorKamar, 500000.0); // Mengirim nilai spesifik untuk Kamar Standard
    }
}
```

### 5. **Polymorphism**
- Pada contoh ini, polymorphism terlihat pada metode `getInfoDetail` yang diimplementasikan di class `KamarStandard` dan `KamarDeluxe`. Masing-masing class memiliki implementasi sendiri meskipun nama metodenya sama.
  
```java
@Override
public String getInfoDetail() {
    return "Tipe: Deluxe | Fasilitas: TV, AC, Air Panas, Kulkas Mini.";
}
```

### 6. **Seleksi**
- Seleksi digunakan dalam berbagai bagian kode, seperti ketika mengecek apakah kamar tersedia atau tidak.

```java
if (kamarDipesan == null) {
    System.out.println("[GAGAL] Kamar dengan nomor " + noKamar + " tidak ditemukan.");
    return;
}
```

### 7. **Perulangan**
- Perulangan digunakan untuk menampilkan daftar kamar dan seluruh reservasi yang telah dibuat.
  
```java
for (Kamar kamar : daftarKamar) {
    System.out.println(kamar.getInfoDasar() + " | " + kamar.getInfoDetail());
}
```

### 8. **Input Output Sederhana**
- Menggunakan `Scanner` untuk menerima input dari pengguna dan `System.out.println` untuk menampilkan hasilnya.
  
```java
Scanner scanner = new Scanner(System.in);
System.out.print("Masukkan nomor kamar yang ingin dipesan: ");
String noKamar = scanner.nextLine();
```

## Struktur Kode

1. **Class Kamar** - Kelas induk untuk semua jenis kamar.
2. **Class KamarStandard** dan **Class KamarDeluxe** - Subclass yang mewarisi `Kamar` dengan penyesuaian fasilitas dan harga per malam.
3. **Class Pelanggan** - Menyimpan informasi pelanggan seperti nama dan noKTP.
4. **Class Reservasi** - Menyimpan informasi terkait reservasi, seperti pelanggan, kamar, jumlah malam, dan total biaya.
5. **Class SistemReservasi** - Menyediakan antarmuka pengguna dengan menu untuk melihat daftar kamar, membuat reservasi baru, dan menampilkan seluruh reservasi.

## Instalasi

1. Pastikan Java telah terinstal di sistem Anda.
2. Salin seluruh kode ke dalam folder proyek.
3. Jalankan `SistemReservasi.java` untuk memulai aplikasi.

```bash
javac SistemReservasi.java
java SistemReservasi
```

## Usulan Nilai

| No  | Materi             | Nilai |
| --- | ------------------- | ----- |
| 1   | Class               | 5     |
| 2   | Object              | 5     |
| 3   | Atribut             | 5     |
| 4   | Constructor         | 5     |
| 5   | Mutator             | 5     |
| 6   | Accessor            | 5     |
| 7   | Encapsulation       | 5     |
| 8   | Inheritance         | 5     |
| 9   | Polymorphism        | 10    |
| 10  | Seleksi             | 5     |
| 11  | Perulangan          | 5     |
| 12  | IO Sederhana        | 10    |
| 13  | Array               | 15    |
| 14  | Error Handling      | 15    |
|     | **TOTAL**           | **100** |

## Pembuat

Nama: Siti Aulia Salsabila  
NPM: 2310010291
Kelas: 4A TI NON-REG BJM
