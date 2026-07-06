package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatMonitorMini$startTimer$1$run$1", f = "FloatMonitorMini.kt", l = {292}, m = "invokeSuspend")
public final class wy1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7835a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ xy1 f3494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3495a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wy1(xy1 xy1Var, b62 b62Var) {
        super(2, b62Var);
        this.f3494a = xy1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        wy1 wy1Var = new wy1(this.f3494a, b62Var);
        wy1Var.f7835a = (wd2) obj;
        return wy1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((wy1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f7835a;
            az1 az1Var = this.f3494a.f7931a;
            this.f3495a = wd2Var;
            this.b = 1;
            if (az1Var.C(this) == objC) {
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
