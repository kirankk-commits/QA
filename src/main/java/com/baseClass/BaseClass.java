package com.baseClass;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public abstract class BaseClass {
	
	public static WebDriver driver;
	public static ExtentReports extentReports;
	public static File file;
	
	protected static void browserLaunch(String browser) {
		
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();				
			}else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();	
			}else if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING THE BROWSER LAUNCH CHECK BROWSER NAME");
		}
	}
	protected static void launchURL(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			
			Assert.fail("ERROR: OCCUR DURING URL LAUNCHING");	
		} 
		
	}
    protected static void navigateToURL(String navigateURL)	{
        	try {
        		driver.navigate().to(navigateURL);
			} catch (Exception e) {
				Assert.fail("ERROR: OCCUR DURING NAVIGATE TO URL");
			}
    }
    protected static void navigateMethods(String type) {
    	try {
    		if (type.equalsIgnoreCase("back")) {
        		driver.navigate().back();    		
        	}else if (type.equalsIgnoreCase("refresh")) {
        		driver.navigate().refresh();  	  
        	}else if (type.equalsIgnoreCase("forward")) {
        		driver.navigate().forward();
        	}
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING NAVIGATE METHOD");
		}
    }
    protected static void  valuePassing(WebElement element, String value) {
    	try {
    		element.sendKeys(value);
			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING THE VALUE PASSING");
		}
    }
    protected static void elementClick(WebElement element) {
    	try {
			element.click();
		} catch (Exception e) {
			Assert.fail(" ERROR : OCCUR DURING THE CLICKING THE ELEMENT");
		}
    	
    }
    protected static void Terminate() {
    	try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR:");
		}
    }
    protected static void Quitting() {
    	try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("ERROR:");
		}
    	
    }
    protected static String getUrl() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING URL GETTING");
        }
        return null;
    }
    protected static void handleAlert(String action) {
        try {
            Alert alert = driver.switchTo().alert();
            if (action.equalsIgnoreCase("accept")) {
                alert.accept();
            } else if (action.equalsIgnoreCase("dismiss")) {
                alert.dismiss();
            }
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING ALERT ACTION");
        }
    }
    protected static void mouseHover(WebElement element) {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(element).perform();
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING MOUSE ACTION");
        }
    }
    // Frames
    protected static void switchToFrame(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING FRAME SWITCH");
        }
    }

    //  Robot (scroll example using JavaScript instead of Robot)
    protected static void scrollBy(int x, int y) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(arguments[0],arguments[1]);", x, y);
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING SCROLL");
        }
    }
    //  Window handles
    protected static void switchToWindow(String windowName) {
        try {
            driver.switchTo().window(windowName);
        } catch (Exception e) {
        	
        	Assert.fail(" ERROR : OCCUR DURING SWITCH WINDOW");
        }
    }

    //  Dropdown
    protected static void selectDropdown(WebElement element, String option, String value) {
        try {
            Select sel = new Select(element);
            switch (option.toLowerCase()) {
                case "index":
                    sel.selectByIndex(Integer.parseInt(value));
                    break;
                case "value":
                    sel.selectByValue(value);
                    break;
                case "text":
                    sel.selectByVisibleText(value);
                    break;
            }
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING DROPDOWN SELECTION");
        }
    }
 //  Check box
    protected static void selectCheckBox(WebElement element) {
        try {
            if (!element.isSelected()) {
                element.click();
            }
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING CHECKBOX SELECTION");
        }
    }

    //  Is Enabled
    protected static boolean isEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING ENABLED CHECKING");
        }
        return false;
    }

    //  Is Displayed
    protected static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING isDISPLAY METHOD");
        }
        return false;
    }
 //  Is Selected
    protected static boolean isSelected(WebElement element) {
        try {
            return element.isSelected();
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING is SELECTED METHOD");
        }
        return false;
    }

    //  Get Options
    protected static List<WebElement> getOptions(WebElement element) {
        try {
            Select sel = new Select(element);
            return sel.getOptions();
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING GET OPTIONS METHOD");
        }
        return null;
    }

    //  Get Title
    protected static String getTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING GET TITLE");
        }
        return null;
    }
    //  Get Current URL
    protected static String getCurrentUrl() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING GET URL");
        }
        return null;
    }

    //  Get Text
    protected static String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING GET TITLE");
        }
        return null;
    }

    //  Get Attribute
    protected static String getAttribute(WebElement element, String attribute) {
        try {
            return element.getAttribute(attribute);
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING GET ATTRIBUTE");
        }
        return null;
    }
 //  Wait
    protected static WebElement waitForElement(WebElement element, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING WAIT");
        }
        return null;
    }

    //  Screenshot
    protected static void takeScreenshot(String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File("./Screenshots/" + fileName + ".png"));
        } catch (IOException e) {
        	Assert.fail(" ERROR : OCCUR DURING TAKING SCREENSHOT");
        }
    }

    //  Scroll up/down
    protected static void scrollIntoView(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING SCROLL UP/DOWN");
        }
    }
    //  Get First Selected Option
    protected static WebElement getFirstSelectedOption(WebElement element) {
        try {
            Select sel = new Select(element);
            return sel.getFirstSelectedOption();
        } catch (Exception e) {
        	Assert.fail(" ERROR : GETTING FIRST SELECTED OPTION");
        }
        return null;
    }

    //  Get All Selected Options
    protected static List<WebElement> getAllSelectedOptions(WebElement element) {
        try {
            Select sel = new Select(element);
            return sel.getAllSelectedOptions();
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING Get All Selected Options");
        }
        return null;
    }

    //  Is Multiple
    protected static boolean isMultiple(WebElement element) {
        try {
            Select sel = new Select(element);
            return sel.isMultiple();
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING Is Multiple");
        }
        return false;
    }


    //  Radio Button
    protected static void selectRadioButton(WebElement element) {
        try {
            if (!element.isSelected()) {
                element.click();
            }
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING  Radio Button");
        }
    }

    //  JavaScript Executor
    protected static void javaScriptClick(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING JAVASCRIPT CLICK");
        }
    }

    protected static String javaScriptGetTitle() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return (String) js.executeScript("return document.title;");
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING JAVASCRIPT GET TITLE");
        }
        return null;
    }

    protected static void javaScriptScrollBottom() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        } catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING JAVASCRIPT SCROLL BOTTOM");
        }
    }
    public static void extentReportStart(String location) {
       try {
    	   
    	extentReports = new ExtentReports();
        file = new File(location);
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
       }catch ( Exception e) {
    	   Assert.fail(" ERROR : OCCUR DURING EXTENT REPORT STARTING");
       }
    }

    public static void extentReportTearDown(String location) throws IOException {
        try {
    	extentReports.flush();
        file = new File(location);
        Desktop.getDesktop().browse((file).toURI());
        }catch (Exception e) {
        	Assert.fail(" ERROR : OCCUR DURING extentReportTearDown ");
        }
    }

    public String takeScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
        File destfile = new File("Screenshot\\Screenshot_" + timeStamp + ".png");
        FileHandler.copy(srcfile, destfile);
        return destfile.getAbsolutePath();
    }
    

}
