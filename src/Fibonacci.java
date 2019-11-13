///**
// * @author xiaodp
// * @date 2019/8/29 10:41
// */
//public class Fibonacci {
//
//    public int[] getFibonacci(int n){
//
//        int[] fib = new int[n];
//        fib[0] = 1;
//        fib[1] = 1;
//        for(int i = 2;i<n;i++){
//            fib[i] = fib[i-1] + fib[i-2];
//        }
//        return fib;
//    }
//    public int getFibonacci2(int n){
//        int pre = 0;
//        int cur = 1;
//        while(n-- > 1){
//            cur = cur + pre;
//            pre = cur - pre;
//        }
//        return cur;
//    }
//
//    public static void main(String[] args) {
////        for (int i:new Fibonacci().getFibonacci(3)
////             ) {
////            System.out.println(i);
////        }
//
//        System.out.println(new Fibonacci().getFibonacci2());
//    }
//}
