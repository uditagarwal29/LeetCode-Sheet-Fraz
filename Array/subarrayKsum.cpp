#include <bits/stdc++.h>
using namespace std;


int main()
{
    vector<int> nums{1, 2, 3, 4, 5};
    vector<int> csum;
    int k = 9;
    int tempsum = 0;
    unordered_map<int, int> sums;

    for (int i = 0; i < nums.size(); i++)
    {
        tempsum += nums[i];
        csum.push_back(tempsum);
    }

    for (int val : csum)
    {
        cout << val << " ";
    }
    cout << endl;

    int count = 0;

    for (int i = 0; i < csum.size(); i++)
    {
        if (csum[i] == k)
        {
            // cout << "1st : " << csum[i] << endl;
            count++;
        }

        if (sums.find(csum[i] - k) != sums.end())
        {
            // cout << "2nd : " << csum[i] << endl;
            count += sums[csum[i] - k];
        }

        sums[csum[i]]++; // This condition is used to take count of repetitive sums which occurs only if array has consecutive 0's
                         // e.g arr=[0,0,0,0,0]  ,  csum = [0,0,0,0,0] , map = {0:1, 0:2,0:3, 0:4, 0: 5}
                         // for rest of the cases , it is 1   e.g
                         // arr = [1,2,3,4], csum = [1,3,6,10], map={1:1, 2:1, 3:1, 4:1}
    }

    for (auto i : sums)
        cout << i.first << "  : " << i.second
             << endl;

    cout << "Count : " << count << endl;
}

//Brute Force
// class Solution {
// public:
//     int subarraySum(vector<int>& nums, int k) {
//     //calculate cumulative sum
//     vector<int> csum;
//     csum.push_back(0);
//     int tempsum = 0;
//     for (int i = 0; i < nums.size(); i++)
//     {
//         tempsum += nums[i];
//         csum.push_back(tempsum);
//     }


//     int p1 = 1;
//     int p2 = 1;
//     int currSum = 0;
//     int count = 0;
//     while (p1 <= nums.size())
//     {
        
//         currSum = csum[p2] - csum[p1 - 1];
//         if (currSum == k)
//         {
//             count++;
//             p2++;
//         }
        
//         else
//         {
//             p2++;
//         }
        
//         if (p2 > nums.size())
//         {
//             p1++;
//             p2 = p1;
//         }

//     }
  
//         return count;
//     }
// };
