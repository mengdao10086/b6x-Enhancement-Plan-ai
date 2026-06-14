package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon", f = "Daemon.kt", l = {539}, m = "getKernelProps")
public final class v30 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ e50 f3230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f3231a;
    public Object b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v30(e50 e50Var, b62 b62Var) {
        super(b62Var);
        this.f3230a = e50Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f3231a = obj;
        this.f7654a |= Integer.MIN_VALUE;
        return this.f3230a.p0(null, this);
    }
}
