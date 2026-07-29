package xr;

import gm.n2;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class x1 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f56098c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f56099d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f56100e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f56101f = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f56102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f56103b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f56104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.h f56105b;

        public a a() {
            this.f56105b = gm.d2.f29657b;
            this.f56104a = 0;
            return this;
        }

        public a b(d dVar) {
            this.f56105b = dVar;
            this.f56104a = 3;
            return this;
        }

        public x1 c() {
            return new x1(this.f56104a, this.f56105b);
        }

        public a d(byte[] bArr) {
            this.f56105b = new gm.f2(bArr);
            this.f56104a = 2;
            return this;
        }

        public a e(m1 m1Var) {
            this.f56105b = m1Var;
            this.f56104a = 0;
            return this;
        }

        public a f(int i10) {
            this.f56104a = i10;
            return this;
        }

        public a g(gm.h hVar) {
            this.f56105b = hVar;
            return this;
        }
    }

    public x1(int i10, gm.h hVar) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3 && !(hVar instanceof d)) {
                        throw new IllegalArgumentException("value is not BitmapSspRange");
                    }
                } else if (!(hVar instanceof gm.z)) {
                    throw new IllegalArgumentException("value is not ASN1OctetString");
                }
            } else if (!(hVar instanceof gm.u)) {
                throw new IllegalArgumentException("value is not ASN1Null");
            }
        } else if (!(hVar instanceof m1)) {
            throw new IllegalArgumentException("value is not SequenceOfOctetString");
        }
        this.f56102a = i10;
        this.f56103b = hVar;
    }

    public static a x() {
        return new a();
    }

    public static x1 y(Object obj) {
        if (obj instanceof x1) {
            return (x1) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        if (iQ == 0) {
            return new x1(0, m1.x(n0VarT.U()));
        }
        if (iQ == 1) {
            return new x1(1, gm.d2.f29657b);
        }
        if (iQ == 2) {
            try {
                return new x1(2, new gm.f2(n0VarT.U().getEncoded()));
            } catch (IOException e10) {
                throw new RuntimeException(e10.getMessage(), e10);
            }
        }
        if (iQ == 3) {
            return new x1(3, d.x(n0VarT.U()));
        }
        throw new IllegalStateException("unknown choice " + iQ);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f56102a, this.f56103b);
    }
}
