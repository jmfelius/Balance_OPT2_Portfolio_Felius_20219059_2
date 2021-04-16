import org.w3c.dom.ls.LSOutput;

public abstract class Activa_Passiva
{
    protected String activum_PassivumName;
    protected double amount;

    public Activa_Passiva()
    {
    }

    public void addAmount(double amount)
    {
        this.amount += amount;
    }

    public void subtractAmount (double amount)
    {
        this.amount -= amount;
    }

    public  void setName(String activum_PassivumName)
    {
        this.activum_PassivumName = activum_PassivumName;
    }

    public String getName()
    {
        return activum_PassivumName;
    }

    public abstract double getYearEndBalance();


    public  double getBalance()
    {
        return amount;
    }
}
