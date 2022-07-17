package com.database.stuff.Model;

public class Artwork {

    private Data data;
    private Info info;
    private Config config;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "Artwork{" +
                "data=" + data +
                ", info=" + info +
                ", config=" + config +
                '}';
    }
}
