package com.angelachen.myhome.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Kartist 2018/10/4 16:22
 */
public class HttpUtil {

    public static void responseImage(String filePath, String fileSuffix, HttpServletResponse response) throws IOException {
        File imageFile = new File(filePath);
        response.setHeader("content-type", "image/" + fileSuffix);
        response.setHeader("content-length", String.valueOf(imageFile.length()));
        FileInputStream fis = new FileInputStream(imageFile);
        OutputStream os = response.getOutputStream();
        byte[] bytes = new byte[10240];
        int len = -1;
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
            os.flush();
        }
        os.close();
        fis.close();
    }


}
