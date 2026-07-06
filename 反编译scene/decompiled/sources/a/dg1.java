package a;

import com.omarea.vtools.activities.ActivityStartSplash;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityStartSplash$dialogExchange$2$1$onActivated$1", f = "ActivityStartSplash.kt", l = {74}, m = "invokeSuspend")
public final class dg1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ eg1 f5897a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f555a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f556a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg1(eg1 eg1Var, b62 b62Var) {
        super(2, b62Var);
        this.f5897a = eg1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        dg1 dg1Var = new dg1(this.f5897a, b62Var);
        dg1Var.f555a = (wd2) obj;
        return dg1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((dg1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f555a;
            ActivityStartSplash activityStartSplash = ActivityStartSplash.this;
            this.f556a = wd2Var;
            this.b = 1;
            if (activityStartSplash.O(this) == objC) {
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
