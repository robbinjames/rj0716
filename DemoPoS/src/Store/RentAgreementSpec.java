package Store;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class RentAgreementSpec {
    private String toolCode;
    private String toolType;
    private String toolBrand;
    private int rentalDays;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private BigDecimal dailyRentalCharge;
    private int chargeDays;
    private BigDecimal preDiscountCharge;
    private double discountPercent;
    private BigDecimal discountAmount;
    private BigDecimal finalCharge;

    public RentAgreementSpec(String toolCode, String toolType, String toolBrand, int rentalDays, LocalDate checkoutDate,
                           LocalDate dueDate, BigDecimal dailyRentalCharge, int chargeDays,
                           BigDecimal preDiscountCharge, double discountPercent, BigDecimal discountAmount,
                           BigDecimal finalCharge) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.toolBrand = toolBrand;
        this.rentalDays = rentalDays;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.dailyRentalCharge = dailyRentalCharge;
        this.chargeDays = chargeDays;
        this.preDiscountCharge = preDiscountCharge;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.finalCharge = finalCharge;
    }

    public String getToolCode() {
        return toolCode;
    }

    public String getToolType() {
        return toolType;
    }

    public String getToolBrand() {
        return toolBrand;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public BigDecimal getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public BigDecimal getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public BigDecimal getFinalCharge() {
        return finalCharge;
    }

    // Override toString() method for convenient printing
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
        return "Rental Agreement:\n" +
                "Tool Code: " + toolCode + "\n" +
                "Tool Type: " + toolType + "\n" +
                "Tool Brand: " + toolBrand + "\n" +
                "Rental Days: " + rentalDays + "\n" +
                "Checkout Date: " + checkoutDate.format(formatter) + "\n" +
                "Due Date: " + dueDate.format(formatter) + "\n" +
                "Daily Rental Charge: $" + dailyRentalCharge + "\n" +
                "Charge Days: " + chargeDays + "\n" +
                "Pre-Discount Charge: $" + preDiscountCharge + "\n" +
                "Discount Percent: " + discountPercent + "%\n" +
                "Discount Amount: $" + discountAmount + "\n" +
                "Final Charge: $" + finalCharge;
    }
}
