package a;

import com.omarea.vtools.activities.ActivityFreezeApps;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityFreezeApps$freezeOptionsDialog$6$1$1", f = "ActivityFreezeApps.kt", l = {}, m = "invokeSuspend")
public final class xb1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7874a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ yb1 f3568a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xb1(yb1 yb1Var, b62 b62Var) {
        super(2, b62Var);
        this.f3568a = yb1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        xb1 xb1Var = new xb1(this.f3568a, b62Var);
        xb1Var.f7874a = (wd2) obj;
        return xb1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((xb1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ActivityFreezeApps.access$getProcessBarDialog$p(ActivityFreezeApps.this).c();
        ActivityFreezeApps.this.loadData();
        return m42.f6769a;
    }
}
