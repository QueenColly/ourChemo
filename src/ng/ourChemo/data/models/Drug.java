package ng.ourChemo.data.models;

import java.time.LocalDate;
import java.util.*;

public class Drug {
      private int drugId;
      private String drugName;
      private String brand ;
      public LocalDate expiryDate;
      private int price;
      private List<Batch> batch = new ArrayList<>();

   public Drug(int drugId, String drugName, String brand, LocalDate expiryDate, int price, List<Batch> batch) {
      this.drugId = drugId;
      this.drugName = drugName;
      this.brand = brand;
      this.expiryDate = expiryDate;
      this.price = price;
      this.batch = batch;
   }

   public Drug() {
   }

   public int getDrugId() {
      return drugId;
   }

   public void setDrugId(int drugId) {
      this.drugId = drugId;
   }

   public String getDrugName() {
      return drugName;
   }

   public void setDrugName(String drugName) {
      this.drugName = drugName;
   }

   public String getBrand() {
      return brand;
   }

   public void setBrand(String brand) {
      this.brand = brand;
   }

   public LocalDate getExpiryDate() {
      return expiryDate;
   }

   public void setExpiryDate(LocalDate expiryDate) {
      this.expiryDate = expiryDate;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public List<Batch> getBatch() {
      return batch;
   }

   public void setBatch(List<Batch> batch) {
      this.batch = batch;
   }
}
