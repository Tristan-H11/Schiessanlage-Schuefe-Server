package me.tristan;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class YamlHandler {

    private final static Yaml yaml = new Yaml();
    private static Map<String, Integer> counters = new HashMap<>();
    private final static Path path = Paths.get("./counter.yaml");


    public YamlHandler() {
    }

    public synchronized static void initialize() {
        try {
            File file = new File(path.toUri());
            if (!file.exists()) {
                file.createNewFile();
                Files.write(path, Collections.singletonList("{a: 0, b: 0, c: 0}"));
            }
            try (FileInputStream fileInputStream = new FileInputStream(path.toFile())) {
                counters = yaml.load(fileInputStream);
                if (counters == null) {
                    counters = new HashMap<>();
                    counters.put("a", 0);
                    counters.put("b", 0);
                    counters.put("c", 0);
                    write();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counters);
    }

    private synchronized static void write() {
        try (FileWriter writer = new FileWriter(path.toFile())) {
            yaml.dump(counters, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static void increaseA() {
        setA(getA() + 1);
    }

    public synchronized static int getA() {
        return counters.get("a");
    }

    public synchronized static void setA(final int value) {
        counters.put("a", value);
        write();
    }

    public synchronized static void increaseB() {
        setB(getB() + 1);
    }

    public synchronized static int getB() {
        return counters.get("b");
    }

    public synchronized static void setB(final int value) {
        counters.put("b", value);
        write();
    }

    public synchronized static void increaseC() {
        setC(getC() + 1);
    }

    public synchronized static int getC() {
        return counters.get("c");
    }

    public synchronized static void setC(final int value) {
        counters.put("c", value);
        write();
    }

}
