package a;

import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.net.SceneUser$announcement$1", f = "SceneUser.kt", l = {}, m = "invokeSuspend")
public final class cp0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5815a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ FutureTask f436a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp0(FutureTask futureTask, b62 b62Var) {
        super(2, b62Var);
        this.f436a = futureTask;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        cp0 cp0Var = new cp0(this.f436a, b62Var);
        cp0Var.f5815a = (wd2) obj;
        return cp0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((cp0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f436a.run();
        return m42.f6769a;
    }
}
