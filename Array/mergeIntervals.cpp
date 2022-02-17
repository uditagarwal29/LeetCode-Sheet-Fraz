#include <bits/stdc++.h>
using namespace std;

//TLE last case
int main()
{
    vector<vector<int>> intervals {{1, 3}, {2, 6}, {8,11}, {11, 12}, {15, 18}};
    sort(intervals.begin(), intervals.end());
    vector<vector<int>> result;
    result.push_back(intervals[0]);
    int p1 = 1;
    int i = 0;
    while (p1 < intervals.size())
    {
        if (intervals[p1][0] <= result[i][1] )
        {
            //merge
            result[i][0] = min(intervals[p1][0], result[i][0]);
            result[i][1] = max(intervals[p1][1], result[i][1]);
        }
        else
        {
            i++;
            result.push_back(intervals[p1]);
        }
        p1++;
    }

    for (int i = 0; i < result.size(); i++)
    {
        cout << " {" << result[i][0] << " , " << result[i][1] << "} ";
    }
}