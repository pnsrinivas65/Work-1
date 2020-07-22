package task;

public abstract class Record {

	private String id;
	private String format;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public abstract String format();

}
