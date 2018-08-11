package core.java.concept.bigdecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class DoubleForCurrency {

	public static String formatRupees(double value) {
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(5);
		return format.format(value);
	}

	public static void main122(String[] args) {
		BigDecimal tempBig = new BigDecimal(22.1214);
		System.out.println("tempBig = " + formatRupees(tempBig.doubleValue()));
	}

	public static void main11(String[] args) {
		double total = 0.2;
		for (int i = 0; i < 100; i++) {
			total += 0.2;
		}
		System.out.println("total = " + total);
		System.out.println("total = " + Math.round(total));
		System.out.println("total = " + Math.round(total));
		System.out.println(new BigDecimal(total, MathContext.UNLIMITED));
		BigDecimal a = new BigDecimal("10.12345");

		System.out.println(a.setScale(2, BigDecimal.ROUND_UP));
		System.out.println(a.setScale(2, BigDecimal.ROUND_CEILING));
		System.out.println(a.setScale(2, BigDecimal.ROUND_DOWN));
		System.out.println(a.setScale(2, BigDecimal.ROUND_FLOOR));
		System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_DOWN));
		System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_EVEN));
		System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_UP));
	}

	public double round1(double input, int scale) {
		BigDecimal bigDecimal = new BigDecimal(input).setScale(scale, RoundingMode.HALF_EVEN);
		return bigDecimal.doubleValue();
	}

	public double round2(double input) {
		return Math.round(input * 100) / 100.0d;
	}

	public double round3(double input) {
		DecimalFormat df = new DecimalFormat("#.00");
		return Double.parseDouble(df.format(input));
	}

	public static void main(String[] args) {
		DoubleForCurrency rd = new DoubleForCurrency();
		System.out.println(rd.round1(9232.129394d, 2));
		System.out.println(rd.round2(9232.129394d));
		System.out.println(rd.round3(9232.129394d));
	}
}