public class Receivables extends Activa_Passiva implements InterestCalculation
{

    private double interestRate;
    private double yearEndBalance;
    private double accInterest;
    private String date0 = "01-01";

    public Receivables (String nameDebtor, double receivable, double interestRate, String date) {
        super(); //roept constructor aan uit klasse Activa_Passiva, maar daar staat niks in, dus in casu geen functie
        setName(nameDebtor);
        this.interestRate = interestRate;
        addAmount(receivable, date);
        super.date = date;
        System.out.println("0. In de constructor van Receivables date = "  + date );
    }


   public double getYearEndBalance()
    {
        yearEndBalance = super.getBalance() + accInterest
                + interestCalculation(interestRate, 0, "31-12", date0, super.getName(), super.getBalance());
        System.out.println(getName() + " yearEndBalance: " + yearEndBalance);
        return yearEndBalance;
    }


    public void addAmount(double amount, String date)
    {
        super.addAmount(amount, date);

        accInterest = interestCalculation(interestRate,amount,date, date0, super.getName(), super.getBalance() );
        System.out.println("1. In klasse Receivables acc interest: " + accInterest);
        System.out.println("2. In klasse receivables date0: " + date0);
        System.out.println("3. In klasse receivables date: " + date);
        date0 = date;
        System.out.println("4. In klasse receivables date0 na date0 = date: " + date0);
    }

    public void subtractAmount(double amount, String date)
    {
        super.subtractAmount(amount, date);

        accInterest = interestCalculation(interestRate,-amount,date, date0, super.getName(), super.getBalance() );
        System.out.println("1. In klasse Receivables acc interest: " + accInterest);
        System.out.println("2. In klasse receivables date0: " + date0);
        System.out.println("3. In klasse receivables date: " + date);
        date0 = date;
        System.out.println("4. In klasse receivables date0 na date0 = date: " + date0);
    }


}
