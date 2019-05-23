package cn.tortoise.enums;

public enum Sex {
    FEMALE(0, "女"), MALE(1, "男");

    private int index;
    private String name;

    private Sex(int index, String name){
        this.index = index;
        this.name = name;
    }

    public static Sex getSex(int index){
        for(Sex s : Sex.values()){
            if(s.getIndex() == index){
                return s;
            }
        }
        return null;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
