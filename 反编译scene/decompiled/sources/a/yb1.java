package a;

import com.omarea.vtools.activities.ActivityFreezeApps;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityFreezeApps$freezeOptionsDialog$6$1", f = "ActivityFreezeApps.kt", l = {648}, m = "invokeSuspend")
public final class yb1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7966a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityFreezeApps.o f3674a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3675a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yb1(ActivityFreezeApps.o oVar, b62 b62Var) {
        super(2, b62Var);
        this.f3674a = oVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        yb1 yb1Var = new yb1(this.f3674a, b62Var);
        yb1Var.f7966a = (wd2) obj;
        return yb1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((yb1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f7966a;
            for (String str : ActivityFreezeApps.this.freezeApps) {
                ActivityFreezeApps activityFreezeApps = ActivityFreezeApps.this;
                f92.c(str, "it");
                activityFreezeApps.enableApp(str);
            }
            fg2 fg2VarC = qe2.c();
            xb1 xb1Var = new xb1(this, null);
            this.f3675a = wd2Var;
            this.b = 1;
            if (oc2.g(fg2VarC, xb1Var, this) == objC) {
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
