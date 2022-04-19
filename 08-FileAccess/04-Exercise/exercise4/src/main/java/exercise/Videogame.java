package exercise;

import java.time.LocalDate;

public class Videogame {
	private String title;
	private int year;
	private String manufacturer;

	LocalDate currentdate = LocalDate.now();

	public Videogame() {

	}

	public Videogame(String title, int year, String manufacturer) {
		setTitle(title);
		setYear(year);
		setManufacturer(manufacturer);
	}

	public void setTitle(String title) {
		this.title = title.toUpperCase();
	}

	public void setYear(int year) {
		if (year < 1950) {
			this.year = currentdate.getYear();
		} else {
			this.year = year;
		}
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer.toUpperCase();
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String getManufacturer() {
		return manufacturer;
	}

}