package com.hyon.aug252.main;

public class FranchiseHyon {
      
	  private String franchiseRestaurantLocation;
      private String branchOwnerName;
      private int seatingCapacity;
      
      
	 public FranchiseHyon() {
		super();
	  }


	public FranchiseHyon(String franchiseRestaurantLocation, String branchOwnerName, int seatingCapacity) {
		super();
		this.franchiseRestaurantLocation = franchiseRestaurantLocation;
		this.branchOwnerName = branchOwnerName;
		this.seatingCapacity = seatingCapacity;
	}


	public String getFranchiseRestaurantLocation() {
		return franchiseRestaurantLocation;
	}


	public void setFranchiseRestaurantLocation(String franchiseRestaurantLocation) {
		this.franchiseRestaurantLocation = franchiseRestaurantLocation;
	}


	public String getBranchOwnerName() {
		return branchOwnerName;
	}


	public void setBranchOwnerName(String branchOwnerName) {
		this.branchOwnerName = branchOwnerName;
	}


	public int getSeatingCapacity() {
		return seatingCapacity;
	}


	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}


	@Override
	public String toString() {
		return "FranchiseHyon [franchiseRestaurantLocation=" + franchiseRestaurantLocation + ", branchOwnerName="
				+ branchOwnerName + ", seatingCapacity=" + seatingCapacity + "]";
	}

      
	
      
      
}
