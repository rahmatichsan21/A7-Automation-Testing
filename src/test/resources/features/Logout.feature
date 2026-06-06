Feature: Logout

  Background: Prasyarat Login
    Given Pelajar telah berhasil login ke dalam aplikasi JTKLearn

  Scenario: Melakukan Logout melalui navigasi Header
    When Pelajar mengklik menu Keluar pada bagian header navigasi
    Then Sistem menghapus sesi login dan mengarahkan Pelajar kembali ke halaman Login