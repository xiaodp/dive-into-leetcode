/**
 * @author xiaodp
 * @date 2019/8/27 22:49
 */
public class InvertBit {

    public int reverse(int x) {

        int y = 0;

        int pop = 0;
        int ans = x;
        int result = 0;

        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;


        while(ans!=0){
            pop = ans % 10;
            ans = ans / 10;

            if(result > INT_MAX/10 || (result == INT_MAX/10 && pop > 7) ) return 0;
            if(result < INT_MIN/10 || (result == INT_MIN/10 && result < -8)) return 0;
            result = result * 10 + pop;
        }
        return result;
    }

    public int reverseBits1(int n) {
        int result = 0;
        for (int i = 0; i <= 32; i++) {
            // 1. 将给定的二进制数,由低到高位逐个取出
            // 1.1 右移 i 位,
            int tmp = n >> i;
            // 1.2  取有效位
            tmp = tmp & 1;
            // 2. 然后通过位运算将其放置到反转后的位置.
            tmp = tmp << (31 - i);
            // 3. 将上述结果再次通过运算结合到一起
            result |= tmp;
        }
        return result;
    }

    public int reverseBits(int n) {
        int res = 0;
        int pop = 0;
        for(int i=0;i<32;i++){
            pop = n & 1;
            n >>= 1;
            res <<=1;
            res += pop;
        }
        return res;
    }
    public static void main(String[] args) {
       System.out.println( new InvertBit().reverseBits1(55));
    }

}
