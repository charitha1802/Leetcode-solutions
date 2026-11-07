import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        // Free servers: ordered by weight ASC, then index ASC
        // int[] format: {weight, index}
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        // Busy servers: ordered by free_time ASC, then weight ASC, then index ASC
        // int[] format: {freeTime, weight, index}
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[]{servers[i], i});
        }

        int currTime = 0;

        for (int j = 0; j < m; j++) {
            currTime = Math.max(currTime, j);

            // Fast-forward time if all servers are currently busy
            if (freeServers.isEmpty()) {
                currTime = busyServers.peek()[0];
            }

            // Move completed servers back to free pool
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currTime) {
                int[] server = busyServers.poll();
                freeServers.offer(new int[]{server[1], server[2]});
            }

            // Assign best server
            int[] chosenServer = freeServers.poll();
            ans[j] = chosenServer[1];

            busyServers.offer(new int[]{currTime + tasks[j], chosenServer[0], chosenServer[1]});
        }

        return ans;
    }
}