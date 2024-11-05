package dev.rebelcraft.j2html.ext.layout;

import dev.rebelcraft.j2html.ext.utilities.Text;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GridTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void gridExample() throws Exception {

        String gridExample = uiDocumentation.render(
                div()
                        .withClasses(Containers.container, Text.text_center)
                        .with(
                                div()
                                        .withClass(Grid.row)
                                        .with(
                                                div("Column")
                                                        .withClass(Grid.col),
                                                div("Column")
                                                        .withClass(Grid.col),
                                                div("Column")
                                                        .withClass(Grid.col)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                    <div class="row">
                        <div class="col">
                            Column
                        </div>
                        <div class="col">
                            Column
                        </div>
                        <div class="col">
                            Column
                        </div>
                    </div>
                </div>
                """, gridExample);

        // document
        uiDocumentation.document("grid-example", gridExample);

    }

}