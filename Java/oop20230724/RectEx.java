package oop20230724;

public class RectEx {
	
	int width;
	int height;
	
	public int round(int width, int height) {
		this.width = width;
		this.height = height;
		return 2*(width+height);
	}
	
	public int area(int width, int height) {
		this.width = width;
		this.height = height;
		return width*height;
	}

}






