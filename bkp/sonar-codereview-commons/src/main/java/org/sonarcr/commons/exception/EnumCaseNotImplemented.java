package org.sonarcr.commons.exception;

public class EnumCaseNotImplemented
    extends
    IllegalArgumentException {

    private static final long serialVersionUID = 3711617527588259180L;

    public EnumCaseNotImplemented(
        final Enum<?> enumm) {
        super("Enum case Not implemented : ".concat(enumm.toString()));
    }
}
