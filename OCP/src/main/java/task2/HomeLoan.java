package task2;

public class HomeLoan extends Loan{
	
  private static final int LOAN_MULTIPLIER_100_000 = 100_000;

public int getLoan(int age,int income){
	  int loan = LOAN_MULTIPLIER_100_000;

      if (age > 30 && income > loan / 2) {
          loan *= 2;
      }

      return IncomeMultiplier.multiply(loan, income);
  }
}
