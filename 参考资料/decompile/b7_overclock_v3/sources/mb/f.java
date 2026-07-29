package mb;

import hb.l;
import hd.c0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f41148c = 1024;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f41149d = 440786851;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f41150a = new c0(8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f41151b;

    public final long a(l lVar) throws IOException {
        int i10 = 0;
        lVar.t(this.f41150a.d(), 0, 1);
        int i11 = this.f41150a.d()[0] & 255;
        if (i11 == 0) {
            return Long.MIN_VALUE;
        }
        int i12 = 128;
        int i13 = 0;
        while ((i11 & i12) == 0) {
            i12 >>= 1;
            i13++;
        }
        int i14 = i11 & (~i12);
        lVar.t(this.f41150a.d(), 1, i13);
        while (i10 < i13) {
            i10++;
            i14 = (this.f41150a.d()[i10] & 255) + (i14 << 8);
        }
        this.f41151b += i13 + 1;
        return i14;
    }

    public boolean b(l lVar) throws IOException {
        long length = lVar.getLength();
        long j10 = 1024;
        if (length != -1 && length <= 1024) {
            j10 = length;
        }
        int i10 = (int) j10;
        lVar.t(this.f41150a.d(), 0, 4);
        long jI = this.f41150a.I();
        this.f41151b = 4;
        while (jI != 440786851) {
            int i11 = this.f41151b + 1;
            this.f41151b = i11;
            if (i11 == i10) {
                return false;
            }
            lVar.t(this.f41150a.d(), 0, 1);
            jI = ((jI << 8) & (-256)) | ((long) (this.f41150a.d()[0] & 255));
        }
        long jA = a(lVar);
        long j11 = this.f41151b;
        if (jA == Long.MIN_VALUE) {
            return false;
        }
        if (length != -1 && j11 + jA >= length) {
            return false;
        }
        while (true) {
            int i12 = this.f41151b;
            long j12 = j11 + jA;
            if (i12 >= j12) {
                return ((long) i12) == j12;
            }
            if (a(lVar) == Long.MIN_VALUE) {
                return false;
            }
            long jA2 = a(lVar);
            if (jA2 < 0 || jA2 > 2147483647L) {
                break;
            }
            if (jA2 != 0) {
                int i13 = (int) jA2;
                lVar.j(i13);
                this.f41151b += i13;
            }
        }
        return false;
    }
}
