public class CostOfTicket {

    public static int mincostTickets(int[] days, int[] costs) {
        /*
        costs: [1 day - 2] [7 day- 7] [30 day - 15]
        days : 1 4 6 7 8 20
               2 ------- 2
                    7  
        days : 1,2,3,4,5,6,7,8,9,10,30,31
               ----------------------- 2
                       15
        divide the days 12 to form 12 months 
        for each month travel days > 14 days buy month pass for that month
        for each month travel < 15 days and > 3 days buy week pass
        remaining days buy day pass
        */
        int result = 0, i = 0, currentDaysCount = 0, startDay=days[0];
        while(i < days.length-1){
            while(startDay - days[i] < 30 && days[i] % 30 !=0 && i < days.length-1){
                currentDaysCount++;
                i++;
            }
            int diff = days[i] - startDay;  
            if(currentDaysCount > 14 && diff > 15){ //10days
                result += costs[2];
            }
            if(currentDaysCount > 7 && currentDaysCount < 15){
                result += costs[1];
                if(diff > 7 && diff < 11){
                    diff -= 7;
                }else if(diff > 11){
                    result += costs[1];
                }
            }
            if(currentDaysCount < 7 || diff < 3){ //10days
                result += costs[0] * currentDaysCount;
            }
            if(i == days.length){
                return result;
            }
            i++;
            startDay = days[i];
            currentDaysCount = 0;
        }
        return result;
    }


    public static void main(String[] args) {
        //            0 1 2 3 4 5 6 7 8 9  10 11
        int[] days = {1,4,6,7,8,20}, costs = {2,7,15};
        System.out.println("Cost: "+mincostTickets(days, costs));
    }
    
}
