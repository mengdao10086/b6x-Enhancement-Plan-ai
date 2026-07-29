package gm;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public abstract class z extends c0 implements a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f29834b = new a(z.class, 4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f29835c = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f29836a;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 d(f0 f0Var) {
            return f0Var.P();
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return f2Var;
        }
    }

    public z(byte[] bArr) {
        Objects.requireNonNull(bArr, "'string' cannot be null");
        this.f29836a = bArr;
    }

    public static z G(byte[] bArr) {
        return new f2(bArr);
    }

    public static z H(n0 n0Var, boolean z10) {
        return (z) f29834b.f(n0Var, z10);
    }

    public static z I(Object obj) {
        if (obj == null || (obj instanceof z)) {
            return (z) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof z) {
                return (z) c0VarB;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (z) f29834b.c((byte[]) obj);
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct OCTET STRING from byte[]: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    @Override // gm.c0
    public c0 E() {
        return new f2(this.f29836a);
    }

    @Override // gm.c0
    public c0 F() {
        return new f2(this.f29836a);
    }

    public byte[] J() {
        return this.f29836a;
    }

    public a0 K() {
        return this;
    }

    @Override // gm.a0
    public InputStream a() {
        return new ByteArrayInputStream(this.f29836a);
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        return org.bouncycastle.util.a.s0(J());
    }

    @Override // gm.h3
    public c0 o() {
        return b();
    }

    public String toString() {
        return "#" + Strings.c(jt.h.h(this.f29836a));
    }

    @Override // gm.c0
    public boolean x(c0 c0Var) {
        if (c0Var instanceof z) {
            return org.bouncycastle.util.a.g(this.f29836a, ((z) c0Var).f29836a);
        }
        return false;
    }
}
