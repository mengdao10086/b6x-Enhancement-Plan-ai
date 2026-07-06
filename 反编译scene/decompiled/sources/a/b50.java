package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon", f = "Daemon.kt", l = {462}, m = "verifyCurrentMode")
public final class b50 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5674a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ e50 f230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f231a;
    public Object b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b50(e50 e50Var, b62 b62Var) {
        super(b62Var);
        this.f230a = e50Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f231a = obj;
        this.f5674a |= Integer.MIN_VALUE;
        return this.f230a.z1(null, this);
    }
}
