package stepDefinitions;

import POM.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepDefinition {
    private Hooks hooks;

    public StepDefinition(Hooks hooks) {
        this.hooks = hooks;
    }

    private HomePage homePage;

    private RumahTanggaCategoryPage rumahTanggaCategoryPage;

    private String promoName;

    private DetailProductPage detailProductPage;

    private ProductCartPage productCartPage;

    private ProductCheckoutPage productCheckoutPage;

    @Given("akses {string}")
    public void akses(String url) {
        hooks.getDriver().get(url);
    }
    @When("Klik Kategori Belanja lalu {string}")
    public void klik_kategori_belanja_lalu(String kategory) {
        homePage= new HomePage(hooks.getDriver());
        homePage.clickKategoryByName(kategory);
    }
    @When("Pilih berdasarkan Promo {string}")
    public void pilih_berdasarkan_promo(String promoName) {
        rumahTanggaCategoryPage=new RumahTanggaCategoryPage(hooks.getDriver());
        rumahTanggaCategoryPage.scrollToText(rumahTanggaCategoryPage.getHeaderByName("Promo"),hooks.getDriver());
        rumahTanggaCategoryPage.clickPromoListByName(promoName);
        this.promoName=promoName;
    }
    @When("Berdasarkan hasil tersebut pilih Urut Berdasarkan {string}")
    public void berdasarkan_hasil_tersebut_pilih_urut_berdasarkan(String sortedCategoryName){
        rumahTanggaCategoryPage.clickUrutListByName(sortedCategoryName);

    }
    @When("Klik produk yang muncul pada baris pertama")
    public void klik_produk_yang_muncul_pada_baris_pertama() {
        rumahTanggaCategoryPage.waitUntilTextToBePresentInElement(rumahTanggaCategoryPage.getPromotionTagLabelFirstProduct(),hooks.getDriver(),promoName);
        rumahTanggaCategoryPage.clickFirstProduct();

    }
    @When("Pada halaman produk, klik button Tambah ke keranjang")
    public void pada_halaman_produk_klik_button_tambah_ke_keranjang() {
        detailProductPage= new DetailProductPage(hooks.getDriver());
        detailProductPage.waitUntilElementVisible(detailProductPage.getCicilanPopupBtn(),hooks.getDriver());
        detailProductPage.clickCicilanPopupBtn();
        detailProductPage.clickTambahKeKeranjangBtn();

    }
    @When("Klik button Lanjut ke Keranjang")
    public void klik_button_lanjut_ke_keranjang() {
        detailProductPage.waitUntilElementVisible(detailProductPage.getLanjutKeKeranjangBtn(),hooks.getDriver());
        detailProductPage.clickLanjutKeKeranjangBtn();
    }
    @When("Klik Sign In")
    public void klik_sign_in() {
        productCartPage= new ProductCartPage(hooks.getDriver());
        productCartPage.waitUntilElementVisible(productCartPage.getCatatanPopupBtn(),hooks.getDriver());
        productCartPage.clickCatatanPopupBtn();
        productCartPage.clickLanjutKePembayaranBtn();
    }
    @When("Masukkan random email dan password")
    public void masukkan_random_email_dan_password() {
        productCheckoutPage= new ProductCheckoutPage(hooks.getDriver());
        productCheckoutPage.waitUntilElementVisible(productCheckoutPage.getSignInBtn(),hooks.getDriver());
        productCheckoutPage.setEmailTextField("asdasdas@gmail.com");
        productCheckoutPage.setPasswordTextField("asdasdas123123");
        productCheckoutPage.clickSignInBtn();

    }
    @Then("Verify error login message")
    public void verify_error_login_message() {
        productCheckoutPage.waitUntilElementVisible(productCheckoutPage.getLoginErrorMsg(),hooks.getDriver());
        Assert.assertEquals(productCheckoutPage.getLoginErrorMsgText(),"Alamat e-mail atau nomor telepon dan password salah, jika Anda lupa kata sandi klik di sini.");
    }
}
