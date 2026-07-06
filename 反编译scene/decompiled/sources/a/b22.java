package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatTemperature", f = "FloatTemperature.kt", l = {200}, m = "updateInfo")
public final class b22 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f5668a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f205a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ d22 f206a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f207a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b22(d22 d22Var, b62 b62Var) {
        super(b62Var);
        this.f206a = d22Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f207a = obj;
        this.f205a |= Integer.MIN_VALUE;
        return this.f206a.k(this);
    }
}
