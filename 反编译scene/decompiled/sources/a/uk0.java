package a;

import android.content.res.Resources;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uk0 extends Resources {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sk0 f7606a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Resources f3196a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uk0(Resources resources, sk0 sk0Var) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        f92.d(resources, "original");
        f92.d(sk0Var, "override");
        this.f3196a = resources;
        this.f7606a = sk0Var;
    }

    @Override // android.content.res.Resources
    public String getString(int i) {
        sk0 sk0Var = this.f7606a;
        String resourceEntryName = this.f3196a.getResourceEntryName(i);
        f92.c(resourceEntryName, "original.getResourceEntryName(id)");
        String strF = sk0Var.f(resourceEntryName);
        if (strF != null) {
            return strF;
        }
        String string = this.f3196a.getString(i);
        f92.c(string, "original.getString(id)");
        return string;
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) {
        sk0 sk0Var = this.f7606a;
        String resourceEntryName = this.f3196a.getResourceEntryName(i);
        f92.c(resourceEntryName, "original.getResourceEntryName(id)");
        String[] strArrG = sk0Var.g(resourceEntryName);
        if (strArrG != null) {
            return strArrG;
        }
        String[] stringArray = this.f3196a.getStringArray(i);
        f92.c(stringArray, "original.getStringArray(id)");
        return stringArray;
    }
}
