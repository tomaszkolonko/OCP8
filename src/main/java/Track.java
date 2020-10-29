public class Track {
    private String fromBP;
    private String toBP;
    private ETCSLevel etcsLevel;

    public Track(String fromBP, String toBP, ETCSLevel etcsLevel) {
        this.fromBP = fromBP;
        this.toBP = toBP;
        this.etcsLevel = etcsLevel;
    }

    public String getFromBP() {
        return fromBP;
    }

    public void setFromBP(String fromBP) {
        this.fromBP = fromBP;
    }

    public String getToBP() {
        return toBP;
    }

    public void setToBP(String toBP) {
        this.toBP = toBP;
    }

    public ETCSLevel getEtcsLevel() {
        return etcsLevel;
    }

    public void setEtcsLevel(ETCSLevel etcsLevel) {
        this.etcsLevel = etcsLevel;
    }
}
