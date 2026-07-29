package pb;

import ab.y;
import com.google.android.exoplayer2.Format;
import hd.c0;
import hd.w;
import java.util.Arrays;
import okio.w0;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import pb.i;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends i {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f46570s = 1332770163;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final byte[] f46571t = {79, pq.b.f46994k, 117, 115, 72, 101, 97, 100};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f46572r;

    public static boolean o(c0 c0Var) {
        int iA = c0Var.a();
        byte[] bArr = f46571t;
        if (iA < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        c0Var.k(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // pb.i
    public long f(c0 c0Var) {
        return c(n(c0Var.d()));
    }

    @Override // pb.i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean i(c0 c0Var, long j10, i.b bVar) {
        if (this.f46572r) {
            hd.a.g(bVar.f46590a);
            boolean z10 = c0Var.o() == 1332770163;
            c0Var.S(0);
            return z10;
        }
        byte[] bArrCopyOf = Arrays.copyOf(c0Var.d(), c0Var.f());
        bVar.f46590a = new Format.b().e0(w.S).H(y.c(bArrCopyOf)).f0(y.f524a).T(y.a(bArrCopyOf)).E();
        this.f46572r = true;
        return true;
    }

    @Override // pb.i
    public void l(boolean z10) {
        super.l(z10);
        if (z10) {
            this.f46572r = false;
        }
    }

    public final long n(byte[] bArr) {
        int i10 = bArr[0] & 255;
        int i11 = i10 & 3;
        int i12 = 2;
        if (i11 == 0) {
            i12 = 1;
        } else if (i11 != 1 && i11 != 2) {
            i12 = bArr[1] & w0.f44229a;
        }
        int i13 = i10 >> 3;
        int i14 = i13 & 3;
        return ((long) i12) * ((long) (i13 >= 16 ? ya.k.f56856n << i14 : i13 >= 12 ? 10000 << (i14 & 1) : i14 == 3 ? 60000 : 10000 << i14));
    }
}
