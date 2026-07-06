package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon", f = "Daemon.kt", l = {715}, m = "getThreads")
public final class x30 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7850a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ e50 f3521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f3522a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f3523b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x30(e50 e50Var, b62 b62Var) {
        super(b62Var);
        this.f3521a = e50Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f3522a = obj;
        this.f7850a |= Integer.MIN_VALUE;
        return this.f3521a.w0(0, this);
    }
}
