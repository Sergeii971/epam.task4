package com.verbovskiy.task4.entity;

public abstract class Stone {
    private String id;
    private String color;
    private int transparency;
    private String origin;
    private int value;

    public Stone() {
    }

    public Stone(String id, String color, int transparency, String origin, int value) {
        this.id = id;
        this.color = color;
        this.transparency = transparency;
        this.origin = origin;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
       if (this == o) {
           return true;
       }
       if ((o == null) || (this.getClass() != o.getClass())) {
           return false;
       }
       Stone stone = (Stone) o;

       if (id == null) {
           if (stone.id != null) {
               return false;
           }
       } else {
           if (!id.equals(stone.id)) {
               return false;
           }
       }
       if (origin == null) {
           if (stone.origin != null) {
               return false;
           }
       } else {
           if (!origin.equals(stone.origin)) {
               return false;
           }
       }
       if (color == null) {
           if (stone.color != null) {
               return false;
           }
       } else {
           if (!color.equals(stone.color)) {
               return false;
           }
       }
       return ((value == stone.value) && (transparency == stone.transparency));
    }

    @Override
    public int hashCode() {
        int result = 1;

        result += result * 31 + (color == null ? 0 : color.hashCode());
        result += result * 31 + transparency;
        result += result * 31 + (id == null ? 0 : id.hashCode());
        result += result * 31 + (origin == null ? 0 : origin.hashCode());
        result += result * 31 + value;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(id);
        builder.append(" ");
        builder.append(origin);
        builder.append(" ");
        builder.append(color);
        builder.append(" ");
        builder.append(transparency);
        builder.append(" ");
        builder.append(value);
        return builder.toString();
    }
}
