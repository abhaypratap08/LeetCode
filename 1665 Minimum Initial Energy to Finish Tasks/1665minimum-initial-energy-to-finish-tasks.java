class Solution {
    public int minimumEffort(int[][] tasks) {

        // sort by (minimum - actual) in descending order
        Arrays.sort(tasks, (a, b) ->
            (b[1] - b[0]) - (a[1] - a[0])
        );

        long ans = 0;
        long energy = 0;

        for (int[] task : tasks) {

            int actual= task[0];
            int minimum = task[1];

            // increase energy if current energy is less
            if (energy < minimum) {
                ans += (minimum - energy);
                energy = minimum;
            }

            // perform current task
            energy -= actual;
        }

        return (int) ans;
    }
}