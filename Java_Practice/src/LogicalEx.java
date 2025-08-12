public class LogicalEx {
    public static void main(String[] args) {
        boolean isRaining = false;
        boolean hasUmbrella = true;

        if(isRaining &&  hasUmbrella){
            System.out.println("비오는데 우산있다 -> 나갈 수 있다");
        } else if(isRaining && !hasUmbrella){
            System.out.println("비오는데 우산 없어 못가요");
        } else {
            System.out.println("비가 안온다 ");
        }
    }
}
