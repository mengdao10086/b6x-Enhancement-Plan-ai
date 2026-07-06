package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dj2 extends ej2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dj2 f5909a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final od2 f576a;

    static {
        dj2 dj2Var = new dj2();
        f5909a = dj2Var;
        f576a = new gj2(dj2Var, oi2.d("kotlinx.coroutines.io.parallelism", ga2.b(64, mi2.a()), 0, 0, 12, null), "Dispatchers.IO", 1);
    }

    public dj2() {
        super(0, 0, null, 7, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // a.od2
    public String toString() {
        return "Dispatchers.Default";
    }

    public final od2 v() {
        return f576a;
    }
}
