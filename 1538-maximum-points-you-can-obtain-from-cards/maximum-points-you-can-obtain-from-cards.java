class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left =0;
        for(int i=0;i<k;i++){
            left += cardPoints[i];
        }
        int maxScore = left;
        int right =0;

        for(int i=0;i<k;i++){
            left -= cardPoints[k-1-i];
            right += cardPoints[cardPoints.length - 1 - i];

            maxScore = Math.max(maxScore, left+right);
        }
        return maxScore;
    }
}