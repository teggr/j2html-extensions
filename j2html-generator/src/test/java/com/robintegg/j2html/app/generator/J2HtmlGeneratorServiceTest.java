package com.robintegg.j2html.app.generator;

import com.robintegg.j2html.app.generator.css.CssLookup;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class J2HtmlGeneratorServiceTest {

    J2HtmlGeneratorService service = new J2HtmlGeneratorService(new CssLookup());

    @Test
    void shouldOutputSingleTagNoAttributes() {

        String walk = service.generateFromHtml(null, true, null, """
                <h1 />
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                h1()
                """);

    }

    @Test
    void shouldOutputSingleTextOnlyTagNoAttributes() {

        String walk = service.generateFromHtml(null, true, null, """
                <h1>hello j2html community</h1>
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                h1()
                  .with(
                    text("hello j2html community")
                  )
                """);

    }

    @Test
    void shouldOutputTwoChildTextOnlyTagsNoAttributes() {

        String walk = service.generateFromHtml(null, true, null, """
                <div>
                    <h1>Title</h1>
                    <p>some text</p>
                </div>
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                div()
                  .with(
                    h1()
                      .with(
                        text("Title")
                      ),
                    p()
                      .with(
                        text("some text")
                      )
                  )
                """);

    }

    @Test
    void shouldOutputNestedTextOnlyChildrenNoAttributes() {

        String walk = service.generateFromHtml(null, true, null, """
                <div>
                    <h1>Title</h1>
                    <p>
                        <a>a link</a>
                    </p>
                </div>
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                div()
                  .with(
                    h1()
                      .with(
                        text("Title")
                      ),
                    p()
                      .with(
                        a()
                          .with(
                            text("a link")
                          )
                      )
                  )
                """);

    }

    @Test
    void shouldOutputSingleTextOnlyTagWithAttribute() {

        String walk = service.generateFromHtml(null, true, null, """
                <h1 class="title"/>
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                h1()
                  .withClasses("title")
                """);

    }

    @Test
    void shouldOutputSingleTextOnlyTagWithMultipleAttributes() {

        String walk = service.generateFromHtml(null, true, null, """
                <h1 class="title" id="t1" />
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                h1()
                  .withClasses("title")
                  .withId("t1")
                """);

    }

    @Test
    void shouldOutputSingleTagWithTextWithAttribute() {

        String walk = service.generateFromHtml(null, true, null, """
                <h1 class="title">hello j2html community</h1>
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                h1()
                  .withClasses("title")
                  .with(
                    text("hello j2html community")
                  )
                """);

    }

    @Test
    void shouldOutputTwoChildTextOnlyTagsWithAttributes() {

        String walk = service.generateFromHtml(null, true, null, """
                <div>
                    <h1 class="title">Title</h1>
                    <p class="content" id="p1">some text</p>
                </div>
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                div()
                  .with(
                    h1()
                      .withClasses("title")
                      .with(
                        text("Title")
                      ),
                    p()
                      .withClasses("content")
                      .withId("p1")
                      .with(
                        text("some text")
                      )
                  )
                """);

    }

    @Test
    void shouldOutputNestedTextOnlyChildrenWithAttributes() {

        String walk = service.generateFromHtml(null, true, null, """
                <div>
                    <h1>Title</h1>
                    <p>
                        <a href="/some/url">a link</a>
                    </p>
                </div>
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                div()
                  .with(
                    h1()
                      .with(
                        text("Title")
                      ),
                    p()
                      .with(
                        a()
                          .withHref("/some/url")
                          .with(
                            text("a link")
                          )
                      )
                  )
                """);

    }

    @Test
    void shouldOutputContainerWithTextNoAttributes() {

        String walk = service.generateFromHtml(null, true, null, """
                <a>hello <span>j2html community</span></a>
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                a()
                  .with(
                    text("hello "),
                    span()
                      .with(
                        text("j2html community")
                      )
                  )
                """);

    }

    @Test
    void shouldOutputContainerWithTextAndAttributes() {

        String walk = service.generateFromHtml(null, true, null, """
                <a href="/some/url">hello <span>j2html community</span></a>
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                a()
                  .withHref("/some/url")
                  .with(
                    text("hello "),
                    span()
                      .with(
                        text("j2html community")
                      )
                  )
                """);

    }

    @Test
    void shouldOutputSingleClass() {

        String walk = service.generateFromHtml(null, true, null, """
                <h1 class="title"/>
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                h1()
                  .withClasses("title")
                """);

    }

    @Test
    void shouldOutputMultipleClasses() {

        String walk = service.generateFromHtml(null, true, null, """
                <h1 class="title other"/>
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                h1()
                  .withClasses("title","other")
                """);

    }

    @Test
    void shouldOutputUnescapedTextComments() {

        //language=html
        String walk = service.generateFromHtml(null, true, null, """
                <div>
                    <!-- this is some comment -->
                </div>
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                div()
                  .with(
                    rawHtml("<!-- this is some comment -->")
                  )
                """);

    }

    @Test
    void shouldOutputAllEmptyTextBetweenTextChildren() {

        //language=html
        String walk = service.generateFromHtml(null, true, null, """
                <div id='parent'>
                    <div class="col-4 col-sm-6">
                      Level 2: .col-4 .col-sm-6
                    </div>
                </div>
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                div()
                  .withId("parent")
                  .with(
                    div()
                      .withClasses("col-4","col-sm-6")
                      .with(
                        text(" Level 2: .col-4 .col-sm-6 ")
                      )
                  )
                """);

    }

    @Nested
    class MissingCSSSnippets {

        @Test
        void shouldOutputMissingFormTableLayout() {

            String walk = service.generateFromHtml(null, true, null, """
                    <form class="table rows">
                      <p>
                          <label for=name>Name</label>
                          <input type=text id=name name=name>
                      </p>
                      <p>
                          <label for=adr>Address</label>
                          <input type=text id=adr name=adr>
                      </p>
                    </form>
                    """, null, null, null, false);

            assertThat(walk).isEqualTo("""
                    import static j2html.TagCreator.*;
                                    
                    form()
                      .withClasses("table","rows")
                      .with(
                        p()
                          .with(
                            label()
                              .withFor("name")
                              .with(
                                text("Name")
                              ),
                            input()
                              .withType("text")
                              .withId("name")
                              .withName("name")
                          ),
                        p()
                          .with(
                            label()
                              .withFor("adr")
                              .with(
                                text("Address")
                              ),
                            input()
                              .withType("text")
                              .withId("adr")
                              .withName("adr")
                          )
                      )
                    """);

        }

    }

    @Nested
    class BulmaCSSSnippets {

        @Test
        void shouldOutputNameField() {

            String walk = service.generateFromHtml(null, true, null, """
                                    
                     <div class="field">
                      <label class="label">Name</label>
                      <div class="control">
                        <input class="input" type="text" placeholder="Text input">
                      </div>
                    </div>
                     """, null, null, null, false);

            assertThat(walk).isEqualTo("""
                    import static j2html.TagCreator.*;
                                    
                    div()
                      .withClasses("field")
                      .with(
                        label()
                          .withClasses("label")
                          .with(
                            text("Name")
                          ),
                        div()
                          .withClasses("control")
                          .with(
                            input()
                              .withClasses("input")
                              .withType("text")
                              .withPlaceholder("Text input")
                          )
                      )
                    """);

        }

        @Test
        void shouldOutputUsernameField() {

            String walk = service.generateFromHtml(null, true, null, """
                                       
                                   
                    <div class="field">
                      <label class="label">Username</label>
                      <div class="control has-icons-left has-icons-right">
                        <input class="input is-success" type="text" placeholder="Text input" value="bulma">
                        <span class="icon is-small is-left">
                          <i class="fas fa-user"></i>
                        </span>
                        <span class="icon is-small is-right">
                          <i class="fas fa-check"></i>
                        </span>
                      </div>
                      <p class="help is-success">This username is available</p>
                    </div>
                                   
                     """, null, null, null, false);

            assertThat(walk).isEqualTo("""
                    import static j2html.TagCreator.*;
                                    
                    div()
                      .withClasses("field")
                      .with(
                        label()
                          .withClasses("label")
                          .with(
                            text("Username")
                          ),
                        div()
                          .withClasses("control","has-icons-left","has-icons-right")
                          .with(
                            input()
                              .withClasses("input","is-success")
                              .withType("text")
                              .withPlaceholder("Text input")
                              .withValue("bulma"),
                            span()
                              .withClasses("icon","is-small","is-left")
                              .with(
                                i()
                                  .withClasses("fas","fa-user")
                              ),
                            span()
                              .withClasses("icon","is-small","is-right")
                              .with(
                                i()
                                  .withClasses("fas","fa-check")
                              )
                          ),
                        p()
                          .withClasses("help","is-success")
                          .with(
                            text("This username is available")
                          )
                      )
                    """);

        }

        @Test
        void shouldOutputEmailField() {

            String walk = service.generateFromHtml(null, true, null, """
                                       
                                   
                    <div class="field">
                      <label class="label">Email</label>
                      <div class="control has-icons-left has-icons-right">
                        <input class="input is-danger" type="email" placeholder="Email input" value="hello@">
                        <span class="icon is-small is-left">
                          <i class="fas fa-envelope"></i>
                        </span>
                        <span class="icon is-small is-right">
                          <i class="fas fa-exclamation-triangle"></i>
                        </span>
                      </div>
                      <p class="help is-danger">This email is invalid</p>
                    </div>
                                  
                     """, null, null, null, false);

            assertThat(walk).isEqualTo("""
                    import static j2html.TagCreator.*;
                                    
                    div()
                      .withClasses("field")
                      .with(
                        label()
                          .withClasses("label")
                          .with(
                            text("Email")
                          ),
                        div()
                          .withClasses("control","has-icons-left","has-icons-right")
                          .with(
                            input()
                              .withClasses("input","is-danger")
                              .withType("email")
                              .withPlaceholder("Email input")
                              .withValue("hello@"),
                            span()
                              .withClasses("icon","is-small","is-left")
                              .with(
                                i()
                                  .withClasses("fas","fa-envelope")
                              ),
                            span()
                              .withClasses("icon","is-small","is-right")
                              .with(
                                i()
                                  .withClasses("fas","fa-exclamation-triangle")
                              )
                          ),
                        p()
                          .withClasses("help","is-danger")
                          .with(
                            text("This email is invalid")
                          )
                      )
                    """);

        }

        @Test
        void shouldOutputSubjectSelect() {

            String walk = service.generateFromHtml(null, true, null, """
                                       
                                   
                    <div class="field">
                      <label class="label">Subject</label>
                      <div class="control">
                        <div class="select">
                          <select>
                            <option>Select dropdown</option>
                            <option>With options</option>
                          </select>
                        </div>
                      </div>
                    </div>
                     """, null, null, null, false);

            assertThat(walk).isEqualTo("""
                    import static j2html.TagCreator.*;
                                    
                    div()
                      .withClasses("field")
                      .with(
                        label()
                          .withClasses("label")
                          .with(
                            text("Subject")
                          ),
                        div()
                          .withClasses("control")
                          .with(
                            div()
                              .withClasses("select")
                              .with(
                                select()
                                  .with(
                                    option()
                                      .with(
                                        text("Select dropdown")
                                      ),
                                    option()
                                      .with(
                                        text("With options")
                                      )
                                  )
                              )
                          )
                      )
                    """);

        }

        @Test
        void shouldOutputTextArea() {

            String walk = service.generateFromHtml(null, true, null, """
                                      
                                   
                    <div class="field">
                      <label class="label">Message</label>
                      <div class="control">
                        <textarea class="textarea" placeholder="Textarea"></textarea>
                      </div>
                    </div>
                     """, null, null, null, false);

            assertThat(walk).isEqualTo("""
                    import static j2html.TagCreator.*;
                                    
                    div()
                      .withClasses("field")
                      .with(
                        label()
                          .withClasses("label")
                          .with(
                            text("Message")
                          ),
                        div()
                          .withClasses("control")
                          .with(
                            textarea()
                              .withClasses("textarea")
                              .withPlaceholder("Textarea")
                          )
                      )
                    """);

        }

        @Test
        void shouldOutputCheckbox() {

            String walk = service.generateFromHtml(null, true, null, """
                                      
                                   
                    <div class="field">
                      <div class="control">
                        <label class="checkbox">
                          <input type="checkbox">
                          I agree to the <a href="#">terms and conditions</a>
                        </label>
                      </div>
                    </div>
                     """, null, null, null, false);

            assertThat(walk).isEqualTo("""
                    import static j2html.TagCreator.*;
                                    
                    div()
                      .withClasses("field")
                      .with(
                        div()
                          .withClasses("control")
                          .with(
                            label()
                              .withClasses("checkbox")
                              .with(
                                input()
                                  .withType("checkbox"),
                                text(" I agree to the "),
                                a()
                                  .withHref("#")
                                  .with(
                                    text("terms and conditions")
                                  )
                              )
                          )
                      )
                    """);

        }

        @Test
        void shouldOutputRadio() {

            String walk = service.generateFromHtml(null, true, null, """
                                       
                                   
                    <div class="field">
                      <div class="control">
                        <label class="radio">
                          <input type="radio" name="question">
                          Yes
                        </label>
                        <label class="radio">
                          <input type="radio" name="question">
                          No
                        </label>
                      </div>
                    </div>
                                
                     """, null, null, null, false);

            assertThat(walk).isEqualTo("""
                    import static j2html.TagCreator.*;
                                    
                    div()
                      .withClasses("field")
                      .with(
                        div()
                          .withClasses("control")
                          .with(
                            label()
                              .withClasses("radio")
                              .with(
                                input()
                                  .withType("radio")
                                  .withName("question"),
                                text(" Yes ")
                              ),
                            label()
                              .withClasses("radio")
                              .with(
                                input()
                                  .withType("radio")
                                  .withName("question"),
                                text(" No ")
                              )
                          )
                      )
                    """);

        }

        @Test
        void shouldOutputGroupedButtons() {

            String walk = service.generateFromHtml(null, true, null, """
                                      
                                   
                    <div class="field is-grouped">
                      <div class="control">
                        <button class="button is-link">Submit</button>
                      </div>
                      <div class="control">
                        <button class="button is-link is-light">Cancel</button>
                      </div>
                    </div>
                     """, null, null, null, false);

            assertThat(walk).isEqualTo("""
                    import static j2html.TagCreator.*;
                                    
                    div()
                      .withClasses("field","is-grouped")
                      .with(
                        div()
                          .withClasses("control")
                          .with(
                            button()
                              .withClasses("button","is-link")
                              .with(
                                text("Submit")
                              )
                          ),
                        div()
                          .withClasses("control")
                          .with(
                            button()
                              .withClasses("button","is-link","is-light")
                              .with(
                                text("Cancel")
                              )
                          )
                      )
                    """);

        }


    }

    @Nested
    class BoostrapExamples {

        @Test
        void shouldHandleNewlines() {


            String walk = service.generateFromHtml(null, true, null, """
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
                    """, null, null, null, false);

            assertThat(walk).isEqualTo("""
                    import static j2html.TagCreator.*;
                                    
                    div()
                      .withClasses("container","text-center")
                      .with(
                        div()
                          .withClasses("row")
                          .with(
                            div()
                              .withClasses("col")
                              .with(
                                text(" Column ")
                              ),
                            div()
                              .withClasses("col")
                              .with(
                                text(" Column ")
                              ),
                            div()
                              .withClasses("col")
                              .with(
                                text(" Column ")
                              )
                          )
                      )
                    """);

        }

    }

    @Test
    void shouldOutputOnlyTextAndInlineInput() throws IOException {

        //language=html
        String walk = service.generateFromHtml(null, true, null, """
                For example, <code>&lt;section&gt;</code> should be wrapped as inline.
                """, null, null, null, false);

        assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                                
                each(
                  text("For example, "),
                  code()
                    .with(
                      text("<section>")
                    ),
                  text(" should be wrapped as inline.")
                )
                """);

    }

    @Nested
    class J2HtmlExtensions {

        @Test
        void shouldOuputCommentMethods() {

            String walk = service.generateFromHtml(null, true, "j2htmlExtensions", """
                For example, <code>&lt;section&gt;</code> should be wrapped as inline.
                <!-- a comment -->
                """, null, null, null, false);

            assertThat(walk).isEqualTo("""
                import static j2html.TagCreator.*;
                import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.*;
                import static dev.rebelcraft.j2html.ext.aria.AriaRoles.*;
                import static dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties.*;
                                
                each(
                  text("For example, "),
                  code()
                    .with(
                      text("<section>")
                    ),
                  text(" should be wrapped as inline. "),
                  comment(" a comment ")
                )
                """);

        }

    }

}