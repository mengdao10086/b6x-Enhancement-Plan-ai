package dn;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.g;
import gm.n0;
import gm.n2;
import gm.w;
import gm.z;
import java.io.IOException;
import zn.o;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f26422d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f26423e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f26424f = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f26425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f26426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f26427c;

    public b(int i10, byte[] bArr) {
        this(new n2(i10, new f2(bArr)));
    }

    public b(n0 n0Var) {
        if (n0Var.q() == 0) {
            this.f26426b = z.H(n0Var, true).J();
        } else {
            if (n0Var.q() == 1) {
                this.f26427c = z.H(n0Var, true).J();
                return;
            }
            throw new IllegalArgumentException("unknown tag number: " + n0Var.q());
        }
    }

    public b(o oVar) {
        this.f26425a = oVar;
    }

    public static b y(n0 n0Var, boolean z10) {
        if (z10) {
            return z(n0Var.U());
        }
        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }

    public static b z(Object obj) {
        if (obj == null || (obj instanceof b)) {
            return (b) obj;
        }
        if (obj instanceof f0) {
            return new b(o.z(obj));
        }
        if (obj instanceof n0) {
            return new b((n0) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public int A() {
        if (this.f26425a != null) {
            return -1;
        }
        return this.f26426b != null ? 0 : 1;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f26426b != null ? new n2(0, new f2(this.f26426b)) : this.f26427c != null ? new n2(1, new f2(this.f26427c)) : this.f26425a.b();
    }

    public byte[] x() {
        o oVar = this.f26425a;
        if (oVar == null) {
            byte[] bArr = this.f26426b;
            return bArr != null ? org.bouncycastle.util.a.p(bArr) : org.bouncycastle.util.a.p(this.f26427c);
        }
        try {
            return oVar.getEncoded();
        } catch (IOException e10) {
            throw new IllegalStateException("can't decode certificate: " + e10);
        }
    }
}
