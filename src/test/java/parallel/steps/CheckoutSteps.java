package parallel.steps;
import POM.*;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import parallel.appHooks.Hooks;

public class CheckoutSteps {
    private Hooks hooks;

    public CheckoutSteps(Hooks hooks) {
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
        DriverFactory.getDriver().get(url);

    }
    @When("Klik Kategori Belanja lalu {string}")
    public void klik_kategori_belanja_lalu(String kategory) {
        homePage= new HomePage(DriverFactory.getDriver());
        homePage.clickKategoryByName(kategory);
    }
    @When("Pilih berdasarkan Promo {string}")
    public void pilih_berdasarkan_promo(String promoName) {
        rumahTanggaCategoryPage=new RumahTanggaCategoryPage(DriverFactory.getDriver());
        rumahTanggaCategoryPage.scrollToText(rumahTanggaCategoryPage.getHeaderByName("Promo"));
        rumahTanggaCategoryPage.clickPromoListByName(promoName);
        this.promoName=promoName;
    }
    @When("Berdasarkan hasil tersebut pilih Urut Berdasarkan {string}")
    public void berdasarkan_hasil_tersebut_pilih_urut_berdasarkan(String sortedCategoryName){
        rumahTanggaCategoryPage.clickUrutListByName(sortedCategoryName);

    }
    @When("Klik produk yang muncul pada baris pertama")
    public void klik_produk_yang_muncul_pada_baris_pertama() {
        rumahTanggaCategoryPage.waitUntilTextToBePresentInElement(rumahTanggaCategoryPage.getPromotionTagLabelFirstProduct(),promoName);
        rumahTanggaCategoryPage.clickFirstProduct();

    }
    @When("Pada halaman produk, klik button Tambah ke keranjang")
    public void pada_halaman_produk_klik_button_tambah_ke_keranjang() {
        detailProductPage= new DetailProductPage(DriverFactory.getDriver());
        detailProductPage.waitUntilElementVisible(detailProductPage.getCicilanPopupBtn());
        detailProductPage.clickCicilanPopupBtn();
        detailProductPage.clickTambahKeKeranjangBtn();
        detailProductPage.clickPilihMetodePemesananBtn();

    }
    @When("Klik button Lanjut ke Keranjang")
    public void klik_button_lanjut_ke_keranjang() {
        detailProductPage.waitUntilElementVisible(detailProductPage.getLanjutKeKeranjangBtn());
        detailProductPage.clickLanjutKeKeranjangBtn();
    }
    @When("Klik Sign In")
    public void klik_sign_in() {
        productCartPage= new ProductCartPage(DriverFactory.getDriver());
        productCartPage.waitUntilElementVisible(productCartPage.getCatatanPopupBtn());
        productCartPage.clickCatatanPopupBtn();
        productCartPage.clickLanjutKePembayaranBtn();
    }
    @When("Masukkan random email dan password")
    public void masukkan_random_email_dan_password() {
        productCheckoutPage= new ProductCheckoutPage(DriverFactory.getDriver());
        productCheckoutPage.waitUntilElementVisible(productCheckoutPage.getSignInBtn());
        productCheckoutPage.setEmailTextField("asdasdas@gmail.com");
        productCheckoutPage.setPasswordTextField("asdasdas123123");
        productCheckoutPage.clickSignInBtn();

    }
    @Then("Verify error login message")
    public void verify_error_login_message() {
        productCheckoutPage.waitUntilElementVisible(productCheckoutPage.getLoginErrorMsg());
        Assert.assertEquals(productCheckoutPage.getLoginErrorMsgText(),"Alamat e-mail atau nomor telepon dan password salah, jika Anda lupa kata sandi klik di sini.");
    }
}
