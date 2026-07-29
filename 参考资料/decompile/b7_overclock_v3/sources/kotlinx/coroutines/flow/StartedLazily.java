package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes5.dex */
public final class StartedLazily implements r {
    @Override // kotlinx.coroutines.flow.r
    @yt.k
    public e<SharingCommand> a(@yt.k u<Integer> uVar) {
        return g.J0(new StartedLazily$command$1(uVar, null));
    }

    @yt.k
    public String toString() {
        return "SharingStarted.Lazily";
    }
}
