import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public interface InterestCalculation
{
     default long getDifferenceDays(String date0, String date) {

         /**
          * Source for count days: https://stackoverflow.com/questions/20165564/calculating-days-between-two-dates-with-java
          * various contributors
          */
         SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM");

         long days = 0;

         try {
             Date d1 = myFormat.parse(date0);
             Date d2 = myFormat.parse(date);

             long diff = d2.getTime() - d1.getTime();
             days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
         } catch (ParseException e) {
             e.printStackTrace();
         }

         return days;
     }

    default double interestCalculation(double interestRate, double addAmount, String date, String date0, String getName, double getBalance)
    {
        double accInterest = 0;
        double interest = (getBalance - addAmount) * (double)(getDifferenceDays(date0, date)) / 365 * interestRate/100;
        System.out.printf("a. Delta dagen: %d, (date0 = %s; date = %s)\n", (getDifferenceDays(date0, date)), date0, date);
        System.out.printf("b. getname %s, getbalance %f, addAmount %f, interest %f\n", getName, getBalance,addAmount, interest);
        accInterest += interest;
        System.out.printf("c. getbalance %f, addAmount %f, accInterest %f\n", getBalance,addAmount,accInterest);
        //date0 = date;
        return accInterest;
    }


}
