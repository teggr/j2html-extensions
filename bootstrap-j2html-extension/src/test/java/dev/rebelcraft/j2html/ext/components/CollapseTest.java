package dev.rebelcraft.j2html.ext.components;

import org.junit.jupiter.api.Test;

import static dev.rebelcraft.j2html.ext.components.Collapse.*;
import static j2html.TagCreator.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CollapseTest {

    @Test
    void shouldAddDataBSToggleAttribute() {

        String formatted = div()
                .attr(dataBSToggle(true)).renderFormatted();

        assertEquals("""
                <div data-bs-toggle="collapse">
                </div>
                """, formatted);

    }

    @Test
    void shouldAddDataBSTargetAttribute() {

        String formatted = div()
                .attr(dataBSTarget("#some-id")).renderFormatted();

        assertEquals("""
                <div data-bs-target="#some-id">
                </div>
                """, formatted);

    }

    @Test
    void shouldAddAriaExpandedAttribute() {

        String formatted = div()
                .attr(ariaExpanded(true)).renderFormatted();

        assertEquals("""
                <div aria-expanded="true">
                </div>
                """, formatted);

    }

    @Test
    void shouldAddAriaControlsAttributeSingle() {

        String formatted = div()
                .attr(ariaControls("some-id")).renderFormatted();

        assertEquals("""
                <div aria-controls="some-id">
                </div>
                """, formatted);

    }

    @Test
    void shouldAddAriaControlsAttributeMultiple() {

        String formatted = div()
                .attr(ariaControls("some-id", "another-id")).renderFormatted();

        assertEquals("""
                <div aria-controls="some-id another-id">
                </div>
                """, formatted);

    }

}