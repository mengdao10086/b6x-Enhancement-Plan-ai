package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7411a = "/sys/module/lowmemorykiller/parameters/minfree";

    public final void a(long j) {
        float f = 1.0f;
        if (j > 8589934592L) {
            f = 2.0f;
        } else if (j > 6442450944L) {
            f = 1.5f;
        } else if (j <= 4294967296L && j <= 3221225472L) {
            if (j > 2147483648L) {
                f = 0.7f;
            } else {
                long j2 = 1073741824;
                f = j > j2 ? 0.5f : j > j2 ? 0.25f : 0.2f;
            }
        }
        x60 x60Var = x60.f7856a;
        String str = this.f7411a;
        StringBuilder sb = new StringBuilder();
        sb.append((int) (10240 * f));
        sb.append(',');
        sb.append((int) (16384 * f));
        sb.append(',');
        sb.append((int) (18432 * f));
        sb.append(',');
        sb.append((int) (20480 * f));
        sb.append(',');
        sb.append((int) (30720 * f));
        sb.append(',');
        sb.append((int) (33280 * f));
        x60Var.j(str, sb.toString());
        x60.f7856a.j("/sys/module/lowmemorykiller/parameters/enable_adaptive_lmk", "0");
    }

    public final String b() {
        return x60.f7856a.d(this.f7411a);
    }

    public final boolean c() {
        return y60.f7952a.d(this.f7411a);
    }
}
