@AccessMaterial
Feature: Access Materials functionality

  Background:
    Given Pelajar telah login dan membuka materi pertama CyberSecurity

  @regression
  Scenario: Navigasi ke materi selanjutnya berfungsi
    When Pelajar mengklik tombol Selanjutnya
    Then Sistem menampilkan materi selanjutnya