package qk;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.p1;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
public final class a0 implements Iterator<p1>, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f47385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f47386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f47387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f47388d;

    public a0(long j10, long j11, long j12) {
        this.f47385a = j11;
        boolean z10 = true;
        if (j12 <= 0 ? Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE) < 0 : Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE) > 0) {
            z10 = false;
        }
        this.f47386b = z10;
        this.f47387c = p1.j(j12);
        this.f47388d = this.f47386b ? j10 : j11;
    }

    public /* synthetic */ a0(long j10, long j11, long j12, kotlin.jvm.internal.u uVar) {
        this(j10, j11, j12);
    }

    public long a() {
        long j10 = this.f47388d;
        if (j10 != this.f47385a) {
            this.f47388d = p1.j(this.f47387c + j10);
        } else {
            if (!this.f47386b) {
                throw new NoSuchElementException();
            }
            this.f47386b = false;
        }
        return j10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f47386b;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ p1 next() {
        return p1.d(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
