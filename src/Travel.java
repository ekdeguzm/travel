public class Travel {

    private String name, destination;
    private int days, travelFund, travelCost;
    private static final int MINIMUM_TRAVEL_BUDGET = 1000;
    private static final double DOLLAR_TO_EURO_CONVERSION = 0.93;
    private static final double DOLLAR_TO_TAIWAN_DOLLAR_CONVERSION = 32.44;

    public Travel(String theName, String theDestination, int theDays, int theTravelCost, int theTravelFund) {
        name = theName;
        destination = theDestination;
        days = theDays;
        travelCost = theTravelCost;
        travelFund = theTravelFund;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }
    
    public int getDays() {
        return days;
    }

    public double getTravelCost() {
        return travelCost;
    }

    public double getTravelFund() {
        return travelFund;
    }

    public void setName(String theNewName) {
        name = theNewName;
    }

    public void setDestination(String theNewDestination) {
        destination = theNewDestination;
    }
    
    public void setDays(int theNewDays) {
        days = theNewDays;
    }

    public void setTravelCost(int theNewTravelCost) {
        travelCost = theNewTravelCost;
    }

    public void setTravelFund(int theNewTravelFund) {
        travelFund = theNewTravelFund;
    }
    
    public String calculateDailyBudget(int numberOfDays) {
        if (numberOfDays <= 0) {
            return "Number of days must be greater than zero. Please enter again.";
        }

        double dailyBudget = (double) travelFund / numberOfDays;
        return "Your budget allows up to $" + String.format("%.2f", dailyBudget) + " per day.";
    }

    public boolean isOkayToTravel(int travelCost) {
        return travelFund >= travelCost;
    }
    
    public boolean isOkayToTravel() {
        if (percentageSaved() < 100) {
            printNotEnoughSavedMessage();
            return false;
        } else if (travelFund < MINIMUM_TRAVEL_BUDGET) {
            printNotEnoughFundsMessage();
            return false;
        } else {
            return true;
        }
    }   
    
    private void printNotEnoughSavedMessage() {
        System.out.println("No, because you have not saved 100% of the trip cost.");
    }

    private void printNotEnoughFundsMessage() {
        System.out.println("No, because you need to save more money. \nMinimum savings required: $" + MINIMUM_TRAVEL_BUDGET);
    }


    public int percentageSaved() {
        if (travelCost == 0) {
            return 0;
        }
        return (int) (((double) travelFund / travelCost) * 100);
    }
    
    public int convertToEuros() {
        return (int) (travelFund * DOLLAR_TO_EURO_CONVERSION);
    }

    public int convertToTaiwanDollars() {
        return (int) (travelFund * DOLLAR_TO_TAIWAN_DOLLAR_CONVERSION);
    }
    
    public void printTravelSummary() {
        System.out.println("");
        System.out.println("Travel Summary:");
        System.out.println("Name: " + getName());
        System.out.println("Destination: " + getDestination());
        System.out.println("Trip length in Days: " + getDays());
        System.out.printf("Travel Cost: $%.2f%n", getTravelCost()); 
        System.out.printf("Travel Fund: $%.2f%n", getTravelFund()); 
        System.out.println("You have saved " + percentageSaved() + "% of the trip cost.");
        System.out.print("Is it okay to travel? ");
        if (isOkayToTravel()) {
            System.out.println("You can go on your trip to " + destination + "!");
        } else {
            System.out.println("You need to save more money for your trip to " + destination + ".");
        }
        System.out.println(calculateDailyBudget(getDays()));
        if (destination.equalsIgnoreCase("Europe")) {
            System.out.println("Travel Fund in Euros: € " + convertToEuros());
        } 
        if (destination.equalsIgnoreCase("Taiwan")) {
        	System.out.println("Travel Fund in Taiwan Dollars: NT$ " + convertToTaiwanDollars());
        }
        
  
    }
}
