package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class cf implements ye {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bf f5786a;

    public cf(bf bfVar) {
        this.f5786a = bfVar;
    }

    @Override // a.ye
    public boolean a(CharSequence charSequence, int i, int i2) {
        if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
            throw new IllegalArgumentException();
        }
        return this.f5786a == null ? b() : c(charSequence, i, i2);
    }

    public abstract boolean b();

    public final boolean c(CharSequence charSequence, int i, int i2) {
        int iA = this.f5786a.a(charSequence, i, i2);
        if (iA == 0) {
            return true;
        }
        if (iA != 1) {
            return b();
        }
        return false;
    }
}
