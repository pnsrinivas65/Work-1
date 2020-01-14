# Loan Calculator
Loan Calculator returns the highest amount of loan a person can take for following reasons:
* help students pay for education and the associated fees
* enable financing of brand new car

Each type of loan consists of its base amount and extra cash and income multiplier.
The formula is:
`loan = (base + extra) * multiplier`

Base and extra are strictly related to loan type, whilst multiplier stays the same in Calculator.

## Problem
This list is quite fixed and each of calculation works through similar steps.
You might notice, that only base and extra components could vary, leaving income multiplier the same.

## Task
The task is to change implementation of Loan Calculator to easily include new loan strategies, leaving multiplying aspect intact.