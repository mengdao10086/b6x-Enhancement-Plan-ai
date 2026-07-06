package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ie {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6403a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final je[] f1354a;

    @Deprecated
    public ie(int i, je[] jeVarArr) {
        this.f6403a = i;
        this.f1354a = jeVarArr;
    }

    public static ie a(int i, je[] jeVarArr) {
        return new ie(i, jeVarArr);
    }

    public je[] b() {
        return this.f1354a;
    }

    public int c() {
        return this.f6403a;
    }
}
