class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids){
            boolean isDestroyed = false;
            while (!stack.isEmpty() && stack.peek()>0 && i < 0){
                if (stack.peek() < -i){
                    stack.pop();
                    continue;
                } else if (stack.peek() == -i){
                    stack.pop();
                }
                isDestroyed = true;
                break;
            }
            if (!isDestroyed) {
                stack.push(i);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}   