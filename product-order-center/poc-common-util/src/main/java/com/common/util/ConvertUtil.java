package com.common.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ConvertUtil {
	public static String bytesToString(byte[] ba){
		StringBuffer sb = new StringBuffer();
		for(byte b:ba){
			char c = (char)b;
			sb.append(c);
		}
		return sb.toString();
	}
	public static byte[] stringToBytes(String s){
		char[] ca = s.toCharArray();
		byte[] ba = new byte[ca.length]; 
		for(int i=0;i<ca.length;i++){
			ba[i]=(byte) ca[i];
		}
		return ba;
	}
    public static byte[] getBytesFromFile(File f) {
    	
        if (f == null) {
            return null;
        }
        try {
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = stream.read(b)) != -1)
                out.write(b, 0, n);
            stream.close();
            out.close();
            return out.toByteArray();
        } catch (IOException e) {
        }
        return null;
    }
    public static File getFileFromBytes(byte[] b, String outputFile) {
        BufferedOutputStream stream = null;
        File file = null;
        try {
            file = new File(outputFile);
            FileOutputStream fstream = new FileOutputStream(file);
            stream = new BufferedOutputStream(fstream);
            stream.write(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return file;
    }
    public static Object getObjectFromBytes(byte[] objBytes){
        if (objBytes == null || objBytes.length == 0) {
            return null;
        }
        ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
        try {
			ObjectInputStream oi = new ObjectInputStream(bi);
			return oi.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
    }
    public static byte[] getBytesFromObject(Serializable obj) {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        try {
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] bs = bo.toByteArray();
       // System.err.println("object size (B)"+bs.length);
		return bs;
    }
    
    public static byte[] getBytesFromObject(Object obj) {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        try {
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] bs = bo.toByteArray();
		return bs;
    }

}
