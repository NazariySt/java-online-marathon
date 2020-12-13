package Quiz5.task2;


public class Plant {
    private String name;
    private Color color;
    private Type type;

    public Plant(String type, String color, String name) throws ColorException, TypeException {
        this.name = name;
        try {
            if (color != null) {
                this.color = Color.valueOf(color.toUpperCase());
            }
        } catch (Exception ex) {
            throw new ColorException("Invalid value " + color + " for field color");
        }

        try {
            if (type != null) {
                this.type = Type.valueOf(type.toUpperCase());
            }
        } catch (Exception e) {
            throw new TypeException("Invalid value " + type + " type for field type");
        }
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color.name();
    }

    public String getType() {
        return type.name();
    }

    @Override
    public String toString() {
        return "{type: " + type.name() + ", color: " + color.name() + ", name: " + name + "}";
    }
}
