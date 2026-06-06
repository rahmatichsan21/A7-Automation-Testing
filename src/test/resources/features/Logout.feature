Feature: Logout

  Scenario: Melakukan Logout melalui navigasi Header
    Given Pelajar dalam status sudah login dan berada di halaman Dashboard
    When Pelajar mengklik menu Keluar pada bagian header navigasi
    Then Sistem menghapus sesi login dan mengarahkan Pelajar kembali ke halaman Login