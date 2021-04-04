import java.util.ArrayList;

public class Balance {

    /**
     * an array list is declared
     */
    public ArrayList<Activa_Passiva> consistsOf;

    /**
     * an arayList consistsOf is constructed
     */
    public Balance() {
        this.consistsOf = new ArrayList<Activa_Passiva>();
    }

    /**
     * add a fixed asset of class FixedAssets with parameters to arraylist consistsOf
     * @param assetName name of fixed asset
     * @param assetPurchaseValue purchase price
     * @param remainingValue remaining value after economic lifetime
     * @param depreciationRate
     */
    public void addFixedAsset(String assetName, double assetPurchaseValue, double remainingValue,
                              double depreciationRate) {
        // adds new fixed asset object to array list
        this.consistsOf.add(new FixedAssets(assetName, assetPurchaseValue, remainingValue, depreciationRate));

    }

    /**
     * add a debtor of class Receivable with parameters to arraylist consistsOf
     * @param nameDebtor
     * @param receivable
     * @param interestRate
     */
    public void addReceivale(String nameDebtor, double receivable, double interestRate) {
        // adds new receivable object to list
        this.consistsOf.add(new Receivables(nameDebtor, receivable, interestRate));
    }

    /**
     * add a creditor of class Debt with parameters to arraylist consistsOf
     * @param nameCreditor
     * @param debt
     * @param interestRate
     */
    public void addDebt(String nameCreditor, double debt, double interestRate) {
        // adds new debt (creditor object to list
        this.consistsOf.add(new Debt(nameCreditor, debt, interestRate));
    }

    public void addProvision(String provisionName) {
        // adds new debt (creditor object to list
        this.consistsOf.add(new Provisions(provisionName));
    }

    public void addAmount(String name, double amount) {
        for (Activa_Passiva activum_passivum : consistsOf) {
            if (name.equals(activum_passivum.getName())) {
                activum_passivum.addAmount(amount);
            }
        }
    }

    public void subtractAmount(String name, double amount)
    {
        for (Activa_Passiva activum_passivum : consistsOf) {
            if (name.equals(activum_passivum.getName())) {
                activum_passivum.subtractAmount(amount);
            }
        }
    }

    public double balanceTotal ()
    {
            double balanceTotal = 0;
            for (Activa_Passiva activa_passiva : consistsOf)
            {
                balanceTotal += activa_passiva.getYearEndBalance();
            }
            return balanceTotal;
    }

}