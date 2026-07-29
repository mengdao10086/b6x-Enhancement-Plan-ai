package r9;

import kotlin.NotImplementedError;
import kotlin.jvm.internal.u;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements r9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f47882a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f47883b = 10;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @Override // r9.a
    @k
    public byte[] a() {
        return k(660, new byte[0]);
    }

    @Override // r9.a
    @k
    public byte[] b(int i10) {
        return k(gg.b.f29502w0, new byte[]{(byte) i10});
    }

    @Override // r9.a
    @k
    public byte[] c() {
        return k(gg.b.f29434f0, new byte[0]);
    }

    @Override // r9.a
    @k
    public byte[] d() {
        return k(gg.b.f29463m1, new byte[0]);
    }

    @Override // r9.a
    @k
    public byte[] e() {
        return k(gg.b.f29442h0, new byte[0]);
    }

    @Override // r9.a
    @k
    public byte[] f() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // r9.a
    @k
    public byte[] g() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // r9.a
    @k
    public byte[] h(int i10) {
        return k(gg.b.f29430e0, new byte[]{(byte) i10});
    }

    @Override // r9.a
    @k
    public byte[] i() {
        return k(gg.b.f29471o1, new byte[0]);
    }

    public final void j(int i10, byte[] bArr, int i11, int i12, boolean z10) {
        int i13 = 0;
        if ((i12 < 0) || (i12 > 4)) {
            throw new IndexOutOfBoundsException("Length must be between 0 and 4");
        }
        if (bArr.length < i11 + i12) {
            throw new IndexOutOfBoundsException("The targeted location must be contained in the target array.");
        }
        if (!z10) {
            int i14 = (i12 - 1) * 8;
            while (i13 < i12) {
                bArr[i13 + i11] = (byte) (((255 << i14) & i10) >> i14);
                i14 -= 8;
                i13++;
            }
            return;
        }
        int i15 = i12 - 1;
        int i16 = 0;
        while (i15 >= 0) {
            bArr[i16 + i11] = (byte) (((255 << i13) & i10) >> i13);
            i13 += 8;
            i16++;
        }
    }

    public final byte[] k(int i10, byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 8];
        bArr2[0] = -1;
        bArr2[1] = 1;
        bArr2[2] = 0;
        bArr2[3] = (byte) bArr.length;
        j(10, bArr2, 4, 2, false);
        j(i10, bArr2, 6, 2, false);
        System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
        return bArr2;
    }
}
