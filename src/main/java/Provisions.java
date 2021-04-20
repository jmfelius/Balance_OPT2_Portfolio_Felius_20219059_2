public class Provisions extends Activa_Passiva
{
    public Provisions (String badDebtorName)
    {
        setName(badDebtorName);
    }

    @Override
    public double getYearEndBalance()
    {
        return - getBalance();
    }
}
