package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatTemperature$startTimer$1$run$1", f = "FloatTemperature.kt", l = {221}, m = "invokeSuspend")
public final class y12 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7942a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ z12 f3648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3649a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y12(z12 z12Var, b62 b62Var) {
        super(2, b62Var);
        this.f3648a = z12Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        y12 y12Var = new y12(this.f3648a, b62Var);
        y12Var.f7942a = (wd2) obj;
        return y12Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((y12) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f7942a;
            d22 d22Var = this.f3648a.f8028a;
            this.f3649a = wd2Var;
            this.b = 1;
            if (d22Var.k(this) == objC) {
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
