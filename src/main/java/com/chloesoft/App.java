package com.chloesoft;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.spire.doc.Document;
import com.spire.doc.documents.ImageType;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        // create a Document object
        Document doc = new Document();

        // load a Word file
        doc.loadFromFile("/Users/soonystory/Downloads/convert_sample.docx");

        // loop through the pages
        for (int i = 0; i < doc.getPageCount(); i++) {

            // save the specific page to a BufferedImage
            BufferedImage image = doc.saveToImages(i, ImageType.Bitmap);

            // write the image data to a .png file
            File file = new File("output/" + String.format(("Img-%d.png"), i));
            ImageIO.write(image, "PNG", file);
        }
    }
}
