package com.example.stepdefs;

import com.example.hooks.Hooks;
import com.example.pages.KoreksiPage;
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
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class TestKoreksi {
    private WebDriver driver;
    private ExtentTest extentTest;
    private KoreksiPage koreksiPage;
    public static String namaSearch;

    public TestKoreksi(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
        koreksiPage = new KoreksiPage(driver);
    }
    @Given("KRK01_Berada di halaman koreksi")
    public void LMBR01_berada_di_halaman_koreksi(){
        driver.get(Constants.URLKoreksi);
        extentTest.log(LogStatus.PASS,"Akses URL");
    }
    @When("KRK02_Input nama sesuai data")
    public void KRK02_input_nama_sesuai_data() {
        Hooks.delay(1);
        namaSearch = "zack";
        koreksiPage.setSearchField(namaSearch);
        extentTest.log(LogStatus.PASS, "User input nama");
    }
    @Then("KRK04_Validasi")
    public void KRK04_Validasi() {
        Hooks.delay(1);
        List<String> nama = koreksiPage.dataKoreksi(1);
        for (int i = 0; i < nama.size(); i++) {
            if (namaSearch.equalsIgnoreCase(nama.get(i))){
                extentTest.log(LogStatus.PASS, "berhasil login dan menampilkan halaman cuti");
            }else {
                extentTest.log(LogStatus.FAIL, "tidak berhasil login dan menampilkan halaman cuti");
            }
        }

    }
    @When("KRK05_Pengguna menginput start date di halaman koreksi")
    public void LMBR04_pengguna_menginput_start_date_di_halaman_koreksi(){
        Hooks.delay(1);
//        cutiPage.clickDateBtn();
        LocalDate inputDate = LocalDate.of(2025, 1, 5); // Tahun, Bulan, Hari
//        LocalDateTime currentDateTime = LocalDateTime.now();

        // Membuat formatter dengan pola "dd MMM yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("id", "ID"));


        // Memformat tanggal dan waktu
        String formattedDate = inputDate.format(formatter);
        koreksiPage.setStartDateField(formattedDate);
        extentTest.log(LogStatus.PASS, "User input waktu awal");
    }
    @And("KRK06_Pengguna menginput end date di halaman koreksi")
    public void LMBR05_pengguna_menginput_end_date_di_halaman_koreksi(){
        koreksiPage.clickDatebtn();
//        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDate inputDate = LocalDate.of(2025, 1, 5); // Tahun, Bulan, Hari

        // Membuat formatter dengan pola "dd MMM yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("id", "ID"));

        // Memformat tanggal spesifik
        String formattedDate = inputDate.format(formatter);
        koreksiPage.setEndDateField(formattedDate);
        extentTest.log(LogStatus.PASS, "User input waktu akhir");
    }
    @And("KRK07_Pengguna klik tombol save di halaman koreksi")
    public void LMBR06_pengguna_klik_tombol_save_di_halaman_koreksi(){
        Hooks.delay(1);
        koreksiPage.setSaveBtn();
        extentTest.log(LogStatus.PASS,"User klik btn save");
    }
    @And("KRK08_Pengguna klik tombol search di halaman koreksi")
    public void LMBR06A_pengguna_klik_tombol_Search_di_halaman_koreksi() {
        Hooks.delay(1);
        koreksiPage.clickSearchBtn();
        extentTest.log(LogStatus.PASS, "User klik btn search");
    }
    @Then("KRK09_Sistem menampilkan laporan koreksi sesuai rentang waktu")
    public void LMBR07_sistem_menampilkan_laporan_lembur_sesuai_rentang_waktu() {
        Hooks.delay(1);
        Assert.assertEquals(koreksiPage.getResultKoreksi(), "");
        extentTest.log(LogStatus.PASS, "berhasil menampilkan hasil laporan koreksi");
    }
    @When("KRK10_Pengguna klik btn approval")
    public void KRK10_pengguna_klik_btn_approval(){
        Hooks.delay(1);
        koreksiPage.setBtnApprove();
        extentTest.log(LogStatus.PASS, "User klik btn approval");
    }
    @And("KRK11_Pengguna klik btn setujui")
    public void KRK11_pengguna_klik_btn_setujui(){
        koreksiPage.setClikSetujui();
        extentTest.log(LogStatus.PASS, "User klik btn setujui");
    }
    @When("KRK15_Pengguna klik tombol Reset di halaman koreksi")
    public void KRK15_pengguna_klik_tombol_Reset_di_halaman_koreksi() {
        Hooks.delay(1);
        koreksiPage.setResetBtnField();
        extentTest.log(LogStatus.PASS, "berhasil mereset");
    }
    @Then("KRK16_Filter pencarian kembali ke kondisi default")
    public void KRK16_filter_pencarian_kembali_ke_kondisi_default() {
        Hooks.delay(1);
        koreksiPage.isFilterCleared();
        extentTest.log(LogStatus.PASS, "berhasil kembali ke kondisi dafault");
    }
    @And("KRK17_Sistem tidak menampilkan hasil pencarian")
    public void KRK17_sistem_tidak_menampilkan_hasil_pencarian() {
        Hooks.delay(1);
        Assert.assertEquals(koreksiPage.getResultKoreksi(), "");
        extentTest.log(LogStatus.PASS, "tidak menampilkan apapun");
    }









}
