package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatMonitorFPS$preRefresh$1", f = "FloatMonitorFPS.kt", l = {609}, m = "invokeSuspend")
public final class wx1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ py1 f7832a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3491a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wx1(py1 py1Var, b62 b62Var) {
        super(2, b62Var);
        this.f7832a = py1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        wx1 wx1Var = new wx1(this.f7832a, b62Var);
        wx1Var.f3490a = (wd2) obj;
        return wx1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((wx1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f3490a;
            this.f7832a.f2468a.d();
            e50 e50Var = e50.f677a;
            this.f3491a = wd2Var;
            this.b = 1;
            if (e50Var.j0(this) == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return m42.f6769a;
    }
}
