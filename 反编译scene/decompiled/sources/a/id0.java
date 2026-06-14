package a;

import com.omarea.krscript.model.KrScriptActionHandler;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class id0 implements cg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nd0 f6401a;

    public id0(nd0 nd0Var) {
        this.f6401a = nd0Var;
    }

    @Override // a.cg0
    public boolean openFileChooser(eg0 eg0Var) {
        f92.d(eg0Var, "fileSelectedInterface");
        if (this.f6401a.f6902a.f7008a.f890a == null) {
            return false;
        }
        KrScriptActionHandler krScriptActionHandler = this.f6401a.f6902a.f7008a.f890a;
        f92.b(krScriptActionHandler);
        return krScriptActionHandler.openFileChooser(eg0Var);
    }
}
