public class Debt extends Activa_Passiva implements InterestCalculation
{
    private double yearEndBalance;

    public Debt(String nameCreditor, double debt, double interestRate, String date)
    {
        super(); //roept constructor aan uit klasse Activa_Passiva, maar daar staat niks in, dus in casu geen funct        setName(nameCreditor);
        setName(nameCreditor);
        super.interestRate = interestRate;
        addAmount(debt, date);
        super.date = date;
    }

    public double getYearEndBalance()
    {
        yearEndBalance = super.getBalance() + super.accumulatedInterest + interestCalculation(interestRate, 0, "31-12", date0, super.getName(), super.getBalance());
        //interestCalculation method is required to calculate accrued interest from last mutation date of receivable/debt to year end 31-12

        return -yearEndBalance;
    }

    public void addAmount(double amount, String date)
    {
        super.addAmount(amount, date);
        super.accumulatedInterest = interestCalculation(interestRate, amount, date, date0, super.getName(), super.getBalance());
        date0 = date;
    }

    public void subtractAmount(double amount, String date)
    {
        super.subtractAmount(amount, date);
        super.accumulatedInterest = interestCalculation(interestRate, -amount, date, date0, super.getName(), super.getBalance());
        date0 = date;
    }
}
