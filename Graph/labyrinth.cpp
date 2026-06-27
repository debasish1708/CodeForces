#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

using pii = pair<int,int>;

const vector<char> DIRECTIONS = {'U', 'R', 'D', 'L'};
const vector<int> dRow = {-1, 0, 1, 0};
const vector<int> dCol = {0, 1, 0 , -1};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int n, m;
    cin >> n >> m;
    vector<string> grid(n);
    for(int i=0;i<n;i++) cin >> grid[i];

    vector<vector<bool>> visited(n, vector<bool>(m, false));
    vector<vector<char>> prevDirection(n, vector<char>(m, 0));

    pii start, end;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]=='A') start = {i,j};
            else if(grid[i][j]=='B') end = {i,j};
        }
    }

    queue<pii> q;
    visited[start.first][start.second]=true;
    q.push(start);

    bool found = false;

    while(!q.empty() && !found){
        pii curr = q.front();
        int row = curr.first;
        int col = curr.second;
        q.pop();

        for(int i=0;i<4;i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && !visited[newRow][newCol] && grid[newRow][newCol]!='#'){
                visited[newRow][newCol]=true;
                prevDirection[newRow][newCol]=DIRECTIONS[i];
                q.push({newRow,newCol});

                if(make_pair(newRow, newCol)==end){
                    found=true;
                    break;
                }
            }
        }
    }

    if(!found){
        cout << "NO\n";
        return 0;
    }

    string path;
    pii currect = end;

    while(currect!=start){
        char dir = prevDirection[currect.first][currect.second];
        path.push_back(dir);

        int index = find(DIRECTIONS.begin(), DIRECTIONS.end(), dir) - DIRECTIONS.begin();
        currect.first -= dRow[index];
        currect.second -= dCol[index];
    }
    
    reverse(path.begin(), path.end());
    
    cout << "YES\n";
    cout << path.size() << "\n";
    cout << path << "\n";

    return 0;
}