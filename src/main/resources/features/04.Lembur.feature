Feature: Pengujian Fitur Sakit

  Scenario: Pencarian
    Given LMBR01_Berada di halaman lembur
    When LMBR02_Input nama sesuai data
    Then LMBR03_Validasi

  Scenario: Filter laporan berdasarkan rentang waktu
    When LMBR04_Pengguna menginput start date di halaman lembur
    And LMBR05_Pengguna menginput end date di halaman lembur
    And LMBR06_Pengguna klik tombol save di halaman lembur
    And LMBR06A_Pengguna klik tombol search di halaman lembur
    Then LMBR07_Sistem menampilkan laporan lembur sesuai rentang waktu

#  Scenario: Filter laporan berdasarkan departemen
#    When LMBR08_Pengguna klik tombol filter di halaman lembur
#    And LMBR09_Pengguna mengisi departemen yang diinginkan
#    And LMBR10_Pengguna klik tombol terapkan
#    And LMBR11_Pengguna klik tombol search di halaman lembur
#    Then LMBR12_Sistem menampilkan laporan lembur sesuai departemen di halaman lembur

  Scenario: Filter btn export
    When LMBR13_Pengguna klik btn export
    Then LMBR14_Sistem menampilkan export

  Scenario: Mereset filter pencarian laporan
    When LMBR15_Pengguna klik tombol Reset di halaman lembur
    Then LMBR16_Filter pencarian kembali ke kondisi default
    And LMBR17_Sistem tidak menampilkan hasil pencarian
