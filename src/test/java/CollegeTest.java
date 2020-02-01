import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CollegeTest {
    private Student student;
    private Course course;
    private MarkModule markModule;
    private Module module;
    private College college;

    @BeforeEach
    public void before() {
        module = new Module("bla", course, "irakleous", ModuleType.MANDATORY);
        course = new Course("java", "athina", Cohort.SEPT_2019_JUNE_2019);
        markModule = new MarkModule(module, null);
        student = new Student("Alpha", course, null);
        Student student1 = new Student("Beta", course, null);
        college = new College();
        college.addStudent(student);
        college.addStudent(student1);

    }

    @Test
    void addStudent() {
        assertEquals(2, college.getStudents().size(), "error");
    }

    @Test
    void saveStudentToCSV() throws IOException {
        assertEquals(true, college.saveStudentToCSV("students.csv"), "error");
    }
    

    @Test
    void saveJsonToFile() {
        assertEquals(true, college.saveStudentToJsonToFile("students.json"), "ms");
    }

    @Test
    void saveAsXML() {
        assertEquals(true, college.saveStudentToXMLFile("students.xml"), "ms");
    }
}