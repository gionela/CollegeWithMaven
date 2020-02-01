import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private Course course;
    private List<MarkModule> markModules;

    public Student() {
        markModules = new ArrayList<>();
    }

    public void addMarkModule(MarkModule markModule) {
        markModules.add(markModule);
    }

//Student gets enrolled in a new Module
    public String enroll(Module module) {
        MarkModule markModule = new MarkModule();
        markModule.setModule(module);
        markModules.add(markModule);
//        markModules.stream().map(x-> x.setModule(module));
        return markModules.stream().map(x->x.getModule().getName()).collect(Collectors.joining());
    }
//Gets Student's max mark per module and calculates their average
    public double getAverageMark() {
        return markModules
                .stream()
                .mapToDouble(MarkModule::getAchievedMarksMax)
                .sum() / markModules
                .size();
    }
//Checks if Student passed the class based on a passing mark
    public boolean checkIfAllModulesPassed() {
        int baseMark = 6;
        double avgPerModule = markModules.stream().mapToDouble(MarkModule::getAverageMarkPerModule).min().getAsDouble();
        if (avgPerModule>= baseMark)
            return true;
        else
            return false;
    }
}
