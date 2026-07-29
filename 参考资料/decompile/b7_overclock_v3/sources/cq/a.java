package cq;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.i;
import gm.j2;
import gm.t;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f25775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25776b;

    public a(f0 f0Var) {
        this.f25775a = z.I(f0Var.K(0)).J();
        this.f25776b = f0Var.size() == 2 ? t.I(f0Var.K(1)).Q() : 12;
    }

    public a(byte[] bArr, int i10) {
        this.f25775a = org.bouncycastle.util.a.p(bArr);
        this.f25776b = i10;
    }

    public static a y(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(new f2(this.f25775a));
        if (this.f25776b != 12) {
            iVar.a(new t(this.f25776b));
        }
        return new j2(iVar);
    }

    public int x() {
        return this.f25776b;
    }

    public byte[] z() {
        return org.bouncycastle.util.a.p(this.f25775a);
    }
}
