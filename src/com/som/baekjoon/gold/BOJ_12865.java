package com.baekjoon;

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
 * 2022.04.29 13:00 ~ 13:45 DP �¾ҽ��ϴ�
 * */
public class BOJ_12865 {

    static int bestV = 0;
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

        dp = new int[k + 1];

        itemW = new int[n];
        values = new int[n];
        choose = new boolean[n];

        for (int i = 0; i < itemW.length; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            itemW[i] = Integer.parseInt(token.nextToken());
            values[i] = Integer.parseInt(token.nextToken());
        }

        selectItem();

        System.out.println(bestV);
    }

    // dp�� Ǫ�� ��� // 100�ۼ�Ʈ���� Ʋ��
    static int[] dp;
    private static void selectItem(){
        for (int i = 0; i < itemW.length; i++) {
            int w = itemW[i];
            int v = values[i];

            for (int j = k; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
                bestV = Math.max(dp[j], bestV);
            }
        }
    }

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