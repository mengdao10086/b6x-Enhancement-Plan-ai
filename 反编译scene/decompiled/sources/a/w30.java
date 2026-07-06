package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon", f = "Daemon.kt", l = {504}, m = "getTemperature")
public final class w30 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7751a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ e50 f3376a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f3377a;
    public Object b;
    public Object c;
    public Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w30(e50 e50Var, b62 b62Var) {
        super(b62Var);
        this.f3376a = e50Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f3377a = obj;
        this.f7751a |= Integer.MIN_VALUE;
        return this.f3376a.u0(null, null, this);
    }
}
