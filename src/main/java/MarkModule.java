import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data

public class MarkModule {
    private Module  module;
    private List<AchievedMark> achievedMarks;

    public MarkModule() {
        achievedMarks = new ArrayList<>();
    }

    public int addAchievedMarks(AchievedMark achievedMark){
        achievedMarks.add(achievedMark);
        return achievedMarks.size();
    }
//Calculates Student's max mark per module.
    public double getAchievedMarksMax(){
        return achievedMarks
                .stream()
                .mapToDouble(AchievedMark::getMark)
                .max()
                .orElse(0);
    }
//Calculates Student's average mark per module.
    public double getAverageMarkPerModule(){
        return achievedMarks
                .stream()
                .mapToDouble(AchievedMark::getMark)
                .average()
                .getAsDouble();
    }
}
