public class ToInvisible {
    public static void main(String[] args) {
        String msg = "Hello";
        String invisibleMsg = makeInvisible(msg);
        System.out.println("Encoded (Invisible): " + invisibleMsg);
        
        String decodedMsg = decodeInvisible(invisibleMsg);
        System.out.println("Decoded: " + decodedMsg);
    }

    static String makeInvisible(String msg) {
        StringBuilder invisibleMsg = new StringBuilder();
        for (char c : msg.toCharArray()) {
            String binString = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
            for (char bit : binString.toCharArray()) {
                if (bit == '1') {
                    invisibleMsg.append(' ');
                } else {
                    invisibleMsg.append('\t');
                }
            }
        }
        return invisibleMsg.toString();
    }

    static String decodeInvisible(String invisibleMsg) {
        StringBuilder decodedMsg = new StringBuilder();
        for (int i = 0; i < invisibleMsg.length(); i += 8) {
            StringBuilder binString = new StringBuilder();
            for (int j = i; j < i + 8; j++) {
                if (invisibleMsg.charAt(j) == ' ') {
                    binString.append('1');
                } else if (invisibleMsg.charAt(j) == '\t') {
                    binString.append('0');
                }
            }
            int charCode = Integer.parseInt(binString.toString(), 2);
            decodedMsg.append((char) charCode);
        }
        return decodedMsg.toString();
    }
}
