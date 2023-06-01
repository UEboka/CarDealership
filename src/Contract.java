import java.util.Random;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean financingOption;

    public SalesContract(String date, String customerName, String customerEmail, String vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinancingOption() {
        return financingOption;
    }

    public void setFinancingOption(boolean financingOption) {
        this.financingOption = financingOption;
    }

    @Override
    public double getTotalPrice() {
        // Calculate the total price based on the sales contract specific rules
        double totalPrice = getVehiclePrice() + (getVehiclePrice() * salesTaxAmount) + recordingFee + processingFee;
        return totalPrice;
    }

    private double getVehiclePrice() {
    }

    @Override
    public double getMonthlyPayment() {
        // Calculate the monthly payment based on the sales contract specific rules
        double monthlyPayment;
        if (financingOption) {
            double loanAmount = getTotalPrice();
            double interestRate;
            int loanTerm;

            if (loanAmount >= 10000) {
                interestRate = 0.0425;
                loanTerm = 48;
            } else {
                interestRate = 0.0525;
                loanTerm = 24;
            }

            monthlyPayment = calculateMonthlyPayment(loanAmount, interestRate, loanTerm);
        } else {
            monthlyPayment = 0.0;
        }

        return monthlyPayment;
    }

    private double calculateMonthlyPayment(double loanAmount, double interestRate, int loanTerm) {
        double monthlyInterestRate = interestRate / 12;
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -loanTerm));
        return monthlyPayment;
    }
}

