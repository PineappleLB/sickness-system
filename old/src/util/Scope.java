package util;

import java.util.HashMap;
import java.util.Map;

public class Scope {
	
	private static Map<String, String> map = new HashMap<>();
	
	static {
		map.put("cgq", "城关区");
		map.put("dlx", "堆龙县");
		map.put("xsq", "西山区");
		map.put("whq", "五华区");
		map.put("lwxq", "柳梧新区");
	}

	public static String getScope(String scope) {
		return map.get(scope);
	}
	
}
