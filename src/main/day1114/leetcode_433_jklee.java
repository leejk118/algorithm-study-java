package main.day1114;

public class leetcode_433_jklee {
    private int answer;

    public int minMutation(String startGene, String endGene, String[] bank) {
        boolean[] isVisited = new boolean[bank.length];
        answer = Integer.MAX_VALUE;
        dfs(startGene, endGene, bank, isVisited, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    private void dfs(String gene, String endGene, String[] bank, boolean[] isVisited, int count) {
        if (endGene.equals(gene)) {
            answer = Math.min(answer, count);
            return;
        }
        for (int i = 0, length = bank.length; i < length; ++i) {
            if (isVisited[i] || !isValidMutation(gene, bank[i])) continue;
            isVisited[i] = true;
            dfs(bank[i], endGene, bank, isVisited, count + 1);
            isVisited[i] = false;
        }
    }
    private boolean isValidMutation(String gene, String bankGene) {
        int diffNumber = 0;
        for (int i = 0; i < gene.length(); ++i) {
            if (gene.charAt(i) != bankGene.charAt(i)) {
                diffNumber++;
            }
        }
        return diffNumber == 1;
    }

    public static void main(String[] args) {
        String[] startGene = {"AACCGGTT", "AACCGGTT", "AACCGGTT", "AACCGGTT"};
        String[] endGene = {"AACCGGTA", "AAACGGTA", "AACCGGTA", "AACCGGTT"};
        String[][] bank = {
                {"AACCGGTA"},
                {"AACCGGTA", "AACCGCTA", "AAACGGTA"},
                {},
                {"AACCGGTT"}
        };

        for (int i = 0; i < startGene.length; ++i) {
            System.out.println(new leetcode_433_jklee().minMutation(startGene[i], endGene[i], bank[i]));
        }
    }
}
