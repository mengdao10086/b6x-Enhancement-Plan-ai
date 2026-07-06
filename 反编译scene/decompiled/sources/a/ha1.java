package a;

import com.omarea.vtools.activities.ActivityCpuControl;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ha1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ia1 f6297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1150a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ha1(ia1 ia1Var, b62 b62Var) {
        super(2, b62Var);
        this.f6297a = ia1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ha1 ha1Var = new ha1(this.f6297a, b62Var);
        ha1Var.f1149a = (wd2) obj;
        return ha1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ha1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f1149a;
            ActivityCpuControl activityCpuControl = this.f6297a.f6392a;
            this.f1150a = wd2Var;
            this.b = 1;
            if (activityCpuControl.f0(this) == objC) {
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
