package dev.rebelcraft.j2html.ext.components;

import org.junit.jupiter.api.Test;

import static dev.rebelcraft.j2html.ext.components.Collapse.dataBSToggle;
import static j2html.TagCreator.div;
import static org.junit.jupiter.api.Assertions.*;

class AlertTest {

    @Test
    void shouldAddDataBsDismissAttribute() {

        String formatted = div()
                .attr(Alert.dataBsDismiss()).renderFormatted();

        assertEquals("""
                <div data-bs-dismiss="alert">
                </div>
                """, formatted);

    }

}