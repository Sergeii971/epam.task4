package com.verbovskiy.task4.entity;

import java.time.LocalDateTime;

public class Gem extends Stone {
    private String name;
    private LocalDateTime cutDate;
    private GemType preciousness;
    private int faceNumber;

    public Gem() {
    }
    public Gem(String id, String color, int transparency, int faceNumber, String origin, int value, String name,
               LocalDateTime cutDate, GemType preciousness) {
        super(id, color, transparency,  origin, value);
        this.name = name;
        this.cutDate = cutDate;
        this.preciousness = preciousness;
        this.faceNumber = faceNumber;
    }

    public LocalDateTime getCutDate() {
        return cutDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCutDate(LocalDateTime cutDate) {
        this.cutDate = cutDate;
    }

    public GemType getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(GemType preciousness) {
        this.preciousness = preciousness;
    }

    public int getFaceNumber() {
        return faceNumber;
    }

    public void setFaceNumber(int faceNumber) {
        this.faceNumber = faceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Gem gem = (Gem) o;

        if (name == null) {
            if (gem.name != null) {
                return false;
            }
        } else {
            if (!name.equals(gem.name)) {
                return false;
            }
        }
        if (cutDate == null) {
            if (gem.cutDate != null) {
                return false;
            }
        } else {
            if (!cutDate.equals(gem.cutDate)) {
                return false;
            }
        }
        if (preciousness == null) {
            if (gem.preciousness != null) {
                return false;
            }
        } else {
            if (!preciousness.equals(gem.preciousness)) {
                return false;
            }
        }
        return  (faceNumber == gem.faceNumber);
    }

    @Override
    public int hashCode() {
        int result = 1;

        result += result * 31 + faceNumber;
        result += result * 31 + (name == null ? 0 : name.hashCode());
        result += result * 31 + (cutDate == null ? 0 : cutDate.hashCode());
        result += result * 31 + (preciousness == null ? 0 : preciousness.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(name);
        builder.append(" ");
        builder.append(cutDate);
        builder.append(" ");
        builder.append(faceNumber);
        builder.append(" ");
        builder.append(preciousness);
        builder.append(" ");
        builder.append(super.toString());
        return builder.toString();
    }
}
