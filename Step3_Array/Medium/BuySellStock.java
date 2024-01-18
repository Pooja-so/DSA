package Step3_Array.Medium;

import java.util.Scanner;

public class BuySellStock{
    public static long[] solution1(int a[], int n){
        long maxProfit = 0;
        int buyDay = 0;
        int sellDay = 0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(a[j]>a[i]){
                    // maxProfit = Math.max(maxProfit, (a[j]-a[i]));
                    if((a[j]-a[i]) > maxProfit){
                        buyDay = i;
                        sellDay = j;
                        maxProfit = (a[j]-a[i]);
                    }
                }
            }
        }
        
        long[] profit = new long[3];
        profit[0] = maxProfit;
        profit[1] = buyDay+1;
        profit[2] = sellDay+1;

        return profit;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print(" Enter " + n + " elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        long[] profit = solution1(arr, n);

        if(profit[0] == 0){
            System.out.println(" Buy and sell stock on the same day.");
        } else 
        {    System.out.println(" Buy stock on day: "+ profit[1] + "\n Sell stock on day: "+ profit[2] + "\n Maximum profit: " + profit[0]);
        }
        sc.close();
    }
}