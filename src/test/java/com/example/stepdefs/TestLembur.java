package com.example.stepdefs;

import com.example.hooks.Hooks;
import com.example.pages.LemburPage;
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

public class TestLembur {
    private WebDriver driver;
    private ExtentTest extentTest;
    private LemburPage lemburPage;
    public static String namaSearch;

    public TestLembur(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
        lemburPage = new LemburPage(driver);
    }
    @Given("LMBR01_Berada di halaman lembur")
    public void LMBR01_berada_di_halaman_lembur(){
        driver.get(Constants.URLLembur);
        extentTest.log(LogStatus.PASS,"Akses URL");
    }
    @When("LMBR02_Input nama sesuai data")
    public void LMBR02_input_nama_sesuai_data() {
        Hooks.delay(1);
        namaSearch = "UserQA";
        lemburPage.setSearchFlied(namaSearch);
        extentTest.log(LogStatus.PASS, "User input nama");
    }
    @Then("LMBR03_Validasi")
    public void LMBR03_Validasi() {
        Hooks.delay(1);
        List<String> nama = lemburPage.dataLembur(1);
        for (int i = 0; i < nama.size(); i++) {
            if (namaSearch.equalsIgnoreCase(nama.get(i))){
                extentTest.log(LogStatus.PASS, "berhasil login dan menampilkan halaman cuti");
            }else {
                extentTest.log(LogStatus.FAIL, "tidak berhasil login dan menampilkan halaman cuti");
            }
        }

    }
    @When("LMBR04_Pengguna menginput start date di halaman lembur")
    public void LMBR04_pengguna_menginput_start_date_di_halaman_lembur(){
        Hooks.delay(1);
//        cutiPage.clickDateBtn();
        LocalDate inputDate = LocalDate.of(2024, 11, 8); // Tahun, Bulan, Hari
//        LocalDateTime currentDateTime = LocalDateTime.now();

        // Membuat formatter dengan pola "dd MMM yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("id", "ID"));


        // Memformat tanggal dan waktu
        String formattedDate = inputDate.format(formatter);
        lemburPage.setStartDate(formattedDate);
        extentTest.log(LogStatus.PASS, "User input waktu awal");
    }
    @And("LMBR05_Pengguna menginput end date di halaman lembur")
    public void LMBR05_pengguna_menginput_end_date_di_halaman_lembur(){
        lemburPage.clickDatebtn();
//        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDate inputDate = LocalDate.of(2024, 11, 8); // Tahun, Bulan, Hari

        // Membuat formatter dengan pola "dd MMM yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("id", "ID"));

        // Memformat tanggal spesifik
        String formattedDate = inputDate.format(formatter);
        lemburPage.setEndDate(formattedDate);
        extentTest.log(LogStatus.PASS, "User input waktu akhir");
    }
    @And("LMBR06_Pengguna klik tombol save di halaman lembur")
    public void LMBR06_pengguna_klik_tombol_save_di_halaman_lembur(){
        Hooks.delay(1);
        lemburPage.setSaveBtn();
        extentTest.log(LogStatus.PASS,"User klik btn save");
    }
    @And("LMBR06A_Pengguna klik tombol search di halaman lembur")
    public void LMBR06A_pengguna_klik_tombol_Search_di_halaman_lembur() {
        Hooks.delay(1);
        lemburPage.clickSearchBtn();
        extentTest.log(LogStatus.PASS, "User klik btn search");
    }
    @Then("LMBR07_Sistem menampilkan laporan lembur sesuai rentang waktu")
    public void LMBR07_sistem_menampilkan_laporan_lembur_sesuai_rentang_waktu() {
        Hooks.delay(1);
        Assert.assertEquals(lemburPage.getResultLembur(), "");
        extentTest.log(LogStatus.PASS, "berhasil menampilkan hasil laporan lembur");
    }
    @When("LMBR13_Pengguna klik btn export")
    public void LMBR13_pengguna_klik_btn_export(){
        Hooks.delay(1);
        extentTest.log(LogStatus.PASS, "User klik btn export");
    }
    @Then("LMBR14_Sistem menampilkan export")
    public void LMBR14_sistem_menampilkan_export(){
        lemburPage.clickBtnExport();
        extentTest.log(LogStatus.PASS, "mengunduh hasil export");
    }
    @When("LMBR15_Pengguna klik tombol Reset di halaman lembur")
    public void LMBR15_pengguna_klik_tombol_Reset_di_halaman_lembur() {
        Hooks.delay(1);
        lemburPage.setResetBtnField();
        extentTest.log(LogStatus.PASS, "berhasil mereset");
    }
    @Then("LMBR16_Filter pencarian kembali ke kondisi default")
    public void LMBR16_filter_pencarian_kembali_ke_kondisi_default() {
        Hooks.delay(1);
        lemburPage.isFilterCleared();
        extentTest.log(LogStatus.PASS, "berhasil kembali ke kondisi dafault");
    }
    @And("LMBR17_Sistem tidak menampilkan hasil pencarian")
    public void LMBR17_sistem_tidak_menampilkan_hasil_pencarian() {
        Hooks.delay(1);
        Assert.assertEquals(lemburPage.getResultLembur(), "");
        extentTest.log(LogStatus.PASS, "tidak menampilkan apapun");
    }









}
