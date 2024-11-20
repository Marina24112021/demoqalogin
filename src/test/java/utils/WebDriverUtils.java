package utils;

public enum WebDriverUtils {
    REMOTEWD("selenoid.autotests.cloud");
    private String def;

    WebDriverUtils(String def) {
        this.def = def;
    }

    public String getDef() {
        return def;
    }
}
