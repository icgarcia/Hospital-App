package sample;

public class ModelTable {
	String date, time, description, notes;
	
	public ModelTable(String date, String time, String description, String notes) {
		this.date = date;
		this.time = time;
		this.description = description;
		this.notes = notes;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
