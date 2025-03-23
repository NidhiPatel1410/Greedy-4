// In this approach, two possible targets, either tops[0] or bottoms[0]. Trying to find the min rotations with one target first, if
// found than returning that. Else trying to find the min number of rotations with second target. If found with none, returning -1.

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // Base case
        if (tops.length != bottoms.length) {
            return -1;
        }
        // Call the method with tops[0] as target first
        int ans = findMinRot(tops, bottoms, tops[0]);
        // If found ans, then return that
        if (ans != -1) {
            return ans;
        }
        // Else call the method with bottoms[0] as the target
        return findMinRot(tops, bottoms, bottoms[0]);
    }

    private int findMinRot(int[] tops, int[] bottoms, int target) {
        // Declare aRot for keeping count of rotations required if trying to make the
        // all elements of tops as target
        int aRot = 0;
        // Declare bRot for keeping count of rotations required if trying to make the
        // all elements of bottoms as target
        int bRot = 0;
        // Loop over till size n
        for (int i = 0; i < tops.length; i++) {
            // Check if both the tops[i] and bottoms[i] is not target then we will never be
            // able to make all equal, so return -1
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }
            // If tops is not equal, so on tops array 1 rotation required, so add 1 to the
            // aRot
            if (tops[i] != target) {
                aRot++;
            }
            // If bottoms is not equal, so on bottoms array 1 rotation required, so add 1 to
            // the bRot
            if (bottoms[i] != target) {
                bRot++;
            }
        }
        // Return min of both
        return Math.min(aRot, bRot);
    }
}

// Another approach using a hashmap to keep the frequency count of all elements.
// As soon as frequency of any element becomes equal to n that means that may
// give us an answer. So call our findminRot method with this element as the
// target.

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if (tops.length != bottoms.length) {
            return -1;
        }
        int target = -1;
        int n = tops.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        // Loop and count all occurences of element from both tops and bottom and put in
        // map
        for (int i = 0; i < n; i++) {
            map.put(tops[i], map.getOrDefault(tops[i], 0) + 1);
            // As soon it becomes n, save that in target and break
            if (map.get(tops[i]) == n) {
                target = tops[i];
                break;
            }
            // Do same with bottoms
            map.put(bottoms[i], map.getOrDefault(bottoms[i], 0) + 1);
            if (map.get(bottoms[i]) == n) {
                target = bottoms[i];
                break;
            }
        }
        // Check target value is still -1, means no element with frequency n, so we will
        // never be able to achieve all equal, so return -1
        if (target == -1) {
            return -1;
        }
        // Else call our method with target
        return findMinRot(tops, bottoms, target);
    }

    private int findMinRot(int[] tops, int[] bottoms, int target) {
        int aRot = 0;
        int bRot = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }
            if (tops[i] != target) {
                aRot++;
            }
            if (bottoms[i] != target) {
                bRot++;
            }
        }
        return Math.min(aRot, bRot);
    }
}
