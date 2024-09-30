package dev.rebelcraft.j2html.ext;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickstartTest {

    @Test
    void shouldOutputTheQuickstart() throws FileNotFoundException, MalformedURLException {

        // save the component output
        // open jwebserver, serving the component
        // open a browser pointing at the served file
        // get the state
        // assert the state

        String output = Quickstart.index().renderFormatted();

        File resourcesDirectory = new File("target/test-resources");

        resourcesDirectory.mkdirs();

        File outputFile = new File(resourcesDirectory, "quickstart.html");

        try (PrintWriter out = new PrintWriter(outputFile)) {
            out.println(output);
        }

        Configuration.headless = true;
        Configuration.reportsFolder = "target/test-reports";

        open(outputFile.toURI().toURL());
        String test = screenshot("test");
        System.out.println(test);

//        //load images to be compared:
//        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources("src/test/java/dev/rebelcraft/j2html/ext/QuickstartTest.png");
//        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("target/test-reports/test.png");
//
//        // where to save the result (leave null if you want to see
//        File resultDestination = new File( "target/test-reports/result.png" );
//
//        //Create ImageComparison object with result destination and compare the images.
//        ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage, resultDestination).compareImages();
//
//        //Image can be saved after comparison, using ImageComparisonUtil.
//        ImageComparisonUtil.saveImage(resultDestination, imageComparisonResult.getResult());
//
//        //Check the result
//        assertEquals(ImageComparisonState.MATCH, imageComparisonResult.getImageComparisonState());

        assertEquals("""
               <html lang="en">
                   <head>
                       <meta charset="utf-8">
                       <meta name="viewport" content="width=device-width, initial-scale=1">
                       <title>
                           Bootstrap demo
                       </title>
                       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
                   </head>
                   <body>
                       <h1>
                           Hello, world!
                       </h1>
                       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
                       </script>
                   </body>
               </html>
               """, output);

    }

}