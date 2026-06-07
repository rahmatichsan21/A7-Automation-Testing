@Document
Feature: Access Materials Document

  Background: Prasyarat Login
    Given Pelajar telah berhasil login ke dalam aplikasi JTKLearn

  Scenario: Akses materi bertipe dokumen PDF berhasil ditampilkan
    When Pelajar menavigasi ke tab Kursus Saya
    And Pelajar memilih card kursus "CyberSecurity" untuk dokumen
    And Pelajar mengklik tombol Lanjutkan Kursus
    And Pelajar memilih item materi bertipe dokumen teks PDF
    Then Sistem memuat dan menampilkan konten materi PDF secara langsung
