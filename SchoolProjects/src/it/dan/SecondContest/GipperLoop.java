package it.dan.SecondContest;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Stack;

public class GipperLoop {

    static class Graph {
        private List<Integer>[] edges;
        private int numberOfTowns; //number of towns
        private int numberOfConnections; //number of connections

        private Graph(int V) {
            this.numberOfTowns = V;
            this.numberOfConnections = 0;
            edges = new List[V];
            for (int i = 0; i < V; i++) {
                edges[i] = new ArrayList<>();
            }
        }

        public int V(){
            return this.numberOfTowns;
        }

        public int E(){
            return this.numberOfConnections;
        }

        private void add(int town, int connection){
            if(!edges[town].contains(connection)){ //if we have no "connection" connection in town "town"
                edges[town].add(connection);       //we adding "connection" to List with index "town"
                numberOfConnections++;             //and increase count of connections
            }
        }
        private Iterable<Integer> adj(int v){
            return edges[v];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(
                inputData()
                //System.in
                );

        int N = in.nextInt();
        int S = in.nextInt();
        Graph graph = new Graph(N);

        Map<Integer, String> citiesNames = new TreeMap<>(); //for keeping cities Names in order
        //filling the map
        for (int i = 0; i < N; i++) {
            citiesNames.put(i, in.next());
        }

        for (int i = 0; i < N; i++) {
            int connectNum = in.nextInt();
            for (int j = 0; j < connectNum; j++) {
                int point = in.nextInt();
                graph.add(i, point);
            }
        }

        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();

        stack.push(S);
        visited[S] = true;

        while(!stack.isEmpty()){
            int current = stack.pop();
            for (int city : graph.adj(current)) {
                if(!visited[city]){
                    stack.push(city);
                    visited[city] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if(visited[i]){
                System.out.print(citiesNames.get(i) + " ");
            }
        }

    }

    private static String inputData() {
        return "10 4\n" +
                "Київ Житомир Лубни Бориспіль Фастів Ніжин Умань Суми Хмельницький Миколаїв\n" +
                "5 1 5 7 8 9 \n" +
                "3 0 2 8\n" +
                "2 4 9 \n" +
                "2 2 5 \n" +
                "1 9\n" +
                "2 0 3\n" +
                "2 8 9\n" +
                "3 0 2 6 \n" +
                "1 6 \n" +
                "2 2 6";
    }
}
