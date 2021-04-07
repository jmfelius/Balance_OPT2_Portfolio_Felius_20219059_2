import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTest {


    @Test
    void shouldAddFixedAssetTest()
    {
    Balance balance = new Balance();
    balance.addFixedAsset("kantoor", 50000,10000,2.5);
    balance.addFixedAsset("machine",4000, 500, 10);
        //Assertions.assertTrue(!balance.consistsOf.isEmpty());
        Assertions.assertEquals(2, balance.consistsOf.size());

    }


}