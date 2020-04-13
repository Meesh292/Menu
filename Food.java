package Entity;

	public class Food {
		private int id;
		private String foodName;
		private String category;
		private double price;
		
		
		public Food(int id, String foodName, String category, double price) {
			this.id = id;
			this.foodName = foodName;
			this.category = category;
			this.price = price;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getFoodName() {
			return foodName;
		}


		public void setFoodName(String foodName) {
			this.foodName = foodName;
		}


		public String getCategory() {
			return category;
		}


		public void setCategory(String category) {
			this.category = category;
		}


		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}
		
}
