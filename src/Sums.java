import sun.java2d.pipe.AAShapePipe;

import java.util.*;

/**
 * @author xiaodp
 * @date 2019/10/12 16:42
 */
public class Sums {

    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> lists = new ArrayList<>();
//        if(nums.length == 0) return lists;
//        Arrays.sort(nums);
//        int k = 0;
//        while(k < nums.length - 2){
//            if(k>0&&nums[k]==nums[k-1]) continue;
//            int i = k+1;
//            int j = nums.length - 1;
//            while(i<j){
//                int sum =nums[i] + nums[j] + nums[k];
//                if(sum < 0) i++;
//                else if (sum > 0) j--;
//                else{
//                    while(i<j&&nums[i]==nums[i+1]) i++;
//                    while(i<j&&nums[j]==nums[j-1]) j--;
//                    List<Integer> list = new ArrayList<>();
//                    list.add(nums[k]);
//                    list.add(nums[i++]);
//                    list.add(nums[j--]);
//                    lists.add(list);
//                }
//            }
//            k++;
//        }
//        return lists;
        List<List<Integer>> lists = new ArrayList<>();
        if(nums.length == 0) return lists;
        Arrays.sort(nums);
        for(int k =0;k < nums.length - 2;k++){
            if(k>0&&nums[k]==nums[k-1]) continue;
            int l = k+1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[l] + nums[r] + nums[k];
                if (sum < 0) l++;
                else if(sum > 0) r--;
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(k);
                    list.add(l);
                    list.add(r);
                    lists.add(list);
                    while(l < r && nums[l] == nums[l + 1]) l++;
                    while(l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                }
                Arrays.asList(1,2);
            }
        }
        return lists;
    }

    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        if(nums.length == 0) return -1;
        int min = Math.abs(nums[0] +nums[1] + nums[2] -target);
        for(int k = 0 ;k < nums.length - 2;k++){
            if(k > 0 && nums[k] == nums[k-1]) k++;
            int l = k + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[l] + nums[k] + nums[r];
                if(min > Math.abs(sum - target)) {
                    min = Math.abs(sum - target);
                    res = sum;
                }
                if(sum < target) {l++;}

                else r--;
            }
        }
        return res;
    }


    public int[] twoSum(int[] nums, int target) {
        Map register = new HashMap();
        int[] result = null;
        for(int i = 0; i < nums.length;i++){
            if(register.containsKey(nums[i])){
                result = new int[]{(int) register.get(nums[i]),i};
            }else{
                register.put(target-nums[i],i);
            }
        }
        return result;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> res = new HashSet<>();
        Map<Integer,List<List<Integer>>> map = new HashMap<>();
        Arrays.sort(nums);

        for(int i = 0;i < nums.length - 1;i++){
            for(int j = i+1; j < nums.length;j++){
                int sum = nums[i] + nums[j];
                if (map.containsKey(sum)){
                    List tmp = map.get(sum);
                    tmp.add(Arrays.asList(i,j));
                    map.put(sum,tmp);
                }else{
                    List<List<Integer>> tmp = new ArrayList<>();
                    tmp.add(Arrays.asList(i,j));
                    map.put(sum,tmp);
                }
            }
        }
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                int sum = target - (nums[i] + nums[j]);
                if(map.containsKey(sum)){
                    for(List indexes : map.get(sum)){
                        int i0 = (int) indexes.get(0);
                        int j0 = (int) indexes.get(1);
                        if(i0 != i && j0 != j && i0 != j && j0 != j){
                            List<Integer> tmp = Arrays.asList(nums[i0],nums[j0],nums[i],nums[j]);
                            tmp.sort(Comparator.comparingInt(o -> o));
                            res.add(tmp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(res);
//
//            HashMap<Integer, List<List<Integer>>> t = new HashMap<>();
//            HashSet<List<Integer>> ret = new HashSet<>();
//            Arrays.sort(nums);
//            int n = nums.length;
//
//            int start = 0;
//            int end = n-1;
//            for (int i = start; i <= end-1; i++){
//                for (int j = i+1; j <= end; j++){
//                    int s = nums[i] + nums[j];
//                    List<Integer> tmp = new ArrayList<>();
//                    tmp.add(i);
//                    tmp.add(j);
//                    if (t.containsKey(s)){
//                        // TODO:
//                        List<List<Integer>> tmp1 = t.get(s);
//                        tmp1.add(tmp);
//                        t.put(s, tmp1);
//                    } else {
//                        // TODO:
//                        List<List<Integer>> tmp1 = new ArrayList<>();
//                        tmp1.add(tmp);
//                        t.put(s, tmp1);
//                    }
//                }
//            }
//
//            start = 0;
//            end = n-1;
//            for (int i = start; i <= end-1; i++){
//                for (int j = i+1; j <= end; j++){
//                    int s = target-(nums[i] + nums[j]);
//                    if (t.containsKey(s)){
//                        // TODO:
//                        for (List<Integer> pairs: t.get(s)){
//                            int k = pairs.get(0);
//                            int l = pairs.get(1);
//                            if (j != k && j != l && i != k && i != l){
//                                List<Integer> tmp = new ArrayList<>();
//                                tmp.add(nums[k]);
//                                tmp.add(nums[l]);
//                                tmp.add(nums[i]);
//                                tmp.add(nums[j]);
//                                tmp.sort(Comparator.comparingInt(o -> o));
//                                ret.add(tmp);
//                            }
//                        }
//                    }
//                }
//            }
//            return new ArrayList<>(ret);


    }

    public static void main(String[] args) {
        Sums sums = new Sums();
        int[] nums = new int[]{-3,-1,0,2,4,5};
//        System.out.println(sums.threeSumClosest(nums,0));
        for (List li :
                sums.fourSum(nums,0)) {
            System.out.println(li);
        }

    }

}
