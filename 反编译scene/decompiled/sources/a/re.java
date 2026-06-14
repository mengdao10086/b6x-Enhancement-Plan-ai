package a;

import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7291a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ye f2731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2732a;

    public re() {
        c(te.e(Locale.getDefault()));
    }

    public static te b(boolean z) {
        return z ? te.b : te.f7492a;
    }

    public te a() {
        return (this.f7291a == 2 && this.f2731a == te.f3016b) ? b(this.f2732a) : new te(this.f2732a, this.f7291a, this.f2731a);
    }

    public final void c(boolean z) {
        this.f2732a = z;
        this.f2731a = te.f3016b;
        this.f7291a = 2;
    }
}
