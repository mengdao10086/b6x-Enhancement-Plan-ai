package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7689a;

    public vf(Object obj) {
        this.f7689a = obj;
    }

    public static vf a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new vf(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || vf.class != obj.getClass()) {
            return false;
        }
        return kf.a(this.f7689a, ((vf) obj).f7689a);
    }

    public int hashCode() {
        Object obj = this.f7689a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f7689a + "}";
    }
}
