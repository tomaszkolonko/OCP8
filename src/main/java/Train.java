public class Train {
    private String trainType;
    private ETCSLevel etcsLevel;

    public Train(String trainType, ETCSLevel etcsLevel) {
        this.trainType = trainType;
        this.etcsLevel = etcsLevel;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public ETCSLevel getEtcsLevel() {
        return etcsLevel;
    }

    public void setEtcsLevel(ETCSLevel etcsLevel) {
        this.etcsLevel = etcsLevel;
    }
}
