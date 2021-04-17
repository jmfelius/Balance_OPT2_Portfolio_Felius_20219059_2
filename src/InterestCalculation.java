public interface InterestCalculation
{

    default double interestCalculation(double interestRate)
    {
         return 1 + interestRate / 100;
    }
}
