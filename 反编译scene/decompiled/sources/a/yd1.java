package a;

import com.omarea.vtools.activities.ActivityPerfBench;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityPerfBench$onViewCreated$5$1$1", f = "ActivityPerfBench.kt", l = {}, m = "invokeSuspend")
public final class yd1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zd1 f3682a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yd1(zd1 zd1Var, b62 b62Var) {
        super(2, b62Var);
        this.f3682a = zd1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        yd1 yd1Var = new yd1(this.f3682a, b62Var);
        yd1Var.f7972a = (wd2) obj;
        return yd1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((yd1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ActivityPerfBench.this.p();
        return m42.f6769a;
    }
}
