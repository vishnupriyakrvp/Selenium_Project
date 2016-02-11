package com.vishnu.visitor;

public class Test {
	
    public static void main(String s[]) {
   	 String str = "StringToReverse";
        char[] value = str.toCharArray();
        int j = value.length - 1;
        for (int i = 0; value.length > 0 && i < j; i++, j--) {
            char ch = value[i];
            value[i] = value[j];
            value[j] = ch;
        }
        System.out.println(new String(value));
    }
}
