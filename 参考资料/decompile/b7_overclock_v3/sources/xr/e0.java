package xr;

/* JADX INFO: loaded from: classes6.dex */
public class e0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f55879a;

    public static class a extends e0 {
        public a(byte[] bArr) {
            super(bArr);
            if (bArr.length != 10) {
                throw new IllegalArgumentException("hash id not 10 bytes");
            }
        }
    }

    public static class b extends e0 {
        public b(byte[] bArr) {
            super(bArr);
            if (bArr.length != 32) {
                throw new IllegalArgumentException("hash id not 32 bytes");
            }
        }
    }

    public static class c extends e0 {
        public c(byte[] bArr) {
            super(bArr);
            if (bArr.length != 3) {
                throw new IllegalArgumentException("hash id not 3 bytes");
            }
        }
    }

    public static class d extends e0 {
        public d(byte[] bArr) {
            super(bArr);
            if (bArr.length != 8) {
                throw new IllegalArgumentException("hash id not 8 bytes");
            }
        }
    }

    public e0(byte[] bArr) {
        this.f55879a = org.bouncycastle.util.a.p(bArr);
    }

    public static e0 x(Object obj) {
        if (obj instanceof e0) {
            return (e0) obj;
        }
        byte[] bArrJ = gm.z.I(obj).J();
        int length = bArrJ.length;
        if (length == 3) {
            return new c(bArrJ);
        }
        if (length == 8) {
            return new d(bArrJ);
        }
        if (length == 10) {
            return new a(bArrJ);
        }
        if (length == 32) {
            return new b(bArrJ);
        }
        throw new IllegalStateException("hash id of unsupported length, length was: " + bArrJ.length);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.f2(this.f55879a);
    }
}
