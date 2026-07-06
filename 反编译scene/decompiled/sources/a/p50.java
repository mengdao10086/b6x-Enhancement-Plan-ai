package a;

import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.HttpRequest$postBase64Sync$1", f = "HttpRequest.kt", l = {}, m = "invokeSuspend")
public final class p50 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7086a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ FutureTask f2395a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p50(FutureTask futureTask, b62 b62Var) {
        super(2, b62Var);
        this.f2395a = futureTask;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        p50 p50Var = new p50(this.f2395a, b62Var);
        p50Var.f7086a = (wd2) obj;
        return p50Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((p50) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f2395a.run();
        return m42.f6769a;
    }
}
