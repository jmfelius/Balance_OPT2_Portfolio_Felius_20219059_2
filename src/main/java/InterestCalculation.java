import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public interface InterestCalculation
{
    double iets = 245;

     default long getDifferenceDays(String date0, String date) {

         /**
          * Determining days in between mutations of amounts;
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

    /**
     * calculation of interest taking into account start date of receivable/debt, dates of additions
     * and/or subtractions and year end date
     * @param interestRate
     * @param addAmount
     * @param date
     * @param date0
     * @param getName
     * @param getBalance
     * @return
     */
    default double interestCalculation(double interestRate, double addAmount, String date, String date0, String getName, double getBalance)
    {
        double accInterest = 0;
        double interest = (getBalance - addAmount) * (double)(getDifferenceDays(date0, date)) / 365 * interestRate/100;
        accInterest += interest;

        return accInterest;
    }
}
