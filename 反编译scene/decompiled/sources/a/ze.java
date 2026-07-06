package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ze implements bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ze f8062a = new ze(true);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3836a;

    public ze(boolean z) {
        this.f3836a = z;
    }

    @Override // a.bf
    public int a(CharSequence charSequence, int i, int i2) {
        int i3 = i2 + i;
        boolean z = false;
        while (i < i3) {
            int iA = ff.a(Character.getDirectionality(charSequence.charAt(i)));
            if (iA != 0) {
                if (iA != 1) {
                    continue;
                    i++;
                    z = z;
                } else if (!this.f3836a) {
                    return 1;
                }
            } else if (this.f3836a) {
                return 0;
            }
            z = true;
            i++;
            z = z;
        }
        if (z) {
            return this.f3836a ? 1 : 0;
        }
        return 2;
    }
}
