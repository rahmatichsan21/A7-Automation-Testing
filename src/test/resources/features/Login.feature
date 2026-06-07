@Login
Feature: Login Functionality JTKLearn

  @Negative
  Scenario: Validasi penolakan akses untuk kredensial yang tidak valid
    Given Pengguna telah menavigasi ke halaman login aplikasi JTKLearn
    When Pengguna memasukkan username "indra@example.com" dan password "admin123"
    And Pengguna mengklik tombol login untuk otentikasi
    Then Sistem menampilkan notifikasi error "Username atau password salah" pada antarmuka

@Positive
  Scenario: Validasi akses masuk yang berhasil dengan kredensial valid
    Given Pengguna telah menavigasi ke halaman login aplikasi JTKLearn
    When Pengguna memasukkan username "nessierdays@gmail.com" dan password "12345678"
    And Pengguna mengklik tombol login untuk otentikasi
    Then Sistem mengarahkan pengguna ke halaman dashboard aplikasi