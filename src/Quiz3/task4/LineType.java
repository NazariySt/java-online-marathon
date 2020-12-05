package Quiz3.task4;

public enum LineType {
    SOLID("Solid") {
        String getType() {
            return type;
        }
    },
    DOTTED("dotted"){
        String getType(){
            return type;
        }
    },
    DASHED("dashed"){
        String getType(){
            return type;
        }
    },
    DOUBLE("double"){
        String getType(){
            return type;
        }
    };
    String type;

    LineType(String type) {
        this.type = type;
    }

    String getType() {
        return null;
    }
    public static String drawLine(LineType lineType){
        return "The line is " + lineType.getType().toLowerCase() + " type";
    }

    public static void main(String[] args) {
        System.out.println(drawLine(LineType.DASHED));
    }
}
