package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon", f = "Daemon.kt", l = {787}, m = "getFocusedActivity")
public final class t30 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ e50 f2946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f2947a;
    public Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t30(e50 e50Var, b62 b62Var) {
        super(b62Var);
        this.f2946a = e50Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f2947a = obj;
        this.f7460a |= Integer.MIN_VALUE;
        return this.f2946a.n0(this);
    }
}
