package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatMonitorFPS$startTimer$1$run$1", f = "FloatMonitorFPS.kt", l = {441}, m = "invokeSuspend")
public final class gy1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hy1 f6253a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1074a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gy1(hy1 hy1Var, b62 b62Var) {
        super(2, b62Var);
        this.f6253a = hy1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        gy1 gy1Var = new gy1(this.f6253a, b62Var);
        gy1Var.f1073a = (wd2) obj;
        return gy1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((gy1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f1073a;
            py1 py1Var = this.f6253a.f6355a;
            this.f1074a = wd2Var;
            this.b = 1;
            if (py1Var.G(this) == objC) {
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
