package a;

import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v72<m42> f6316a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Timer f1173a;

    public hj0(v72<m42> v72Var, String str) {
        f92.d(v72Var, "onTick");
        this.f6316a = v72Var;
        this.f1172a = str;
    }

    public final void c() {
        Timer timer = this.f1173a;
        if (timer != null) {
            timer.cancel();
        }
        this.f1173a = null;
    }

    public final boolean d() {
        return this.f1173a != null;
    }

    public final boolean e(long j, long j2) {
        if (this.f1173a != null) {
            return false;
        }
        Timer timer = new Timer(this.f1172a);
        this.f1173a = timer;
        timer.schedule(new gj0(this, timer), j, j2);
        return true;
    }
}
