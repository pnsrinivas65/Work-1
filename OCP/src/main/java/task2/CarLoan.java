package task2;

public class CarLoan extends Loan{
	
  private static final int LOAN_MULTIPLIER_2_000 = 2_000;

public int getLoan(int age,int income){
	  int loan = LOAN_MULTIPLIER_2_000;

      if (age > 50) {
          loan += 1_500;
      } else if (age > 30) {
          loan += 1_000;
      }
      return IncomeMultiplier.multiply(loan, income);
  }
}
