class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        for (int i = 0; i < n; i++) {
            while (st.peek() != -1 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            prevSmaller[i] = st.peek();
            st.push(i);
        }

        st.clear();
        st.push(-1);

        for (int i = n - 1; i >= 0; i--) {
            while (st.peek() != -1 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nextSmaller[i] = (st.peek() == -1) ? n : st.peek();
            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] histogram = new int[cols];
        int answer = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1')
                    histogram[j]++;
                else
                    histogram[j] = 0;
            }
            answer = Math.max(answer, largestRectangleArea(histogram));
        }

        return answer;
    }
}