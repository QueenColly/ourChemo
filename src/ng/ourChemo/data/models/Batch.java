package ng.ourChemo.data.models;

import java.time.LocalDate;

public class Batch {
    private int quantityLeft;
    private int costPrice;
    private int purchaseQuantity;
    private LocalDate purchasedDate;
    private int id;
    private LocalDate expiryYearMonth;
    private int drugId;

    public int getQuantityLeft() {
        return quantityLeft;
    }

    public void setQuantityLeft(int quantityLeft) {
        this.quantityLeft = quantityLeft;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public LocalDate getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(LocalDate purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getExpiryYearMonth() {
        return expiryYearMonth;
    }

    public void setExpiryYearMonth(LocalDate expiryYearMonth) {
        this.expiryYearMonth = expiryYearMonth;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }
}
