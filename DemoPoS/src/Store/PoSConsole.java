package Store;

import java.util.Scanner;


public class PoSConsole {

    RentSpec rentSpec;

    public PoSConsole(){
        this.rentSpec = new RentSpec();
    }

    public static void main(String[] args) {

        System.out.println("################ Store PoS Demo - Renting out Tools! ##################\n");

        String toolCode;
        String rentalDays;
        PoSConsole poSConsole = new PoSConsole();
        System.out.println("---- Checkout the Renting Tool ----");

        // User Input validation
        System.out.println("Enter Tool Code");
        Scanner scannerObj = new Scanner(System.in);
        while(true){
            toolCode = scannerObj.nextLine();
            if( poSConsole.validateTool(toolCode) || toolCode.equalsIgnoreCase("X")){
                break;
            }
            System.out.println("Wrong Tool Code Entered. Please Enter Correct Tool Code");
            System.out.println("Enter X to Exit");
        }
        if( toolCode.equalsIgnoreCase("x")){
            System.out.println("Exiting...");
            System.exit(0);
        }

        int nRentalDays;
        System.out.println("Enter Number of Rental Days");
        while(true){
            rentalDays = scannerObj.nextLine();
            nRentalDays = Integer.parseInt(rentalDays);
            if(nRentalDays > 0){
                break;
            }
            System.out.println("Number of Days for Rental is invalid! Please enter a valid number");
        }

        int discountPercentage;
        System.out.println("Enter the discount in percentage");
        while(true){
            discountPercentage = Integer.parseInt(scannerObj.nextLine());
            if(nRentalDays >= 0 && nRentalDays <= 100){
                break;
            }
            System.out.println("Discount should be between 0% -100%! Please enter a valid discount");
        }

        System.out.print("Enter checkout date (MM/dd/yy): ");
        String checkOutDate = scannerObj.nextLine();

        // Begin Checkout
        poSConsole.checkout(toolCode, checkOutDate, nRentalDays, discountPercentage);

    }



    // Support Methods
    private boolean validateTool(String toolCode){
       return rentSpec.validateTool(toolCode);
    }

    private Boolean checkout(String toolCode, String checkoutDate, int rentalDays, int discountPercentage){
        System.out.println(rentSpec.checkout(toolCode, checkoutDate, rentalDays, discountPercentage));
        System.out.println("Tool Checkout Success");
        return true;
    }

}
