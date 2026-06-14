package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.dialogs.DialogExchange$toLogin$1$onLoginSuccess$2", f = "DialogExchange.kt", l = {}, m = "invokeSuspend")
public final class lm1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mm1 f6722a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1836a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lm1(mm1 mm1Var, b62 b62Var) {
        super(2, b62Var);
        this.f6722a = mm1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        lm1 lm1Var = new lm1(this.f6722a, b62Var);
        lm1Var.f1836a = (wd2) obj;
        return lm1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((lm1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        if (!this.f6722a.f6823a.f2115a.isDestroyed()) {
            this.f6722a.f6823a.s(true);
        }
        return m42.f6769a;
    }
}
