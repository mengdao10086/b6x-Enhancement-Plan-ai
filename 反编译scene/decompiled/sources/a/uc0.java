package a;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class uc0 {
    public String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public String b(File file) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int i = fileInputStream.read(bArr, 0, 1024);
                if (i == -1) {
                    fileInputStream.close();
                    return a(messageDigest.digest());
                }
                messageDigest.update(bArr, 0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String c(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
