package m5;

import com.google.android.material.timepicker.ChipTextInputComboView;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40639a = "flydigi2018appyf";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f40640b = "AES/CBC/PKCS5Padding";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f40641c = "AES";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f40642d = "wfjjgjakiglgisla";

    public static String a(String src) {
        return new String(b(src.getBytes()), StandardCharsets.UTF_8);
    }

    public static byte[] b(byte[] data) {
        return com.blankj.utilcode.util.z.c(data, f40639a.getBytes(), f40640b, new IvParameterSpec(f40642d.getBytes()).getIV());
    }

    public static String c(final String password) {
        try {
            return f(password);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String d(String src) {
        return new String(e(src.getBytes()), StandardCharsets.UTF_8);
    }

    public static byte[] e(byte[] data) {
        return com.blankj.utilcode.util.z.q(data, f40639a.getBytes(), f40640b, new IvParameterSpec(f40642d.getBytes()).getIV());
    }

    public static String f(String input) throws NoSuchAlgorithmException {
        byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(input.getBytes());
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < bArrDigest.length; i10++) {
            int length = bArrDigest.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                byte b10 = bArrDigest[i11];
                if (b10 == 0) {
                    sb2.append(ChipTextInputComboView.b.f21060b);
                    i11++;
                } else if ((b10 & 15) == b10) {
                    sb2.append("0");
                }
            }
            sb2.append(new BigInteger(1, bArrDigest).toString(16));
        }
        return sb2.toString().substring(0, 32);
    }
}
