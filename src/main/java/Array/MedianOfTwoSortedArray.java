package Array;

/**
 * MedianOfTwoSortedArray.java:
 *
 * @author zefan.szf on 2016-07-09 19:25
 */
public class MedianOfTwoSortedArray {

    public static void main(String... args) {
        MedianOfTwoSortedArray me = new MedianOfTwoSortedArray();
        int[] nums1 = {1};
        int[] nums2 = {2,3,4,5,6};
        System.out.println(me.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length+nums2.length) % 2 == 1) {
            return findKthNumberOfTwoSortedArrrys(nums1, 0, nums2, 0, (nums1.length+nums2.length)/2+1);
        } else {
            return (findKthNumberOfTwoSortedArrrys(nums1, 0, nums2, 0, (nums1.length+nums2.length)/2)
                    + findKthNumberOfTwoSortedArrrys(nums1, 0, nums2, 0, (nums1.length+nums2.length)/2+1))/2.0;
        }
    }

    public double findKthNumberOfTwoSortedArrrys(int[] nums1, int pos1, int[] nums2, int pos2, int k) {
        if ((nums1.length-pos1) > (nums2.length-pos2)) {
            return findKthNumberOfTwoSortedArrrys(nums2, pos2, nums1, pos1, k);
        }
        if (pos1 > nums1.length-1) {
            return nums2[pos2+k-1];
        }
        if (k == 1) {
            return nums1[pos1] < nums2[pos2] ? nums1[pos1] : nums2[pos2];
        }

        // size1 indicate the duplicated length of array nums1 when if condition is satisfied
        int size1 = (nums1.length-pos1) >= k/2 ? k/2 : nums1.length-pos1, size2 = k-size1;
        if (nums1[size1+pos1-1] < nums2[size2+pos2-1]) {
            return findKthNumberOfTwoSortedArrrys(nums1, size1+pos1, nums2, pos2, k-size1);
        } else if (nums1[size1+pos1-1] > nums2[size2+pos2-1]) {
            return findKthNumberOfTwoSortedArrrys(nums1, pos1, nums2, size2+pos2, k-size2);
        } else {
            return nums1[size1+pos1-1];
        }
    }

    // the run time complexity of this solution is O(m+n), not optimal
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int medIdx = (nums1.length+nums2.length+1)/2;
//        int idx1 = 0, idx2 = 0;
//        while (idx1 + idx2 + 1 < medIdx) {
//            if (nums1[idx1] <= nums2[idx2]) {
//                idx1++;
//            } else {
//                idx2++;
//            }
//        }
//        if ((nums1.length+nums2.length) % 2 == 1) {
//            if (nums1[idx1] <= nums2[idx2]) {
//                return nums1[idx1];
//            } else {
//                return nums2[idx2];
//            }
//        } else {
//            if (nums1[idx1] < nums2[idx2]) {
//                if (idx1 < nums1.length-1 && nums1[idx1+1] < nums2[idx2]) {
//                    return (nums1[idx1]+nums1[idx1+1])/2.0;
//                } else {
//                    return (nums1[idx1]+nums2[idx2])/2.0;
//                }
//            } else {
//                if (idx2 < nums2.length-1 && nums2[idx2+1] < nums1[idx1]) {
//                    return (nums2[idx1]+nums2[idx1+1])/2.0;
//                } else {
//                    return (nums1[idx1]+nums2[idx2])/2.0;
//                }
//            }
//        }
//    }
}
