public enum EVU {
    SBB(1100), BLS(1003), CARGO(8843);

    private int debitCode;

    EVU(int debitCode) {
        this.debitCode = debitCode;
    }

    public int geteDebitCode() {
        return debitCode;
    }
}

// Enums cannot be extended by other Enums !!!
