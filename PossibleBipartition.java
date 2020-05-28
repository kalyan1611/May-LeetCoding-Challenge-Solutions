class Solution {

    public boolean possibleBipartition(int N, int[][] dislikes) {

        int len = dislikes.length;
        Person[] graph = new Person[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new Person(i);
        }

        for (int i = 0; i < len; i++) {
            int x = dislikes[i][0];
            int y = dislikes[i][1];
            graph[x].addHater(graph[y]);
            graph[y].addHater(graph[x]);
        }

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        int[] visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 1) {
                continue;
            }
            Queue<Person> queue = new LinkedList<>();
            queue.add(graph[i]);
            while (!queue.isEmpty()) {

                Person current = queue.remove();
                visited[current.id] = 1;

                if (!setA.contains(current.id) && !setB.contains(current.id)) {
                    setA.add(current.id);
                } else if (setB.contains(current.id)) {
                    Set<Integer> temp = setA;
                    setA = setB;
                    setB = temp;
                }
                for (Person hater : current.haters) {
                    if (visited[hater.id] == 1) {
                        continue;
                    }
                    if (setA.contains(hater.id)) {
                        return false;
                    }
                    setB.add(hater.id);
                    queue.add(hater);
                }
            }
        }

        return true;
    }
}

class Person {

    Integer id;
    List<Person> haters;

    Person(Integer id) {
        this.id = id;
        haters = new ArrayList();
    }

    public void addHater(Person x) {
        haters.add(x);
    }
}
