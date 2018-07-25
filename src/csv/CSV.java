/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Tess
 */
public class CSV {

     public static void main(String[] args) throws Exception {

        String csvFile = "test.csv";
        FileWriter writer = new FileWriter(csvFile);

        List<User> users = Arrays.asList(
                new User("Wunmi", new Double(1200), 32),
                new User("Theresa", new Double(1599), 5),
                new User("Sogunle", new Double(999), 99)
        );

        //for header
       CsvUtils.writeLine(writer, Arrays.asList("Name", "Salary", "Age"));
		
        for (User u : users) {

            List<String> list = new ArrayList<>();
            list.add(u.getName());
            list.add(u.getSalary().toString());
            list.add(String.valueOf(u.getAge()));

          CsvUtils.writeLine(writer, list);

			//try custom separator and quote. 
			//CSVUtils.writeLine(writer, list, '|', '\"');
        }

        writer.flush();
        writer.close();

    }
}
