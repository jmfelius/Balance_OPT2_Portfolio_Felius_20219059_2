/**
 * This class executes the balance program and its methods
 * @author Johan Felius HHS 20219059
 */

public class Main {

    public static void main(String[] args) {

    /**constructs a new object balance entailing various methods to compile an array Activa_Passiva */
        Balance balance = new Balance();

        balance.startingCashPosition(100000.00);
        balance.addFixedAsset("kantoor", 50000, 10000, 2.5);
        balance.addDebt("jansen", 5000,5);
        balance.addReceivable("peters", 4000,4);
        balance.addAmount("jansen", 1700);
        balance.addAmount("peters", 20000);
        balance.subtractAmount("peters", 1700);
        balance.addProvision("provisionPeters");
        balance.addAmount("provisionPeters", 1400);

    /** print of assets/liabilities and their year-end values after year-end processing */
        for (Activa_Passiva activa_passiva : balance.consistsOf ) {
            System.out.printf("%15s : %10.2f\n", activa_passiva.getName(), activa_passiva.getYearEndBalance());
         }
    /** print the total balance of all year-end assets and liabilities */
        System.out.printf("The year-end balance total is: %10.2f\n", balance.balanceTotal());


        /** print the year end result */
        System.out.printf("The year end result is %.2f and the remaining cash is %.2f\n", balance.yearEndResult(), balance.getCashPosition());
    }
}
