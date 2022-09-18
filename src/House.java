import java.util.ArrayList;

public class House implements Comparable<House>{
	private int id;
	private int duration;
	private double rating;
	private static ArrayList<House> houseList = new ArrayList<House>();
	public House(int id ,int duration, double rating){
		this.id = id;
		this.duration = duration;
		this.rating = rating;

	}
	public static void decrementDuration() {
		for ( House h :House.getHouseList()) {
			if (h.getDuration() >0) {
				h.setDuration(h.getDuration()-1);
			}
		}
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public int compareTo(House o) {

		if (this.id < o.getId()) {
			return -1;
		}
		else if  (this.id >o.getId()) {
			return 1;
		}


		return 0;
	}
	
	/**
	 * @return the houseList
	 */
	public static ArrayList<House> getHouseList() {
		return houseList;
	}
	/**
	 * @param houseList the houseList to set
	 */
	public static void setHouseList(ArrayList<House> houseList) {
		House.houseList = houseList;
	}


}
