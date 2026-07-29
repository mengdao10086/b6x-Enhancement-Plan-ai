package gm;

/* JADX INFO: loaded from: classes5.dex */
public class b2 extends q {
    public b2(byte[] bArr) {
        this(bArr, true);
    }

    public b2(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }

    public static b2 K(n0 n0Var, boolean z10) {
        c0 c0VarU = n0Var.U();
        return (z10 || (c0VarU instanceof b2)) ? L(c0VarU) : new b2(z.I(c0VarU).J());
    }

    public static b2 L(Object obj) {
        if (obj == null || (obj instanceof b2)) {
            return (b2) obj;
        }
        if (obj instanceof q) {
            return new b2(((q) obj).f29783a, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (b2) c0.D((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }
}
