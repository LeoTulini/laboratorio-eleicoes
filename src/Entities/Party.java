package Entities;

public record Party(String name) {
    @Override
    public String name() {
        return name;
    }
}
