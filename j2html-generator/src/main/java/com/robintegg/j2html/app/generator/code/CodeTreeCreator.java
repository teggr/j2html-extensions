package com.robintegg.j2html.app.generator.code;

public class CodeTreeCreator {

    public static CodeTree codeTree() {
        return new CodeTree();
    }

    public static BuilderMethodCall builder(String methodName) {
        return new BuilderMethodCall(methodName);
    }

    public static ChainedMethodCall chainedMethodCall(String methodName) {
        return new ChainedMethodCall(methodName);
    }

    public static MethodCall methodCall(String methodName) {
        return new MethodCall(methodName);
    }
    public static NumberParameter numberParameter(String numberText) {
        return new NumberParameter(Integer.parseInt(numberText));
    }

    public static PlainTextParameter plainTextParameter(String plainText) {
        return new PlainTextParameter(plainText);
    }

    public static BooleanParameter booleanParameter(boolean booleanValue) {
        return new BooleanParameter(booleanValue);
    }

    public static MethodCallParameter methodCallParameter(MethodCall methodCall) {
        return new MethodCallParameter(methodCall);
    }

    public static BuilderMethodCallParameter builderMethodCallParameter(BuilderMethodCall builderMethodCall) {
        return new BuilderMethodCallParameter(builderMethodCall);
    }

    public static StaticVariableParameter staticVariableParameter(String className, String variableName) {
        return new StaticVariableParameter(className, variableName);
    }

}
