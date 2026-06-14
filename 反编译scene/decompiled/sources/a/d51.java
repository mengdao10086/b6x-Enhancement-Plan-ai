package a;

import com.omarea.ui.fps.BatteryIOView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.ui.fps.BatteryIOView$render$1$1", f = "BatteryIOView.kt", l = {}, m = "invokeSuspend")
public final class d51 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ BatteryIOView.a f493a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d51(BatteryIOView.a aVar, b62 b62Var) {
        super(2, b62Var);
        this.f493a = aVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        d51 d51Var = new d51(this.f493a, b62Var);
        d51Var.f5863a = (wd2) obj;
        return d51Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((d51) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        BatteryIOView.this.invalidate();
        return m42.f6769a;
    }
}
