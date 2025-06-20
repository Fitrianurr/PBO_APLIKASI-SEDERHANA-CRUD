# PBO_APLIKASI-SEDERHANA-CRUD
# Aplikasi Login & Menu GUI Java NetBeans (Modul 13)

Ini adalah proyek Java GUI menggunakan NetBeans yang menampilkan fitur login, menu utama, serta integrasi session user. Aplikasi ini dikembangkan sebagai tugas **Modul 13** dalam mata kuliah **Pemrograman Berorientasi Objek (PBO)**.

---

## ✨ Fitur Utama

- 🔐 **Login user** (menggunakan tabel `user`)
- 👋 Menampilkan sapaan "Hai, [Nama User]" setelah login
- 📋 Menu utama dengan navigasi ke form CRUD data siswa
- 📦 Pencatatan **log login dan logout** ke tabel `log_login`
- 👨‍💻 Penggunaan **Session** untuk menyimpan informasi login
- 🧠 Implementasi:
  - `Abstract Class` untuk setter & getter `user`
  - `Interface` untuk operasi `Login`, `Logout`, `LogLogin`, `LogLogout`
- ☕ Koneksi ke MySQL menggunakan JDBC

---

## 📂 Struktur File

```

src/
└── crud/
├── Login.java              # Class login yang implement interface & extends abstract
├── AbstractUser.java       # Abstract class berisi getter-setter user
├── AuthInterface.java      # Interface untuk login/logout
├── Session.java            # Class static untuk menyimpan info login
├── LoginForm.java          # JFrame untuk form login
├── Menu.java               # JFrame untuk menu utama
├── Form_Siswa.java         # JFrame form data siswa (CRUD)
├── CRUD.java               # Class CRUD untuk data siswa
└── KoneksiMysql.java       # Koneksi ke database

````

---

## 🧪 Database Setup

### 1. Tabel `user`
```sql
CREATE TABLE `user` (
  `id_user` VARCHAR(50) PRIMARY KEY,
  `password` CHAR(32),
  `nama` VARCHAR(100)
);
````

### 2. Tabel `log_login`

```sql
CREATE TABLE `log_login` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `id_user` VARCHAR(50),
  `waktu_login` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `waktu_logout` TIMESTAMP NULL
);
```

### 3. Data awal user admin:

```sql
INSERT INTO `user` (id_user, password, nama)
VALUES ('admin', MD5('pass'), 'Administrator');
```

---

## 💻 Cara Menjalankan

1. **Import ke NetBeans**
2. **Pastikan database MySQL aktif**
3. **Jalankan class `Main.java`** yang akan membuka form login
4. Masukkan:

   * **User ID:** `admin`
   * **Password:** `pass`

---
## Tampilan Aplikasi
## Tampilan awal Aplikasi
![Screenshot (713)](https://github.com/user-attachments/assets/af368175-7c8c-4f24-8909-9e48e0da1987)
## Tampilan Setelah Login
![Screenshot (715)](https://github.com/user-attachments/assets/b86071ed-eb5e-4f8b-953a-4633c92c523f)
## Saat kita Pilih CRUD Siswa akan Muncul Tampilan CRUD yang telah kita buat sebelumnya
![Screenshot (716)](https://github.com/user-attachments/assets/fcc3d7bd-648e-453a-ba1d-60e9f66ca5b1)
![Screenshot (717)](https://github.com/user-attachments/assets/0a35a906-c846-45c9-8658-cddabde36b1d)
## Saat kita pilih Aplikasi dan dan Klik Keluar Maka akan muncul notifikasi Dan Aplikasi otomastis akan tertutup
![Screenshot (720)](https://github.com/user-attachments/assets/53ebda8c-b234-479c-97f5-e9579d6bebd1)
![Screenshot (721)](https://github.com/user-attachments/assets/8ed743e4-96c7-45da-9628-a322d355f10b)
## Untuk Tampilan tabel log_login yang bisa mencatat waktu user admin login dan logout
![Screenshot (722)](https://github.com/user-attachments/assets/a72fb792-ebe2-4d91-a6c6-86c7cc6917fb)

## 👩‍💻 Dibuat oleh

**Fitria Nurhayati**
- STMIK Mardira Indonesia
- Semester 6
- Mata Kuliah: Pemrograman Berorientasi Objek (PBO)
- Dosen Pengampu: Bapak Cahyo Hermanto, M.Kom

---

## 📌 Catatan Tambahan

* Password disimpan dalam bentuk hash MD5 (untuk demo; bukan praktik terbaik)
* Session login akan otomatis berakhir jika user logout, dan dicatat ke `log_login`
* Menu tidak bisa diakses tanpa login


