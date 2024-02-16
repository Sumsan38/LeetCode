package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @see <a href="https://www.acmicpc.net/problem/18870">
 * https://www.acmicpc.net/problem/18870 ��ǥ ����
 * </a>
 */
public class BOJ_18870 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		br.close();
		
		int[] nums = new int[N];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(token.nextToken());
		}
		
		int[] listClone = nums.clone();
		Arrays.sort(nums);
		HashMap<Integer, Integer> nMap = new HashMap<Integer, Integer>();
		
		for (int i = 0, cnt = 0; i < nums.length; i++) {
			int num = nums[i];
			if(!nMap.containsKey(num)) { // �Ƹ� ���⼭ �ð��� ���� �ɸ��µ�
				nMap.put(num, cnt++);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < listClone.length; i++) {
			// indexOf�� �ð� ���⵵ ������ ��
//			sb.append(nList.indexOf(nums[i])).append(" ");
			sb.append(nMap.get(listClone[i])).append(" ");
		}
		bw.write(sb.toString());
		bw.close();
	}
}