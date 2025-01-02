import java.util.Arrays;
import java.util.HashSet;

class MinimumCostOfTickets{
    public static HashSet<Integer> isTravelNeeded = new HashSet<>(); // 1 2 3 4 5 6 7 8 9 10 30 31

    public static int solve(int[] dp, int[] days, int[] costs, int currDay) {
        if (currDay > days[days.length - 1]) {
            return 0;
        }
        if (!isTravelNeeded.contains(currDay)) {
            return solve(dp, days, costs, currDay + 1);
        }
        if (dp[currDay] != -1) {
            return dp[currDay];
        }

        int oneDay = costs[0] + solve(dp, days, costs, currDay + 1); //  24
        int sevenDay = costs[1] + solve(dp, days, costs, currDay + 7); // 21
        int thirtyDay = costs[2] + solve(dp, days, costs, currDay + 30); // 30

        // Store the cost with the minimum of the three options.
        return dp[currDay] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1]; // 31
        int dp[] = new int[lastDay + 1]; //32
        Arrays.fill(dp, -1);
        for (int day : days) {
            isTravelNeeded.add(day);
        }
        return solve(dp, days, costs, 1);
    }


    public static void main(String[] args) {
        int[] days = { 1,2,3,4,5,6,7,8,9,10,30,31}, cost = { 2,7,15};
        System.out.println(mincostTickets(days, cost));
    }
}