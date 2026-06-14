package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.net.ActivatedState", f = "ActivatedState.kt", l = {82, 101, 104, 123}, m = "cloudSync")
public final class qn0 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ sn0 f2583a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f2584a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f2585b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2586b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qn0(sn0 sn0Var, b62 b62Var) {
        super(b62Var);
        this.f2583a = sn0Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f2584a = obj;
        this.f7223a |= Integer.MIN_VALUE;
        return this.f2583a.a(null, this);
    }
}
