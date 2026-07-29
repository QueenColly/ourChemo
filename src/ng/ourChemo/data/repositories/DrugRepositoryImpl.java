package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Drug;
import ng.ourChemo.utils.Mapper;

import java.util.ArrayList;
import java.util.Random;


public class DrugRepositoryImpl implements DrugRepository {
    ArrayList<Drug> users = new ArrayList<>();

    @Override
    public long count() {
        long count =  users.size();
        return count;
    }

    @Override
    public Drug save(Drug drug) {
//        Drug drugOne = new Drug();
//        drugOne.setDrugName(drug.getDrugName());
//        drugOne.setBrand(drug.getBrand());
//        drugOne.setPrice(drug.getPrice());
//        drugOne.setExpiryDate(drug.getExpiryDate());
//        drugOne.setBatch(drug.getBatch());
//        drugOne.setDrugId(setDrugId());
        Drug newDrug = Mapper.mapToCreateNewDrug(drug);
        users.add(newDrug);
        return newDrug;
    }


    private int setDrugId(){
        Random random = new Random();
        return random.nextInt(1, 100);
    }

    @Override
    public Drug findByDrugNameAndBrand(String drugName, String brand) {
        Drug drug = null;
        for(Drug foundDrug : users){
            if(drugName.equals(foundDrug.getDrugName()) && brand.equals(foundDrug.getBrand())){
                drug = foundDrug;
            }
            else {
                drug = null;
            }
        }
            return drug;
    }


    @Override
    public void saveNewDrug(Drug newDrug) {
        for(Drug drug : users){
            if(drug.getDrugName().equals(newDrug.getDrugName())) {
                System.out.println("Drug already exists");
                return;
            }
        }
        save(newDrug);
    }

    @Override
    public void delete(Drug drug) {
        Drug foundDrug = findByDrugNameAndBrand(drug.getDrugName(),drug.getBrand());
        System.out.println(foundDrug.getDrugName());
        users.remove(foundDrug);

    }

    @Override
    public void clearAll() {
        while(!users.isEmpty()){
            users.remove(users.get(0));
        }
    }

    @Override
    public Drug findById(int drugId) {
       Drug drugFoundById = null;
       for(Drug drug : users){
           if(drugId == drug.getDrugId()){
               drugFoundById = drug;
           }
       }
        return drugFoundById;
    }

    @Override
    public void deleteById(int drugTwoId) {

    }

    @Override
    public void updateExisting(Drug drug) {

    }
}
