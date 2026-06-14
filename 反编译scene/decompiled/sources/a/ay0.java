package a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ay0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5653a = "/odm/etc/default_cloud.json";

    public final byte[] a(byte[] bArr, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("ASCII"), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr);
    }

    public String b() {
        return new String(a(f(f5653a), e()));
    }

    public final byte[] c(byte[] bArr, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("ASCII"), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(bArr);
    }

    public byte[] d(String str) {
        return c(str.getBytes(StandardCharsets.US_ASCII), e());
    }

    public final String e() {
        byte[] bArr = {72, 75, 73, 71, 73, 74, 72, 77, 73, 27, 73, 78, 73, 28, 73, 25, 72, 79, 73, 74, 73, 26, 72, 76, 72, 76, 73, 28, 77, 26, 73, 71};
        for (int i = 0; i < 32; i++) {
            bArr[i] = (byte) (bArr[i] ^ 127);
        }
        return new String(bArr);
    }

    public byte[] f(String str) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) randomAccessFile.length());
        byte[] bArr = new byte[8192];
        while (true) {
            int i = randomAccessFile.read(bArr);
            if (i == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                randomAccessFile.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }
}
