/**
 * OPT2 Portfolio opdracht (herkansing) SE HHS april 2021
 * This class executes the balance program and its methods
 * @author Johan Felius HHS 20219059
 */

public class Main {

    public static void main(String[] args) {

    /* constructs a new object balance_2020 entailing various methods to compile an array Activa_Passiva */
        Balance balance_2020 = new Balance();

        /* zomaar wat input */
        balance_2020.startingCashPosition(100000);
        balance_2020.addFixedAsset("kantoor", 50000, 10000, 2.5);
        balance_2020.addDebt("jansen", 3000,5,"02-01");
        balance_2020.addReceivable("peters", 1000,10, "01-02");
        balance_2020.subtractAmount("peters", 500, "15-04");
        balance_2020.addAmount("jansen", 2000, "01-10" );
        balance_2020.addAmount("peters", 1000, "01-07");
        balance_2020.addAmount("peters", 2000, "01-09");
        balance_2020.addProvision("provisionPeters");
        balance_2020.addAmount("provisionPeters", 250, "12-01");

         /* print of assets/liabilities and their year-end values after year-end processing */
        for (Activa_Passiva activa_passiva : balance_2020.consistsOf )
        {
            System.out.printf("%15s : %10.2f\n", activa_passiva.getName(), activa_passiva.getYearEndBalance());
         }
         /* print the total balance_2020 of all year-end assets and liabilities */
        System.out.printf("The year-end balance_2020 total is: %10.2f\n", balance_2020.balanceTotal());

        /* print the year end result */
        System.out.printf("The year end result is %.2f and the remaining cash is %.2f\n", balance_2020.yearEndResult(), balance_2020.getCashPosition());
    }
}
