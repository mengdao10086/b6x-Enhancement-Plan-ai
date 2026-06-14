package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class h92 implements y82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f6290a;

    public h92(Class<?> cls, String str) {
        f92.d(cls, "jClass");
        f92.d(str, "moduleName");
        this.f6290a = cls;
    }

    @Override // a.y82
    public Class<?> a() {
        return this.f6290a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof h92) && f92.a(a(), ((h92) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
