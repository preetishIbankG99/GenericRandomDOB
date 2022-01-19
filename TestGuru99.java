package com.gurubank99.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGuru99 {
//mngr381131
//abYjUjy
	
	////div[@id='dismiss-button']
	public static WebElement dob;
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/v1/");
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr381131");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abYjUjy");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		
		 Random random = new Random();
		int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2022, 1, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        String act_date=randomBirthDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(act_date);
       
        String[] dateParts = act_date.split("-");
        String dd = dateParts[0]; 
        String MM = dateParts[1]; 
        String yy=dateParts[2];
        System.out.println(dd);
        System.out.println(MM);
        System.out.println(yy);
        Thread.sleep(6000);
        dob=driver.findElement(By.xpath("//input[@id='dob']"));
		Date_Of_Birth(dd, MM, yy);
		
		}
public static void	Date_Of_Birth(String dd,String MM,String yy) {
	dob.sendKeys(dd);
	dob.sendKeys(MM);
	dob.sendKeys(yy);
}

}


