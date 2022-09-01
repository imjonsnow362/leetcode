class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        //this will store the next greater element in nums2
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            //nums2 element is bigger than top element in the stack 
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                //If nums2[i] is bigger than top element in the stack then we just pop it 
                Integer top = stack.pop();
                //We are going to insert the currentElement and top element in the stack 
                map.put(top, nums2[i]);
            }
            stack.push(nums2[i]);
        }
            //It is possible that we have elements left in the stack 
            while(!stack.isEmpty()){
                //this is when we dont find the element in nums2 or the number is the highest value or the number is present on the last index of nums2
                Integer top = stack.pop();
                map.put(top, -1);
            }
            //resultant array initialisation 
            int[] res = new int[nums1.length];
            for(int i=0; i < nums1.length; i++){
                res[i] = map.get(nums1[i]);    
            }
        return res;
    }
}