package entity.film;

public enum Feature {
    TRALLERS("Trallers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");

    private final String value;

    Feature(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Feature getFeatureByValue(String value) {
        if(value != null || value.isEmpty())
            return null;
        for (Feature feature : Feature.values()) {
            if (value.equals(feature.value))
                return feature;
        }
        return null;
    }
}
