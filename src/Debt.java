public class Debt extends Activa_Passiva implements InterestCalculation
{

    private double interestRate;
    private double yearEndBalance;
    private double accInterest;
    private String date0 = "01-01";

    public Debt(String nameCreditor, double debt, double interestRate, String date)
    {
        super(); //roept constructor aan uit klasse Activa_Passiva, maar daar staat niks in, dus in casu geen funct        setName(nameCreditor);
        setName(nameCreditor);
        this.interestRate = interestRate;
        addAmount(debt, date);
       super.date = date;
        System.out.println("6. In de constructor van Debt date = "  + date );
    }

    public double getYearEndBalance()
    {
        yearEndBalance = super.getBalance() + accInterest
                + interestCalculation(interestRate, 0, "31-12", date0, super.getName(), super.getBalance());
        return -yearEndBalance;
    }

    public void addAmount(double amount, String date)
    {
        super.addAmount(amount, date);

        accInterest = interestCalculation(interestRate, amount, date, date0, super.getName(), super.getBalance());
        date0 = date;
    }
}
