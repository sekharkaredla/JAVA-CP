package com.sekhar.coding;

public class GenericMains {
    /*
    This class serves the purpose of calling the solution classes with main function

    @version 1.0
    @author Sekhar Karedla
     */
//    public static void main(String[] args) {
//        MeetingRooms meetingRooms = new MeetingRooms();
//        Scanner scanner  = new Scanner(System.in);
//        int size = 1;
//        if (scanner.hasNextInt())
//            size = scanner.nextInt();
//        int[][] intervals = new int[size][2];
//        for (int index = 0; index < size; index++) {
//            intervals[index][0] = scanner.nextInt();
//            intervals[index][1] = scanner.nextInt();
//        }
//        System.err.println(Arrays.deepToString(intervals));
//        System.out.println(meetingRooms.minMeetingRooms(intervals));
//    }

//    public static void main(String[] args) {
//        System.out.println(StringForward.numberToOrdinal(500));
//    }

//    public static void main(String[] args) {
//        MakingFileNamesUnique makingFileNamesUnique = new MakingFileNamesUnique();
//        System.out.println(Arrays.deepToString(makingFileNamesUnique.getFolderNames(new String[]{"onepiece","onepiece(1)","onepiece(2)","onepiece(5)","onepiece"})));
//    }

//    public static void main(String[] args) {
//        DifferentPalindromicSubsequences differentPalindromicSubsequences = new DifferentPalindromicSubsequences();
//        System.out.println(differentPalindromicSubsequences.countPalindromicSubsequences("bccb"));
//    }

//    public static void main(String[] args) {
//        TopologicalSortWithCycleDetectionDirectedGraph topologicalSortWithCycleDetectionDirectedGraph =
//                new TopologicalSortWithCycleDetectionDirectedGraph();
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//        int V = 4;
//        for(int i = 0; i < V; i++)
//            adj.add(new ArrayList<>());
//        adj.get(0).add(1);
//        adj.get(0).add(2);
//        adj.get(1).add(2);
//        adj.get(2).add(0);
//        adj.get(2).add(3);
//        System.out.println(topologicalSortWithCycleDetectionDirectedGraph.topologicalSort(V, adj));
//    }

//    public static void main(String[] args) {
//        ConcatenatedWords concatenatedWords = new ConcatenatedWords();
//        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
//        System.out.println(concatenatedWords.findAllConcatenatedWordsInADict(words));
//    }

//    public static void main(String[] args) {
//        RottingOranges rottingOranges = new RottingOranges();
//        int[][] grid = new int[1][];
//        grid[0] = new int[]{0, 2};
//        System.out.println(rottingOranges.orangesRotting(grid));
//    }

//    public static void main(String[] args) {
//        TopologicalSortPossibleOrNot topologicalSortPossibleOrNot = new TopologicalSortPossibleOrNot();
//        int[][] prereq = new int[8][];
//        prereq[0] = new int[]{0, 10};
//        prereq[1] = new int[]{3, 18};
//        prereq[2] = new int[]{5, 5};
//        prereq[3] = new int[]{6, 10};
//        prereq[4] = new int[]{11, 10};
//        prereq[5] = new int[]{13, 10};
//        prereq[6] = new int[]{15, 10};
//        prereq[7] = new int[]{17, 10};
//    }
//
//    public static void main(String[] args) {
//        NQueens nQueens = new NQueens();
//        nQueens.solveNQueens(4);
//    }

//    public static void main(String[] args) {
//        UnionFind unionFind = new UnionFind();
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//        adj.add(new ArrayList<>());
//        adj.add(new ArrayList<>());
//        adj.add(new ArrayList<>());
//        adj.add(new ArrayList<>());
//        adj.add(new ArrayList<>());
//        adj.get(4).add(2);
//        adj.get(1).add(2);
//        adj.get(2).add(3);
//        System.out.println(unionFind.isCycle(5, adj));
//    }
//    public static void main(String[] args) {
//        RatInAMaze ratInAMaze = new RatInAMaze();
//        int[][] m = {{1, 0, 0, 0},
//            {1, 1, 0, 1},
//            {1, 1, 0, 0},
//            {0, 1, 1, 1}};
//        System.out.println(ratInAMaze.findPath(m));
//    }

    public static void main(String[] args) {
        StringPermutations stringPermutations = new StringPermutations();
        StringSubSequences stringSubSequences = new StringSubSequences();
        StringSubStrings stringSubStrings = new StringSubStrings();
        System.out.println(stringPermutations.getPermutations("abc"));
        System.out.println(stringSubSequences.getSubSequences("abc"));
        System.out.println(stringSubStrings.getSubStrings("abc"));
    }
}
