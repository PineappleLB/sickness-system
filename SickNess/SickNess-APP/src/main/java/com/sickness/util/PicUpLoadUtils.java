package com.sickness.util;

import com.sickness.exception.ServiceException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 上传文件类
 *
 * @author pineapple
 * @create 2019/3/5
 */
public class PicUpLoadUtils {
    public static String getPicEnd(String picPath) throws ServiceException {
        String oldName =picPath;
        int index = oldName.lastIndexOf(".");
        if(index==-1) {
            throw new ServiceException("文件名不正确，文件名应当以:.jpg、.jpeg、.png、.gif、.bmp");
        }
        if(!oldName.endsWith(".jpg")&&!oldName.endsWith(".jpeg")&&!oldName.endsWith(".png")
                &&!oldName.endsWith(".gif")&&!oldName.endsWith("bmp")) {
            throw new ServiceException("文件名不正确，文件名应当以:.jpg、.jpeg、.png、.gif、.bmp");
        }
        String picEnd = oldName.substring(index+1, oldName.length());
        return picEnd;
    }
    public static void deleteFile(String url) throws ServiceException {
        if(url!=null&&!"".equals(url)) {
            try {
                File f = new File(url);
                if(f.exists()) {
                    f.delete();
                }
            }catch(Exception e) {

            }
        }
    }

    public static  String saveFile(byte [] file,String fileEnd,String picPath) throws IOException {
        String homePagePic = "HomePagePic";
        if(picPath.endsWith("/")) {
            homePagePic  = picPath+homePagePic;
        }else {
            homePagePic  = picPath+"/"+homePagePic;
        }
        File dir = new File(homePagePic);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = "/"+System.currentTimeMillis()+"."+fileEnd;
        File pic = new File(homePagePic+fileName);
        if(!pic.exists()) {
            pic.createNewFile();
        }
        FileOutputStream fout  = null;
        try {
            fout = new FileOutputStream(pic);
            fout.write(file);
            fout.flush();
        }catch(Exception e) {

        }finally {
            if(fout!=null) {
                fout.close();
            }
        }
        return pic.getAbsolutePath();
    }
}
