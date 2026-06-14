package a;

import com.omarea.ui.fps.FrameTimeView2;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.ui.fps.FrameTimeView2$render$1$1", f = "FrameTimeView2.kt", l = {}, m = "invokeSuspend")
public final class p51 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7087a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ FrameTimeView2.a f2396a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p51(FrameTimeView2.a aVar, b62 b62Var) {
        super(2, b62Var);
        this.f2396a = aVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        p51 p51Var = new p51(this.f2396a, b62Var);
        p51Var.f7087a = (wd2) obj;
        return p51Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((p51) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        FrameTimeView2.this.invalidate();
        return m42.f6769a;
    }
}
