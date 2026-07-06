package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon", f = "Daemon.kt", l = {520}, m = "getCpuCycles")
public final class q30 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ e50 f2539a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f2540a;
    public Object b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q30(e50 e50Var, b62 b62Var) {
        super(b62Var);
        this.f2539a = e50Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f2540a = obj;
        this.f7173a |= Integer.MIN_VALUE;
        return this.f2539a.j0(this);
    }
}
