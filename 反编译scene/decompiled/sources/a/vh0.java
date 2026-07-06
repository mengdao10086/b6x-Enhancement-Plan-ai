package a;

import android.widget.Spinner;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.FormValueHandler$bindInput$10", f = "FormValueHandler.kt", l = {264}, m = "invokeSuspend")
public final class vh0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l92 f7696a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ rh0 f3281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Spinner f3283a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3284a;
    public int b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vh0(rh0 rh0Var, l92 l92Var, Spinner spinner, b62 b62Var) {
        super(2, b62Var);
        this.f3281a = rh0Var;
        this.f7696a = l92Var;
        this.f3283a = spinner;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        vh0 vh0Var = new vh0(this.f3281a, this.f7696a, this.f3283a, b62Var);
        vh0Var.f3282a = (wd2) obj;
        return vh0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((vh0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.c;
        try {
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f3282a;
                int iIntValue = ((Number) this.f3281a.getValue()).intValue();
                if (iIntValue != this.f7696a.f6687a) {
                    this.f7696a.f6687a = iIntValue;
                    this.f3281a.a(t62.e(this.f7696a.f6687a));
                }
                fg2 fg2VarC = qe2.c();
                uh0 uh0Var = new uh0(this, null);
                this.f3284a = wd2Var;
                this.b = iIntValue;
                this.c = 1;
                if (oc2.g(fg2VarC, uh0Var, this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
        } catch (Exception unused) {
        }
        return m42.f6769a;
    }
}
