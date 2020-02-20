public class AirQualityTesterChallenge {
	public static void main(String[] args) {
		AirQualityProfileChallenge obj1 = new AirQualityProfileChallenge("Mahidol University International College", 164, 80, 33);
		AirQualityProfileChallenge obj2 = new AirQualityProfileChallenge("Bangkok", 155, 63, 34);
		obj1.printAirQualityInfo();
		obj2.printAirQualityInfo();
		System.out.println("Total Profiles : " + AirQualityProfileChallenge.count);
	}
}