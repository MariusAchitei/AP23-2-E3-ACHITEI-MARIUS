import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Programmer extends Person {
    private List<String> skills;

    public Programmer(String name, String... skills) {
        super(name);
        this.skills = new ArrayList<>();
        for (var skill :
                skills) {
            this.skills.add(skill);
        }
    }

    public Programmer(String name) {
        super(name);
        skills = new ArrayList<>();
    }

    public void addSkill(String... skills) {
        if (skills.length == 0)
            return;
        for (String skill :
                skills) {
            this.skills.add(skill);
        }
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Programmer: ").append(this.getName()).append("\nskills:{");
        for (var skill :
                this.skills) {
            s.append(skill).append(", ");
        }
        s.append("}");
        return s.toString();
    }
}
