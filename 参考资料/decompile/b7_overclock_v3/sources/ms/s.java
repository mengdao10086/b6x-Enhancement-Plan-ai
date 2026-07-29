package ms;

import zo.c0;
import zo.d0;
import zo.e0;
import zo.f0;
import zo.h0;

/* JADX INFO: loaded from: classes6.dex */
public class s {
    public static org.bouncycastle.crypto.s a(String str) {
        if (str.equals(et.e.f27137f)) {
            return new c0();
        }
        if (str.equals(et.e.f27138g)) {
            return new d0();
        }
        if (str.equals("SHA-256")) {
            return new e0();
        }
        if (str.equals(et.e.f27140i)) {
            return new f0();
        }
        if (str.equals("SHA-512")) {
            return new h0();
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + str);
    }
}
