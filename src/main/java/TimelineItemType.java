public enum TimelineItemType {
    LESSON("ZAJECIA"), BREAK("PRZERWA"), UNDEFINED("UNDEFINED");

    private final String text;

    TimelineItemType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

