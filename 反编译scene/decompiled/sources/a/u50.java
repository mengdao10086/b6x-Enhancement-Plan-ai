package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class u50 {
    public static int a(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i += (bArr[i2] & 255) << ((3 - i2) * 8);
        }
        return i;
    }

    public static byte[] b(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }
}
