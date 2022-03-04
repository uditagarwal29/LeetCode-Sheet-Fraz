#include <bits/stdc++.h>
using namespace std;


//o(N) time complexity
int main()
{
    vector<int> nums{1, 3, 1, 5, 3};
    int k = 0;
    int pairs = 0;
    unordered_map<int, int> mp;
    for (int i = 0; i < nums.size(); i++)
    {
        mp[nums[i]]++;
    }
    for (auto x : mp)
    {
        if (k == 0)
        {
            if (x.second > 1)
            {
                pairs++;
            }
        }
        else if (mp.find(x.first + k) != mp.end())
        {
            pairs++;
        }
    }

    cout << pairs;
}


// nLog n -> My method using set and maps
// int main()
// {
//     vector<int> nums{1, 3, 1, 5, 3};
//     int k = 0;
//     int pairs = 0;
//     if (k == 0)
//     {
//         unordered_map<int, int> mp;

//         for (int i = 0; i < nums.size(); i++)
//             mp[nums[i]]++;

//         for (auto x : mp)
//         {
//             if (x.second > 1)
//             {
//                 pairs++;
//             }
//         }
//     }
//     else
//     {
//         set<int> set(nums.begin(), nums.end());
//         for (const int &i : set)
//         {
//             if (set.find(i + k) != set.end())
//             {
//                 pairs++;
//             }
//         }
//     }

//     cout << pairs;
// }
