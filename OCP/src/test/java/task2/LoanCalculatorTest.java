package task2;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LoanCalculatorTest {

    private LoanCalculator calculator = new LoanCalculator();

    @Test
    public void studentLoanForYoungPoorPerson() {
        assertThat(calculator.getStudentLoan(18, 100), is(100));
    }

    @Test
    public void studentLoanForOldPerson() {
        assertThat(calculator.getStudentLoan(21, 100), is(250));
    }

    @Test
    public void studentLoanForRichPerson() {
        assertThat(calculator.getStudentLoan(18, 2_000), is(200));
    }

    @Test
    public void carLoanForYoungPoorPerson() {
        assertThat(calculator.getCarLoan(20, 500), is(2_000));
    }

    @Test
    public void carLoanForAdultPoorPerson() {
        assertThat(calculator.getCarLoan(45, 500), is(3_000));
    }

    @Test
    public void carLoanForOldPoorPerson() {
        assertThat(calculator.getCarLoan(60, 500), is(3_500));
    }

    @Test
    public void carLoanForYoungRichPerson() {
        assertThat(calculator.getCarLoan(20, 2_000), is(4_000));
    }

    @Test
    public void carLoanForAdultRichPerson() {
        assertThat(calculator.getCarLoan(45, 2_000), is(6_000));
    }

    @Test
    public void carLoanForOldRichPerson() {
        assertThat(calculator.getCarLoan(60, 2_000), is(7_000));
    }

    @Test
    public void houseLoanForYoungPoorPerson() {
        assertThat(calculator.getHouseLoan(20, 500), is(100_000));
    }

    @Test
    public void houseLoanForOldPoorPerson() {
        assertThat(calculator.getHouseLoan(60, 500), is(100_000));
    }

    @Test
    public void houseLoanForYoungRichPerson() {
        assertThat(calculator.getHouseLoan(20, 65_000), is(200_000));
    }

    @Test
    public void houseLoanForOldRichPerson() {
        assertThat(calculator.getHouseLoan(60, 65_000), is(400_000));
    }
}
