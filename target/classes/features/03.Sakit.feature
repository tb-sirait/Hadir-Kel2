Feature: Pengujian Fitur Sakit

  Scenario: Pencarian
    Given SKT01_Berada di halaman sakit
    When SKT02_Input nama sesuai data
    Then SKT03_Validasi

  Scenario: Filter laporan berdasarkan rentang waktu
    When SKT04_Pengguna menginput start date di halaman sakit
    And SKT05_Pengguna menginput end date di halaman sakit
    And SKT06_Pengguna klik tombol save di halaman sakit
    And SKT11_Pengguna klik tombol search di halaman sakit
    Then SKT07_Sistem menampilkan laporan sakit sesuai rentang waktu

  Scenario: Filter btn download
    When SKT18_Pengguna klik btn download
    Then SKT19_Sistem mendownload hasil photo

  Scenario: Filter btn view
    When SKT16_Pengguna klik btn view
    Then SKT17_Sistem menampilkan photo dalam view

#  Scenario: Filter laporan berdasarkan departemen
#    When SKT08_Pengguna klik tombol filter di halaman sakit
#    And SKT09_Pengguna mengisi departemen yang diinginkan
#    And SKT10_Pengguna klik tombol terapkan
##    And SKT11_Pengguna klik tombol search di halaman sakit
#    Then SKT12_Sistem menampilkan laporan sakit sesuai departemen di halaman sakit

  Scenario: Mereset filter pencarian laporan
    When SKT13_Pengguna klik tombol Reset di halaman sakit
    Then SKT14_Filter pencarian kembali ke kondisi default
    And SKT15_Sistem tidak menampilkan hasil pencarian

