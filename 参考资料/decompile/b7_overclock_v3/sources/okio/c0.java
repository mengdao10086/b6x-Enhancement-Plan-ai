package okio;

import com.umeng.analytics.pro.an;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0014J(\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0014J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0014J\b\u0010\u000f\u001a\u00020\u0004H\u0014J\b\u0010\u0010\u001a\u00020\u0004H\u0014R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lokio/c0;", "Lokio/q;", "", "size", "Lkotlin/z1;", "I", "L", "fileOffset", "", "array", "", "arrayOffset", "byteCount", an.aD, "M", "u", "n", "Ljava/io/RandomAccessFile;", "d", "Ljava/io/RandomAccessFile;", "randomAccessFile", "", "readWrite", "<init>", "(ZLjava/io/RandomAccessFile;)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class c0 extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final RandomAccessFile f44047d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(boolean z10, @yt.k RandomAccessFile randomAccessFile) {
        super(z10);
        kotlin.jvm.internal.f0.p(randomAccessFile, "randomAccessFile");
        this.f44047d = randomAccessFile;
    }

    @Override // okio.q
    public synchronized void I(long j10) {
        long jD1 = d1();
        long j11 = j10 - jD1;
        if (j11 > 0) {
            int i10 = (int) j11;
            M(jD1, new byte[i10], 0, i10);
        } else {
            this.f44047d.setLength(j10);
        }
    }

    @Override // okio.q
    public synchronized long L() {
        return this.f44047d.length();
    }

    @Override // okio.q
    public synchronized void M(long j10, @yt.k byte[] array, int i10, int i11) {
        kotlin.jvm.internal.f0.p(array, "array");
        this.f44047d.seek(j10);
        this.f44047d.write(array, i10, i11);
    }

    @Override // okio.q
    public synchronized void n() {
        this.f44047d.close();
    }

    @Override // okio.q
    public synchronized void u() {
        this.f44047d.getFD().sync();
    }

    @Override // okio.q
    public synchronized int z(long j10, @yt.k byte[] array, int i10, int i11) {
        kotlin.jvm.internal.f0.p(array, "array");
        this.f44047d.seek(j10);
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                break;
            }
            int i13 = this.f44047d.read(array, i10, i11 - i12);
            if (i13 != -1) {
                i12 += i13;
            } else if (i12 == 0) {
                return -1;
            }
        }
        return i12;
    }
}
