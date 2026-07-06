package a;

import com.omarea.ui.fps.GpuLoadView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.ui.fps.GpuLoadView$render$1$1", f = "GpuLoadView.kt", l = {}, m = "invokeSuspend")
public final class q51 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7181a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ GpuLoadView.a f2550a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q51(GpuLoadView.a aVar, b62 b62Var) {
        super(2, b62Var);
        this.f2550a = aVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        q51 q51Var = new q51(this.f2550a, b62Var);
        q51Var.f7181a = (wd2) obj;
        return q51Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((q51) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        GpuLoadView.this.invalidate();
        return m42.f6769a;
    }
}
