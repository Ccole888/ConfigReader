import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class readconfig {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> bruh = readconfigFile();
        System.out.println(bruh);

    }

    public static HashMap<String, String> readconfigFile() throws IOException {
        HashMap<String, String> returnvalues = new HashMap<String, String>();
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("config.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\n");
                records.add(Arrays.asList(values));
            }
        }
        System.out.println(records.toString());
        for (int i = 0; i <= (records.size()-1); i++) {
            List<String> templist = records.get(i);
            String tempstring = templist.get(0);
            String[] parts = tempstring.split("=");
            parts[0] = parts[0].replace(" ", "");
            parts[1] = parts[1].replace(" ", "");
            returnvalues.put(parts[0], parts[1]);
        }
        return returnvalues;

    }
}