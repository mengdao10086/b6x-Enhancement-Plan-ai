package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class d60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5865a;

    public d60(int i) {
        this.f5865a = i;
    }

    public final int a(int i) {
        int i2 = i | this.f5865a;
        this.f5865a = i2;
        return i2;
    }

    public final boolean b(int i) {
        return (this.f5865a & i) == i;
    }

    public final int c(int i) {
        int i2 = (~i) & this.f5865a;
        this.f5865a = i2;
        return i2;
    }
}
