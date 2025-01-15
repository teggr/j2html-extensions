package com.robintegg.j2html.app.generator.code;

public final class ChainedMethodCall extends AbstractMethodCall<ChainedMethodCall> {

    ChainedMethodCall(String methodName) {
        super(methodName);
    }

    @Override
    protected String prefix() {
        return ".";
    }

}
