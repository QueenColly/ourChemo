package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.DispensedDrug;
import ng.ourChemo.data.models.Drug;
import ng.ourChemo.data.models.Drug;

public interface DrugRepository {

    long count();
    Drug save(Drug drug);

    Drug findByDrugNameAndBrand(String drugName, String brand);

    void saveNewDrug(Drug newDrug);

    void delete(Drug drug);


    void clearAll();

    Drug findById(int drugId);

    void deleteById(int drugTwoId);

    void updateExisting(Drug drug);
}
