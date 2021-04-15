public class Debt extends Activa_Passiva {

    private double interestRate;
    private double yearEndBalance;

    public Debt(String nameCreditor, double debt, double interestRate)
    {
        setName(nameCreditor);
        addAmount(debt);
        this.interestRate = interestRate;
    }

    public double getYearEndBalance()
    {
        yearEndBalance = getBalance() * (1 + (interestRate / 100));
        return -yearEndBalance;
    }
}
