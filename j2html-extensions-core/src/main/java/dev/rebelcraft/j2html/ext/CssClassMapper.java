package dev.rebelcraft.j2html.ext;

/**
 * Apply to a <code>public static final String XXX = "";</code> static field so that the mapping is both documented and re-usable by other applications.
 */
public @interface CssClassMapper {

    String field();

    String className();

}
