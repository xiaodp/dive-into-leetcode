public class SubPalStr {

        public String findSubPalString(String string){
            String maxPal = "";
            int length = string.length();
            boolean[][] P = new boolean[length][length];
            int maxLen = 0;
            for(int len = 1; len <= length;len++){
                for(int start=0;start < length;start++){
                    int  end = start + len - 1;
                    if (end >= length) break;
                    P[start][end] = (len==1 || len ==2 || P[start+1][end-1]) && string.charAt(start) == string.charAt(end);
                    if (P[start][end] && len >= maxLen){
                        maxLen = len;
                        maxPal = string.substring(start,end+1);
                    }
                }
            }
            return maxPal;
        }
}
