package a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class gd2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f6197a = AtomicIntegerFieldUpdater.newUpdater(gd2.class, "_handled");
    public volatile int _handled;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Throwable f999a;

    public gd2(Throwable th, boolean z) {
        this.f999a = th;
        this._handled = z ? 1 : 0;
    }

    public /* synthetic */ gd2(Throwable th, boolean z, int i, b92 b92Var) {
        this(th, (i & 2) != 0 ? false : z);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return f6197a.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return ce2.a(this) + '[' + this.f999a + ']';
    }
}
