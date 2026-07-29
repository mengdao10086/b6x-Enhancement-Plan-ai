package fs;

import cp.o0;
import cp.t;
import cs.q;
import cs.y;
import fp.h0;
import ip.k;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import np.n1;
import np.v1;
import org.bouncycastle.crypto.c0;
import org.bouncycastle.crypto.v;
import org.bouncycastle.util.j;
import pn.r;
import pn.s;

/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f28743a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Set f28744b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Set f28745c = new HashSet();

    public static class a implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gm.y f28746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f28747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f28748c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ char[] f28749d;

        public a(gm.y yVar, r rVar, k kVar, char[] cArr) {
            this.f28746a = yVar;
            this.f28747b = rVar;
            this.f28748c = kVar;
            this.f28749d = cArr;
        }

        @Override // cs.y
        public zn.b a() {
            return new zn.b(this.f28746a, this.f28747b);
        }

        @Override // cs.y
        public OutputStream b() {
            return new gp.f(this.f28748c);
        }

        @Override // cs.y
        public byte[] d() {
            byte[] bArr = new byte[this.f28748c.d()];
            this.f28748c.c(bArr, 0);
            return bArr;
        }

        @Override // cs.y
        public q getKey() {
            return new q(a(), c0.a(this.f28749d));
        }
    }

    static {
        Map map = f28743a;
        gm.y yVar = s.f46814i6;
        map.put(yVar, j.g(128));
        Map map2 = f28743a;
        gm.y yVar2 = s.f46817j6;
        map2.put(yVar2, j.g(40));
        Map map3 = f28743a;
        gm.y yVar3 = s.f46820k6;
        map3.put(yVar3, j.g(192));
        Map map4 = f28743a;
        gm.y yVar4 = s.f46823l6;
        map4.put(yVar4, j.g(128));
        f28743a.put(s.f46826m6, j.g(128));
        f28743a.put(s.f46829n6, j.g(40));
        f28744b.add(yVar);
        f28744b.add(yVar2);
        f28745c.add(yVar4);
        f28745c.add(yVar3);
    }

    public static org.bouncycastle.crypto.k a(gm.y yVar, v vVar, int i10, r rVar, char[] cArr) {
        h0 h0Var = new h0(vVar);
        h0Var.j(c0.a(cArr), rVar.x(), rVar.z().intValue());
        if (e(yVar)) {
            return h0Var.e(d(yVar));
        }
        org.bouncycastle.crypto.k kVarF = h0Var.f(d(yVar), i10 * 8);
        if (f(yVar)) {
            np.k.c(((n1) ((v1) kVarF).b()).a());
        }
        return kVarF;
    }

    public static y b(gm.y yVar, v vVar, r rVar, char[] cArr) {
        h0 h0Var = new h0(vVar);
        h0Var.j(c0.a(cArr), rVar.x(), rVar.z().intValue());
        n1 n1Var = (n1) h0Var.d(vVar.h() * 8);
        k kVar = new k(vVar);
        kVar.a(n1Var);
        return new a(yVar, rVar, kVar, cArr);
    }

    public static mp.e c(gm.y yVar) {
        org.bouncycastle.crypto.f tVar;
        if (yVar.C(s.f46820k6) || yVar.C(s.f46823l6)) {
            tVar = new t();
        } else {
            if (!yVar.C(s.f46826m6) && !yVar.C(s.f46829n6)) {
                throw new IllegalStateException("unknown algorithm");
            }
            tVar = new o0();
        }
        return new mp.e(new jp.c(tVar), new mp.d());
    }

    public static int d(gm.y yVar) {
        return ((Integer) f28743a.get(yVar)).intValue();
    }

    public static boolean e(gm.y yVar) {
        return f28744b.contains(yVar);
    }

    public static boolean f(gm.y yVar) {
        return f28745c.contains(yVar);
    }
}
