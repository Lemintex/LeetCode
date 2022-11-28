package RandomStuff;

import java.util.*;

public class MinimumEnrgyToFinishTask {
        public static void main(String[] args) {
                int[][] i = {{1,3},{2,4},{10,11},{10,12},{8,9}};
                int j = minimumEffort(i);
        }
        public static int minimumEffort(int[][] tasks) {
                //[1,5],[2,5],[4,5],[3,5]
                //[4, 0], [3,1], [1,2], [2, 3 ]
                //[4, 0], [3,1], [2, 3], [1,2]
                // foreach val+=A THEN if val<E val=E
                int energy = 0;

                Arrays.sort(tasks,(a, b)->{
                        int diff = (b[1]-b[0]) - (a[1]-a[0]);
                        return diff;
                });

                int power = 0;

                for(int i=0;i<tasks.length;i++) {
                        if (power < tasks[i][1]) {
                                power = tasks[i][1];
                        } else {
                                power += tasks[i][0];
                        }
                }
                        return power;
        }
//                HashMap<Integer, Integer> effortRequired = new HashMap<>();
//                for (int i = 0; i < tasks.length; i++) {
//                        int diff = tasks[i][1] - tasks[i][0];
//                        effortRequired.put(i, diff);
//                }
//                ArrayList<Integer> list;
//                list = sortHashMap(effortRequired);
//                Object[] indexOrder = list.toArray();
                for (Object n: indexOrder) {
                        Integer i = (Integer) n;
                        energy += tasks[i][0];
                        if (energy < tasks[i][1]) energy = tasks[i][1];
                }
                return energy;
        }
//        public static ArrayList sortHashMap(HashMap<Integer, Integer> map) {
//                ArrayList<Integer> list = new ArrayList();
//                int index = 0;
//                int mapSize = map.size();
//                for (int i = 0; i < mapSize; i++) {
//                        int maxIndex = 0;
//                        int maxDifference = 0;
//                        for (int j = index; j < mapSize; j++) {
//                                if (maxDifference < map.get(i)) {
//                                        maxDifference = map.get(i);
//                                        maxIndex = i;
//                                }
//                        }
//                        list.add(maxIndex);
//                        map.remove(maxIndex);
//                }
//                return list;
//        }
}
