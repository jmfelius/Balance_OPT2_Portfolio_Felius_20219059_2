import java.util.ArrayList;

public class Balance {

    /**
     * declaration of cash position: all mutations of Activa_Passiva have
     * corresponding mirror mutations of cash position
     */
    private double cashPosition;
    private double startingCashPosition;
    /**
     * an array list is declared
     */
    public ArrayList<Activa_Passiva> consistsOf;

    /**
     * an arayList consistsOf is constructed
     */
    public  Balance() {
     this.consistsOf = new ArrayList<>();
    }

    /** initialize starting cash position */

    public void startingCashPosition (double cashPosition)
    {
        this.cashPosition = cashPosition;
        this.startingCashPosition = cashPosition;
    }

    /**
     * add a fixed asset of class FixedAssets with parameters to arraylist consistsOf
     * @param assetName name of fixed asset
     * @param assetPurchaseValue purchase price
     * @param remainingValue remaining value after economic lifetime
     * @param depreciationRate depreciation rate with purchase price minus remaining value as basis
     */
    public void addFixedAsset(String assetName, double assetPurchaseValue, double remainingValue,
                                     double depreciationRate) {
        // adds new fixed asset object to array list
        this.consistsOf.add(new FixedAssets(assetName, assetPurchaseValue, remainingValue, depreciationRate));
        cashPosition -= assetPurchaseValue;
    }

    /**
     * add a debtor of class Receivable with parameters to arraylist consistsOf
     * @param nameDebtor
     * @param receivable
     * @param interestRate
     * cash position is reduced with amount of receivable
     */
    public void addReceivable(String nameDebtor, double receivable, double interestRate,String date) {
        // adds new receivable object to list
        this.consistsOf.add(new Receivables(nameDebtor, receivable, interestRate, date));
        cashPosition -= receivable;
    }

    /**
     * add a creditor of class Debt with parameters to arraylist consistsOf
     * @param nameCreditor
     * @param debt
     * @param interestRate
     * cash position is increased with amount of added debt
     */
    public void addDebt(String nameCreditor, double debt, double interestRate, String date) {
        // adds new debt (creditor object to list)
        this.consistsOf.add(new Debt(nameCreditor, debt, interestRate,date));
        cashPosition += debt;
    }

    /**
     * make a provision for a specific debtor
     * @param provisionName
     */
    public void addProvision(String provisionName) {
        // adds new debt (creditor object to list
        this.consistsOf.add(new Provisions(provisionName));
    }

    /**
     * add an amount to a specific activum or passivum
     * @param name
     * @param amount
     */
    public void addAmount(String name, double amount, String date) {
        for (Activa_Passiva activum_passivum : consistsOf) {
            if (name.equals(activum_passivum.getName())) {
                activum_passivum.addAmount(amount, date);
                if ("class Debt".equals(activum_passivum.getClass().toString()))
                {
                    cashPosition += amount;
                }
                else if ("class Receivables".equals(activum_passivum.getClass().toString()))
                {
                    cashPosition -= amount;
                }
            }
        }
    }

    /**
     * subtract a specific amount from a specific activum/passivum
     * @param name
     * @param amount
     */
    public void subtractAmount(String name, double amount, String date)
    {
        for (Activa_Passiva activum_passivum : consistsOf) {
            if (name.equals(activum_passivum.getName())) {
                activum_passivum.subtractAmount(amount, date);

                if ("class Debt".equals(activum_passivum.getClass().toString()))
                {
                    cashPosition -= amount;
                }
                else if ("class Receivables".equals(activum_passivum.getClass().toString()))
                {
                    cashPosition += amount;
                }
            }
        }
    }

    /**
     * declares and initializes net balance total of all assets and liabilities at year end,
     * including cash position at year end.
     * @return balance total
     */
    public double balanceTotal()
    {
            double balanceTotal = cashPosition;
            for (Activa_Passiva activa_passiva : consistsOf)
            {
                balanceTotal += activa_passiva.getYearEndBalance();
            }
            return balanceTotal;
    }

    public double yearEndResult()
    {
        return  balanceTotal() - startingCashPosition;
    }

    public double getCashPosition()
    {
        return cashPosition;
    }

}