package baekjoon;

import java.io.*;
import java.util.*;

/**
 * @see <a href="https://www.acmicpc.net/problem/1260">
 * https://www.acmicpc.net/problem/1260
 * </a> DFS�� BFS
 */
public class BOJ_1260 {
	
	static boolean[] isVisited; // DFS
	static Queue<Integer> bfsQueue; // BFS
	
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(token.nextToken()); // ������ ���� N(1 �� N �� 1,000), 
		int M = Integer.parseInt(token.nextToken()); // ������ ���� M(1 �� M �� 10,000), 
		int V = Integer.parseInt(token.nextToken()); // Ž���� ������ ������ ��ȣ V
		
		bfsQueue = new LinkedList<Integer>();
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			String read = br.readLine();
			int start = Integer.parseInt(read.substring(0, read.indexOf(" ")));
			int end = Integer.parseInt(read.substring(read.indexOf(" ") + 1, read.length()));
			graph.get(start).add(end);
			if(!graph.get(end).contains(start))
				graph.get(end).add(start);
			// ���� ����Ǿ� �־���ϴµ�?
		}
		br.close();
		
		// �������� ���� // �ʿ����? // ������ �׳� ������������ ���� ������
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(graph.get(i));
		}
		
		isVisited = new boolean[N + 1];
		dfs(V);
		System.out.println();

		isVisited = new boolean[N + 1];
		explorerUsingBFS(V);
	}
	
	// ��͸� ���� DFS
	private static void dfs(int V) {
		isVisited[V] = true; // �湮
		System.out.print(V + " ");
		for (int i = 0; i < graph.get(V).size(); i++) {
			int next = graph.get(V).get(i);
			if(!isVisited[next]) {
				dfs(next);
			}
		}
	}
	
	
	private static void explorerUsingBFS(int V) {
		// ����
		isVisited[V] = true;
		bfsQueue.offer(V);
		
		while (!bfsQueue.isEmpty()) {
			int index = bfsQueue.poll();
			System.out.print(index + " ");
			for (int i = 0; i < graph.get(index).size(); i++) {
				int next = graph.get(index).get(i);
				// �湮���� �ʾҴٸ� ť�� ����
				if(!isVisited[next]) {
					isVisited[next] = true;
					bfsQueue.offer(graph.get(index).get(i));
				}
			}
			
		}
	}
}
