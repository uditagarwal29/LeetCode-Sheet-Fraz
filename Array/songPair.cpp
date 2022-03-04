#include <bits/stdc++.h>
using namespace std;

int main()
{
    vector<int> time{30, 20, 150, 100, 40};
    vector<int> pairval;
    int pairs = 0;
    int zeroCount = 0;
    for (int i = 0; i < time.size(); i++)
    {
        if (time[i] < 60)
        {
            pairval.push_back(60 - time[i]);
        }
        else if (time[i] > 60)
        {
            pairval.push_back(60 - (time[i] % 60));
        }
        else if (time[i] % 60 == 0)
        {
            pairval.push_back(0);
            zeroCount += 1;
            // find combination on   zeroCount(C)2 to get pair of values that are divisible by 60 and can make pairs with
            // values that are divisible with 60 only
        }
    }

    // for (int i = 0; i < pairval.size(); i++)
    //     cout << pairval[i] << " ";
    // cout << endl;

    map<int, int> M;
    for (int i = 0; i < time.size(); i++)
    {
        if (M.find(time[i]) == M.end())
        {
            M[time[i]] = 1;
        }
        else
        {
            M[time[i]]++;
        }
    }

    for (int i = 0; i < time.size(); i++)
    {
        if (time[i] == pairval[i] && M[time[i]] > 1)
        {
            cout << "if.." << endl;
            cout << "time[i] : " << time[i] << " pairval[i] : " << pairval[i] << endl;
            pairs += 1;
        }
        else if (time[i] != pairval[i])
        {
            cout << "else..." << endl;
            cout << "time[i] : " << time[i] << " pairval[i] : " << pairval[i] << endl;
            if (M.find(pairval[i]) != M.end())
            {
                pairs += 1;
                M[time[i]] = pairval[i];
            }
        }
        cout << "-------------------" << endl;
    }
    cout << "Answer : " << pairs << endl;
}