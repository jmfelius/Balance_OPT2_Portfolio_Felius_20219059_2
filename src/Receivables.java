public class Receivables extends Activa_Passiva implements InterestCalculation
{
    private double interestRate;
    private double yearEndBalance;

    public Receivables (String nameDebtor, double receivable, double interestRate)
    {
    super(); //roept constructor aan uit klasse Activa_Passiva, maar daar staat niks in, dus in casu geen functie
    setName(nameDebtor);
    this.interestRate = interestRate;
    addAmount(receivable);
    }

   public double getYearEndBalance()
    {
        yearEndBalance = super.getBalance() * (interestCalculation(interestRate)) * 10/12;
        return yearEndBalance;
    }




}
