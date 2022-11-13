package main.codingTest.LG_CNS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Marble {
    public List<Integer> marbleList;
    public int marbleWeight, marbleCount, leftCount, rightCount;

    public Marble(List<Integer> marbleList, int marbleWeight, int marbleCount, int leftCount, int rightCount) {
        this.marbleList = new ArrayList<>(marbleList);
        this.marbleWeight = marbleWeight;
        this.marbleCount = marbleCount;
        this.leftCount = leftCount;
        this.rightCount = rightCount;
    }
    public Marble(Marble marble) {
        this.marbleList = marble.marbleList;
        this.marbleWeight = marble.marbleWeight;
        this.marbleCount = marble.marbleCount;
        this.leftCount = marble.leftCount;
        this.rightCount = marble.rightCount;
    }
}

public class Problem1 {
    Marble maxMarble;

    public int[] solution(int[] marbles) {
        boolean[] isVisited = new boolean[marbles.length];
        dfs(marbles, isVisited, new ArrayList<>());
        return maxMarble.marbleList.stream().mapToInt(i -> i).toArray();
    }
    private void dfs(int[] marbles, boolean[] isVisited, List<Integer> list) {
        if (list.size() > 0) {
            Marble marble = getPossibleMarble(list);
            if (marble != null) {
                System.out.println("-------------");
                System.out.println(marble.marbleList.toString());
                System.out.println(marble.leftCount);
                System.out.println(marble.rightCount);
                maxMarble = getMaxMarble(maxMarble, marble);
            }
        }
        for (int i = 0; i < marbles.length; ++i) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            list.add(marbles[i]);
            dfs(marbles, isVisited, list);
            isVisited[i] = false;
            list.remove(list.size() - 1);
        }
    }
    private Marble getPossibleMarble(List<Integer> list) {
        int leftSum = list.get(0), rightSum = 0;
        Marble marble = null;

        if (list.size() == 1) {
            return new Marble(list, leftSum + rightSum, list.size(), 0, 0);
        }

        for (int i = 1; i < list.size(); ++i) {
            rightSum += list.get(i);
        }
        if (leftSum == rightSum) {
            return new Marble(list, leftSum + rightSum, list.size(), 1, 1);
        }

        for (int i = 1; i < list.size() - 1; ++i) {
            int centerWeight = list.get(i);
            if (leftSum == rightSum - centerWeight) {
                return new Marble(list, leftSum + rightSum, list.size(), i, list.size() - i - 1);
            }
            leftSum += centerWeight;
            rightSum -= centerWeight;
            if (leftSum == rightSum) {
                return new Marble(list, rightSum + leftSum, list.size(), i + 1, list.size() - i - 1);
            }
        }
        return marble;
    }
    private Marble getMaxMarble(Marble marble1, Marble marble2) {
        if (marble1 == null) return new Marble(marble2);

        int diff1 = Math.abs(marble1.leftCount - marble1.rightCount), diff2 = Math.abs(marble2.leftCount - marble2.rightCount);
        if (diff1 == diff2) {
            if (marble1.marbleCount == marble2.marbleCount) {
                if (marble1.marbleWeight == marble2.marbleWeight) {
                    StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
                    for (int a : marble1.marbleList) {
                        sb1.append(a);
                    }
                    for (int a : marble2.marbleList) {
                        sb2.append(a);
                    }
                    return new Marble(sb1.toString().compareTo(sb2.toString()) > 0 ? marble2 : marble1);
                } else {
                    return new Marble(marble1.marbleWeight > marble2.marbleWeight ? marble1 : marble2);
                }
            } else {
                return new Marble(marble1.marbleCount > marble2.marbleCount ? marble1 : marble2);
            }
        } else {
            return new Marble(diff1 < diff2 ? marble1 : marble2);
        }
    }

    public static void main(String[] args) {
        int[][] testcase = {
                {1, 2, 3, 4, 4}, {5, 5, 1, 4}, {3, 9, 7, 5}, {7, 3, 1}
        };
        for (int[] tc : testcase) {
            System.out.println(Arrays.toString(new Problem1().solution(tc)));
        }
    }
}
