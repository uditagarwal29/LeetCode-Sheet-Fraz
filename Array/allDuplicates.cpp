#include <bits/stdc++.h>
using namespace std;
// for explanation check allDuplicates.jpeg
int main()
{
    vector<int> nums{4, 3, 2, 7, 8, 8, 3, 1};
    nums.push_back(nums.size() + 1); // one extra space for nth element, but we wont iterate through this, this is used to mark
                                     //  it negativ to identify if the nth element (= length of array) has a duplicate or not
    vector<int> ans;
    for (int i = 0; i < nums.size() - 1; i++)
    {
        // if its index is marked negative then it is duplicate
        if (nums[abs(nums[i])] < 0)
        {
            ans.push_back(abs(nums[i]));
        }
        // mark its index negative to show that we have already iterated through it.
        nums[abs(nums[i])] *= -1;
    }

    for (int i = 0; i < ans.size(); i++)
    {
        cout << ans[i] << " ";
    }
}
