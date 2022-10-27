package Main;

public class UnexpectedCharacterException extends Exception{
  public UnexpectedCharacterException(String character){ super("Unexpected character: " + character);}
}
