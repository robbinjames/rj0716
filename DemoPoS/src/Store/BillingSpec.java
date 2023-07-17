package Store;

import java.math.BigDecimal;

public class BillingSpec {

    BigDecimal toolDailyPrice;
    BigDecimal toolFinalPrice;
    int rentalDays;
    double discountPercentage;

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    BigDecimal discountAmount;
    BigDecimal priceBeforeDicount;

    public BigDecimal getPriceBeforeDicount() {
        return priceBeforeDicount;
    }

    public  BillingSpec(BigDecimal toolDailyPrice, int rentalDays, double discountPercentage){
        this.toolDailyPrice = toolDailyPrice;
        this.rentalDays = rentalDays;
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal calculateRentalPrice(){
        double multiplier = rentalDays * (discountPercentage/100);

//        System.out.println("Billing: toolDailyPrice"+ toolDailyPrice);
//        System.out.println("Billing: rentalDays"+ rentalDays);
//        System.out.println("Billing: discountPercentage"+ discountPercentage);

        priceBeforeDicount = toolDailyPrice.multiply(BigDecimal.valueOf(rentalDays));
//        System.out.println("Billing: priceBeforeDicount" + priceBeforeDicount);
        discountAmount = toolDailyPrice.multiply(BigDecimal.valueOf(multiplier));
//        System.out.println("Billing: Final: "+ priceBeforeDicount.subtract(discountAmount));

        toolFinalPrice = priceBeforeDicount.subtract(discountAmount);
        return toolFinalPrice;

    }
}
