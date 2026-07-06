package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class al0 {
    public al0() {
    }

    public /* synthetic */ al0(b92 b92Var) {
        this();
    }

    public final boolean a() {
        String str;
        String[] strArr = {"/dev/block/bootdevice/by-name", "/dev/block/by-name", "/dev/block/platform/bootdevice/by-name"};
        int i = 0;
        while (true) {
            if (i >= 3) {
                str = null;
                break;
            }
            str = strArr[i];
            if (y60.f7952a.c(str)) {
                break;
            }
            i++;
        }
        return str != null;
    }
}
