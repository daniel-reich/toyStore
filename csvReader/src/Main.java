import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args){

        String csvFile = "/Users/Daniel/desktop/test.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            br.readLine(); //this burns the first line which is the header
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] personLine = line.split(cvsSplitBy);
                Person person = new Person();
                person.setName(personLine[0]);
                person.setAddress(personLine[1]);
                person.setAge(Integer.parseInt(personLine[2]));
                //In spring, save person object to database *personDAO.save(person)*
                System.out.println(person.getName()+" "+person.getAddress()+" "+person.getAge());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
