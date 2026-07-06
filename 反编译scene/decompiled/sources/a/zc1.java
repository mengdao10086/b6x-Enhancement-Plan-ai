package a;

import com.omarea.vtools.activities.ActivityModuleUpload;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityModuleUpload$onViewCreated$10$1", f = "ActivityModuleUpload.kt", l = {183}, m = "invokeSuspend")
public final class zc1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f8058a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityModuleUpload.b f3826a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3827a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f3828b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zc1(ActivityModuleUpload.b bVar, b62 b62Var) {
        super(2, b62Var);
        this.f3826a = bVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        zc1 zc1Var = new zc1(this.f3826a, b62Var);
        zc1Var.f8058a = (wd2) obj;
        return zc1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((zc1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f8058a;
            i92 i92Var = new i92();
            i92Var.b = new yn0().D(this.f3826a.f5367a);
            fg2 fg2VarC = qe2.c();
            yc1 yc1Var = new yc1(this, i92Var, null);
            this.f3827a = wd2Var;
            this.f3828b = i92Var;
            this.b = 1;
            if (oc2.g(fg2VarC, yc1Var, this) == objC) {
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
