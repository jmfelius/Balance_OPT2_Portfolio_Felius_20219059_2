public class Debt extends Activa_Passiva {

    private String nameCreditor;
    private double debt;
    private double interestRate;
    private double yearEndBalance;

    public Debt(String nameCreditor, double debt, double interestRate) {
        this.nameCreditor = nameCreditor;
        //System.out.println(nameCreditor);
        this.debt = debt;
        //System.out.println(debt); //om te kijken wat de waarde is
        this.interestRate = interestRate;
    }

    //@Override
    public void addAmount(double amount) {
        super.addAmount(amount);
        debt += amount;
    }

    @Override
    public void subtractAmount(double amount) {
        super.subtractAmount(amount);
        debt += amount;
    }
    public double getYearEndBalance()
    {
        yearEndBalance = getBalance() * (1 + (interestRate / 100));
        return -yearEndBalance;
    }

    public String getName() {
        return nameCreditor;
    }

    public double getBalance() {
        return debt;
    }
}
