package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class di {
    public static int a() {
        return 128;
    }

    public static int b(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 32) {
            return 5;
        }
        if (i == 64) {
            return 6;
        }
        if (i == 128) {
            return 7;
        }
        if (i == 256) {
            return 8;
        }
        throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
    }

    public static int c() {
        return 1;
    }

    public static int d() {
        return 7;
    }
}
