class Solution {
    public int tupleSameProduct(int[] nums) {
        int N=nums.length;
        int res=0;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                map.put(nums[i]*nums[j], map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        for(Map.Entry<Integer, Integer> enty:map.entrySet()){
            if(enty.getValue()>=2){
                int n=enty.getValue();
                res+=8*(n*(n-1)/2);    
            }
        }
        return res;
    }
}