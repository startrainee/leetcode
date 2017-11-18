package findnum;

public class FindNumber {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };
        int targetNum = 7;
        System.out.println(findNum(array,targetNum));
    }

    private static boolean findNum(int[][] array, int targetNum) {
        for (int[] array_1 : array){
            for(int num : array_1){
                if(num > targetNum){
                    break;
                }
                if(num == targetNum){
                    return true;
                }
            }
        }
        return true;
    }
}
