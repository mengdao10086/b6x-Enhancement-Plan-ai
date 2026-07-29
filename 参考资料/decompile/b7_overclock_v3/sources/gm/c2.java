package gm;

/* JADX INFO: loaded from: classes5.dex */
public class c2 extends r {
    public c2(String str) {
        this(str, false);
    }

    public c2(String str, boolean z10) {
        super(str, z10);
    }

    public c2(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }

    public static c2 L(n0 n0Var, boolean z10) {
        c0 c0VarU = n0Var.U();
        return (z10 || (c0VarU instanceof c2)) ? M(c0VarU) : new c2(z.I(c0VarU).J(), true);
    }

    public static c2 M(Object obj) {
        if (obj == null || (obj instanceof c2)) {
            return (c2) obj;
        }
        if (obj instanceof r) {
            return new c2(((r) obj).f29793a, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (c2) c0.D((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }
}
