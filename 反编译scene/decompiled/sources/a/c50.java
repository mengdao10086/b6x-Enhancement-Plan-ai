package a;

import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon$verifyOnline$1", f = "Daemon.kt", l = {1311}, m = "invokeSuspend")
public final class c50 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f5761a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f350a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ FutureTask f352a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c50(long j, FutureTask futureTask, b62 b62Var) {
        super(2, b62Var);
        this.f5761a = j;
        this.f352a = futureTask;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        c50 c50Var = new c50(this.f5761a, this.f352a, b62Var);
        c50Var.f350a = (wd2) obj;
        return c50Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((c50) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f350a;
            long j = this.f5761a;
            if (j > 0) {
                this.f351a = wd2Var;
                this.b = 1;
                if (ke2.a(j, this) == objC) {
                    return objC;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        this.f352a.run();
        return m42.f6769a;
    }
}
