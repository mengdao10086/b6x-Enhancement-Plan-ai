package a;

import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.net.SceneUser$getDevices$1", f = "SceneUser.kt", l = {}, m = "invokeSuspend")
public final class ip0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f6432a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ FutureTask f1397a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ip0(FutureTask futureTask, b62 b62Var) {
        super(2, b62Var);
        this.f1397a = futureTask;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ip0 ip0Var = new ip0(this.f1397a, b62Var);
        ip0Var.f6432a = (wd2) obj;
        return ip0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ip0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f1397a.run();
        return m42.f6769a;
    }
}
