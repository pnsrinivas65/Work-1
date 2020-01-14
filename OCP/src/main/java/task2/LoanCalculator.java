package task2;

final class LoanCalculator {

    int getStudentLoan(int age, int income) {
        int loan = 100;

        if (age >= 21) {
            loan += 150;
        }

        return IncomeMultiplier.multiply(loan, income);
    }

    int getCarLoan(int age, int income) {
        int loan = 2_000;

        if (age > 50) {
            loan += 1_500;
        } else if (age > 30) {
            loan += 1_000;
        }

        return IncomeMultiplier.multiply(loan, income);
    }

    int getHouseLoan(int age, int income) {
        int loan = 100_000;

        if (age > 30 && income > loan / 2) {
            loan *= 2;
        }

        return IncomeMultiplier.multiply(loan, income);
    }
}
