package u9;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f51954a = "flydigi123456abc";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f51955b = "0392039203920300";

    public static String a(String sSrc) throws Exception {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(f51954a.getBytes(StandardCharsets.US_ASCII), m5.b.f40641c);
            Cipher cipher = Cipher.getInstance(m5.b.f40640b);
            cipher.init(2, secretKeySpec, new IvParameterSpec(f51955b.getBytes()));
            return new String(cipher.doFinal(Base64.decode(sSrc, 2)), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String sSrc) throws Exception {
        Cipher cipher = Cipher.getInstance(m5.b.f40640b);
        cipher.init(1, new SecretKeySpec(f51954a.getBytes(), m5.b.f40641c), new IvParameterSpec(f51955b.getBytes()));
        return Base64.encodeToString(cipher.doFinal(sSrc.getBytes(StandardCharsets.UTF_8)), 2);
    }
}
