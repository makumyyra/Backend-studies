package S2024.homework.model;

public class Message {

	private String content;
	private String name;
	private int age;

	public Message(String content) {
		super();
		this.content = content;
	}
	
	public Message (String name, int age) {
		this.name = name;
		this.age = age;
	}





	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
}
