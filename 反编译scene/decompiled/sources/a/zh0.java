package a;

import android.widget.EditText;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.FormValueHandler$bindInput$3", f = "FormValueHandler.kt", l = {112}, m = "invokeSuspend")
public final class zh0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f8071a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ rh0 f3846a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3847a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f3848a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3849a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f3850b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zh0(rh0 rh0Var, n92 n92Var, EditText editText, b62 b62Var) {
        super(2, b62Var);
        this.f3846a = rh0Var;
        this.f8071a = n92Var;
        this.f3848a = editText;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        zh0 zh0Var = new zh0(this.f3846a, this.f8071a, this.f3848a, b62Var);
        zh0Var.f3847a = (wd2) obj;
        return zh0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((zh0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.String] */
    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        try {
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f3847a;
                n92 n92Var = new n92();
                ?? r3 = (String) this.f3846a.getValue();
                n92Var.f6891a = r3;
                this.f8071a.f6891a = (String) r3;
                fg2 fg2VarC = qe2.c();
                yh0 yh0Var = new yh0(this, n92Var, null);
                this.f3849a = wd2Var;
                this.f3850b = n92Var;
                this.b = 1;
                if (oc2.g(fg2VarC, yh0Var, this) == objC) {
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
