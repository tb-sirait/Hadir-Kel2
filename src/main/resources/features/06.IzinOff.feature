Feature: Pengujian Fitur Koreksi

  Scenario: Pencarian
    Given OFF01_Berada di halaman Izin Off
    When OFF02_Input nama sesuai data
    Then OFF03_Validasi

  Scenario: Filter laporan berdasarkan rentan waktu
    When OFF04_Pengguna menginput start date di halaman Izin Off
    And 0FF05_Pengguna menginput end date di halaman Izin Off
    And OFF06_Pengguna klik tombol save di halaman Izin Off
    And OFF07_Pengguna klik tombol search di halaman Izin Off
    Then OFF08_Sistem menampilkan laporan Izin Off sesuai rentang waktu

  Scenario: Filter btn Approval
    When OFF09A_Pengguna klik btn aksi di halaman Izin Off
    When OFF09_Pengguna klik btn approval di halaman Izin Off
    And 0FF10_Pengguna klik btn setujui di halaman Izin Off

  Scenario: Mereset filter pencarian laporan
    When OFF11_Pengguna klik tombol Reset di halaman Izin Off
    Then OFF12_Filter pencarian kembali ke kondisi default
    And OFF13_Sistem tidak menampilkan hasil pencarian

