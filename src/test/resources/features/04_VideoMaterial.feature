@Video
Feature: Access Materials

  # Blok Background akan memanggil metode dari CommonSteps.java secara otomatis
  Background: Prasyarat Login
    Given Pelajar telah berhasil login ke dalam aplikasi JTKLearn

  Scenario: Akses materi bertipe video berhasil diputar
    When Pelajar menavigasi ke tab Kursus Saya
    And Pelajar memilih card kursus "Contoh Kursus"
    And Pelajar mengklik tombol Lanjutkan Kursus
    And Pelajar memilih item materi "Test Video"
    Then Sistem memuat player video dan ikon YouTube dapat diklik