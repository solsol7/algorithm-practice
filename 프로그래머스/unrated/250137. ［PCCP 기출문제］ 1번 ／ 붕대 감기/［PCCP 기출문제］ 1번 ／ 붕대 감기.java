class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = bandage[0]; // 붕대감기 시간
        int recovery = bandage[1]; // 체력회복 정도
        int bnsHealth = bandage[2]; // 보너스 체력

        // 마지막 공격시간 구하기
        int leng = attacks.length;
        int lastAttackTime = attacks[leng-1][0];
        
        int cnt = 0;
        int successCnt = 0; // 성공 횟수
        int totalHealth = health;
        // 마지막 공격 시간만큼 for문 돌리기
        for(int i=1; i<=lastAttackTime; i++){

        	if(i==attacks[cnt][0]) {
        	// 공격 당했을 때
        		totalHealth -= attacks[cnt][1];
        		cnt++;
        		successCnt = 0;
        	}else{
        	// 공격 당하지 않았을 때
        		totalHealth += recovery;
        		successCnt++;
        	}
        	
        	// 총 체력이 0 이하가 됐을 때
        	if(totalHealth <= 0) {
        		totalHealth = -1;
        		break;
        	}
        	
        	if(successCnt == time) {
        		// 모두 성공했을 때
        		totalHealth += bnsHealth;
        		successCnt = 0;
        	}
        	
        	// 총 체력이 최대 체력을 넘었다면
        	if(totalHealth > health) {
        		totalHealth = health;
        	}
           
        }
        
        return totalHealth;
    }
}