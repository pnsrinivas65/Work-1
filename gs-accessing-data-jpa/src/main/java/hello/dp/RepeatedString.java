package hello.dp;

public class RepeatedString {
	
	public static void main(String s[]) {
		
		RepeatedString rs = new RepeatedString();
		System.out.println(rs.getRepatedString("abaabaabaa"));
	}

	
	public int getRepatedString(String inputString) {
		
		if(inputString == null || inputString.length() ==0) {
			return 0;
		}
		int strIndex = 0;
		int count = 0;
		while(strIndex < inputString.length()) {
			count+= inputString.charAt(strIndex)=='a' ?1:0;
					//infiteString.contains(inputString.subSequence(strIndex, strIndex+1))?1:0;
			strIndex++;
		}
		
		return count;
	}
}
