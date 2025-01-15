package com.robintegg.j2html.app.generator.code;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractMethodCall<T extends AbstractMethodCall<T>> {

    private final String methodName;
    private List<Parameter> parameters = new ArrayList<>();

    AbstractMethodCall(String methodName) {
        this.methodName = methodName;
    }

    public String printMethod(String prefix, int indentLevel) {
        String indent = prefix.repeat(indentLevel);
        StringBuilder sb = new StringBuilder();
        sb.append(indent);
        sb.append(prefix());
        sb.append(methodName).append("(");

        boolean anyBuilders = parameters.stream().anyMatch(Parameter::isNewlineRequired);

        // if all inline then wrap in a join not each

        for (int i = 0; i < parameters.size(); i++) {
            Parameter param = parameters.get(i);
            boolean first = i == 0;
            boolean last = i == parameters.size() - 1;
            if (!first) {
                sb.append(",");
            }
            if (anyBuilders) {
                sb.append("\n");
            }
            sb.append(param.printParam(prefix, indentLevel + 1));
        }

        if (anyBuilders) {
            sb.append("\n").append(indent);
        }

        sb.append(")");
        return sb.toString();
    }

    protected String prefix() {
        return "";
    }

    public T withParameter(Parameter parameter) {
        parameters.add(parameter);
        return self();
    }

    public boolean hasParameters() {
        return !parameters.isEmpty();
    }

    public T withParameters(List<Parameter> parameterCollection) {
        parameters.addAll(parameterCollection);
        return self();
    }

    protected T self() {
        return (T) this;
    }

}
