import java.util.Scanner;

public class TravelDriver {

    public static final int CREATE_TRAVEL_PLAN = 1;
    public static final int SHOW_TRAVEL_SUMMARY = 2;
    public static final int CALCULATE_DAILY_BUDGET = 3;
    public static final int CHECK_IF_OKAY_TRAVEL = 4;
    public static final int CONVERT_DOLLAR_TO_EURO = 5;
    public static final int CONVERT_DOLLAR_TO_TAIWAN_DOLLAR = 6;
    public static final int UPDATE_TRIP_DETAILS = 7;
    public static final int QUIT = 8;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Travel travel1 = null;
        
        boolean exit = false;
        while (!exit) {
        	System.out.println("");
            System.out.println("Welcome to the Travel Planner!");
            System.out.println("\nMenu:");
            System.out.println(CREATE_TRAVEL_PLAN + ". Create Travel Plan");
            System.out.println(SHOW_TRAVEL_SUMMARY + ". Show Travel Summary");
            System.out.println(CALCULATE_DAILY_BUDGET + ". Calculate Daily Budget");
            System.out.println(CHECK_IF_OKAY_TRAVEL + ". Check if Okay to Travel");
            System.out.println(CONVERT_DOLLAR_TO_EURO + ". Convert Travel Fund to Euros");
            System.out.println(CONVERT_DOLLAR_TO_TAIWAN_DOLLAR + ". Convert Travel Fund to Taiwan Dollars");
            System.out.println(UPDATE_TRIP_DETAILS + ". Update Trip Details");
            System.out.println(QUIT + ". Exit");

            System.out.println("\nEnter your choice:");

            int choice = getValidIntInput(scnr);

            switch (choice) {
                case CREATE_TRAVEL_PLAN:

                    System.out.println("What is your name?");
                    String name = scnr.nextLine();

                    System.out.println("What is your destination?");
                    String destination = scnr.nextLine();

                    System.out.println("How many days is your trip?");
                    int days = getValidIntInput(scnr);

                    System.out.println("What is the approximate cost of your trip? (numbers only)");
                    int travelCost = getValidIntInput(scnr);

                    System.out.println("What is the amount of your travel fund? Minimum of $1000 (numbers only)");
                    int travelFund = getValidIntInput(scnr);

                    travel1 = new Travel(name, destination, days, travelCost, travelFund);
                    System.out.println("Travel plan created successfully.");
                    break;
                case SHOW_TRAVEL_SUMMARY:
                    if (travel1 != null) {
                        travel1.printTravelSummary();
                    } else {
                        System.out.println("Please create a travel plan first.");
                    }
                    break;
                case CALCULATE_DAILY_BUDGET:
                    if (travel1 != null) {
                        System.out.println(travel1.calculateDailyBudget(travel1.getDays()));
                    } else {
                        System.out.println("Please create a travel plan first.");
                    }
                    break;
                case CHECK_IF_OKAY_TRAVEL:
                    if (travel1 != null) {
                        if (travel1.isOkayToTravel()) {
                        	System.out.println("");
                            System.out.println("You can go on your trip to " + travel1.getDestination() + "!");
                            System.out.println("You have saved " + travel1.percentageSaved() + "% of the trip cost.");
                        }
                    } 
                    break;
                case CONVERT_DOLLAR_TO_EURO:
                    if (travel1 != null) {
                        System.out.println("Travel Fund in Euros: € " + travel1.convertToEuros());
                    } else {
                        System.out.println("Please create a travel plan first.");
                    }
                    break;
                case CONVERT_DOLLAR_TO_TAIWAN_DOLLAR:
                    if (travel1 != null) {
                        System.out.println("Travel Fund in Taiwan Dollars: NT$ " + travel1.convertToTaiwanDollars());
                    } else {
                        System.out.println("Please create a travel plan first.");
                    }
                    break;
                case UPDATE_TRIP_DETAILS:
                    if (travel1 != null) {
                        System.out.println("Update Trip Details:");
                        System.out.println("What is your name?");
                        String newName = scnr.nextLine();
                        travel1.setName(newName);
                        System.out.println("What is your new destination?");
                        String newDestination = scnr.nextLine();
                        travel1.setDestination(newDestination);
                        System.out.println("Enter new number of days:");
                        int newDays = getValidIntInput(scnr);
                        travel1.setDays(newDays);
                        System.out.println("Enter new travel cost:");
                        int newTravelCost = getValidIntInput(scnr);
                        travel1.setTravelCost(newTravelCost);
                        System.out.println("Enter new travel fund:");
                        int newTravelFund = getValidIntInput(scnr);
                        travel1.setTravelFund(newTravelFund);
                    } else {
                        System.out.println("Please create a travel plan first.");
                    }
                    break;
                case QUIT:
                    System.out.println("Exiting program. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from " + CREATE_TRAVEL_PLAN + " to " + QUIT + ".");
                    break;
            }
        }

        scnr.close();
    }

    private static int getValidIntInput(Scanner scnr) {
        while (!scnr.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number: ");
            scnr.next();
        }
        int input = scnr.nextInt();
        scnr.nextLine();
        return input;
    }
}
