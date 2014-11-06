package linearTabel.arrays;

/**
 * 类GasStation.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月6日 上午11:53:22
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int index = -1;
        for(int i = 0, sum = 0; i < gas.length; ++i) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(sum < 0) {
                index = i;
                sum = 0;
            }
        }
        return total >= 0 ? index+1 : -1;
    }
    public static void main(String... args) {
        int[] gas = {5};
        int[] cost = {4};
        GasStation gs = new GasStation();
        System.out.println(gs.canCompleteCircuit(gas, cost));
    }
}
