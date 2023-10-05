package com.hyon.oct053.unit;

public class ConvertResult {
	private double beforeNum;
	private double convertedNum;
	private String beforeUnit;
	private String convertedUnit;
	
	public ConvertResult() {
		// TODO Auto-generated constructor stub
	}

	public ConvertResult(double beforeNum, double convertedNum, String beforeUnit, String convertedUnit) {
		super();
		this.beforeNum = beforeNum;
		this.convertedNum = convertedNum;
		this.beforeUnit = beforeUnit;
		this.convertedUnit = convertedUnit;
	}

	public double getBeforeNum() {
		return beforeNum;
	}

	public void setBeforeNum(double beforeNum) {
		this.beforeNum = beforeNum;
	}

	public double getConvertedNum() {
		return convertedNum;
	}

	public void setConvertedNum(double convertedNum) {
		this.convertedNum = convertedNum;
	}

	public String getBeforeUnit() {
		return beforeUnit;
	}

	public void setBeforeUnit(String beforeUnit) {
		this.beforeUnit = beforeUnit;
	}

	public String getConvertedUnit() {
		return convertedUnit;
	}

	public void setConvertedUnit(String convertedUnit) {
		this.convertedUnit = convertedUnit;
	}

	
}
