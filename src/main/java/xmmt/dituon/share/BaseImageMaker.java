package xmmt.dituon.share;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class BaseImageMaker {
    public InputStream makeImage(String path,
                                 ArrayList<AvatarModel> avatarList, ArrayList<TextModel> textList,
                                 BufferedImage sticker ,boolean antialias) {
        try {
            return bufferedImageToInputStream(ImageSynthesis.synthesisImage(
                    sticker, avatarList, textList, antialias, true));
        } catch (IOException e) {
            System.out.println("构造IMG失败，请检查 PetData");
            e.printStackTrace();
        }
        return null;
    }

    private InputStream bufferedImageToInputStream(BufferedImage bf) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(bf, "png", os);
        return new ByteArrayInputStream(os.toByteArray());
    }
}
