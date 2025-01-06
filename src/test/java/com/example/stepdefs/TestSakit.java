package com.example.stepdefs;

import com.example.hooks.Hooks;
import com.example.pages.SakitPage;
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


public class TestSakit {
    private WebDriver driver;
    private ExtentTest extentTest;
    private SakitPage sakitPage;
    public static String namaSearch;

    public TestSakit() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
        sakitPage = new SakitPage(driver);
    }

    @Given("SKT01_Berada di halaman sakit")
    public void SKT01_berada_di_halaman_laporan_sakit() {
        driver.get(Constants.URLSakit);
        extentTest.log(LogStatus.PASS, "Akses Url");
    }

    @When("SKT02_Input nama sesuai data")
    public void SKT02_input_nama_sesuai_data() {
        Hooks.delay(1);
        namaSearch = "Test User 1";
        sakitPage.setSearchField(namaSearch);
        extentTest.log(LogStatus.PASS, "User input nama");
    }

    @Then("SKT03_Validasi")
    public void SKT03_Validasi() {
        Hooks.delay(1);
        List<String> nama = sakitPage.dataSakit(1);
        for (int i = 0; i < nama.size(); i++) {
            if (namaSearch.equalsIgnoreCase(nama.get(i))){
                extentTest.log(LogStatus.PASS, "berhasil login dan menampilkan halaman cuti");
            }else {
                extentTest.log(LogStatus.FAIL, "tidak berhasil login dan menampilkan halaman cuti");
            }
        }

    }

//    @And("Klik Button search")
//    public void klik_button_search() {
//        Hooks.delay(1);
//        cutiPage.clickSearchBtn();
//        extentTest.log(LogStatus.PASS, "User klik btn search");
//    }


    @When("SKT04_Pengguna menginput start date di halaman sakit")
    public void SKT04_pengguna_menginput_start_date_di_halaman_sakit(){
        Hooks.delay(1);
//        cutiPage.clickDateBtn();
        LocalDate inputDate = LocalDate.of(2024, 11, 20); // Tahun, Bulan, Hari
//        LocalDateTime currentDateTime = LocalDateTime.now();

        // Membuat formatter dengan pola "dd MMM yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("id", "ID"));


        // Memformat tanggal dan waktu
        String formattedDate = inputDate.format(formatter);
        sakitPage.setStartDateField(formattedDate);
        extentTest.log(LogStatus.PASS, "User input waktu awal");
    }

    @And("SKT05_Pengguna menginput end date di halaman sakit")
    public void SKT05_pengguna_menginput_end_date_di_halaman_sakit(){
        sakitPage.clickDateBtn();
        //LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDate inputDate = LocalDate.of(2024, 11, 21); // Tahun, Bulan, Hari

        // Membuat formatter dengan pola "dd MMM yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("id", "ID"));

        // Memformat tanggal spesifik
        String formattedDate = inputDate.format(formatter);
        sakitPage.setEndDateField(formattedDate);
        extentTest.log(LogStatus.PASS, "User input waktu akhir");
    }



    @And("SKT06_Pengguna klik tombol save di halaman sakit")
    public void SKT06_pengguna_klik_tombol_save_di_halaman_sakit(){
        Hooks.delay(1);
        sakitPage.setSaveBtn();
        extentTest.log(LogStatus.PASS,"User klik btn save");
    }


    @Then("SKT07_Sistem menampilkan laporan sakit sesuai rentang waktu")
    public void SKT07_sistem_menampilkan_laporan_sakit_sesuai_rentang_waktu() {
        Hooks.delay(1);
        Assert.assertEquals(sakitPage.getResultSakit(), "");
        extentTest.log(LogStatus.PASS, "berhasil menampilkan hasil laporan sakit");
    }

    @When("SKT08_Pengguna klik tombol filter di halaman sakit")
    public void SKT08_pengguna_klik_tombol_Reset_di_halaman_sakit(){
        Hooks.delay(1);
        sakitPage.clikcResetBtn();
        extentTest.log(LogStatus.PASS, "User klik btn reset");
    }

    @And("SKT14_Filter pencarian kembali ke kondisi default")
    public void SKT14_filter_kembali_kondisi_default() {
        Hooks.delay(1);
        sakitPage.isFilterCleared(); // Validasi langsung di metode
        extentTest.log(LogStatus.PASS, "Filter pencarian kembali kosong.");

    }

    @Then("SKT13_Pengguna klik tombol Reset di halaman sakit")
    public void SKT13_Pengguna_klik_tombol_reset_di_halaman_sakit() {
        Hooks.delay(1);
        sakitPage.clikcResetBtn();
        extentTest.log(LogStatus.PASS, "berhasil mereset");
    }

//    @When("Pengguna klik tombol filter di halaman sakit")
//    public void pengguna_klik_tombol_filter_di_halaman_sakit(){
//        Hooks.delay(1);
//        sakitPage.clickFilterButton();
//        extentTest.log(LogStatus.PASS, "User klik btn filter");
//
//    }

    @Then("SKT15_Sistem tidak menampilkan hasil pencarian")
    public void SKT15_sistem_tidak_menampilkan_hasil_pencarian() {
        Hooks.delay(1);
        Assert.assertEquals(sakitPage.getResultSakit(), "");
        extentTest.log(LogStatus.PASS, "berhasil mereset");
    }

    @And("SKT09_Pengguna mengisi departemen yang diinginkan")
    public void SKT09_pengguna_mengisi_departemen_yang_diinginkan() {
        Hooks.delay(1);
        sakitPage.pilihDepartemenDenganKeyboard(); // Isi input departemen
        extentTest.log(LogStatus.PASS, "set filter");
    }

    @And("SKT10_Pengguna klik tombol terapkan")
    public void SKT10_pengguna_klik_tombol_terapkan(){
        Hooks.delay(1);
        sakitPage.clickTerapkan();
        extentTest.log(LogStatus.PASS, "klik button terapkan");
    }

    @And("SKT11_Pengguna klik tombol search di halaman sakit")
    public void SK11_pengguna_klik_tombol_Search_di_halaman_cuti() {
        Hooks.delay(1);
        sakitPage.clickSearchBtn();
        extentTest.log(LogStatus.PASS, "User klik btn search");
    }

    @Then("SKT12_Sistem menampilkan laporan sakit sesuai departemen di halaman sakit")
    public void sistem_menampilkan_laporan_sakit_sesuai_departemen_di_halaman_sakit() {
        Hooks.delay(1);
        Assert.assertEquals(sakitPage.getResultSakit(), "");
        extentTest.log(LogStatus.PASS, "menampilkan data yang sudah di filter");
    }

    @When("SKT16_Pengguna klik btn view")
    public void SKT16_pengguna_klik_btn_view(){
        Hooks.delay(1);
        sakitPage.setClickView();
        extentTest.log(LogStatus.PASS, "User klik btn view");
    }

    @Then("SKT17_Sistem menampilkan photo dalam view")
    public void SKT17_sistem_menampilkan_photo_dalam_view(){
        Assert.assertEquals(sakitPage.getResultSakit(), "");
        Hooks.delay(1);
        sakitPage.closeImage();
        extentTest.log(LogStatus.PASS, "melihat photo");
    }

    @When("SKT18_Pengguna klik btn download")
    public void SKT18_pengguna_klik_btn_download(){
        Hooks.delay(1);
        sakitPage.setClickDownload();
        extentTest.log(LogStatus.PASS, "User klik btn download");
    }

    @Then("SKT19_Sistem mendownload hasil photo")
    public void SKT19_sistem_mendownload_hasil_photo(){
        Assert.assertEquals(sakitPage.getResultSakit(), "");
        Hooks.delay(1);
        sakitPage.closeNewTabAndReturnToOriginal();
        extentTest.log(LogStatus.PASS, "sistem mendownload hasil photo");
    }

}
