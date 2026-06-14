package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class f8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6081a = 0;
    public int b = 0;
    public int c = Integer.MIN_VALUE;
    public int d = Integer.MIN_VALUE;
    public int e = 0;
    public int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f857a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f858b = false;

    public int a() {
        return this.f857a ? this.f6081a : this.b;
    }

    public int b() {
        return this.f6081a;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.f857a ? this.b : this.f6081a;
    }

    public void e(int i, int i2) {
        this.f858b = false;
        if (i != Integer.MIN_VALUE) {
            this.e = i;
            this.f6081a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f = i2;
            this.b = i2;
        }
    }

    public void f(boolean z) {
        int i;
        if (z == this.f857a) {
            return;
        }
        this.f857a = z;
        if (this.f858b) {
            if (z) {
                int i2 = this.d;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = this.e;
                }
                this.f6081a = i2;
                i = this.c;
                if (i == Integer.MIN_VALUE) {
                }
            } else {
                int i3 = this.c;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.e;
                }
                this.f6081a = i3;
                i = this.d;
                if (i == Integer.MIN_VALUE) {
                }
            }
            this.b = i;
        }
        this.f6081a = this.e;
        i = this.f;
        this.b = i;
    }

    public void g(int i, int i2) {
        this.c = i;
        this.d = i2;
        this.f858b = true;
        if (this.f857a) {
            if (i2 != Integer.MIN_VALUE) {
                this.f6081a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f6081a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.b = i2;
        }
    }
}
