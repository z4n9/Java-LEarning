package Patterns.Singleton;

import java.util.ArrayList;
import java.util.List;

public class SectionDatabase {
    private static SectionDatabase instance = null;

    private static final Object lock = new Object();

    private List<Section> sections;

    private SectionDatabase() {
        sections = new ArrayList<>();
    }

    public static SectionDatabase initialize() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new SectionDatabase();
                }
            }
        }
        return instance;
    }

    public void addSection(String name, String code) {
        sections.add(new Section(name, code));
    }

    public List<Section> getSections() {
        return sections;
    }

    public static class Section {
        private String name;
        private String code;

        public Section(String name, String code) {
            this.name = name;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

        @Override
        public String toString() {
            return "Section{name='" + name + "', code='" + code + "'}";
        }
    }

    public static void main(String[] args) {
        SectionDatabase db = SectionDatabase.initialize();
        db.addSection("Раздел 1", "001");
        db.addSection("Раздел 2", "002");

        for (Section section : db.getSections()) {
            System.out.println(section);
        }
    }
}
