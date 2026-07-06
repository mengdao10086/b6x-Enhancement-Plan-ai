package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class za2 {
    public static final int a(int i) {
        if (2 <= i && 36 >= i) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new ea2(2, 36));
    }

    public static final int b(char c, int i) {
        return Character.digit((int) c, i);
    }

    public static final boolean c(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }
}
