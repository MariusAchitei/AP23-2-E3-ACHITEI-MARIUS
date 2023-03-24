public class Designer extends Person{
    private int skillLevel;

    public Designer(String name, int skillLevel) {
        super(name);
        this.skillLevel = skillLevel;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }
}
