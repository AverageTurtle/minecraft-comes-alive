package mca.api.types;

public record Hair (String texture, String overlay) {

    public Hair() {
        this("", "");
    }

    public Hair(String texture, String overlay) {
        this.texture = texture;
        this.overlay = overlay == null ? "" : overlay;
    }
    @Deprecated
    public String getTexture() {
        return texture;
    }
    @Deprecated
    public String getOverlay() {
        return overlay;
    }
}
