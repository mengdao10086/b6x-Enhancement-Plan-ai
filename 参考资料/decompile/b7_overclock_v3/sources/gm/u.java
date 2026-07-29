package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class u extends c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f29811a = new a(u.class, 5);

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return u.G(f2Var.J());
        }
    }

    public static u G(byte[] bArr) {
        if (bArr.length == 0) {
            return d2.f29657b;
        }
        throw new IllegalStateException("malformed NULL encoding encountered");
    }

    public static u H(n0 n0Var, boolean z10) {
        return (u) f29811a.f(n0Var, z10);
    }

    public static u I(Object obj) {
        if (obj instanceof u) {
            return (u) obj;
        }
        if (obj == null) {
            return null;
        }
        try {
            return (u) f29811a.c((byte[]) obj);
        } catch (IOException e10) {
            throw new IllegalArgumentException("failed to construct NULL from byte[]: " + e10.getMessage());
        }
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        return -1;
    }

    public String toString() {
        return "NULL";
    }

    @Override // gm.c0
    public boolean x(c0 c0Var) {
        return c0Var instanceof u;
    }
}
