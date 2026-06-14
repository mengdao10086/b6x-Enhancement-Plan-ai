package a;

import a.v4;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class m5 implements v4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n5 f6770a;

    public m5(n5 n5Var) {
        this.f6770a = n5Var;
    }

    @Override // a.v4.a
    public void b(i4 i4Var, boolean z) {
        if (i4Var instanceof c5) {
            i4Var.D().e(false);
        }
        v4.a aVarM = this.f6770a.m();
        if (aVarM != null) {
            aVarM.b(i4Var, z);
        }
    }

    @Override // a.v4.a
    public boolean c(i4 i4Var) {
        if (i4Var == ((x3) ((x3) this.f6770a)).f3515a) {
            return false;
        }
        this.f6770a.g = ((c5) i4Var).getItem().getItemId();
        v4.a aVarM = this.f6770a.m();
        if (aVarM != null) {
            return aVarM.c(i4Var);
        }
        return false;
    }
}
