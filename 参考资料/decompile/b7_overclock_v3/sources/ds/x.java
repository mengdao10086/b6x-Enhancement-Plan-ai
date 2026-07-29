package ds;

import java.security.Key;

/* JADX INFO: loaded from: classes6.dex */
public class x {
    public static byte[] a(cs.q qVar) {
        if (qVar.b() instanceof Key) {
            return ((Key) qVar.b()).getEncoded();
        }
        if (qVar.b() instanceof byte[]) {
            return (byte[]) qVar.b();
        }
        throw new IllegalArgumentException("unknown generic key type");
    }
}
