package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.ui.AdapterProcessMini$1", f = "AdapterProcessMini.kt", l = {49}, m = "invokeSuspend")
public final class b21 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f21 f5667a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f203a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f204a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b21(f21 f21Var, b62 b62Var) {
        super(2, b62Var);
        this.f5667a = f21Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        b21 b21Var = new b21(this.f5667a, b62Var);
        b21Var.f203a = (wd2) obj;
        return b21Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((b21) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f203a;
            f21 f21Var = this.f5667a;
            this.f204a = wd2Var;
            this.b = 1;
            if (f21Var.d(this) == objC) {
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
