package models;

public class Plants {
	private String code;
	private String name;
	private String description;

	public Plants() {
	}

	public Plants(String code, String name, String description) {
		this.code = code;
		this.name = name;
		this.description = description;
	}

	public String flowerColor(String color) {
		return "";
	}

	@Override
	public String toString() {
		return "Plants [code=" + code + ", name=" + name + ", description=" + description + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
