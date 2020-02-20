
public class MyDate {
  private int year,month,day,objectNumber;
  public static int objectCounter = 0;
  public static String[] strMonths = {"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
  
  public MyDate(){
    year = 1900;
    month = 1;
    day = 1;
    objectCounter++;
    objectNumber = objectCounter;
  }
  
  public MyDate(int aYear, int aMonth, int aDay){
    year = aYear;
    month = aMonth;
    day = aDay;
    objectCounter++;
    objectNumber = objectCounter;
  }
  
  public int getObjectNumber(){
    return objectNumber;
  }
  
  public void setDate(int aYear,int aMonth, int aDay){
    year = aYear;
    month = aMonth;
    day = aDay;
  }
  
  public String toString(){
    return day + " " + strMonths[month-1] + " " + year;
  }
  
  public static boolean isLeapYear(int year){
    if(year%4!=0){
      return false;
    } else if(year%100!=0){
      return true;
    } else if(year%400!=0){
      return false;
    } else {
      return true;
    }
  }
    
  MyDate nextDay(){
	  if(month==12 && day==31) {
		  year+=1;
		  month=1;
		  day=1;
	  } else {
		  if(month==4 || month==6 || month==9 || month==11){
			  if(day==30) {
				  month+=1;
				  day=1;
			  } else {
				  day+=1;
			  }
		  } else if(month!=2) {
			  if(day==31) {
				  month+=1;
				  day=1;
			  } else {
				  day+=1;
			  }
		  } else {
			  if(isLeapYear(year)==true && day==29) {
				  month+=1;
				  day=1;
			  } else if(isLeapYear(year)==false && day ==28) {
				  month+=1;
				  day=1;
			  } else {
				  day+=1;
			  }
		  }
	  }
	  return this;
  }
  
  MyDate nextMonth() {
	  if(month==12) {
		  year+=1;
		  month=1;
	  } else if((month==3 || month==5 || month==8 || month==10) && day==31){
		  month+=1;
		  day=30;
	  } else if(month==1 && day>=28){
		  if(isLeapYear(year)==true) {
			  month+=1;
			  day=29;
		  }else {
			  month+=1;
			  day=28;
		  }
	  }else {
		  month+=1;
	  }
	  return this;
  }
  
  MyDate nextYear() {
	  if(month==2 && day==29) {
		  year+=1;
		  day=28;
	  }else {
		  year+=1;
	  }
	  return this;
  }
  
  MyDate previousDay() {
	  if(month==1 && day==1) {
		  year-=1;
		  month=12;
		  day=31;
	  } else {
		  if(month==5 || month==7 || month==10 || month==12) {
			  if(day==1) {
				  month-=1;
				  day=30;
			  } else {
				  day-=1;
			  }
		  } else if(month!=3) {
			  if(day==1) {
				  month-=1;
				  day=31;
			  } else {
				  day-=1;
			  }
		  } else {
			  if(isLeapYear(year)==true && day==1) {
				  month-=1;
				  day=29;
			  }else if(day==1) {
				  month-=1;
				  day=28;
			  }else {
				  day-=1;
			  }
		  }
	  }
	  return this;
  }
  
  MyDate previousMonth() {
	  if(month==1) {
		  year-=1;
		  month=12;
	  }else if((month==5 || month==7 || month==10 || month==12) && day==31){
		  month-=1;
		  day=30;
	  }else if(day==30){
		  month-=1;
		  day=31;
	  }else if(month==3 && day>=28){
		  if(isLeapYear(year)==true) {
			  month-=1;
			  day=29;
		  }else {
			  month-=1;
			  day=28;
		  }
	  }else {
		  month-=1;
	  }
	  return this;
  }
  
  MyDate previousYear() {
	  if(month==2 && day==29) {
		  year-=1;
		  day=28;
	  }else {
		  year-=1;
	  }
	  return this;
  }

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

public int getMonth() {
	return month;
}

public void setMonth(int month) {
	this.month = month;
}

public int getDay() {
	return day;
}

public void setDay(int day) {
	this.day = day;
}
}