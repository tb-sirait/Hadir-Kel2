package com.example.stepdefs;

import com.example.hooks.Hooks;
import com.example.pages.CutiPage;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static org.testng.Assert.assertTrue;

public class TestCuti {
    private WebDriver driver;
    private ExtentTest extentTest;
    private CutiPage cutiPage;
    public static String namaSearch;

    public TestCuti() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
        cutiPage = new CutiPage(driver);
    }

    @Given("Berada di halaman cuti")
    public void berada_di_halaman_cuti() {
        driver.get(Constants.URLCuti);
        extentTest.log(LogStatus.PASS, "Akses Url");
    }

    @When("Input nama sesuai data")
    public void input_nama_sesuai_data() {
        Hooks.delay(1);
        namaSearch = "Anif Biantoro";
        cutiPage.setSearchField(namaSearch);
        extentTest.log(LogStatus.PASS, "User input nama");
    }

//    @And("Klik Button search")
//    public void klik_button_search() {
//        Hooks.delay(1);
//        cutiPage.clickSearchBtn();
//        extentTest.log(LogStatus.PASS, "User klik btn search");
//    }


    @Then("Validasi")
    public void validasi() {
        Hooks.delay(1);
        List<String> nama = cutiPage.dataCuti(1);
        for (int i = 0; i < nama.size(); i++) {
            if (namaSearch.equalsIgnoreCase(nama.get(i))){
                extentTest.log(LogStatus.PASS, "berhasil login dan menampilkan halaman cuti");
            }else {
                extentTest.log(LogStatus.FAIL, "tidak berhasil login dan menampilkan halaman cuti");
            }
        }

    }

    @When("Pengguna menginput start date di halaman cuti")
    public void pengguna_menginput_start_date_di_halaman_cuti(){
        Hooks.delay(1);
//        cutiPage.clickDateBtn();
        LocalDate inputDate = LocalDate.of(2024, 9, 24); // Tahun, Bulan, Hari
//        LocalDateTime currentDateTime = LocalDateTime.now();

        // Membuat formatter dengan pola "dd MMM yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("id", "ID"));


        // Memformat tanggal dan waktu
        String formattedDate = inputDate.format(formatter);
        cutiPage.setStartDateField(formattedDate);
        extentTest.log(LogStatus.PASS, "User input waktu awal");
    }

    @And("Pengguna menginput end date di halaman cuti")
    public void pengguna_menginput_end_date_di_halaman_cuti(){
        cutiPage.clickDateBtn();
        //LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDate inputDate = LocalDate.of(2024, 9, 25); // Tahun, Bulan, Hari

        // Membuat formatter dengan pola "dd MMM yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("id", "ID"));

        // Memformat tanggal spesifik
        String formattedDate = inputDate.format(formatter);
        cutiPage.setEndDateField(formattedDate);
        extentTest.log(LogStatus.PASS, "User input waktu akhir");
    }



    @And("Pengguna klik tombol save")
    public void pengguna_klik_tombol_save(){
        Hooks.delay(1);
        cutiPage.setSaveBtn();
        extentTest.log(LogStatus.PASS,"User klik btn save");
    }

    @And("Pengguna klik tombol search di halaman cuti")
    public void pengguna_klik_tombol_Search_di_halaman_cuti() {
        Hooks.delay(1);
        cutiPage.clickSearchBtn();
        extentTest.log(LogStatus.PASS, "User klik btn search");
    }

    @Then("Sistem menampilkan hasil laporan cuti sesuai rentang waktu")
    public void sistem_menampilkan_hasil_laporan_cuti_sesuai_rentang_waktu() {
        Hooks.delay(1);
        Assert.assertEquals(cutiPage.getResultCuti(), "");
        extentTest.log(LogStatus.PASS, "berhasil menampilkan hasil laporan cuti");
    }

    @When("Pengguna klik tombol Reset di halaman cuti")
    public void pengguna_klik_tombol_Reset_di_halaman_cuti(){
        Hooks.delay(1);
        cutiPage.clikcResetBtn();
        extentTest.log(LogStatus.PASS, "User klik btn reset");
    }

    @And("Filter pencarian kembali ke kondisi default")
    public void filter_kembali_kondisi_default() {
        Hooks.delay(1);
        cutiPage.isFilterCleared(); // Validasi langsung di metode
        extentTest.log(LogStatus.PASS, "Filter pencarian kembali kosong.");

    }

    @Then("Sistem tidak menampilkan hasil pencarian")
    public void sistem_tidak_menampilkan_hasil_pencarian() {
        Hooks.delay(1);
        Assert.assertEquals(cutiPage.getResultCuti(), "");
        extentTest.log(LogStatus.PASS, "berhasil mereset");
    }

    @When("Clik button filter")
    public void clik_button_filter(){
        Hooks.delay(1);
        cutiPage.clickFilterButton();
        extentTest.log(LogStatus.PASS, "User klik btn filter");

    }

    @And("Lalu isi departemen di halaman cuti")
    public void lalu_isi_departemen_di_halaman_cuti() {
        Hooks.delay(1);
        cutiPage.pilihDepartemenDenganKeyboard(); // Isi input departemen
        extentTest.log(LogStatus.PASS, "set filter");
    }

    @And("Klik button terapkan di halaman cuti")
    public void klik_button_terapkan_di_halaman_cuti(){
        Hooks.delay(1);
        cutiPage.clickTerapkan();
        extentTest.log(LogStatus.PASS, "klik button terapkan");
    }

    @Then("Sistem menampilkan laporan cuti sesuai departemen di halaman cuti")
    public void sistem_menampilkan_laporan_cuti_sesuai_departemen_di_halaman_cuti() {
        Hooks.delay(1);
        Assert.assertEquals(cutiPage.getResultCuti(), "");
        extentTest.log(LogStatus.PASS, "menampilkan data yang sudah di filter");
    }
}