Feature: Pengujian Fitur Cuti

  Scenario: Pencarian
    Given Berada di halaman cuti
    When Input nama sesuai data
    Then Validasi

  Scenario: Pengguna memfilter laporan cuti berdasarkan rentang waktu
    When Pengguna menginput start date di halaman cuti
    And Pengguna menginput end date di halaman cuti
    And Pengguna klik tombol save
    And Pengguna klik tombol search di halaman cuti
    Then Sistem menampilkan hasil laporan cuti sesuai rentang waktu

  Scenario: Filter laporan cuti berdasarkan departemen
    When Clik button filter
    And Lalu isi departemen di halaman cuti
    And Klik button terapkan di halaman cuti
#    And Pengguna klik tombol search di halaman cuti
    Then Sistem menampilkan laporan cuti sesuai departemen di halaman cuti

  Scenario: Mereset filter pencarian laporan cuti
    When Pengguna klik tombol Reset di halaman cuti
    And Filter pencarian kembali ke kondisi default
    Then Sistem tidak menampilkan hasil pencarian
