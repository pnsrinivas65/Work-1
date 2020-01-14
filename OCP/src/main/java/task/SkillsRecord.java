package task;

public class SkillsRecord extends Record {

    private String skill;
    private Level level;

    public String getSkill() {
        return skill;
    }

    public SkillsRecord setSkill(String skill) {
        this.skill = skill;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public SkillsRecord setLevel(Level level) {
        this.level = level;
        return this;
    }

    public enum Level {
        EXPERT, ADVANCED, INTERMEDIATE, NOVICE
    }
}
