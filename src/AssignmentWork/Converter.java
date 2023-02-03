package AssignmentWork;

import java.util.Arrays;

public class Converter {

	public static void main(String[] args) {
		
		double[] input = new double[] {625615.7528, 73465147.008, 41624.2712, 274.0009};
		System.out.println(convertToDollar(input));
	
	}
	
	public static String convertToDollar(double[] array) {
		
		String[] output = new String[array.length];
		int i=0;
		for(double num:array) {
			
			String str = String.valueOf(num);
			int decimalPoint = str.indexOf(".");
			String wholeNumber = str.substring(0, decimalPoint);
			int wholeNumberLength = wholeNumber.length();
			if(wholeNumberLength>3) {
				
				String hunderedPart = wholeNumber.substring(wholeNumberLength-3);
				wholeNumber = wholeNumber.substring(0,wholeNumberLength-3);
				String newFormat = "";
				while(wholeNumber.length()>2) {
					
					newFormat = ","+wholeNumber.substring(wholeNumber.length()-2)+newFormat;
					wholeNumber = wholeNumber.substring(0,wholeNumber.length()-2);
				
				}
				
				wholeNumber=wholeNumber+newFormat+","+hunderedPart;
			}
			String decimalNumber = str.substring(decimalPoint+1,decimalPoint+3);
			str = "$"+wholeNumber+"."+decimalNumber;
			output[i++]=str;	
			
		}
		return Arrays.toString(output);		
	}
}
