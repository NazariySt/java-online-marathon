package Quiz3.task5;

public enum ClientType {
    NEW(1) {
        @Override
        public double discount() {
            return 1.0;
        }
    },
    SILVER(12){
        @Override
        public double discount() {
            return (100 - SILVER.months * 0.25) / 100;
        }
        },
    GOLD( 30) {
        @Override
        public double discount() {
            return (100 - GOLD.months *0.3)/100;        }
    },
    PLATINUM(60){
        public  double discount(){
            return (100 - PLATINUM.months *0.35)/100;
        }
    };
    private int months = 0;

     ClientType(int months) {
        this.months = months;
    }

    public double discount() {
        return 1.0;
    }

}
