package PendaftaranUser .Daftar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserRegistrationPage {
    private WebDriver driver; // Make sure this is private
    private ChromeOptions options;

    @FindBy(className = "MuiButtonBase-root") // Adjust the selector as needed
    private WebElement uploadButton;

    @FindBy(name = "logo")
    private WebElement fileInput;

    @FindBy(name = "nik")
    private WebElement nikInput;

    @FindBy(name = "fullname")
    private WebElement nameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "divisi")
    private WebElement divisionInput;

    @FindBy(name = "unit")
    private WebElement unitSelect;

    @FindBy(name = "posisi-kerja")
    private WebElement positionSelect;

    @FindBy(name = "Jabatan")
    private WebElement jabatan;

    @FindBy(name = "tipe-kontrak")
    private WebElement tipeKontrak;

    @FindBy(name = "lokasi-kerja")
    private WebElement lokasiKerja;

    @FindBy(name = "jadwal-kerja")
    private WebElement jadwalKerja;

    @FindBy(id = "required_selfie") // This is the combobox
    private WebElement selfieCombobox;

    @FindBy(xpath = "//li[contains(text(), 'No Selfie')]") // Adjust the selector based on the actual HTML structure
    private WebElement nonSelfieOption;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(id = "jumlah-cuti")
    private WebElement jumlahCuti;

    // Additional fields that might be necessary
    @FindBy(id = "required_selfie") // This is the combobox
    private WebElement selfie;

    @FindBy(name = "shift_type") // Assuming there's a field for shift type
    private WebElement shiftType;

    @FindBy(name = "work_schedule") // Assuming there's a field for work schedule
    private WebElement workSchedule;

    // Constructor
    public UserRegistrationPage(WebDriver driver) {
        this.driver = driver; // Set the driver instance
        PageFactory.initElements(driver, this); // Initialize elements
    }

    public void uploadPhoto(String filePath) {
        uploadButton.click(); // Click the upload button
        fileInput.sendKeys(filePath); // Upload the file
    }

    public void enterNIK(String nik) {
        nikInput.sendKeys(nik);
    }

    public void enterEmployeeName(String name) {
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void selectDivision(String division) {
        // Tunggu input divisi terlihat
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement divisionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisi")));

        // Klik input untuk membuka dropdown
        divisionInput.click();

        // Ketik nama divisi
        divisionInput.sendKeys(division);

        // Tunggu opsi dropdown muncul
        WebElement divisionOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(text(), '" + division + "')]")
        ));

        // Klik opsi yang sesuai
        divisionOption.click();
    }

    public void selectUnit(String unit) {
        // Tunggu input divisi terlihat
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement unitInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unit")));

        // Klik input untuk membuka dropdown
        unitInput.click();

        // Ketik nama unit
        unitInput.sendKeys(unit);

        // Tunggu opsi dropdown muncul
        WebElement unitOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(text(), '" + unit + "')]")
        ));

        // Klik opsi yang sesuai
        unitOption.click();
    }

    public void posisiKerja(String posker) {
        // Tunggu input divisi terlihat
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement poskerInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("posisi-kerja")));

        // Klik input untuk membuka dropdown
        poskerInput.click();

        // Ketik nama divisi
        poskerInput.sendKeys(posker);

        // Tunggu opsi dropdown muncul
        WebElement poskerOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(text(), '" + posker + "')]")
        ));

        // Klik opsi yang sesuai
        poskerOption.click();
    }

    public void selectJabatan(String jabatanValue) {
        // Tunggu input divisi terlihat
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement jabatanInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jabatan")));

        // Klik input untuk membuka dropdown
        jabatanInput.click();

        // Ketik nama divisi
        jabatanInput.sendKeys(jabatanValue);

        // Tunggu opsi dropdown muncul
        WebElement jabatanOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(text(), '" + jabatanValue + "')]")
        ));

        // Klik opsi yang sesuai
        jabatanOption.click();
    }

    public void selectTipeKontrak(String tipe) {
        // Tunggu input divisi terlihat
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement TipeKontrakInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipe-kontrak")));

        // Klik input untuk membuka dropdown
        TipeKontrakInput.click();

        // Ketik nama divisi
        TipeKontrakInput.sendKeys(tipe);

        // Tunggu opsi dropdown muncul
        WebElement TipeKontrakOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(text(), '" + tipe + "')]")
        ));

        // Klik opsi yang sesuai
        TipeKontrakOption.click();
    }

    public void selectLokasiKerja(String lokasi) {
        // Tunggu input divisi terlihat
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lokasiKerjaInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lokasi-kerja")));

        // Klik input untuk membuka dropdown
        lokasiKerjaInput.click();

        // Ketik nama divisi
        lokasiKerjaInput.sendKeys(lokasi);

        // Tunggu opsi dropdown muncul
        WebElement lokasiKerjaOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(text(), '" + lokasi + "')]")
        ));

        // Klik opsi yang sesuai
        lokasiKerjaOption.click();
    }

    public void selectJadwalKerja(String jadwal) {
        // Tunggu input divisi terlihat
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement JadwalKerjaInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jadwal-kerja")));

        // Klik input untuk membuka dropdown
        JadwalKerjaInput.click();

        // Ketik nama divisi
        JadwalKerjaInput.sendKeys(jadwal);

        // Tunggu opsi dropdown muncul
        WebElement JadwalKerjaOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(text(), '" + jadwal + "')]")
        ));

        // Klik opsi yang sesuai
        JadwalKerjaOption.click();
    }

    public void enterJumlahCuti(String jumlah) {
        jumlahCuti.sendKeys(jumlah);
    }

    public void Selfie() {
        selfie.click(); // Click to open the selfie selection
        nonSelfieOption.click(); // Select the "No Selfie" option
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        // Implement success message verification
        return true;
    }

    public boolean areRequiredFieldErrorsDisplayed() {
        // Implement required field error verification
        return true;
    }
}