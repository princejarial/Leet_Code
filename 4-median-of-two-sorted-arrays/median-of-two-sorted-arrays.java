class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<n1;i++)
            list.add(nums1[i]);

        for(int n : nums2)
            list.add(n);
        
        Collections.sort(list);
        int n = list.size();
        double med=0;

        if (n % 2 != 0) {
            return list.get(n / 2);
        } else {
            return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
        }
    }
}
