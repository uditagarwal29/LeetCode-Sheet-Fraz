class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {

    sort(nums.begin(), nums.end());

    int minDiff = INT_MAX;
    int ans = 0;

    for (int i = 0; i < nums.size() - 2; i++)
    {
        int s = i + 1;
        int e = nums.size() - 1;
        while (s < e)
        {
            int threeSum = nums[i] + nums[s] + nums[e];
            int currDiff = abs(target - threeSum);
            if (currDiff <= minDiff)
            {
                ans = threeSum;
                minDiff = min(minDiff, currDiff);
            }
            if (threeSum == target)
            {
                ans = target;
                return ans;
            }
            else if (threeSum < target)
            {
                s++;
            }
            else
            {
                e--;
            }
        }
    }
    return ans;
    }
};
