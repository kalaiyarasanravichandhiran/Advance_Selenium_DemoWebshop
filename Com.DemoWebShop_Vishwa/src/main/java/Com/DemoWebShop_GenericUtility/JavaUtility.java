package Com.DemoWebShop_GenericUtility;

import java.time.LocalDateTime;

public class JavaUtility {
	public String LocalDateTime(){
		String date = LocalDateTime.now().toString().replace(":", "").replace("-", "");
		return date;
	}
}
