package dev.rebelcraft.j2html.ext.components;

import org.junit.jupiter.api.Test;

import static j2html.TagCreator.div;
import static org.junit.jupiter.api.Assertions.*;

class BreadCrumbTest {

    @Test
    void shouldAddAriaCurrentAttribute() {

        String formatted = div()
                .attr(BreadCrumb.ariaCurrent()).renderFormatted();

        assertEquals("""
                <div aria-current="page">
                </div>
                """, formatted);

    }

    @Test
    void shouldAddAriaLabel() {

        String formatted = div()
                .attr(BreadCrumb.ariaLabel()).renderFormatted();

        assertEquals("""
                <div aria-label="breadcrumb">
                </div>
                """, formatted);
    }

    @Test
    void shouldConstructCorrectBreadcrumDividerStyle() {

        String style = BreadCrumb.breadcrumbStyle("'>'");

        assertEquals("--bs-breadcrumb-divider: '>';", style);
    }
}