public class Main {
    public static void main(String[] args) {

        int[] coins = {2, 3, 5};
        int amount = 12;
        int[][] table = new int[coins.length][amount+1];

        for(int i = 0; i < coins.length; i++)
            table[i][0] = 1;

        for (int i = 1; i < amount+1; i++) {
            if (i % coins[0] == 0)
                table[0][i] = 1;

            else
                table[0][i] = 0;
        }

        for(int i = 1; i < coins.length; i++)
            for(int j = 1; j < amount+1; j++)
                if(j < coins[i])
                    table[i][j] = table[i-1][j];
                else
                    table[i][j] = table[i-1][j]+table[i][j-coins[i]];

        System.out.println(table[coins.length-1][amount]);
    }
}