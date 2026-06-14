package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class tf2 extends bg2 implements fd2 {
    public final boolean b;

    public tf2(qf2 qf2Var) {
        super(true);
        d0(qf2Var);
        this.b = D0();
    }

    public final boolean D0() {
        bg2 bg2Var;
        zc2 zc2VarZ = Z();
        if (!(zc2VarZ instanceof ad2)) {
            zc2VarZ = null;
        }
        ad2 ad2Var = (ad2) zc2VarZ;
        if (ad2Var != null && (bg2Var = (bg2) ((wf2) ad2Var).f7784a) != null) {
            while (!bg2Var.W()) {
                zc2 zc2VarZ2 = bg2Var.Z();
                if (!(zc2VarZ2 instanceof ad2)) {
                    zc2VarZ2 = null;
                }
                ad2 ad2Var2 = (ad2) zc2VarZ2;
                if (ad2Var2 == null || (bg2Var = (bg2) ((wf2) ad2Var2).f7784a) == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // a.bg2
    public boolean W() {
        return this.b;
    }

    @Override // a.bg2
    public boolean X() {
        return true;
    }
}
