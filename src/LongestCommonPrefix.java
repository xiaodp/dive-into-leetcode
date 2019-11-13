/**
 * @author xiaodp
 * @date 2019/10/11 18:08
 */
public class LongestCommonPrefix {

//    public String longestCommonPrefix(String[] strs){
//        String lcp = null;
//        if(strs.length == 1) return strs[0];
//        if(strs.length == 0) return null;
//        lcp = lcp(strs, strs.length-1);
//        return lcp;
//     }
//
//    public String lcp(String[] strs,int hi) {
//        String s = null;
//        if (hi == 1){
//            s = comPrefix(strs[0],strs[1]);
//        }
//        else {
//            s = comPrefix(strs[hi],lcp(strs,--hi));
//        }
//        return s;
//    }
//
//    public String comPrefix(String s1,String s2){
//        int len = Math.min(s1.length(),s2.length());
//        int index = 0;
//        for(int i = 0; i < len;i++){
//            if(s1.charAt(i)==s2.charAt(i)){
//                index++;
//            }else
//                break;
//        }
//        return s1.substring(0,index);
//    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
