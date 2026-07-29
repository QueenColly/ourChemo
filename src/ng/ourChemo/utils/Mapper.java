package ng.ourChemo.utils;

import ng.ourChemo.data.models.DispensedDrugs;
import ng.ourChemo.data.models.Drug;
import ng.ourChemo.data.models.User;
import ng.ourChemo.data.repositories.DrugRepository;
import ng.ourChemo.data.repositories.DrugRepositoryImpl;
import ng.ourChemo.dtos.requests.AddDrugRequest;
import ng.ourChemo.dtos.requests.DispensedDrugsRequest;
import ng.ourChemo.dtos.requests.RegisterUserRequest;
import ng.ourChemo.dtos.requests.UpdateDrugRequest;

public class Mapper {
    public static User mapUser(RegisterUserRequest userRequest){
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setFullname(userRequest.getFullName());
        user.setPassword(userRequest.getPassword());
        return user;
    }
    public static Drug mapDrug(AddDrugRequest drugRequest){
        Drug drug = new Drug();
        drug.setDrugName(drugRequest.getName());
        drug.setBrand(drugRequest.getBrand());
        drug.setPrice(drugRequest.getPrice());

        return drug;
    }

    public static Drug mapToCreateNewDrug(Drug drug) {
        Drug drugOne = new Drug();
        drugOne.setDrugName(drug.getDrugName());
        drugOne.setBrand(drug.getBrand());
        drugOne.setPrice(drug.getPrice());
        drugOne.setExpiryDate(drug.getExpiryDate());
        drugOne.setBatch(drug.getBatch());

        return drugOne;
    }
   public static Drug mapDrugUpdate(UpdateDrugRequest updateRequest){
        Drug foundDrug = validateFoundDrug(updateRequest);
        foundDrug.setDrugName(updateRequest.getName());
        foundDrug.setBrand(updateRequest.getBrand());
        foundDrug.setPrice(updateRequest.getPrice());
        return foundDrug;
    }
    public static Drug validateFoundDrug(UpdateDrugRequest updateDrugRequest){
        DrugRepository drug = new DrugRepositoryImpl();
        Drug foundDrug = drug.findById(updateDrugRequest.getDrugId());
        if(foundDrug == null) throw new IllegalArgumentException("Drug not found");
        return foundDrug;
    }
    public static DispensedDrugs mapToDispensedDrugs(DispensedDrugsRequest dispensedDrugsRequest){
        DispensedDrugs drugs = new DispensedDrugs();
        drugs.setDispensedBy(dispensedDrugsRequest.getDispensedBy());
        drugs.setDispensedDrugsId(dispensedDrugsRequest.getId());
        drugs.setDispensedDateTime(dispensedDrugsRequest.getDispensedDateTime());
        drugs.setDispensedDrugs(dispensedDrugsRequest.getDispensedDrugs());
        return drugs;
    }
}
