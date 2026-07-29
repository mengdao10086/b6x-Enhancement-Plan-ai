package an;

import gm.c0;
import gm.f0;
import gm.i;
import gm.j2;
import gm.t;
import gm.w;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class d extends w implements c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f807e = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b[] f810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f811d;

    public d(f0 f0Var) {
        this.f808a = new t(0L);
        if (f0Var == null || f0Var.size() == 0) {
            throw new IllegalArgumentException("null or empty sequence passed.");
        }
        Enumeration enumerationL = f0Var.L();
        this.f808a = t.I(enumerationL.nextElement());
        this.f809b = zn.b.z(enumerationL.nextElement());
        f0 f0VarJ = f0.J(enumerationL.nextElement());
        if (this.f808a.L(1)) {
            this.f811d = e.x(enumerationL.nextElement());
        }
        x(f0VarJ.size());
        this.f810c = new b[f0VarJ.size()];
        for (int i10 = 0; i10 < f0VarJ.size(); i10++) {
            this.f810c[i10] = b.z(f0VarJ.K(i10));
        }
    }

    public d(zn.b bVar, b[] bVarArr) {
        this.f808a = new t(0L);
        this.f808a = new t(0L);
        this.f809b = bVar;
        this.f810c = y(bVarArr);
        x(bVarArr.length);
    }

    public d(zn.b bVar, b[] bVarArr, e eVar) {
        this.f808a = new t(0L);
        this.f808a = new t(1L);
        this.f809b = bVar;
        this.f810c = y(bVarArr);
        this.f811d = eVar;
        x(bVarArr.length);
    }

    public static d B(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(f0.J(obj));
        }
        return null;
    }

    public zn.b A() {
        return this.f809b;
    }

    public int C() {
        return this.f808a.Q();
    }

    public e D() {
        return this.f811d;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(4);
        iVar.a(this.f808a);
        iVar.a(this.f809b);
        iVar.a(new j2(this.f810c));
        e eVar = this.f811d;
        if (eVar != null) {
            iVar.a(eVar);
        }
        return new j2(iVar);
    }

    public final void x(int i10) {
        if (i10 < 2 || i10 > 16) {
            throw new IllegalArgumentException("wrong size in DataGroupHashValues : not in (2..16)");
        }
    }

    public final b[] y(b[] bVarArr) {
        int length = bVarArr.length;
        b[] bVarArr2 = new b[length];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
        return bVarArr2;
    }

    public b[] z() {
        return y(this.f810c);
    }
}
