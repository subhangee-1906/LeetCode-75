package Day2;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int planted = 0;
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                boolean prevEmpty = i == 0 || flowerbed[i - 1] == 0;
                boolean nextEmpty = i == len - 1 || flowerbed[i + 1] == 0;
                if (prevEmpty && nextEmpty) {
                    flowerbed[i] = 1;
                    planted++;
                    if (planted >= n) return true;  
                }
            }
        }
        return planted >= n;
    }
}

