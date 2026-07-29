package dn;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.i;
import gm.j2;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f26420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f26421b;

    public a(f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f26420a = zn.b.z(f0Var.K(0));
            this.f26421b = z.I(f0Var.K(1)).J();
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public a(zn.b bVar, byte[] bArr) {
        this.f26420a = bVar;
        byte[] bArr2 = new byte[bArr.length];
        this.f26421b = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public static a z(Object obj) {
        if (obj == null || (obj instanceof a)) {
            return (a) obj;
        }
        if (obj instanceof f0) {
            return new a((f0) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(this.f26420a);
        iVar.a(new f2(this.f26421b));
        return new j2(iVar);
    }

    public byte[] x() {
        return org.bouncycastle.util.a.p(this.f26421b);
    }

    public zn.b y() {
        return this.f26420a;
    }
}
