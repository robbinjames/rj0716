package Store;

import java.math.BigDecimal;

public enum Tool {
    LADW("Ladder", "Werner", BigDecimal.valueOf(1.99), true, true, false),
    CHNS("Chainsaw", "Stihl", BigDecimal.valueOf(1.49), true, false, true),
    JAKD("Jackhammer", "DeWalt", BigDecimal.valueOf(2.99), true, false, false),
    JAKR("JAckhammer", "Ridgid", BigDecimal.valueOf(2.99), true, false, false);

    private String toolType;
    private String toolBrand;
    private BigDecimal dailyCharge;
    private boolean weekdayCharge;
    private boolean weekendCharge;
    private boolean holidayCharge;


    Tool(String toolType, String toolBrand, BigDecimal dailyCharge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
        this.toolType = toolType;
        this.toolBrand = toolBrand;
        this.dailyCharge = dailyCharge;
        this.weekdayCharge = weekdayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }

    public String getToolType() {
        return toolType;
    }

    public String getToolBrand() {
        return toolBrand;
    }


    public BigDecimal getDailyCharge() {
        return dailyCharge;
    }

    public boolean isWeekdayCharge() {
        return weekdayCharge;
    }

    public boolean isWeekendCharge() {
        return weekendCharge;
    }

    public boolean isHolidayCharge() {
        return holidayCharge;
    }
}
