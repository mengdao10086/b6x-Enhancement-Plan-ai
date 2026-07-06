package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ab2 extends za2 {
    public static final boolean d(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (z) {
            return Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
        }
        return false;
    }
}
