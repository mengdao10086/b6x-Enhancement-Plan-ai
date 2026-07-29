package ob;

import g.p0;
import hd.c0;
import hd.t;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f43243a = "PsshAtomUtil";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f43244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f43245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f43246c;

        public a(UUID uuid, int i10, byte[] bArr) {
            this.f43244a = uuid;
            this.f43245b = i10;
            this.f43246c = bArr;
        }
    }

    public static byte[] a(UUID uuid, @p0 byte[] bArr) {
        return b(uuid, null, bArr);
    }

    public static byte[] b(UUID uuid, @p0 UUID[] uuidArr, @p0 byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(ob.a.f43072p0);
        byteBufferAllocate.putInt(uuidArr != null ? 16777216 : 0);
        byteBufferAllocate.putLong(uuid.getMostSignificantBits());
        byteBufferAllocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            byteBufferAllocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                byteBufferAllocate.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && bArr.length != 0) {
            byteBufferAllocate.putInt(bArr.length);
            byteBufferAllocate.put(bArr);
        }
        return byteBufferAllocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    @p0
    public static a d(byte[] bArr) {
        c0 c0Var = new c0(bArr);
        if (c0Var.f() < 32) {
            return null;
        }
        c0Var.S(0);
        if (c0Var.o() != c0Var.a() + 4 || c0Var.o() != 1886614376) {
            return null;
        }
        int iC = ob.a.c(c0Var.o());
        if (iC > 1) {
            t.n(f43243a, "Unsupported pssh version: " + iC);
            return null;
        }
        UUID uuid = new UUID(c0Var.z(), c0Var.z());
        if (iC == 1) {
            c0Var.T(c0Var.K() * 16);
        }
        int iK = c0Var.K();
        if (iK != c0Var.a()) {
            return null;
        }
        byte[] bArr2 = new byte[iK];
        c0Var.k(bArr2, 0, iK);
        return new a(uuid, iC, bArr2);
    }

    @p0
    public static byte[] e(byte[] bArr, UUID uuid) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return null;
        }
        if (uuid.equals(aVarD.f43244a)) {
            return aVarD.f43246c;
        }
        t.n(f43243a, "UUID mismatch. Expected: " + uuid + ", got: " + aVarD.f43244a + j3.b.f36044h);
        return null;
    }

    @p0
    public static UUID f(byte[] bArr) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return null;
        }
        return aVarD.f43244a;
    }

    public static int g(byte[] bArr) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return -1;
        }
        return aVarD.f43245b;
    }
}
