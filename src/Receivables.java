public class Receivables extends Activa_Passiva
{
    private double interestRate;
    private double yearEndBalance;

    public Receivables (String nameDebtor, double receivable, double interestRate)
    {
    setName(nameDebtor);
    this.interestRate = interestRate;
    addAmount(receivable);
    }

    public double getYearEndBalance()
    {
        yearEndBalance = super.getBalance()  * (1.0 + interestRate /100);
        return yearEndBalance;
    }




}
