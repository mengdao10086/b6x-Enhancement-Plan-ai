package xr;

/* JADX INFO: loaded from: classes6.dex */
public class c0 extends gm.w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c0 f55828b = new c0(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c0 f55829c = new c0(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c0 f55830d = new c0(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.k f55831a;

    public c0(int i10) {
        this.f55831a = new gm.k(i10);
    }

    public c0(gm.k kVar) {
        this.f55831a = kVar;
    }

    public static c0 x(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof c0 ? (c0) obj : new c0(gm.k.I(obj));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f55831a;
    }
}
