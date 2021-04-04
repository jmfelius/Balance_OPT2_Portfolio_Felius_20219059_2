public class FixedAssets extends Activa_Passiva
{
    /**
     declaration of instance varibles
     */
    private String asset;
    private double depreciationRate;
    private double remainingValue;
    private double assetPurchaseValue;
    private double value;
    private double yearEndBalance;
    /**
     Constructs an object FixedAssets with initializing of parameters.
     */
    public FixedAssets (String assetName, double assetPurchaseValue, double remainingValue, double depreciationRate)
    {
        this.asset = assetName;
        this.assetPurchaseValue = assetPurchaseValue;
        this.remainingValue = remainingValue;
        this.depreciationRate = depreciationRate;
        value = assetPurchaseValue;
    }

    @Override
    public String getName() {
        return asset;
    }

    /**
     processes based on parameters the year end value of the FixedAsset object
     */
    public double getYearEndBalance()
    {
        yearEndBalance = value - ( assetPurchaseValue - remainingValue) * depreciationRate / 100;
        return yearEndBalance; //sets starting value for next years calculations
    }

    public double getBalance()
    {
        return value;
    }
}
