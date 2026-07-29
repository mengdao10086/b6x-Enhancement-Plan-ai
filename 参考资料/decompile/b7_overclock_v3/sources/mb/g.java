package mb;

import hb.l;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f41152d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f41153e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long[] f41154f = {128, 64, 32, 16, 8, 4, 2, 1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f41155a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f41156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41157c;

    public static long a(byte[] bArr, int i10, boolean z10) {
        long j10 = ((long) bArr[0]) & 255;
        if (z10) {
            j10 &= ~f41154f[i10 - 1];
        }
        for (int i11 = 1; i11 < i10; i11++) {
            j10 = (j10 << 8) | (((long) bArr[i11]) & 255);
        }
        return j10;
    }

    public static int c(int i10) {
        int i11 = 0;
        while (true) {
            long[] jArr = f41154f;
            if (i11 >= jArr.length) {
                return -1;
            }
            if ((jArr[i11] & ((long) i10)) != 0) {
                return i11 + 1;
            }
            i11++;
        }
    }

    public int b() {
        return this.f41157c;
    }

    public long d(l lVar, boolean z10, boolean z11, int i10) throws IOException {
        if (this.f41156b == 0) {
            if (!lVar.e(this.f41155a, 0, 1, z10)) {
                return -1L;
            }
            int iC = c(this.f41155a[0] & 255);
            this.f41157c = iC;
            if (iC == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f41156b = 1;
        }
        int i11 = this.f41157c;
        if (i11 > i10) {
            this.f41156b = 0;
            return -2L;
        }
        if (i11 != 1) {
            lVar.readFully(this.f41155a, 1, i11 - 1);
        }
        this.f41156b = 0;
        return a(this.f41155a, this.f41157c, z11);
    }

    public void e() {
        this.f41156b = 0;
        this.f41157c = 0;
    }
}
