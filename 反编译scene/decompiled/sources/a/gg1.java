package a;

import com.omarea.vtools.activities.ActivityStartSplash;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityStartSplash$initContractAction$4$1", f = "ActivityStartSplash.kt", l = {285}, m = "invokeSuspend")
public final class gg1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f6205a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityStartSplash.q f1009a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1010a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gg1(ActivityStartSplash.q qVar, b62 b62Var) {
        super(2, b62Var);
        this.f1009a = qVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        gg1 gg1Var = new gg1(this.f1009a, b62Var);
        gg1Var.f6205a = (wd2) obj;
        return gg1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((gg1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f6205a;
            ActivityStartSplash activityStartSplash = ActivityStartSplash.this;
            this.f1010a = wd2Var;
            this.b = 1;
            if (activityStartSplash.F(this) == objC) {
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
