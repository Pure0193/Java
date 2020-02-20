public class AirQualityProfile {
	private String datetime,location;
	private int aqi,pm25;
	private double temp;
	
	public AirQualityProfile(String dt,String loc,int aqi,int pm25,double temp) {
		datetime = dt;
		location = loc;
		this.aqi = aqi;
		this.pm25 = pm25;
		this.temp = temp;
	}
	
	public void setdate(String x) {
		datetime=x;
	}
	
	public void setloc(String x) {
		location=x;
	}
	
	public void setAQI(int x) {
		aqi=x;
	}
	
	public void setpm25(int x) {
		pm25=x;
	}
	
	public void settemp(double x) {
		temp=x;
	}
	
	public String getdate() {
		return datetime;
	}
	
	public String getloc() {
		return location;
	}
	
	public int getAQI() {
		return aqi;
	}
	
	public int getpm25() {
		return pm25;
	}
	
	public double gettemp() {
		return temp;
	}
	
	public void printAirQualityInfo() {
		System.out.println(location + " at " + datetime);
		System.out.printf("AQI: %d, PM2.5: %d microgram/m3\n",aqi,pm25);
		System.out.printf("Temperature: %.2f Celsius\n",temp);
		System.out.println("----------------------------------------------");
	}
}