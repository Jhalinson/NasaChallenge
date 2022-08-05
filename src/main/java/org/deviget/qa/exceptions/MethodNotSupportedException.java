package org.deviget.qa.exceptions;

public class MethodNotSupportedException extends  Exception{
    private String method;

    public MethodNotSupportedException() {
        super("not supported method by the ServicesSupport interface");
    }
/*
    public MethodNotSupportedException(String method) {
        super("not supported method by the ServicesSupport interface.\nMethod requested: "
                + method.toUpperCase() +
                "\nSupported methods are: \n" + printSupportedMethods());
        this.method = method.toUpperCase();
    }

    private static String printSupportedMethods() {
        String name = "";
        boolean firstOne = true;

        for (AvailableMethods availableMethod : AvailableMethods.values()) {
            if (firstOne) name = availableMethod.name();
            else name = name + ", " + availableMethod.name();
            firstOne = false;
        }

        return name;
    }

    private List<String> getSupportedMethods() {
        List<String> supportedMethods = new ArrayList<>();
        for (AvailableMethods value : AvailableMethods.values()) {
            supportedMethods.add(value.name());
        }
        return supportedMethods;
    }

    public String getNotSupportedMethod() {
        return method;
    }*/
}
