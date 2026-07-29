package qk;

import java.util.NoSuchElementException;
import kotlin.collections.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class o extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f47419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f47420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f47421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f47422d;

    public o(long j10, long j11, long j12) {
        this.f47419a = j12;
        this.f47420b = j11;
        boolean z10 = true;
        if (j12 <= 0 ? j10 < j11 : j10 > j11) {
            z10 = false;
        }
        this.f47421c = z10;
        this.f47422d = z10 ? j10 : j11;
    }

    @Override // kotlin.collections.l0
    public long b() {
        long j10 = this.f47422d;
        if (j10 != this.f47420b) {
            this.f47422d = this.f47419a + j10;
        } else {
            if (!this.f47421c) {
                throw new NoSuchElementException();
            }
            this.f47421c = false;
        }
        return j10;
    }

    public final long d() {
        return this.f47419a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f47421c;
    }
}
