package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CoursePage;

public class VideoSteps {

    CoursePage coursePage;

    // Metode helper untuk Lazy Initialization Page Object
    private void initCoursePage() {
        if (coursePage == null) {
            coursePage = new CoursePage(Hooks.driver);
        }
    }

    @When("Pelajar menavigasi ke tab Kursus Saya")
    public void pelajar_menavigasi_ke_tab_kursus_saya() {
        initCoursePage();
        coursePage.clickTabKursusSaya();
    }

    @When("Pelajar memilih card kursus {string}")
    public void pelajar_memilih_card_kursus(String string) {
        initCoursePage();
        coursePage.clickCardContohKursus();
    }

    @When("Pelajar mengklik tombol Lanjutkan Kursus")
    public void pelajar_mengklik_tombol_lanjutkan_kursus() {
        initCoursePage();
        coursePage.clickBtnLanjutkanKursus();
    }

    @When("Pelajar memilih item materi {string}")
    public void pelajar_memilih_item_materi(String string) {
        initCoursePage();
        coursePage.clickMateriTestVideo();
    }

    @Then("Sistem memuat player video dan ikon YouTube dapat diklik")
    public void sistem_memuat_player_video_dan_ikon_youtube_dapat_diklik() {
        initCoursePage();
        Assert.assertTrue("Gagal berinteraksi dengan player YouTube", coursePage.interactWithYouTubePlayer());
    }
}