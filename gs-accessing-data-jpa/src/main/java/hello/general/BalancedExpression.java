package hello.general;

import java.util.Scanner;
import java.util.Stack;

public class BalancedExpression {

	public static boolean isBalanced(String expression) {
		if ((expression.length() % 2) == 1)
			return false;
		else {
			Stack<Character> s = new Stack<>();
			for (char bracket : expression.toCharArray())
				switch (bracket) {
				case '{':
					s.push('}');
					break;
				case '(':
					s.push(')');
					break;
				case '[':
					s.push(']');
					break;
				default:
					if (s.isEmpty() || bracket != s.peek()) {
						return false;
					}
					s.pop();
				}
			return s.isEmpty();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String expression = in.nextLine();
		boolean answer = isBalanced(expression);
		if (answer) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}
}
