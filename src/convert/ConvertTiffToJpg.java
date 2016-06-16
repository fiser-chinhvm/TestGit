/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

/**
 *
 * @author chinhvm
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.image.RenderedImage;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.SeekableStream;
import com.sun.media.jai.codec.TIFFDecodeParam;
import java.io.File;
/**
 *
 * @author chinhvm
 */
public class ConvertTiffToJpg {

  public static void TiffToJpg(String tiff, String output)
     throws IOException
  {
    File tiffFile = new File(tiff);
    SeekableStream s = new FileSeekableStream(tiffFile);
    TIFFDecodeParam param = null;
    ImageDecoder dec = ImageCodec.createImageDecoder("tiff", s, param);
    RenderedImage op = dec.decodeAsRenderedImage(0);
    FileOutputStream fos = new FileOutputStream(output);
    JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(fos);
    jpeg.encode(op.getData());
    fos.close();
  }

  public static void main(String[] args) throws Exception {
    ConvertTiffToJpg.TiffToJpg("/home/chinhvm/Documents/cea.tif",
                        "/home/chinhvm/Documents/cea.jpg");
  }
}
