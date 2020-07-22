package task2;

public class StudentLoan extends Loan {

	private static final int LOAN_MUTIPLIER_100 = 100;

	public int getLoan(int age, int income) {
		int loan = LOAN_MUTIPLIER_100;

		if (age >= 21) {
			loan += 150;
		}
		return IncomeMultiplier.multiply(loan, income);
	}
}
