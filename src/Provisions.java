public class Provisions extends Activa_Passiva
{
    private String BadDebtorName;
    private double provisionValue;

    public Provisions ( String debtorName)
    {
        this.BadDebtorName = debtorName;
    }

    public double getBalance()
    {
                return  provisionValue;
    }

    public void addAmount(double amount)
    {
                provisionValue += amount;
    }

    @Override
    public void subtractAmount(double amount) {
        provisionValue += amount;
    }

    @Override
    public String getName()
    {
        return BadDebtorName;
    }

    @Override
    public double getYearEndBalance()
    {
        return - provisionValue;
    }
}
