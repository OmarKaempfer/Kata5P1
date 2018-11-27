package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailListReader {

    public List<String> read(String fileName) throws IOException {
        File emailtxt = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(emailtxt));
        String line;

        List mailList = new ArrayList<String>();

        Pattern pattern = Pattern.compile("\\w+(\\.\\w+)*@\\w+(\\.\\w+)+");
        Matcher matcher;

        while((line = br.readLine()) != null) {
            matcher = pattern.matcher(line);
            if(matcher.matches()) {
                mailList.add(line);
            }
        }

        return mailList;
    }
}
