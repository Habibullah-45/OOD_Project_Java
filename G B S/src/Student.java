import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends User {
    private String name;
    private Map<String, List<Integer>> subjects;

    public Student(String username, String password, String name) {
        super(username, password);
        this.name = name;
        this.subjects = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addSubject(String subject) {
        subjects.putIfAbsent(subject, new ArrayList<>());
    }

    public void addGrade(String subject, int grade) {
        subjects.computeIfAbsent(subject, k -> new ArrayList<>()).add(grade);
    }

    public List<Integer> getGrades(String subject) {
        return subjects.getOrDefault(subject, new ArrayList<>());
    }

    public double getAverageGrade(String subject) {
        List<Integer> grades = getGrades(subject);
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public String getReport() {
        StringBuilder report = new StringBuilder("Grade Report for " + name + ":\n");
        for (Map.Entry<String, List<Integer>> entry : subjects.entrySet()) {
            report.append("Subject: ").append(entry.getKey()).append("\n");
            report.append("Grades: ").append(entry.getValue()).append("\n");
            report.append("Average: ").append(getAverageGrade(entry.getKey())).append("\n\n");
        }
        return report.toString();
    }
}
