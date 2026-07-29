package kotlinx.coroutines.flow;

import kotlinx.coroutines.flow.r;

/* JADX INFO: loaded from: classes5.dex */
public final class s {
    @yt.k
    public static final r a(@yt.k r.a aVar, long j10, long j11) {
        return new StartedWhileSubscribed(uk.e.M(j10), uk.e.M(j11));
    }

    public static /* synthetic */ r b(r.a aVar, long j10, long j11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = uk.e.f52169b.W();
        }
        if ((i10 & 2) != 0) {
            j11 = uk.e.f52169b.q();
        }
        return a(aVar, j10, j11);
    }
}
