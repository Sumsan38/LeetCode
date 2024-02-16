package com.somi.programmers;

import java.util.Arrays;
import java.util.Comparator;
/**
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 * [Programmers] ���� ū ��
 */
public class Solution_BigNum {
	/**
	 * numbers�� ���̴� 1 �̻� 100,000 �����Դϴ�.
	 * numbers�� ���Ҵ� 0 �̻� 1,000 �����Դϴ�.
	 * ������ �ʹ� Ŭ �� ������ ���ڿ��� �ٲپ� return �մϴ�.
	*/
	public String solution(int[] numbers) {
		StringBuilder sb = new StringBuilder();
		
		String[] numberString = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numberString[i] = numbers[i] + "";
		}
		
		Arrays.sort(numberString, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -(o1+o2).compareTo(o2+o1); // ���� �� // ��������
			}
		});
		
		if(numberString[0].equals("0")) return numberString[0];
		for (int i = 0; i < numberString.length; i++) sb.append(numberString[i]);
        return sb.toString();
    }
}
// TestCase
//int[] numbers = {6, 10, 2}; // 6210
//int[] numbers = {6, 10, 2, 0}; // 62100
//int[] numbers = {3, 30, 34, 5, 9}; // 9534330
//int[] numbers = {1, 10, 100, 1000}; // 1101001000
//int[] numbers = {0, 0, 70}; // 0, 0, 70
//int[] numbers = {0, 0, 0, 0}; // 0
//int[] numbers = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // 0
//int[] numbers = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}; // 0
//int[] numbers = {12, 121}; // 12121
//int[] numbers = {40, 403}; // 40403
