class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int width = Math.max(bill[0], bill[1]);
        int height = Math.min(bill[0], bill[1]);
        int walletWidth = Math.max(wallet[0], wallet[1]);
        int walletHeigth = Math.min(wallet[0], wallet[1]);
        while(width > walletWidth || height > walletHeigth) {
            if(bill[0] > bill[1]) {
                bill[0] = bill[0] / 2;
            } else {
                bill[1] = bill[1] / 2;
            }
            width = Math.max(bill[0], bill[1]);
            height = Math.min(bill[0], bill[1]);
            answer ++;
        }
        
        return answer;
    }
}