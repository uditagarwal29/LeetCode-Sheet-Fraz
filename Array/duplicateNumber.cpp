#include <bits/stdc++.h>
using namespace std;
// O(n) --> Floyd Cycle Method (slow and fast pointer)
int main()
{
    vector<int> nums{3, 1, 3, 4, 2};

    int slow = nums[0];
    int fast = nums[nums[0]];
    while (fast != slow)
    {
        slow = nums[slow];
        fast = nums[nums[fast]];
    }
    slow = 0;
    while (slow != fast)
    {
        slow = nums[slow];
        fast = nums[fast];
    }
    cout << "Duplicate number : " << fast << endl;
}

// n(log n) --> Sorting
//  class Solution {
//  public:
//      int findDuplicate(vector<int>& nums) {
//          sort(nums.begin(), nums.end());
//          int ans =0;
//          for(int i=0; i<nums.size();i++){
//              if(nums[i]==nums[i+1]){
//                  ans= nums[i];
//                  return ans;
//              }
//          }
//          return ans;
//      }
//  };
