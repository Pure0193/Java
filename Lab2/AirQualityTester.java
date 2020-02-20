public class AirQualityTester {
	public static void main(String[] args) {
		AirQualityProfile obj1 = new AirQualityProfile("2020-01-21 17:00", "Mahidol University International College", 164, 80, 33);
		AirQualityProfile obj2 = new AirQualityProfile("2020-01-21 17:04", "Bangkok", 155, 63, 34);
		obj1.printAirQualityInfo();
		obj2.printAirQualityInfo();
	}
}