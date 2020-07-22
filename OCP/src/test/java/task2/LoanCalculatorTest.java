package task2;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LoanCalculatorTest {

	private LoanCalculator calculator = new LoanCalculator();
	private Loan studentLoan = new StudentLoan();
	private Loan carLoan = new CarLoan();
	private Loan homeLoan = new HomeLoan();

	@Test
	public void studentLoanForYoungPoorPerson() {
		assertThat(calculator.calculator(studentLoan, 18, 100), is(100));
	}

	@Test
	public void studentLoanForOldPerson() {
		assertThat(calculator.calculator(studentLoan, 21, 100), is(250));
	}

	@Test
	public void studentLoanForRichPerson() {
		assertThat(calculator.calculator(studentLoan, 18, 2_000), is(200));
	}

	@Test
	public void carLoanForYoungPoorPerson() {
		assertThat(calculator.calculator(carLoan, 20, 500), is(2_000));
	}

	@Test
	public void carLoanForAdultPoorPerson() {
		assertThat(calculator.calculator(carLoan, 45, 500), is(3_000));
	}

	@Test
	public void carLoanForOldPoorPerson() {
		assertThat(calculator.calculator(carLoan, 60, 500), is(3_500));
	}

	@Test
	public void carLoanForYoungRichPerson() {
		assertThat(calculator.calculator(carLoan, 20, 2_000), is(4_000));
	}

	@Test
	public void carLoanForAdultRichPerson() {
		assertThat(calculator.calculator(carLoan, 45, 2_000), is(6_000));
	}

	@Test
	public void carLoanForOldRichPerson() {
		assertThat(calculator.calculator(carLoan, 60, 2_000), is(7_000));
	}

	@Test
	public void houseLoanForYoungPoorPerson() {
		assertThat(calculator.calculator(homeLoan, 20, 500), is(100_000));
	}

	@Test
	public void houseLoanForOldPoorPerson() {
		assertThat(calculator.calculator(homeLoan, 60, 500), is(100_000));
	}

	@Test
	public void houseLoanForYoungRichPerson() {
		assertThat(calculator.calculator(homeLoan, 20, 65_000), is(200_000));
	}

	@Test
	public void houseLoanForOldRichPerson() {
		assertThat(calculator.calculator(homeLoan, 60, 65_000), is(400_000));
	}
}
