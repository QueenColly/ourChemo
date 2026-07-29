package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Batch;
import ng.ourChemo.data.models.User;
import ng.ourChemo.data.models.Drug;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DrugRepositoryImplTest {

    private DrugRepository drugRepository;
    private Drug drug;

    @BeforeEach
    public void setup() {
        drugRepository = new DrugRepositoryImpl();
        drug = new Drug();

        drug.setDrugName("Paracetemol");

        Batch batch = new Batch();
        batch.setCostPrice(5900);

        DateTimeFormatter expiryDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        YearMonth expiryYearMonth = YearMonth.parse("2027-05", expiryDateFormatter);
        LocalDate expiryLocalDate = expiryYearMonth.atEndOfMonth();

        batch.setExpiryYearMonth(expiryLocalDate);
        batch.setQuantityLeft(67);
        batch.setPurchaseQuantity(34);


        DateTimeFormatter purchaseDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        YearMonth purchaseYearMonth = YearMonth.parse("2027-05", purchaseDateFormatter);
        LocalDate purchaseLocalDate = purchaseYearMonth.atEndOfMonth();
        batch.setPurchasedDate(purchaseLocalDate);

        List<Batch> batches = new ArrayList<>();
        batches.add(batch);

        drug.setBatch(batches);
        drug.setBrand("Phizer");
        drug=drugRepository.save(drug);

    }
    @AfterEach
    public void after() {
            drugRepository.clearAll();
        }
  @Test
  public void createANewDrugAndSaveToSystem_test() {
      Drug response =drugRepository.save(drug);
      assertEquals(drug.getDrugName(), response.getDrugName());
      assertNotEquals(drug.getDrugId(),response.getDrugId());
        }

    @Test
    public void saveANewDrugToTheListOfDrugs_test() {

        Drug drug2 = new Drug();
        drug.setDrugName("Emzor");
        drugRepository.saveNewDrug(drug2);

        assertEquals(2, drugRepository.count());
    }

    @Test
    public void saveThreeNewDrugs_deleteDrugObject() {
        Drug drug2 = new Drug();
        drug2.setDrugName("Penicillin");
        drug2.setBrand("Augmentin");
        drugRepository.saveNewDrug(drug2);
        assertEquals(2,drugRepository.count());

        Drug drug3 = new Drug();
        drug3.setDrugName("Vitamin");
        drug3.setBrand("Vitamin C");
        drugRepository.saveNewDrug(drug3);
        assertEquals(3,drugRepository.count());

        drugRepository.delete(drug3);
        assertEquals(2,drugRepository.count());
    }
    @Test
    public void saveTwoDrugs_clearTheListOfSavedDrugs_listIsEmpty_test() {
        Drug drug2 = new Drug();
        drug2.setDrugName("Penicillin");
        drug2.setBrand("Augmentin");
        drugRepository.saveNewDrug(drug2);
        assertEquals(2,drugRepository.count());

        drugRepository.clearAll();
        assertEquals(0, drugRepository.count());
    }
    @Test
        public void saveANewDrugToTheList_findDrugBy_drugId_test(){
        Drug drugOne = drugRepository.findById(drug.getDrugId());
        assertEquals(1, drugRepository.count());
        assertEquals(drugOne.getDrugName(), drug.getDrugName());
    }
}