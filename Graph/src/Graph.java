import java.util.*;

public class Graph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int INF = Integer.MAX_VALUE;
        int[][] matrix = new int[][]{
                {INF, 25, 15, 7, 2},
                {25, INF, 6, INF, INF},
                {15, 6, INF, 4, INF},
                {7, INF, 4, INF, 3},
                {2, INF, INF, 3, INF}
        };
        int verticesCount = matrix.length;
        System.out.println("1. Алгоритм Дейкстры");
        System.out.println("2. Алгоритм Беллмана-Форда");
        int choice = scanner.nextInt();
        System.out.print("Введите вершину: ");
        int startVertex = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Результат: " + Arrays.toString(dijkstra(matrix, startVertex, verticesCount)));
        } else if (choice == 2) {
            System.out.println("Результат: " + bellmanFord(matrix, startVertex, verticesCount));
        } else {
            System.out.println("Ошибка");
        }
    }


    public static List<Integer> bellmanFord(int[][] matrix, int start, int verticesCount) {
        if (start >= verticesCount) {
            return null;
        }
        List<Integer> d = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < verticesCount; i++) {
            d.add(Integer.MAX_VALUE);
        }
        d.set(start, 0);
        boolean flag = true;
        int step = 1;
        while (flag) {
            int checked = 0;
            for (int i = 0; i < verticesCount; i++) {
                if (i == start)
                    continue;
                for (int j = 0; j < verticesCount; j++) {
                    if (matrix[j][i] == Integer.MAX_VALUE || d.get(j) == Integer.MAX_VALUE) {
                        temp.add(Integer.MAX_VALUE);
                    } else {
                        temp.add(d.get(j) + matrix[j][i]);
                    }
                }
                int minElementInTemp = searchMinElement(temp);
                if (!Objects.equals(d.get(i), minElementInTemp)) {
                    checked = 0;
                } else {
                    checked += 1;
                }
                d.set(i, minElementInTemp);
                temp.clear();
                step += 1;
                if (checked == verticesCount - 1)
                    flag = false;
            }
        }
        return d;
    }


    public static int[] dijkstra(int[][] matrix, int start, int verticesCount) {
        if (start >= verticesCount) {
            return null;
        }
        int[] d = new int[verticesCount];
        boolean[] visited = new boolean[verticesCount];
        for (int i = 0; i < verticesCount; i++) {
            d[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        d[start] = 0;
        for (int i = 0; i < verticesCount - 1; i++) {
            int index = searchMinIndex(d, visited);
            visited[index] = true;
            for (int v = 0; v < verticesCount; v++)
                if (matrix[index][v] != Integer.MAX_VALUE && d[index] != Integer.MAX_VALUE && !visited[v])
                    d[v] = Math.min(d[v], d[index] + matrix[index][v]);
        }

        return d;
    }

    public static int searchMinElement(List<Integer> array) {
        int minElement = Integer.MAX_VALUE;
        for (Integer integer : array) {
            if (integer < minElement) {
                minElement = integer;
            }
        }
        return minElement;
    }


    public static int searchMinIndex(int[] array, boolean[] visited) {
        int index = 0;
        int minElement = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minElement && !visited[i]) {
                minElement = array[i];
                index = i;
            }
        }
        return index;
    }

}
