package uiAssement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.openqa.selenium.support.ui.WebDriverWait;

public class ExecuteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://blockstream.info/block/000000000000000000076c036ff5119e5a5a74df77abf64203473364509f7732");
		
		driver.manage().window().maximize();
		
		// Test case 1
		// Validate the section has the heading "25 of 2875 Transactions"
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		String heading = driver.findElement(By.xpath("//h3[text()='25 of 2875 Transactions']")).getText();
		Assert.assertEquals(heading, "25 of 2875 Transactions");
		
		// Test Case 2
		// Transaction which has only 1 input & 2 outputs
		List<WebElement> totalTransaction = driver.findElements(By.xpath("//div[@class='transaction-box']"));
		Assert.assertEquals(totalTransaction.size(), 25);
		
		for(int i=0; i<=totalTransaction.size(); i++) {
			WebElement ele = totalTransaction.get(i);
			List<WebElement> output = ele.findElements(By.xpath("//div[@class='vout']"));
			List<WebElement> input = driver.findElements(By.xpath("//div[@class='vins']"));
			int sizeofoutput = output.size();
			int sizeofinput = input.size();
			if(sizeofoutput==2 && sizeofinput==1) {
				System.out.println(ele.findElement(By.xpath("//div[@class='header']/div[1]/a")).getText());
			}
		}	
	}
}