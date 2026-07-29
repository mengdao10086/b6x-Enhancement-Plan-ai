package ts;

import gm.d2;
import gm.y;
import is.g;
import is.k;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.s;
import org.bouncycastle.util.j;
import rs.h;
import zo.e0;
import zo.h0;
import zo.j0;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zn.b f51622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zn.b f51623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zn.b f51624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zn.b f51625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zn.b f51626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zn.b f51627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zn.b f51628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zn.b f51629h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map f51630i;

    static {
        y yVar = g.X;
        f51622a = new zn.b(yVar);
        y yVar2 = g.Y;
        f51623b = new zn.b(yVar2);
        f51624c = new zn.b(kn.d.f37606j);
        f51625d = new zn.b(kn.d.f37602h);
        f51626e = new zn.b(kn.d.f37592c);
        f51627f = new zn.b(kn.d.f37596e);
        f51628g = new zn.b(kn.d.f37612m);
        f51629h = new zn.b(kn.d.f37614n);
        HashMap map = new HashMap();
        f51630i = map;
        map.put(yVar, j.g(5));
        map.put(yVar2, j.g(6));
    }

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

    public static s b(y yVar) {
        if (yVar.C(kn.d.f37592c)) {
            return new e0();
        }
        if (yVar.C(kn.d.f37596e)) {
            return new h0();
        }
        if (yVar.C(kn.d.f37612m)) {
            return new j0(128);
        }
        if (yVar.C(kn.d.f37614n)) {
            return new j0(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + yVar);
    }

    public static String c(y yVar) {
        if (yVar.C(on.b.f44365i)) {
            return et.e.f27137f;
        }
        if (yVar.C(kn.d.f37598f)) {
            return et.e.f27138g;
        }
        if (yVar.C(kn.d.f37592c)) {
            return "SHA-256";
        }
        if (yVar.C(kn.d.f37594d)) {
            return et.e.f27140i;
        }
        if (yVar.C(kn.d.f37596e)) {
            return "SHA-512";
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + yVar);
    }

    public static zn.b d(int i10) {
        if (i10 == 5) {
            return f51622a;
        }
        if (i10 == 6) {
            return f51623b;
        }
        throw new IllegalArgumentException("unknown security category: " + i10);
    }

    public static int e(zn.b bVar) {
        return ((Integer) f51630i.get(bVar.x())).intValue();
    }

    public static zn.b f(String str) {
        if (str.equals("SHA3-256")) {
            return f51624c;
        }
        if (str.equals(h.f49168c)) {
            return f51625d;
        }
        throw new IllegalArgumentException("unknown tree digest: " + str);
    }

    public static String g(k kVar) {
        zn.b bVarY = kVar.y();
        if (bVarY.x().C(f51624c.x())) {
            return "SHA3-256";
        }
        if (bVarY.x().C(f51625d.x())) {
            return h.f49168c;
        }
        throw new IllegalArgumentException("unknown tree digest: " + bVarY.x());
    }

    public static zn.b h(String str) {
        if (str.equals("SHA-256")) {
            return f51626e;
        }
        if (str.equals("SHA-512")) {
            return f51627f;
        }
        if (str.equals("SHAKE128")) {
            return f51628g;
        }
        if (str.equals("SHAKE256")) {
            return f51629h;
        }
        throw new IllegalArgumentException("unknown tree digest: " + str);
    }
}
