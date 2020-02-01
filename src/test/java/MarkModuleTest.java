import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarkModuleTest {
    private List<AchievedMark> achievedMarks = new ArrayList<>();
    private MarkModule markModule1;
    @BeforeEach
    void setup(){
        Module module = new Module("JavaSpring",null, "kodtsd",ModuleType.OPTIONAL);
        AchievedMark achievedMark1 = new AchievedMark(new Date(), 6);
        AchievedMark achievedMark2 = new AchievedMark(new Date(), 8);
        AchievedMark achievedMark3 = new AchievedMark(new Date(), 10);
        achievedMarks.add(achievedMark1);
        achievedMarks.add(achievedMark2);
        List<AchievedMark> achievedMarks2 = new ArrayList<>();
        achievedMarks2.add(achievedMark3);
        markModule1 = new MarkModule(module,achievedMarks);
        MarkModule markModule2 = new MarkModule(module,achievedMarks2);
    }

    @Test
    void addAchievedMarks() {
        assertEquals(2,achievedMarks.size());
    }

    @Test
    void getAchievedMarksMax() {
        assertEquals(8, markModule1.getAchievedMarksMax());
    }

    @Test
    void getAverageMarkPerModule() {
        assertEquals(7, markModule1.getAverageMarkPerModule());
    }
}