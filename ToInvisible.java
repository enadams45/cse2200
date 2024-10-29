public class ToInvisible {
    public static void main(String[] args) {
        String msg = "Hello";
        String invisibleMsg = makeInvisible(msg);
        System.out.println(invisibleMsg);
    }

    static String makeInvisible(String msg) {
        StringBuilder invisibleMsg = new StringBuilder();
        for(char c:msg.toCharArray()) {
            String binString = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
            for(char binChar:binString.toCharArray()) {
                if(binChar == '1') {
                    invisibleMsg.append(' ');
                }
                else invisibleMsg.append('\t');
            }
        }
        return invisibleMsg.toString();
    }
}
