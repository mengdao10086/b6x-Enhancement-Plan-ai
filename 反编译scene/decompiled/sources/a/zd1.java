package a;

import com.omarea.vtools.activities.ActivityPerfBench;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityPerfBench$onViewCreated$5$1", f = "ActivityPerfBench.kt", l = {131, 132}, m = "invokeSuspend")
public final class zd1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f8060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3831a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityPerfBench.h f3832a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3833a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3834a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zd1(ActivityPerfBench.h hVar, String str, long j, b62 b62Var) {
        super(2, b62Var);
        this.f3832a = hVar;
        this.f3834a = str;
        this.f8060a = j;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        zd1 zd1Var = new zd1(this.f3832a, this.f3834a, this.f8060a, b62Var);
        zd1Var.f3831a = (wd2) obj;
        return zd1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((zd1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        wd2 wd2Var;
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2Var = this.f3831a;
            e50.j1(e50.f677a, "cpu-bench", this.f3834a, null, 4, null);
            long j = this.f8060a;
            this.f3833a = wd2Var;
            this.b = 1;
            if (ke2.a(j, this) == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
                return m42.f6769a;
            }
            wd2Var = (wd2) this.f3833a;
            h42.b(obj);
        }
        fg2 fg2VarC = qe2.c();
        yd1 yd1Var = new yd1(this, null);
        this.f3833a = wd2Var;
        this.b = 2;
        if (oc2.g(fg2VarC, yd1Var, this) == objC) {
            return objC;
        }
        return m42.f6769a;
    }
}
