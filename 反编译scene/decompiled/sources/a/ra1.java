package a;

import com.omarea.vtools.activities.ActivityFpsSession;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ra1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f7285a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2725a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityFpsSession f2726a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ra1(long j, b62 b62Var, ActivityFpsSession activityFpsSession) {
        super(2, b62Var);
        this.f7285a = j;
        this.f2726a = activityFpsSession;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ra1 ra1Var = new ra1(this.f7285a, b62Var, this.f2726a);
        ra1Var.f2725a = (wd2) obj;
        return ra1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ra1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        try {
            this.f2726a.r(this.f7285a);
        } catch (Exception unused) {
        }
        return m42.f6769a;
    }
}
