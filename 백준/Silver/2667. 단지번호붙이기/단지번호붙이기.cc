#include <cstdio>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int d[25][25];
const int dx[] = {1, -1, 0, 0};
const int dy[] = {0, 0, 1, -1};
bool chk[25][25];

int main() {
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%1d", &d[i][j]);
        }
    }
    vector<int> ans;
    queue<pair<int, int>> q;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            // 새로운 단지를 찾았을 때,
            if (!chk[i][j] && d[i][j] == 1) { // chk에 false d에 1이면;
                int cnt = 1;
                q.push(make_pair(i, j));
                chk[i][j] = true;
                while (!q.empty()) {
                    int x = q.front().first;
                    int y = q.front().second;
                    q.pop();
                    for (int i = 0; i < 4; i++) {
                        int nx = dx[i] + x;
                        int ny = dy[i] + y;
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            if (!chk[nx][ny] && d[nx][ny] == 1) {
                                q.push(make_pair(nx, ny));
                                chk[nx][ny] = true;
                                cnt += 1;
                            }
                        }
                    }
                }
                ans.push_back(cnt);
            }
        }
    }
    // 각 단지내 집의 수를 오름차순으로 정렬
    sort(ans.begin(), ans.end());
    // 단지의 개수 출력
    printf("%d\n", ans.size());
    for (int i = 0; i < ans.size(); i++) {
        printf("%d\n", ans[i]);
    }
    return 0;
}
