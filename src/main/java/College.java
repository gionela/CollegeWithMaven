import com.opencsv.CSVWriter;
import lombok.AllArgsConstructor;
import lombok.Data;

import org.json.JSONArray;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data

public class College {
    private List<Student> students;

    public College() {
        students = new ArrayList<>();
    }

    public int addStudent(Student student){
        students.add(student);
        return students.size();
    }

    public boolean saveStudentToCSV(String filename) throws IOException {
        File file = new File(filename);
        FileWriter fw = new FileWriter(file);
        CSVWriter csvWriter = new CSVWriter(fw);
       for (Student student:students){
            String[] studentArray ={student.getName(),student.getCourse().getName(),student.getCourse().getLocation()};
           csvWriter.writeNext(studentArray);
      }
        csvWriter.close();
        return true;
    }

    public String getAsJson(){
        JSONArray jsArray = new JSONArray(students);
        return jsArray.toString();
    }

    public boolean saveStudentToJsonToFile(String filename)
    {
        try (PrintWriter pw = new PrintWriter(
                new File(filename))) {
            pw.println( getAsJson());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean saveStudentToXMLFile(String filename) {
        XMLEncoder encoder=null;
        try{
            encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
        }catch(FileNotFoundException fileNotFound){
            System.out.println("ERROR");
        }
        encoder.writeObject(students);
        encoder.close();
        return true;
    }

}
