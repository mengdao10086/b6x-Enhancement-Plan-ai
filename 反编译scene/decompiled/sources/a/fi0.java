package a;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.FormValueHandler$bindInput$8", f = "FormValueHandler.kt", l = {242}, m = "invokeSuspend")
public final class fi0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rh0 f6109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f902a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f903a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f904a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f905b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fi0(rh0 rh0Var, CompoundButton compoundButton, b62 b62Var) {
        super(2, b62Var);
        this.f6109a = rh0Var;
        this.f903a = compoundButton;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        fi0 fi0Var = new fi0(this.f6109a, this.f903a, b62Var);
        fi0Var.f902a = (wd2) obj;
        return fi0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((fi0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        try {
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f902a;
                i92 i92Var = new i92();
                i92Var.b = ((Boolean) this.f6109a.getValue()).booleanValue();
                fg2 fg2VarC = qe2.c();
                ei0 ei0Var = new ei0(this, i92Var, null);
                this.f904a = wd2Var;
                this.f905b = i92Var;
                this.b = 1;
                if (oc2.g(fg2VarC, ei0Var, this) == objC) {
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
