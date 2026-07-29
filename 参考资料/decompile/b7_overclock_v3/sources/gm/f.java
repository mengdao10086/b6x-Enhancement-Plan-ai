package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class f extends c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f29672c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f29673d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f29676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f29671b = new a(f.class, 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f29674e = new f((byte) 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f29675f = new f((byte) -1);

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return f.G(f2Var.J());
        }
    }

    public f(byte b10) {
        this.f29676a = b10;
    }

    public static f G(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
        }
        byte b10 = bArr[0];
        return b10 != -1 ? b10 != 0 ? new f(b10) : f29674e : f29675f;
    }

    public static f H(int i10) {
        return i10 != 0 ? f29675f : f29674e;
    }

    public static f I(n0 n0Var, boolean z10) {
        return (f) f29671b.f(n0Var, z10);
    }

    public static f J(Object obj) {
        if (obj == null || (obj instanceof f)) {
            return (f) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (f) f29671b.c((byte[]) obj);
        } catch (IOException e10) {
            throw new IllegalArgumentException("failed to construct boolean from byte[]: " + e10.getMessage());
        }
    }

    public static f K(boolean z10) {
        return z10 ? f29675f : f29674e;
    }

    @Override // gm.c0
    public int A(boolean z10) {
        return b0.i(z10, 1);
    }

    @Override // gm.c0
    public c0 E() {
        return L() ? f29675f : f29674e;
    }

    public boolean L() {
        return this.f29676a != 0;
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        return L() ? 1 : 0;
    }

    public String toString() {
        return L() ? "TRUE" : "FALSE";
    }

    @Override // gm.c0
    public boolean x(c0 c0Var) {
        return (c0Var instanceof f) && L() == ((f) c0Var).L();
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.o(z10, 1, this.f29676a);
    }

    @Override // gm.c0
    public boolean z() {
        return false;
    }
}
