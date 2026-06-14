package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class fg2 extends od2 {
    public abstract fg2 p();

    public final String t() {
        fg2 fg2VarP;
        fg2 fg2VarC = qe2.c();
        if (this == fg2VarC) {
            return "Dispatchers.Main";
        }
        try {
            fg2VarP = fg2VarC.p();
        } catch (UnsupportedOperationException unused) {
            fg2VarP = null;
        }
        if (this == fg2VarP) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
