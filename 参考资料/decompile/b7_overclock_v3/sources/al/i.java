package al;

/* JADX INFO: loaded from: classes5.dex */
public abstract class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    public long f745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public j f746b;

    public i(long j10, @yt.k j jVar) {
        this.f745a = j10;
        this.f746b = jVar;
    }

    public final int a() {
        return this.f746b.M0();
    }

    public i() {
        this(0L, m.f757i);
    }
}
