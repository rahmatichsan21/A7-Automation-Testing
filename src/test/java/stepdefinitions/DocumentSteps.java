package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CoursePage;

public class DocumentSteps {

    CoursePage coursePage;

    // Metode helper untuk Lazy Initialization Page Object
    private void initCoursePage() {
        if (coursePage == null) {
            coursePage = new CoursePage(Hooks.driver);
        }
    }

    @When("Pelajar memilih card kursus {string} untuk dokumen")
    public void pelajar_memilih_card_kursus_untuk_dokumen(String string) {
        initCoursePage();
        if (string.equals("CyberSecurity")) {
            coursePage.clickCardCyberSecurity();
        } else {
            coursePage.clickCardContohKursus();
        }
    }

    @When("Pelajar memilih item materi bertipe dokumen teks PDF")
    public void pelajar_memilih_item_materi_bertipe_dokumen_teks_pdf() {
        initCoursePage();
        coursePage.clickMateriTestPDF();
    }

    @Then("Sistem memuat dan menampilkan konten materi PDF secara langsung")
    public void sistem_memuat_dan_menampilkan_konten_materi_pdf_secara_langsung() {
        initCoursePage();
        
        // Asersi menggunakan JUnit untuk mengonfirmasi JTKLearn sukses menampilkan kontainer PDF
        Assert.assertTrue("Iframe/Viewer PDF gagal dirender oleh sistem JTKLearn", coursePage.isPDFDisplayed());
    }
}
