Feature: Pengujian Fitur Koreksi

  Scenario: Pencarian
    Given KRK01_Berada di halaman koreksi
    When KRK02_Input nama sesuai data
#    When KRK03_KRK07_Pengguna klik tombol search di halaman lembur
    Then KRK04_Validasi

  Scenario: Filter laporan berdasarkan rentan waktu
    When KRK05_Pengguna menginput start date di halaman koreksi
    And KRK06_Pengguna menginput end date di halaman koreksi
    And KRK07_Pengguna klik tombol save di halaman koreksi
    And KRK08_Pengguna klik tombol search di halaman koreksi
    Then KRK09_Sistem menampilkan laporan koreksi sesuai rentang waktu

  Scenario: Filter btn Approval
    When KRK10_Pengguna klik btn approval
    And KRK11_Pengguna klik btn setujui

#  Scenario: Filter btn Tolak
#    When KRK12_Pengguna klik btn Tolak
#    When KRK13_Pengguna mengisi alasan
#    When KRK14_Pengguna klik btn Tolak

  Scenario: Mereset filter pencarian laporan
    When KRK15_Pengguna klik tombol Reset di halaman koreksi
    Then KRK16_Filter pencarian kembali ke kondisi default
    And KRK17_Sistem tidak menampilkan hasil pencarian

