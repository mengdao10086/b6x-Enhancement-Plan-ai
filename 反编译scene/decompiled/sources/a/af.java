package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class af implements bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final af f5600a = new af();

    @Override // a.bf
    public int a(CharSequence charSequence, int i, int i2) {
        int i3 = i2 + i;
        int iB = 2;
        while (i < i3 && iB == 2) {
            iB = ff.b(Character.getDirectionality(charSequence.charAt(i)));
            i++;
        }
        return iB;
    }
}
