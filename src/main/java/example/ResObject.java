package example;

public class ResObject {
    private final long id;
    private final String content;

    public ResObject(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
