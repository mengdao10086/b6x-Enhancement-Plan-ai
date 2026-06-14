package a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class f50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6075a = d(65, 69, 83);
    public static final String b = d(65, 69, 83, 47, 67, 66, 67, 47, 80, 75, 67, 83, 53, 80, 97, 100, 100, 105, 110, 103);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f853a = a(115, 99, 101, 110, 101, 46, 111, 109, 97, 114, 101, 97, 46, 99, 111, 109);

    public static byte[] a(int... iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            bArr[i] = (byte) iArr[i];
        }
        return bArr;
    }

    public static String d(int... iArr) {
        char[] cArr = new char[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            cArr[i] = (char) iArr[i];
        }
        return new String(cArr);
    }

    public byte[] b(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(b);
        cipher.init(2, new SecretKeySpec(bArr2, f6075a), new IvParameterSpec(f853a));
        return cipher.doFinal(bArr);
    }

    public byte[] c(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(b);
        cipher.init(1, new SecretKeySpec(bArr2, f6075a), new IvParameterSpec(f853a));
        return cipher.doFinal(bArr);
    }
}
