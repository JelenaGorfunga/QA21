import org.junit.jupiter.api.Test;

public class Homework {

    @Test
    public void loanTotalPayment() {

        double price = 162000.00;
        double downPayment = 8100.00;
        double annualInterestRate = 0.022;
        int loanTerm = 35;

        double loanAmount = getLoanAmount(price, downPayment);
        double monthlyInterestRate = getMonthlyInterestRate(annualInterestRate);
        int months = getMonthsCount(loanTerm);
        double payment = getMonthlyPayment(loanAmount, monthlyInterestRate, months);
        double totalSum = getTotalSum(payment, months);
        double totalInterestSum = getInterestSum(totalSum, loanAmount);

        System.out.println("Start loan amount is " + loanAmount + " EUR. Total Interest sum is " +
                totalInterestSum + " EUR. Total sum is " + totalSum + " EUR.");
    }

    private double getLoanAmount(double price, double downPayment) {
        return price - downPayment;
    }

    private double getMonthlyInterestRate(double annualInterestRate) {
        return annualInterestRate / 12;
    }

    private int getMonthsCount(int loanTerm) {
        return loanTerm * 12;
    }

    private double getMonthlyPayment(double loanAmount, double monthlyInterestRate, int months) {
        return loanAmount * (monthlyInterestRate /
                (1 - Math.pow(1 + monthlyInterestRate, -months)));
    }

    private double getTotalSum(double payment, int months) {
        return payment * months;
    }

    private double getInterestSum(double totalSum, double loanAmount) {
        return totalSum - loanAmount;
    }
}
