package imPAC.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public interface Screenshot {
	public String TakeScreenShot(String TCName) throws IOException;
}