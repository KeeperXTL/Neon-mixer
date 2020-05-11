package com.neonmixer.etc;

import java.math.*;

public class MyMath {
	public static double round(double temp) {
		double rounded = new BigDecimal(temp).setScale(2, RoundingMode.UP).doubleValue();
		return rounded;
	}
}
