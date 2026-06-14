package a;

import com.omarea.ui.bench.CyclesPowerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.ui.bench.CyclesPowerView$render$1$1", f = "CyclesPowerView.kt", l = {}, m = "invokeSuspend")
public final class a41 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CyclesPowerView.a f30a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a41(CyclesPowerView.a aVar, b62 b62Var) {
        super(2, b62Var);
        this.f30a = aVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        a41 a41Var = new a41(this.f30a, b62Var);
        a41Var.f5569a = (wd2) obj;
        return a41Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((a41) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        CyclesPowerView.this.invalidate();
        return m42.f6769a;
    }
}
