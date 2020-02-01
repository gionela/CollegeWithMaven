import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Module module;
    private List<AchievedMark> achievedMarks = new ArrayList<>();
    private Student student;

    @BeforeEach
    void setup(){
        module = new Module("JavaSpring",null, "Kostas",ModuleType.OPTIONAL);
        AchievedMark achievedMark1 = new AchievedMark(new Date(), 6);
        AchievedMark achievedMark2 = new AchievedMark(new Date(), 8);
        AchievedMark achievedMark4 = new AchievedMark(new Date(), 2);
        AchievedMark achievedMark3 = new AchievedMark(new Date(), 10);
        achievedMarks.add(achievedMark1);
        achievedMarks.add(achievedMark2);
        achievedMarks.add(achievedMark4);
        List<AchievedMark> achievedMarks2 = new ArrayList<>();
        achievedMarks2.add(achievedMark3);
        MarkModule markModule1 = new MarkModule(module,achievedMarks);
        MarkModule markModule2 = new MarkModule(module,achievedMarks2);
        student = new Student();
        student.addMarkModule(markModule1);
        student.addMarkModule(markModule2);
    }

    // Runs 3 times. (One inside the  method where markModule is created and added. And two more when markModule1, markModule2 are added in the test here)
    @Test
    void enroll() {
        assertEquals("JavaSpringJavaSpringJavaSpring", student.enroll(module));
    }

    @Test
    void getAverageMark() {
        assertEquals(9,student.getAverageMark());
    }

    @Test
    void checkIfAllModulesPassed() {
        assertEquals(false, student.checkIfAllModulesPassed());
    }
}