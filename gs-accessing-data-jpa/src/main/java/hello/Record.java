package hello;

public class Record {

	public String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int score;
	
	public Record(String name, int score) {
		this.name = name;
		this.score = score;
	}

	
}
