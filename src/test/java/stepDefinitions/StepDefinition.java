package stepDefinitions;

import POM.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class StepDefinition {
    private WebDriver driver;

    private HomePage homePage;

    private RumahTanggaCategoryPage rumahTanggaCategoryPage;

    private String promoName;

    private DetailProductPage detailProductPage;

    private ProductCartPage productCartPage;

    private ProductCheckoutPage productCheckoutPage;

    @Given("akses {string}")
    public void akses(String url) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(url);
    }
    @When("Klik Kategori Belanja lalu {string}")
    public void klik_kategori_belanja_lalu(String kategory) {
        homePage= new HomePage(driver);
        homePage.clickKategoryByName(kategory);
    }
    @When("Pilih berdasarkan Promo {string}")
    public void pilih_berdasarkan_promo(String promoName) {
        rumahTanggaCategoryPage=new RumahTanggaCategoryPage(driver);
        rumahTanggaCategoryPage.scrollToText(rumahTanggaCategoryPage.getHeaderByName("Promo"),driver);
        rumahTanggaCategoryPage.clickPromoListByName(promoName);
        this.promoName=promoName;
    }
    @When("Berdasarkan hasil tersebut pilih Urut Berdasarkan {string}")
    public void berdasarkan_hasil_tersebut_pilih_urut_berdasarkan(String sortedCategoryName){
        rumahTanggaCategoryPage.clickUrutListByName(sortedCategoryName);

    }
    @When("Klik produk yang muncul pada baris pertama")
    public void klik_produk_yang_muncul_pada_baris_pertama() {
        rumahTanggaCategoryPage.waitUntilTextToBePresentInElement(rumahTanggaCategoryPage.getPromotionTagLabelFirstProduct(),driver,promoName);
        rumahTanggaCategoryPage.clickFirstProduct();

    }
    @When("Pada halaman produk, klik button Tambah ke keranjang")
    public void pada_halaman_produk_klik_button_tambah_ke_keranjang() {
        detailProductPage= new DetailProductPage(driver);
        detailProductPage.waitUntilElementVisible(detailProductPage.getCicilanPopupBtn(),driver);
        detailProductPage.clickCicilanPopupBtn();
        detailProductPage.clickTambahKeKeranjangBtn();

    }
    @When("Klik button Lanjut ke Keranjang")
    public void klik_button_lanjut_ke_keranjang() {
        detailProductPage.waitUntilElementVisible(detailProductPage.getLanjutKeKeranjangBtn(),driver);
        detailProductPage.clickLanjutKeKeranjangBtn();
    }
    @When("Klik Sign In")
    public void klik_sign_in() {
        productCartPage= new ProductCartPage(driver);
        productCartPage.waitUntilElementVisible(productCartPage.getCatatanPopupBtn(),driver);
        productCartPage.clickCatatanPopupBtn();
        productCartPage.clickLanjutKePembayaranBtn();
    }
    @When("Masukkan random email dan password")
    public void masukkan_random_email_dan_password() {
        productCheckoutPage= new ProductCheckoutPage(driver);
        productCheckoutPage.waitUntilElementVisible(productCheckoutPage.getSignInBtn(), driver);
        productCheckoutPage.setEmailTextField("asdasdas@gmail.com");
        productCheckoutPage.setPasswordTextField("asdasdas123123");
        productCheckoutPage.clickSignInBtn();

    }
    @Then("Verify error login message")
    public void verify_error_login_message() {
        productCheckoutPage.waitUntilElementVisible(productCheckoutPage.getLoginErrorMsg(), driver);
        Assert.assertEquals(productCheckoutPage.getLoginErrorMsgText(),"Alamat e-mail atau nomor telepon dan password salah, jika Anda lupa kata sandi klik di sini.");
        driver.quit();
    }
}
