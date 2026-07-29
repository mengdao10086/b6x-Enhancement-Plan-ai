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
public class c extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f25795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25796b;

    public c(f0 f0Var) {
        this.f25795a = z.I(f0Var.K(0)).J();
        this.f25796b = f0Var.size() == 2 ? t.I(f0Var.K(1)).Q() : 12;
    }

    public c(byte[] bArr, int i10) {
        this.f25795a = org.bouncycastle.util.a.p(bArr);
        this.f25796b = i10;
    }

    public static c y(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(new f2(this.f25795a));
        if (this.f25796b != 12) {
            iVar.a(new t(this.f25796b));
        }
        return new j2(iVar);
    }

    public int x() {
        return this.f25796b;
    }

    public byte[] z() {
        return org.bouncycastle.util.a.p(this.f25795a);
    }
}
