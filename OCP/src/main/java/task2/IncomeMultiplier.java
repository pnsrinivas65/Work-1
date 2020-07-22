package task2;

final class IncomeMultiplier {

	private static final int LOAN_MUTIPLIER_1000 = 1_000;
    static int multiply(int loan, int income) {
        return loan * getIncomeMultiplier(income);
    }

    private static int getIncomeMultiplier(int income) {
		return income <= LOAN_MUTIPLIER_1000 ? 1 : 2;
    }
}
