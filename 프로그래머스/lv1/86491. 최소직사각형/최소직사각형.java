class Solution {
    public int solution(int[][] sizes) {
		int answer = 0;

		int maxA = 0;
		int maxB = 0;
		for (int i = 0; i < sizes.length; i++) {
			int[] size = sizes[i];

			int a = size[0];
			int b = size[1];
			if (a >= b) {
				if (maxA < a) {
					maxA = a;
				}
				if (maxB < b) {
					maxB = b;
				}

			} else {
				if (maxA < b) {
					maxA = b;
				}
				if (maxB < a) {
					maxB = a;
				}
			}
		}

		answer = maxA * maxB;

		return answer;
	}
}