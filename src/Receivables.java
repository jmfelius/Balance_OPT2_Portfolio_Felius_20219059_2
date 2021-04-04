public class Receivables extends Activa_Passiva
{
    private String nameDebtor;
    private double interestRate;
    private double receivable;
    private double yearEndBalance;

    public Receivables (String nameDebtor, double receivable, double interestRate)
    {
    this.nameDebtor = nameDebtor;
    this.interestRate = interestRate;
    this. receivable = receivable;
    //System.out.println(receivable); //om te kijken wat de waarde is
    }

    public double getYearEndBalance()
    {
        yearEndBalance = getBalance()  * (1.0 + interestRate /100);
        return yearEndBalance;
    }

    public double getBalance()
    {

        return receivable;
    }

    public String getName() {
        return nameDebtor;
    }

    //@Override
    public void addAmount(double amount) {
       // super.addAmount(amount);
        receivable += amount;
    }

    @Override
    public void subtractAmount(double amount) {
        //super.subtractAmount(amount);
        receivable -= amount;
    }
}
