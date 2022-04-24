package com.somi.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/12865
 * ����� �賶
 * 2022.04.20 16:30 ~ 17:00 ���Ʈ���� ���� �ð� �ʰ�
 * ���� https://jeonyeohun.tistory.com/86
 *
 * */
public class BOJ_12865 {

    static int currentW = Integer.MAX_VALUE;
    static int bestV = Integer.MIN_VALUE;
    static int n;
    static int k;

    static boolean choose[];
    static int[] itemW;
    static int[] values;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token;
        token = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(token.nextToken()); // ������ �� N��
        k = Integer.parseInt(token.nextToken()); // �ؼ��� ��ƿ �� �ִ� ���� K

        itemW = new int[n];
        values = new int[n];
        choose = new boolean[n];

        for (int i = 0; i < itemW.length; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            itemW[i] = Integer.parseInt(token.nextToken());
            values[i] = Integer.parseInt(token.nextToken());
        }

        System.out.println(bestV);
    }

    // dp�� Ǫ�� ���
    static int[][] dp;


    // ���Ʈ������ Ǫ�� ����� �ð��ʰ�
    private static void chooseItem(int totalweight, int totalvalue, int beforeChoose){
        for (int i = beforeChoose; i < choose.length; i++) {
            int value = totalvalue + values[i];
            int weight = totalweight + itemW[i];
            choose[i] = true;

            if(weight <= k) {
                bestV = Math.max(bestV, value);
                chooseItem(weight, value, i + 1);
            } else {
                continue;
            }

            // ��Ʈ��ŷ���� ���� ���� ������ �ǵ�����
            choose[i] = false;
        }
    }
}