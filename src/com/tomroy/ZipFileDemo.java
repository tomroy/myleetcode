package com.tomroy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by tom_th_lin on 2015/7/27.
 */

// tom_th_lin@[~/repos/leetcode/out/production/leetcode]$java com.tomroy.ZipFileTest files.zip
public class ZipFileDemo {

  static final int BUFFER = 2048;

  public static void main(String argv[]) {
    try {
      BufferedOutputStream dest = null;
      BufferedInputStream is = null;
      ZipEntry entry;
      ZipFile zipfile = new ZipFile(argv[0]);
      Enumeration e = zipfile.entries();
      while (e.hasMoreElements()) {
        entry = (ZipEntry) e.nextElement();
        System.out.println("Extracting: " + entry);
        is = new BufferedInputStream
                (zipfile.getInputStream(entry));
        int count;
        byte data[] = new byte[BUFFER];
        FileOutputStream fos = new
                FileOutputStream(entry.getName());
        dest = new
                BufferedOutputStream(fos, BUFFER);
        StringBuffer sb = new StringBuffer();
        while ((count = is.read(data, 0, BUFFER))
                != -1) {
          dest.write(data, 0, count);
          sb.append(new String(data, 0, BUFFER));
          System.out.print(sb.toString());
        }
        System.out.println();
        dest.flush();
        dest.close();
        is.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
