package hello;

import java.math.BigInteger;
import java.math.BigDecimal;

class MyClass {

    void bigIntegerChecker() {
        BigInteger aBigInteger = BigInteger.valueOf(100L);
        BigInteger anotherBigInteger = BigInteger.valueOf(200L);

        BigInteger bigInteger = aBigInteger.add(anotherBigInteger);// Noncompliant
        BigInteger bigInteger15 = aBigInteger.add(anotherBigInteger);// Noncompliant
        BigInteger bigInteger1 = bigInteger.subtract(anotherBigInteger);// Noncompliant
        BigInteger bigInteger2 = bigInteger1.multiply(anotherBigInteger);// Noncompliant
        BigInteger bigInteger3 = bigInteger2.divide(anotherBigInteger);// Noncompliant
        BigInteger bigInteger4 = bigInteger3.remainder(anotherBigInteger);// Noncompliant
        BigInteger bigInteger5 = bigInteger4.max(anotherBigInteger);// Noncompliant
        BigInteger bigInteger6 = bigInteger5.min(anotherBigInteger);// Noncompliant
        BigInteger bigInteger7 = bigInteger6.and(anotherBigInteger);// Noncompliant
        BigInteger bigInteger8 = bigInteger7.andNot(anotherBigInteger);// Noncompliant
        BigInteger bigInteger9 = bigInteger8.or(anotherBigInteger);// Noncompliant
        BigInteger bigInteger10 = bigInteger9.xor(anotherBigInteger);// Noncompliant
        BigInteger bigInteger11 = aBigInteger.mod(anotherBigInteger);// Noncompliant
        BigInteger bigInteger12 = bigInteger11.modPow(anotherBigInteger, BigInteger.TEN);// Noncompliant
        BigInteger bigInteger13 = bigInteger12.modInverse(anotherBigInteger);// Noncompliant
        BigInteger bigInteger14 = bigInteger13.gcd(anotherBigInteger);// Noncompliant
        BigInteger[] bigIntegers = bigInteger4.divideAndRemainder(anotherBigInteger);// Noncompliant
        int compareTo = bigInteger10.compareTo(anotherBigInteger);// Noncompliant
        boolean equals = bigInteger14.equals(anotherBigInteger);// Noncompliant

        BigInteger pow = aBigInteger.pow(1);
    }

    void bigDecimalChecker() {
        BigDecimal aBigDecimal = BigDecimal.valueOf(100.0);
        BigDecimal anotherBigDecimal = BigDecimal.valueOf(200.0);

        BigDecimal bigDecimal = aBigDecimal.add(anotherBigDecimal);// Noncompliant
        BigDecimal bigDecimal1 = bigDecimal.subtract(anotherBigDecimal);// Noncompliant
        BigDecimal bigDecimal2 = bigDecimal1.multiply(anotherBigDecimal);// Noncompliant
        BigDecimal bigDecimal3 = bigDecimal2.divide(anotherBigDecimal);// Noncompliant
        BigDecimal bigDecimal4 = bigDecimal3.divideToIntegralValue(anotherBigDecimal);// Noncompliant
        BigDecimal bigDecimal5 = bigDecimal4.divideToIntegralValue(anotherBigDecimal, null);// Noncompliant
        BigDecimal bigDecimal6 = bigDecimal5.remainder(anotherBigDecimal);// Noncompliant
        BigDecimal bigDecimal7 = bigDecimal6.pow(1);
        BigDecimal bigDecimal8 = bigDecimal7.pow(1, null);// Noncompliant
        BigDecimal bigDecimal9 = bigDecimal8.setScale(1, 1);
        BigDecimal bigDecimal10 = bigDecimal9.setScale(1);
        BigDecimal bigDecimal11 = bigDecimal10.setScale(1, null);// Noncompliant
        System.out.println("Here 1");
        BigDecimal sequenceNumber = BigDecimal.valueOf(100.0);
        BigDecimal bigDecimal22 = sequenceNumber.add(BigDecimal.ONE);
        System.out.println("Here 2");
        BigDecimal bigDecimal12 = bigDecimal11.abs();
        BigDecimal bigDecimal13 = bigDecimal12.abs(null);// Noncompliant
        BigDecimal bigDecimal14 = bigDecimal13.negate();
        BigDecimal bigDecimal15 = bigDecimal14.negate(null);// Noncompliant
        BigDecimal bigDecimal16 = bigDecimal15.plus();
        BigDecimal bigDecimal17 = bigDecimal16.plus(null);// Noncompliant
        BigDecimal bigDecimal18 = bigDecimal17.round(null);// Noncompliant
        BigDecimal bigDecimal19 = bigDecimal18.max(anotherBigDecimal);// Noncompliant
        BigDecimal bigDecimal20 = bigDecimal19.min(anotherBigDecimal);// Noncompliant
        BigDecimal[] bigDecimals = bigDecimal20.divideAndRemainder(anotherBigDecimal);// Noncompliant
        int compareTo = aBigDecimal.compareTo(anotherBigDecimal);// Noncompliant
        boolean equals = aBigDecimal.equals(anotherBigDecimal);// Noncompliant
    }
}

