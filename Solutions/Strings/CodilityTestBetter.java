

class CodilityTest {


    public int solution(int A, int B) {
            //Sticks are too short to use 
            if(A + B < 4) return 0;

            int large = Math.max(A, B);
            int small = Math.min(A, B);


             // Split one stick into 4 pieces
            if(large / 4 >= small) {
                return large / 4;
            }

            // Split large stick into 3 and check if small stick can give 4th piece
            int thirds = 0;
            if(large / 3 <= small) {
                thirds = large / 3;
            }

            // Split both sticks into 2 pieces
            int quarters = small / 2;
          

        
        return Math.max(thirds, quarters);
    }
    
}