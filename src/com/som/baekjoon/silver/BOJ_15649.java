package baekjoon;

import java.io.*;
import java.util.*;
/**
 * @see <a href="https://www.acmicpc.net/problem/15649">
 * https://www.acmicpc.net/problem/15649 N�� M (1)
 * ��Ʈ��ŷ�� ������ ���Ʈ������ DFS�� ȥ�� �� �� �ִ�
 */
public class BOJ_15649 {
	static int N;
	static int M;
	static int[] array;
	static boolean[] isVisited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(token.nextToken()); // �ڿ���
		M = Integer.parseInt(token.nextToken()); // �迭 ����
		br.close();
		
		array = new int[M]; // ��� Array
		isVisited = new boolean[N]; // �湮
		dfs(0);
		
		bw.write(sb.toString());
		bw.close();
	}
	
	private static void dfs(int depth) { // ���� ����
		// ���̰� M�� �����ߴٸ� return
		if(depth == M) {
			for (int i : array) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		// �װ� �ƴ϶�� Ž���� �մ´�
		for (int i = 0; i < N; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				array[depth] = i + 1;
				dfs(depth + 1);
				isVisited[i] = false; // ��� Ž���� ������ ���� ���� ���� �湮���� ���� ������ ������
			}
		}
	}
}
