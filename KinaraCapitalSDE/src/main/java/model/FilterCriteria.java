package model;
public class FilterCriteria {
    private Integer id;
    private String name;
    private Integer totalMarks;
    
    // Constructors, getters, and setters
    
	public FilterCriteria(Integer id, String name, Integer totalMarks) {
		super();
		this.id = id;
		this.name = name;
		this.totalMarks = totalMarks;
	}
	public FilterCriteria() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}
	@Override
	public String toString() {
		return "FilterCriteria [id=" + id + ", name=" + name + ", totalMarks=" + totalMarks + "]";
	}

  
}
