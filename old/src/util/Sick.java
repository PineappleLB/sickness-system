package util;

import java.util.HashMap;
import java.util.Map;

public class Sick {

private static Map<String, String> map = new HashMap<>();
	
	static {
		map.put("mz", "麻疹");
		map.put("gm", "流行性感冒");
		map.put("xzb", "先天性心脏病");
		map.put("bcb", "包虫病");
		map.put("bnz", "白内障");
	}

	public static String getSick(String sick) {
		return map.get(sick);
	}
	
}
