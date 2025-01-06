package com.example.stepdefs;

import com.example.hooks.Hooks;
import com.example.pages.IzinOffPage;
import com.example.pages.KoreksiPage;
import com.example.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class TestIzinOff {
    private WebDriver driver;
    private ExtentTest extentTest;
    private IzinOffPage izinOffPage;
    public static String namaSearch;

    public TestIzinOff(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
        izinOffPage = new IzinOffPage(driver);
    }
    @Given("OFF01_Berada di halaman Izin Off")
    public void OFF01_berada_di_halaman_izin_Off(){
        driver.get(Constants.URLIzinOff);
        extentTest.log(LogStatus.PASS,"Akses URL");
    }
    @When("OFF02_Input nama sesuai data")
    public void OFF02_input_nama_sesuai_data() {
        Hooks.delay(1);
        namaSearch = "kazama";
        izinOffPage.setSearchField(namaSearch);
        extentTest.log(LogStatus.PASS, "User input nama");
    }
    @Then("OFF03_Validasi")
    public void OFF03_Validasi() {
        Hooks.delay(1);
        List<String> nama = izinOffPage.dataIzinOff(1);
        for (int i = 0; i < nama.size(); i++) {
            if (namaSearch.equalsIgnoreCase(nama.get(i))){
                extentTest.log(LogStatus.PASS, "berhasil login dan menampilkan halaman cuti");
            }else {
                extentTest.log(LogStatus.FAIL, "tidak berhasil login dan menampilkan halaman cuti");
            }
        }

    }
    @When("OFF04_Pengguna menginput start date di halaman Izin Off")
    public void OFF04_pengguna_menginput_start_date_di_halaman_izin_off(){
        Hooks.delay(1);
//        cutiPage.clickDateBtn();
        LocalDate inputDate = LocalDate.of(2024, 11, 8); // Tahun, Bulan, Hari
//        LocalDateTime currentDateTime = LocalDateTime.now();

        // Membuat formatter dengan pola "dd MMM yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("id", "ID"));


        // Memformat tanggal dan waktu
        String formattedDate = inputDate.format(formatter);
        izinOffPage.setStartDateField(formattedDate);
        extentTest.log(LogStatus.PASS, "User input waktu awal");
    }
    @And("0FF05_Pengguna menginput end date di halaman Izin Off")
    public void OFF05_pengguna_menginput_end_date_di_halaman_izin_Off(){
        izinOffPage.clickDatebtn();
//        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDate inputDate = LocalDate.of(2024, 11, 8); // Tahun, Bulan, Hari

        // Membuat formatter dengan pola "dd MMM yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("id", "ID"));

        // Memformat tanggal spesifik
        String formattedDate = inputDate.format(formatter);
        izinOffPage.setEndDateField(formattedDate);
        extentTest.log(LogStatus.PASS, "User input waktu akhir");
    }
    @And("OFF06_Pengguna klik tombol save di halaman Izin Off")
    public void OFF06_pengguna_klik_tombol_save_di_halaman_izin_off(){
        Hooks.delay(1);
        izinOffPage.setSaveBtn();
        extentTest.log(LogStatus.PASS,"User klik btn save");
    }
    @And("OFF07_Pengguna klik tombol search di halaman Izin Off")
    public void OFF07_pengguna_klik_tombol_search_di_halaman_izin_off() {
        Hooks.delay(1);
        izinOffPage.clickSearchBtn();
        extentTest.log(LogStatus.PASS, "User klik btn search");
    }
    @Then("OFF08_Sistem menampilkan laporan Izin Off sesuai rentang waktu")
    public void OFF08_sistem_menampilkan_laporan_izin_off_sesuai_rentang_waktu() {
        Hooks.delay(1);
        Assert.assertEquals(izinOffPage.getResultIzinOff(), "");
        extentTest.log(LogStatus.PASS, "berhasil menampilkan hasil laporan koreksi");
    }
    @When("OFF09A_Pengguna klik btn aksi di halaman Izin Off")
    public void OFF09A_pengguna_klik_btn_aksi_di_halaman_izin_0ff(){
        Hooks.delay(1);
        izinOffPage.setBtnAksi();
        extentTest.log(LogStatus.PASS, "User klik btn aksi");
    }
    @When("OFF09_Pengguna klik btn approval di halaman Izin Off")
    public void OFF09_pengguna_klik_btn_approval_di_halaman_izin_off(){
        Hooks.delay(1);
        izinOffPage.setBtnApprove();
        extentTest.log(LogStatus.PASS, "User klik btn approval");
    }
    @And("0FF10_Pengguna klik btn setujui di halaman Izin Off")
    public void OFF10_pengguna_klik_btn_setujui_di_halaman_izin_off(){
        izinOffPage.setClikSetujui();
        Hooks.delay(1);
        izinOffPage.escape();
        extentTest.log(LogStatus.PASS, "User klik btn setujui");
    }
    @When("OFF11_Pengguna klik tombol Reset di halaman Izin Off")
    public void OFF11_pengguna_klik_tombol_reset_di_halaman_izin_off() {
        Hooks.delay(1);
        izinOffPage.setResetBtnField();
        extentTest.log(LogStatus.PASS, "berhasil mereset");
    }
    @Then("OFF12_Filter pencarian kembali ke kondisi default")
    public void OFF12_filter_pencarian_kembali_ke_kondisi_default() {
        Hooks.delay(1);
        izinOffPage.isFilterCleared();
        extentTest.log(LogStatus.PASS, "berhasil kembali ke kondisi dafault");
    }
    @And("OFF13_Sistem tidak menampilkan hasil pencarian")
    public void OFF13_sistem_tidak_menampilkan_hasil_pencarian() {
        Hooks.delay(1);
        Assert.assertEquals(izinOffPage.getResultIzinOff(), "");
        extentTest.log(LogStatus.PASS, "tidak menampilkan apapun");
    }



}
