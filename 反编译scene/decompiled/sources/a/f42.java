package a;

import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class f42 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f6073a;

    public f42(Throwable th) {
        f92.d(th, "exception");
        this.f6073a = th;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f42) && f92.a(this.f6073a, ((f42) obj).f6073a);
    }

    public int hashCode() {
        return this.f6073a.hashCode();
    }

    public String toString() {
        return "Failure(" + this.f6073a + ')';
    }
}
