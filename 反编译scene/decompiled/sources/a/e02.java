package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatQuickPanel$setUpView$hapticFeedback$1$1", f = "FloatQuickPanel.kt", l = {}, m = "invokeSuspend")
public final class e02 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f02 f5953a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f636a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e02(f02 f02Var, b62 b62Var) {
        super(2, b62Var);
        this.f5953a = f02Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        e02 e02Var = new e02(this.f5953a, b62Var);
        e02Var.f636a = (wd2) obj;
        return e02Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((e02) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        try {
            this.f5953a.f6060a.performHapticFeedback(1);
        } catch (Exception unused) {
        }
        return m42.f6769a;
    }
}
