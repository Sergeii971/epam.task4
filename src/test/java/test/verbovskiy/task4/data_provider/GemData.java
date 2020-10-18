package test.verbovskiy.task4.data_provider;

import com.verbovskiy.task4.entity.Gem;
import com.verbovskiy.task4.entity.GemType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GemData {
    private static List<Gem> gems;

    private GemData() {
    }

    public static List<Gem> getGems() {
        if (gems == null) {
            gems = new ArrayList<>();
        }
            Gem gem1 = new Gem("p1", "Green", 1,15, "New-York", 2, "Ruby",
                    LocalDateTime.of(2000,05,14,14,00,20), GemType.PRECIOUS);
            Gem gem2 = new Gem("p2", "Red", 3,12, "Minsk", 4, "Augite",
                    LocalDateTime.of(2010,05,15,14,00,20), GemType.PRECIOUS);
            Gem gem3 = new Gem("p3", "Red", 3,13, "Moscow", 3, "Automalic",
                    LocalDateTime.of(2011,05,15,14,00,20), GemType.PRECIOUS);
            Gem gem4 = new Gem("p4", "Red", 3,13, "London", 3, "Agate",
                    LocalDateTime.of(2012,05,15,14,00,20), GemType.PRECIOUS);
            Gem gem5 = new Gem("p5", "Blue", 3,12, "London", 2, "Adularia",
                    LocalDateTime.of(2012,05,15,14,00,20), GemType.PRECIOUS);
            Gem gem6 = new Gem("p6", "Blue", 3,12, "Minsk", 3, "Aquamarine",
                    LocalDateTime.of(2012,05,15,14,00,20), GemType.PRECIOUS);
            Gem gem7 = new Gem("p7", "Blue", 3,12, "Minsk", 3, "Axinite",
                    LocalDateTime.of(2012,05,15,14,00,20), GemType.PRECIOUS);
            Gem gem8 = new Gem("p8", "Blue", 3,12, "London", 3, "Pearl",
                    LocalDateTime.of(2012,05,15,14,00,20), GemType.PRECIOUS);
            Gem gem9 = new Gem("s1", "Blue", 3,12, "London", 3, "Emerald",
                    LocalDateTime.of(2012,05,15,14,00,20), GemType.SEMIPRECIOUS);
            Gem gem10 = new Gem("s2", "Blue", 2,12, "London", 2, "Iloit",
                    LocalDateTime.of(2012,05,15,14,00,20), GemType.SEMIPRECIOUS);
            Gem gem11 = new Gem("s3", "Blue", 2,12, "London", 2, "Kyanite",
                    LocalDateTime.of(2012,05,15,14,00,20), GemType.SEMIPRECIOUS);
            Gem gem12 = new Gem("s4", "Blue", 2,12, "London", 2, "Corundum",
                    LocalDateTime.of(2012,05,15,14,00,20), GemType.SEMIPRECIOUS);
            Gem gem13 = new Gem("s5", "Blue", 2,9, "London", 2, "Flint",
                    LocalDateTime.of(2012,05,15,14,00,20), GemType.SEMIPRECIOUS);
            Gem gem14 = new Gem("s6", "Blue", 2,9, "London", 2, "Lal",
                    LocalDateTime.of(2012,05,15,14,00,20), GemType.SEMIPRECIOUS);
            Gem gem15 = new Gem("s7", "Blue", 2,9, "London", 2, "Melanite",
                    LocalDateTime.of(2012,05,15,14,00,20), GemType.SEMIPRECIOUS);
            Gem gem16 = new Gem("s8", "Blue", 2,9, "London", 2, "Amethyst",
                    LocalDateTime.of(2012,05,15,14,00,20), GemType.SEMIPRECIOUS);
            gems.add(gem1);
            gems.add(gem2);
            gems.add(gem3);
            gems.add(gem4);
            gems.add(gem5);
            gems.add(gem6);
            gems.add(gem7);
            gems.add(gem8);
            gems.add(gem9);
            gems.add(gem10);
            gems.add(gem11);
            gems.add(gem12);
            gems.add(gem13);
            gems.add(gem14);
            gems.add(gem15);
            gems.add(gem16);
        return Collections.unmodifiableList(gems);
    }
}
