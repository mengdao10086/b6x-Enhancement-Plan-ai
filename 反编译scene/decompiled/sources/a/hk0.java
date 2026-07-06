package a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class hk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6320a;

    public hk0() {
        this.f6320a = false;
        String strA = um0.f7612a.a("persist.vendor.aes_whitebox.encrypt");
        if (strA.equals("true") || strA.equals("1")) {
            this.f6320a = true;
        }
    }

    public byte[] a(byte[] bArr) {
        try {
            return b(bArr, e());
        } catch (Exception unused) {
            return b(bArr, f());
        }
    }

    public byte[] b(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr2));
        return cipher.doFinal(bArr);
    }

    public byte[] c(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArrD = d();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, new SecretKeySpec(bArrD, "AES"), new IvParameterSpec(bArrD));
        return cipher.doFinal(bArr);
    }

    public final byte[] d() {
        return this.f6320a ? e() : f();
    }

    public final byte[] e() {
        return g("6bc1bee22e409f96e93d7e117393172a");
    }

    public final byte[] f() {
        return "thermalopenssl.h".getBytes("UTF-8");
    }

    public byte[] g(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
