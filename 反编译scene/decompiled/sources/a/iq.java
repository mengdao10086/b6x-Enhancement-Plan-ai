package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class iq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6434a = 0;
    public int b;
    public int c;
    public int d;
    public int e;

    public void a(int i) {
        this.f6434a = i | this.f6434a;
    }

    public boolean b() {
        int i = this.f6434a;
        if ((i & 7) != 0 && (i & (c(this.d, this.b) << 0)) == 0) {
            return false;
        }
        int i2 = this.f6434a;
        if ((i2 & 112) != 0 && (i2 & (c(this.d, this.c) << 4)) == 0) {
            return false;
        }
        int i3 = this.f6434a;
        if ((i3 & 1792) != 0 && (i3 & (c(this.e, this.b) << 8)) == 0) {
            return false;
        }
        int i4 = this.f6434a;
        return (i4 & 28672) == 0 || (i4 & (c(this.e, this.c) << 12)) != 0;
    }

    public int c(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i == i2 ? 2 : 4;
    }

    public void d() {
        this.f6434a = 0;
    }

    public void e(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }
}
