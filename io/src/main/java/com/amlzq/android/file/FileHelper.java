package com.amlzq.android.file;

import android.graphics.Bitmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件操作助手
 */
public class FileHelper {

    /**
     * @param bitmap
     * @param fileName 文件名，包含格式
     * @param dir      目录
     * @return 保存Bitmap，并返回路径
     */
    public static String saveBitmap(Bitmap bitmap, String fileName, String dir) {
        // 新建文件夹用于存放裁剪后的图片
        File tmpDir = new File(dir);
        if (!tmpDir.exists()) {
            tmpDir.mkdirs();
        }
        String filePath = tmpDir.getAbsolutePath() + File.separator + fileName;
        // 新建文件存储裁剪后的图片
        File file = new File(filePath);
        try {
            // 打开文件输出流
            FileOutputStream fos = new FileOutputStream(file);
            // 将bitmap压缩后写入输出流(参数依次为图片格式、图片质量和输出流)
            bitmap.compress(Bitmap.CompressFormat.PNG, 85, fos);
            //刷新输出流
            fos.flush();
            //关闭输出流
            fos.close();
            return filePath;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return filePath;
        }
    }

}