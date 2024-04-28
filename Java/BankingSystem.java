import java.util.Scanner;
import java.lang.Math;

abstract class Account {
    abstract void calculateInterest();
}

class SavingsAccount extends Account {
    private double averageAmount;

    SavingsAccount(double averageAmount) {
        this.averageAmount = averageAmount;
    }

    @Override
    void calculateInterest() {
        if (averageAmount < 0) {
            throw new IllegalArgumentException("Invalid average amount. Please enter a non-negative value.");
        }
        double interest = averageAmount * 0.04; // Assuming a 4% interest rate for savings account
        System.out.println("Interest gained: Rs. " + interest);
    }
}

class FixedDeposit extends Account {
    private double fdAmount;
    private int numberOfDays;
    private int age;

    FixedDeposit(double fdAmount, int numberOfDays, int age) {
        this.fdAmount = fdAmount;
        this.numberOfDays = numberOfDays;
        this.age = age;
    }

    @Override
    void calculateInterest() {
        if (fdAmount < 0 || numberOfDays < 0 || age < 0) {
            throw new IllegalArgumentException("Invalid input values. Please enter non-negative values.");
        }

        double interestRate;
        
        if (fdAmount <= 10000000) {
            // Amount less than or equal to 1 crore
            if (numberOfDays >= 7 && numberOfDays <= 14) {
                interestRate = (age >= 60) ? 5.00 : 4.50;
            } else if (numberOfDays >= 15 && numberOfDays <= 29) {
                interestRate = (age >= 60) ? 5.25 : 4.75;
            } else if (numberOfDays >= 30 && numberOfDays <= 45) {
                interestRate = (age >= 60) ? 6.00 : 5.50;
            } else if (numberOfDays >= 46 && numberOfDays <= 60) {
                interestRate = (age >= 60) ? 7.50 : 7.00;
            } else if (numberOfDays >= 61 && numberOfDays <= 184) {
                interestRate = (age >= 60) ? 8.00 : 7.50;
            } else if (numberOfDays >= 185 && numberOfDays <= 365) {
                interestRate = (age >= 60) ? 8.50 : 8.00;
            } else {
                throw new IllegalArgumentException("Invalid number of days for Fixed Deposit.");
            }
        } else {
            // Amount above 1 crore
            if (numberOfDays >= 7 && numberOfDays <= 14) {
                interestRate = 6.50;
            } else if (numberOfDays >= 15 && numberOfDays <= 29) {
                interestRate = 6.75;
            } else if (numberOfDays >= 30 && numberOfDays <= 45) {
                interestRate = 6.75;
            } else if (numberOfDays >= 46 && numberOfDays <= 60) {
                interestRate = 8.00;
            } else if (numberOfDays >= 61 && numberOfDays <= 184) {
                interestRate = 8.50;
            } else if (numberOfDays >= 185 && numberOfDays <= 365) {
                interestRate = 10.00;
            } else {
                throw new IllegalArgumentException("Invalid number of days for Fixed Deposit.");
            }
        }

        double interest = (fdAmount * interestRate * numberOfDays) / (365 * 100);
        System.out.println("Interest gained is: " + interest);
    }
}

class RecurringDeposit extends Account {
    private double rdAmount;
    private int numberOfMonths;
    private int age;

    RecurringDeposit(double rdAmount, int numberOfMonths, int age) {
        this.rdAmount = rdAmount;
        this.numberOfMonths = numberOfMonths;
        this.age = age;
    }

    @Override
    void calculateInterest() {
        if (rdAmount < 0 || numberOfMonths < 0 || age < 0) {
            throw new IllegalArgumentException("Invalid input values. Please enter non-negative values.");
        }

        double interestRate;

        if (numberOfMonths == 6) {
            interestRate = (age >= 60) ? 8.00 : 7.50;
        } else if (numberOfMonths == 9) {
            interestRate = (age >= 60) ? 8.50 : 7.75;
        } else if (numberOfMonths == 12) {
            interestRate = (age >= 60) ? 9.00 : 8.00;
        } else if (numberOfMonths == 15) {
            interestRate = (age >= 60) ? 9.25 : 8.25;
        } else if (numberOfMonths == 18) {
            interestRate = (age >= 60) ? 9.50 : 8.50;
        } else if (numberOfMonths == 21) {
            interestRate = (age >= 60) ? 9.75 : 8.75;
        } else {
            throw new IllegalArgumentException("Invalid number of months for Recurring Deposit.");
        }

        double interest = rdAmount - rdAmount * Math.pow((1 - interestRate / 100*numberOfMonths), numberOfMonths);
        System.out.println("Interest gained is: " + interest);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mehak Sharma \n21BCS2062");
        while (true) {
            System.out.println("Select the option:");
            System.out.println("1. Interest Calculator -SB");
            System.out.println("2. Interest Calculator -FD");
            System.out.println("3. Interest Calculator -RD");
            System.out.println("4. Exit");

            int option = scanner.nextInt();

            if (option == 4) {
                System.out.println("Exiting program.");
                break;
            }

            try {
                switch (option) {
                    case 1:
                        System.out.println("Enter the Average amount in your account:");
                        double averageAmountSB = scanner.nextDouble();
                        Account savingsAccount = new SavingsAccount(averageAmountSB);
                        savingsAccount.calculateInterest();
                        break;

                    case 2:
                        System.out.println("Enter the FD amount:");
                        double fdAmount = scanner.nextDouble();
                        System.out.println("Enter the number of days:");
                        int numberOfDaysFD = scanner.nextInt();
                        System.out.println("Enter your age:");
                        int ageFD = scanner.nextInt();
                        Account fixedDeposit = new FixedDeposit(fdAmount, numberOfDaysFD, ageFD);
                        fixedDeposit.calculateInterest();
                        break;

                    case 3:
                        System.out.println("Enter the RD amount:");
                        double rdAmount = scanner.nextDouble();
                        System.out.println("Enter the number of months:");
                        int numberOfMonthsRD = scanner.nextInt();
                        System.out.println("Enter your age:");
                        int ageRD = scanner.nextInt();
                        Account recurringDeposit = new RecurringDeposit(rdAmount, numberOfMonthsRD, ageRD);
                        recurringDeposit.calculateInterest();
                        break;

                    default:
                        System.out.println("Invalid option. Please enter a valid option.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
