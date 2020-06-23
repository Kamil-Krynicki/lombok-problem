package org.example;

import lombok.Value;

@Value
public class Test {
    private final long id;
    private final String name;

    @lombok.Builder(builderMethodName = "builderB", builderClassName = "BuilderB")
    private static Test builderB(long id) {
        return new Test(id, "");
    }

    @lombok.Builder(builderMethodName = "builderA", builderClassName = "BuilderA")
    private static Test builderA(String name) {
        return new Test(0, name);
    }

    static {
        new BuilderA().name("");
        new BuilderB().id(0);
    }

    public static class BuilderA { }

    public static class BuilderB { }
}

