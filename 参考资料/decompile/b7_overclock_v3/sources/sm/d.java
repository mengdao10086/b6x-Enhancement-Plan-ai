package sm;

import gm.c0;
import gm.s;
import gm.s1;
import gm.w;
import gm.y;
import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.asn1.eac.BidirectionalMap;

/* JADX INFO: loaded from: classes5.dex */
public class d extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f49885d = 192;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f49886e = 128;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f49887f = 64;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f49888g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f49889h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f49890i = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f49894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.a f49895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y f49884c = g.f49900a.G("3.1.2.1");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Hashtable f49891j = new Hashtable();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static BidirectionalMap f49892k = new BidirectionalMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Hashtable f49893l = new Hashtable();

    static {
        f49891j.put(org.bouncycastle.util.j.g(2), "RADG4");
        f49891j.put(org.bouncycastle.util.j.g(1), "RADG3");
        f49892k.put(org.bouncycastle.util.j.g(192), "CVCA");
        f49892k.put(org.bouncycastle.util.j.g(128), "DV_DOMESTIC");
        f49892k.put(org.bouncycastle.util.j.g(64), "DV_FOREIGN");
        f49892k.put(org.bouncycastle.util.j.g(0), "IS");
    }

    public d(gm.a aVar) throws IOException {
        if (aVar.H() == 76) {
            D(new s(aVar.I()));
        }
    }

    public d(y yVar, int i10) throws IOException {
        C(yVar);
        B((byte) i10);
    }

    public static String A(int i10) {
        return (String) f49892k.get(org.bouncycastle.util.j.g(i10));
    }

    public static int y(String str) {
        Integer num = (Integer) f49892k.a(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("Unknown value " + str);
    }

    public final void B(byte b10) {
        this.f49895b = new s1(19, new byte[]{b10});
    }

    public final void C(y yVar) {
        this.f49894a = yVar;
    }

    public final void D(s sVar) throws IOException {
        c0 c0VarN = sVar.n();
        if (!(c0VarN instanceof y)) {
            throw new IllegalArgumentException("no Oid in CerticateHolderAuthorization");
        }
        this.f49894a = (y) c0VarN;
        c0 c0VarN2 = sVar.n();
        if (!(c0VarN2 instanceof gm.a)) {
            throw new IllegalArgumentException("No access rights in CerticateHolderAuthorization");
        }
        this.f49895b = (gm.a) c0VarN2;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f49894a);
        iVar.a(this.f49895b);
        return new s1(76, iVar);
    }

    public int x() {
        return this.f49895b.I()[0] & 255;
    }

    public y z() {
        return this.f49894a;
    }
}
