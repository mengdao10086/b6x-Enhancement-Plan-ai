package gm;

/* JADX INFO: loaded from: classes5.dex */
public class r2 extends w0 {
    public r2(byte[] bArr) {
        this(bArr, true);
    }

    public r2(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }

    public static r2 K(n0 n0Var, boolean z10) {
        c0 c0VarU = n0Var.U();
        return (z10 || (c0VarU instanceof r2)) ? L(c0VarU) : new r2(z.I(c0VarU).J());
    }

    public static r2 L(Object obj) {
        if (obj == null || (obj instanceof r2)) {
            return (r2) obj;
        }
        if (obj instanceof w0) {
            return new r2(((w0) obj).f29817a, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (r2) c0.D((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }
}
