package Main;

import java.util.*;
import java.io.*;

public class RPNSimple {
  private ArrayList<Token> tokens = new ArrayList<>();
  Regex regex;

  public void scan(FileReader file) throws UnexpectedCharacterException {
      try (Scanner in = new Scanner(file)) {
        while(in.hasNextLine()) {
              Token digito;
              String expressao = in.nextLine();
              if(Regex.isNum(expressao)){
                  digito = new Token(TokenType.NUM, expressao);
                  this.tokens.add(digito);
              }else if(Regex.isPlus(expressao)){
            	  digito = new Token(TokenType.PLUS, expressao);
                  tokens.add(digito);
              }else if(Regex.isMinus(expressao)){
            	  digito = new Token(TokenType.MINUS, expressao);
                  tokens.add(digito);
              }else if(Regex.isOp(expressao)){
            	  digito = new Token(TokenType.STAR, expressao);
                  tokens.add(digito);
              }else if(Regex.isSlash(expressao)){
            	  digito = new Token(TokenType.SLASH, expressao);
                  tokens.add(digito);
              }else {
            	  UnexpectedCharacterException error = new UnexpectedCharacterException(expressao);
                  throw error;
              }
               
                
              }
          }
    }
  

  public int run() throws UnexpectedOperatorException {
      Stack<Integer> RPNStacker = new Stack<>();
      for(Token token : this.tokens) {
          try{
              RPNStacker.push(Integer.parseInt(token.lexeme));
          }catch (NumberFormatException e){
              int x = 0, y = 0;
              y = RPNStacker.pop();
              x = RPNStacker.pop();

              switch (token.type){
                  case MINUS -> RPNStacker.push(x-y);
                  case PLUS -> RPNStacker.push(x+y);
                  case STAR -> RPNStacker.push(x*y);
                  case SLASH -> RPNStacker.push(x/y);
                  case NUM -> {}
                  case EOF -> {}
                  default ->  {
                      UnexpectedOperatorException error = new UnexpectedOperatorException(token.lexeme);
                      throw error;
                  }
              }
          }
      }
      return RPNStacker.get(0);
  }
  public static void main(String[] args) throws FileNotFoundException, UnexpectedCharacterException, UnexpectedOperatorException {
  
  RPNSimple rpnsimple = new RPNSimple();
  rpnsimple.scan(new FileReader("Calc1.stk"));
  int rpn = rpnsimple.run();
  System.out.println(rpn);
  
  }
}
