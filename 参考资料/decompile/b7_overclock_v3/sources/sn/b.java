package sn;

import gm.c0;
import gm.f0;
import gm.w;
import gm.y;
import java.util.Enumeration;
import java.util.Vector;
import pn.s;
import so.a0;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f50011b = s.S4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y f50012c = s.T4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f50013d = s.U4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y f50014e = kn.d.O;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y f50015f = kn.d.G;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final y f50016g = kn.d.f37625y;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final y f50017h = new y(a0.f50037f);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final y f50018i = new y(a0.f50038g);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final y f50019j = new y("1.3.14.3.2.7");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final y f50020k = s.Z3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final y f50021l = s.f46788a4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f50022a;

    public b(f0 f0Var) {
        this.f50022a = f0Var;
    }

    public static b y(Object obj) {
        if (obj == null || (obj instanceof b)) {
            return (b) obj;
        }
        if (obj instanceof f0) {
            return new b((f0) obj);
        }
        if (obj instanceof mm.a) {
            return new b((f0) ((mm.a) obj).y().J(0));
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f50022a;
    }

    public Vector x(y yVar) {
        Enumeration enumerationL = this.f50022a.L();
        Vector vector = new Vector();
        if (yVar == null) {
            while (enumerationL.hasMoreElements()) {
                vector.addElement(d.y(enumerationL.nextElement()));
            }
        } else {
            while (enumerationL.hasMoreElements()) {
                d dVarY = d.y(enumerationL.nextElement());
                if (yVar.C(dVarY.x())) {
                    vector.addElement(dVarY);
                }
            }
        }
        return vector;
    }
}
