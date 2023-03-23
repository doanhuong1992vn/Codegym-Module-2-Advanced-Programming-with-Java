package homework.shopee_project.entity;

public class Category {
    private final long id;
    private String name;
    private static long count = 0;

    public Category(String name) {
        this.id = ++count;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category ID " + id + ": " + name;
    }
}
