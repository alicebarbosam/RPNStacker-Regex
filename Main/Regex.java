package Main;

public class Regex {
	
	
	public static boolean isNum (String token) {
        return token.matches("[0-9]+");
    }
	
	public static boolean isOp (String token) {
        return token.matches("[+-/*]");
    }

    public static boolean isPlus (String token) {
        return token.matches("[+]");
    }

    public static boolean isMinus (String token) {
        return token.matches("[-]");
    }

    public static boolean isSlash (String token) {
        return token.matches("[/]");
    }
    

}