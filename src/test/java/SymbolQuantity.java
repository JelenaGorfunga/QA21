import org.junit.jupiter.api.Test;

public class SymbolQuantity {

    @Test
    public void symbolQuantity() {
    String helloWorld = "Hello World!";
    String[] wordsInString = helloWorld.split(" ", 10);

    System.out.println("There are " + helloWorld.length() + " symbols in the string.");
    System.out.println("There are " + wordsInString.length + " words in the string.");
    }
}