package xs;

import gm.d2;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes6.dex */
public class l {
    public static zn.b a(String str) {
        if (str.equals(et.e.f27137f)) {
            return new zn.b(on.b.f44365i, d2.f29657b);
        }
        if (str.equals(et.e.f27138g)) {
            return new zn.b(kn.d.f37598f);
        }
        if (str.equals("SHA-256")) {
            return new zn.b(kn.d.f37592c);
        }
        if (str.equals(et.e.f27140i)) {
            return new zn.b(kn.d.f37594d);
        }
        if (str.equals("SHA-512")) {
            return new zn.b(kn.d.f37596e);
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + str);
    }

    public static s b(zn.b bVar) {
        if (bVar.x().C(on.b.f44365i)) {
            return org.bouncycastle.crypto.util.f.c();
        }
        if (bVar.x().C(kn.d.f37598f)) {
            return org.bouncycastle.crypto.util.f.d();
        }
        if (bVar.x().C(kn.d.f37592c)) {
            return org.bouncycastle.crypto.util.f.e();
        }
        if (bVar.x().C(kn.d.f37594d)) {
            return org.bouncycastle.crypto.util.f.f();
        }
        if (bVar.x().C(kn.d.f37596e)) {
            return org.bouncycastle.crypto.util.f.k();
        }
        throw new IllegalArgumentException("unrecognised OID in digest algorithm identifier: " + bVar.x());
    }
}
