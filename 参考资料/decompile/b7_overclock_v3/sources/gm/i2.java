package gm;

/* JADX INFO: loaded from: classes5.dex */
public class i2 extends d0 {
    public i2(String str) {
        this(str, false);
    }

    public i2(String str, boolean z10) {
        super(str, z10);
    }

    public i2(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }

    public static i2 L(n0 n0Var, boolean z10) {
        c0 c0VarU = n0Var.U();
        return (z10 || (c0VarU instanceof i2)) ? M(c0VarU) : new i2(z.I(c0VarU).J(), true);
    }

    public static i2 M(Object obj) {
        if (obj == null || (obj instanceof i2)) {
            return (i2) obj;
        }
        if (obj instanceof d0) {
            return new i2(((d0) obj).f29653a, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (i2) c0.D((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }
}
