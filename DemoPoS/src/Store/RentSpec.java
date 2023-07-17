package Store;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentSpec {

    BillingSpec billingSpec;

    public boolean validateTool(String toolCode) {

        try {
            Tool tool = Tool.valueOf(toolCode);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public RentAgreementSpec checkout(String toolCode, String checkoutDate, int rentalDays, double discountPercentage) {

        Tool tool = Tool.valueOf(toolCode);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
        LocalDate startDate = LocalDate.parse(checkoutDate, formatter);
        LocalDate dueDate = startDate.plusDays(rentalDays);

        int bilingRentalDays = calculateRentalDays(rentalDays, startDate, dueDate, tool.isWeekendCharge(), tool.isHolidayCharge());
        billingSpec = new BillingSpec(tool.getDailyCharge(), bilingRentalDays, discountPercentage);
        System.out.println("Final" + billingSpec.calculateRentalPrice());


        RentAgreementSpec rentAgreementSpec = new RentAgreementSpec(toolCode,
                tool.getToolType(),
                tool.getToolBrand(),
                rentalDays,
                startDate, dueDate,
                tool.getDailyCharge(),
                bilingRentalDays,
                billingSpec.getPriceBeforeDicount(),
                discountPercentage,
                billingSpec.getDiscountAmount(),
                billingSpec.toolFinalPrice
        );
        return rentAgreementSpec;
    }

    private int calculateRentalDays(int rentalDays, LocalDate startDate, LocalDate endDate, Boolean weekend, Boolean holiday) {
        int actualBillingDays = 0;
        int weekendDayCount = 0;
        int holidayCount = 0;

        if (!weekend) {
            LocalDate currentDate = startDate;
            while (!currentDate.isAfter(endDate)) {
                if (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY || currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    weekendDayCount++;
                }
                currentDate = currentDate.plusDays(1);
            }
            if (holiday) {
                LocalDate julyFourth = LocalDate.of(startDate.getYear(), 7, 4);
                if ((julyFourth.getDayOfWeek() != DayOfWeek.SATURDAY) || (julyFourth.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                    if (startDate.isBefore(julyFourth) && endDate.isAfter(julyFourth)) {
                        weekendDayCount--;
                    }
                }
            }
        }
        actualBillingDays = rentalDays - weekendDayCount;
        System.out.println("Rental Days count After weekend check :" + actualBillingDays);

        if (!holiday) {
            LocalDate julyFourth = LocalDate.of(startDate.getYear(), 7, 4);

            LocalDate date = LocalDate.of(startDate.getYear(), 9, 1);
            while (date.getDayOfWeek() != DayOfWeek.MONDAY) {
                date = date.plusDays(1);
            }
            LocalDate firstMondayInSeptember = date;

            //  Independence day
            if (startDate.isBefore(julyFourth) && endDate.isAfter(julyFourth)) {
                holidayCount++;
            }

            // Laobor Day
            if (startDate.isBefore(firstMondayInSeptember) && endDate.isAfter(firstMondayInSeptember)) {
                holidayCount++;
            }
        }

        actualBillingDays = actualBillingDays - holidayCount;
        System.out.println("Rental Days count after Holiday check:" + actualBillingDays);

        return actualBillingDays;
    }

    private int findNumberOfWeekendDays(LocalDate startDate, LocalDate endDate) {
        int weekendDayCount = 0;

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            if (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY || currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                weekendDayCount++;
            }
            currentDate = currentDate.plusDays(1);
        }

        LocalDate julyFourth = LocalDate.of(startDate.getYear(), 7, 4);
        if ((julyFourth.getDayOfWeek() != DayOfWeek.SATURDAY) || (julyFourth.getDayOfWeek() == DayOfWeek.SUNDAY)) {
            if (startDate.isBefore(julyFourth) && endDate.isAfter(julyFourth)) {
                // weekendDayCount--;
            }
        }
        return weekendDayCount;
    }

    private int countHolidayDaysInRange(LocalDate startDate, LocalDate endDate) {
        LocalDate julyFourth = LocalDate.of(startDate.getYear(), 7, 4);

        LocalDate date = LocalDate.of(startDate.getYear(), 9, 1);
        while (date.getDayOfWeek() != DayOfWeek.MONDAY) {
            date = date.plusDays(1);
        }
        LocalDate firstMondayInSeptember = date;

        int holidayCount = 0;
        if (startDate.isBefore(julyFourth) && endDate.isAfter(julyFourth)) {
            holidayCount++;
        }
        if (startDate.isBefore(firstMondayInSeptember) && endDate.isAfter(firstMondayInSeptember)) {
            holidayCount++;
        }
        return holidayCount;
    }
}
