package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes5.dex */
public interface r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a f38737a = a.f38738a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f38738a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public static final r f38739b = new t();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public static final r f38740c = new StartedLazily();

        public static /* synthetic */ r b(a aVar, long j10, long j11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = 0;
            }
            if ((i10 & 2) != 0) {
                j11 = Long.MAX_VALUE;
            }
            return aVar.a(j10, j11);
        }

        @yt.k
        public final r a(long j10, long j11) {
            return new StartedWhileSubscribed(j10, j11);
        }

        @yt.k
        public final r c() {
            return f38739b;
        }

        @yt.k
        public final r d() {
            return f38740c;
        }
    }

    @yt.k
    e<SharingCommand> a(@yt.k u<Integer> uVar);
}
