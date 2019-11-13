import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author xiaodp
 * @date 2019/9/16 21:14
 */
public class Sum {

    public static void main(String[] args) {
        Sum sum = new Sum();
        System.out.println(sum.letterCombinations("235"));

    }

//    public int sum(){
////        Scanner scanner = new Scanner(System.in);
////        int sum = 0;
////        if(scanner.hasNext()){
////            String s = scanner.nextLine();
////            String[] num = s.split(" ");
////            for (String n : num
////            ) {
////                sum += Integer.parseInt(n);
////            }
////        }
////        return sum;
////    }

    String[] dict = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length()==0){
            return res;
        }
        backTracking(new StringBuilder(),digits,0,res);
        return res;

    }
    private void backTracking(StringBuilder temp, String digits, int index, List<String> res){
        if(temp.length() == digits.length()){
            res.add(temp.toString());
            return;
        }
        for(int i=0;i<dict[digits.charAt(index) - '0'].length();i++){
            temp.append(dict[digits.charAt(index)-'0'].charAt(i));
            backTracking(temp,digits,index+1,res);
            if(temp.length()>0){
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

}
