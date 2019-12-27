package by.bstu.unittesting.model;

public class Item {

    private String name;

    private String search;

    public Item (String testDataSearch){
        this.search = testDataSearch;
    }

    public String getSearch() {
        return search;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
