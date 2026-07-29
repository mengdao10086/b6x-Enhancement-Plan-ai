package okio.internal;

import java.io.IOException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okio.t0;
import okio.u;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000b¨\u0006\u0016"}, d2 = {"Lokio/internal/b;", "Lokio/u;", "Lokio/j;", "sink", "", "byteCount", "F1", "newSize", "Lkotlin/z1;", "d", "b", "J", "size", "", "c", "Z", "truncate", "bytesReceived", "Lokio/t0;", "delegate", "<init>", "(Lokio/t0;JZ)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class b extends u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f44093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f44094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f44095d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@k t0 delegate, long j10, boolean z10) {
        super(delegate);
        f0.p(delegate, "delegate");
        this.f44093b = j10;
        this.f44094c = z10;
    }

    @Override // okio.u, okio.t0
    public long F1(@k okio.j sink, long j10) throws IOException {
        f0.p(sink, "sink");
        long j11 = this.f44095d;
        long j12 = this.f44093b;
        if (j11 > j12) {
            j10 = 0;
        } else if (this.f44094c) {
            long j13 = j12 - j11;
            if (j13 == 0) {
                return -1L;
            }
            j10 = Math.min(j10, j13);
        }
        long jF1 = super.F1(sink, j10);
        if (jF1 != -1) {
            this.f44095d += jF1;
        }
        long j14 = this.f44095d;
        long j15 = this.f44093b;
        if ((j14 >= j15 || jF1 != -1) && j14 <= j15) {
            return jF1;
        }
        if (jF1 > 0 && j14 > j15) {
            d(sink, sink.m2() - (this.f44095d - this.f44093b));
        }
        throw new IOException("expected " + this.f44093b + " bytes but got " + this.f44095d);
    }

    public final void d(okio.j jVar, long j10) throws IOException {
        okio.j jVar2 = new okio.j();
        jVar2.X0(jVar);
        jVar.V0(jVar2, j10);
        jVar2.d();
    }
}
