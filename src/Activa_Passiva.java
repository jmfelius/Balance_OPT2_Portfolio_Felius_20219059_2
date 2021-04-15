import org.w3c.dom.ls.LSOutput;

public abstract class Activa_Passiva
{
    protected String activum_passivum;
    protected double amount;

    public Activa_Passiva()
    {
    }

    public void addAmount(double amount)
    {
        amount += amount;
    }

    public void subtractAmount (double amount)
    {
        amount -= amount;
    }

    public abstract String getName();

    public abstract double getYearEndBalance();

    public abstract double getBalance();

}
