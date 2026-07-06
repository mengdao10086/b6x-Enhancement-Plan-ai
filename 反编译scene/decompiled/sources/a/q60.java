package a;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class q60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i50 f7182a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f2551a;

    public q60(i50 i50Var, String str) {
        f92.d(i50Var, "handlerDaemon");
        f92.d(str, "cmd");
        this.f7182a = i50Var;
        this.f2551a = str;
    }

    public final q60 a() {
        c(this.f2551a);
        return this;
    }

    public final i50 b() {
        return this.f7182a;
    }

    public final q60 c(String str) {
        Boolean bool;
        FutureTask futureTask = new FutureTask(new p60(this, str));
        qc2.d(xd2.a(qe2.b()), null, null, new o60(futureTask, null), 3, null);
        try {
            bool = (Boolean) futureTask.get(100L, TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
            bool = Boolean.FALSE;
        }
        f92.c(bool, "connected");
        if (bool.booleanValue()) {
            return this;
        }
        return null;
    }

    public final void d() {
    }
}
