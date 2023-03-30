package me.tristan;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.Paths;
import java.util.Map;

public class YamlHandler {

    private final static Yaml yaml = new Yaml();
    private static Map<String, Integer> counters;
    private final static String pathname = "./counter.yaml";

    public YamlHandler() {
    }

    public static void initialize() {
        try (FileInputStream fileInputStream = new FileInputStream(Paths.get(pathname).toFile())) {
            File yourFile = new File(pathname);
            yourFile.createNewFile();
            counters = yaml.load(fileInputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (counters.keySet().size() != 3) {
            counters.clear();
            counters.put("a", 0);
            counters.put("b", 0);
            counters.put("c", 0);
        }
        System.out.println(counters);
    }

    private static void write() {
        try (FileWriter writer = new FileWriter(Paths.get(pathname).toFile())) {
            yaml.dump(counters, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void increaseA() {
        setA(getA() + 1);
    }

    public static int getA() {
        return counters.get("a");
    }

    public static void setA(final int value) {
        counters.put("a", value);
        write();
    }

    public static void increaseB() {
        setB(getB() + 1);
    }

    public static int getB() {
        return counters.get("b");
    }

    public static void setB(final int value) {
        counters.put("b", value);
        write();
    }

    public static void increaseC() {
        setC(getC() + 1);
    }

    public static int getC() {
        return counters.get("c");
    }

    public static void setC(final int value) {
        counters.put("c", value);
        write();
    }

}
