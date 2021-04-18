import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTest {

    /**
     * Asserts whether 2 fixed assets has been added to an empty arraylist
     */
    @Test
    void shouldAddFixedAssetTest()
    {
    Balance balance = new Balance();
    balance.addFixedAsset("kantoor", 50000,10000,2.5);
    balance.addFixedAsset("machine",4000, 500, 10);
        //Assertions.assertTrue(!balance.consistsOf.isEmpty());
        Assertions.assertEquals(2, balance.consistsOf.size());
    }

    /** Asserts whether year end balance is calculated correctly */
   @Test
   void yearEndBalanceReceivableTest()
   {
       Receivables receivable = new Receivables("Piet",1000,5,"01-01");
       Assertions.assertEquals(1050, receivable.getYearEndBalance(), 1.0 / 365 * 5 / 100 * 5000);
   }

   /** Asserts whether year end balance total is according  to expected */
   @Test
    void yearEndBalanceTotalTest()
   {
       Balance balance = new Balance();
       balance.startingCashPosition(10000);
       balance.addReceivable("Piet", 5000,5, "01-07");
       Assertions.assertEquals(10125, balance.balanceTotal(), 1.0 / 365 * 5 / 100 * 5000);

   }


}