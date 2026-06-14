package a;

import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.net.SceneMagisk$getModules$1", f = "SceneMagisk.kt", l = {}, m = "invokeSuspend")
public final class wn0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ FutureTask f3459a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wn0(FutureTask futureTask, b62 b62Var) {
        super(2, b62Var);
        this.f3459a = futureTask;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        wn0 wn0Var = new wn0(this.f3459a, b62Var);
        wn0Var.f7805a = (wd2) obj;
        return wn0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((wn0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f3459a.run();
        return m42.f6769a;
    }
}
