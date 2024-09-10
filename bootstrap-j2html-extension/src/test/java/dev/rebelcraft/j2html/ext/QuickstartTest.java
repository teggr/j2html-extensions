package dev.rebelcraft.j2html.ext;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickstartTest {

    @Test
    void shouldOutputTheQuickstart() {

        assertEquals("""
                <!doctype html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Bootstrap demo</title>
                  </head>`
                  <body>
                    <h1>Hello, world!</h1>
                  </body>
                </html>
                """, Quickstart.index());

    }

}