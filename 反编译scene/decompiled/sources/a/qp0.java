package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.permissions.CheckRootStatus", f = "CheckRootStatus.kt", l = {71, 85, 90, 91}, m = "forceGetRoot")
public final class qp0 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7228a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ wp0 f2593a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f2594a;
    public Object b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2595b;
    public Object c;
    public Object d;
    public Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qp0(wp0 wp0Var, b62 b62Var) {
        super(b62Var);
        this.f2593a = wp0Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f2594a = obj;
        this.f7228a |= Integer.MIN_VALUE;
        return this.f2593a.d(this);
    }
}
