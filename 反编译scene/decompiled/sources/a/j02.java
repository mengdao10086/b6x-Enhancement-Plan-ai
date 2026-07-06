package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatQuickPanel$setUpView$updateUI$1$2", f = "FloatQuickPanel.kt", l = {237, 238}, m = "invokeSuspend")
public final class j02 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k02 f6460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1487a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f1488b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j02(k02 k02Var, b62 b62Var) {
        super(2, b62Var);
        this.f6460a = k02Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        j02 j02Var = new j02(this.f6460a, b62Var);
        j02Var.f1486a = (wd2) obj;
        return j02Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((j02) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        wd2 wd2Var;
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2Var = this.f1486a;
            ez0 ez0Var = this.f6460a.f6561a.f1703a;
            String str = this.f6460a.f1592a;
            this.f1487a = wd2Var;
            this.b = 1;
            obj = ez0Var.c(str, this);
            if (obj == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
                return m42.f6769a;
            }
            wd2Var = (wd2) this.f1487a;
            h42.b(obj);
        }
        String strValueOf = String.valueOf(((az0) obj).a());
        fg2 fg2VarC = qe2.c();
        i02 i02Var = new i02(this, strValueOf, null);
        this.f1487a = wd2Var;
        this.f1488b = strValueOf;
        this.b = 2;
        if (oc2.g(fg2VarC, i02Var, this) == objC) {
            return objC;
        }
        return m42.f6769a;
    }
}
