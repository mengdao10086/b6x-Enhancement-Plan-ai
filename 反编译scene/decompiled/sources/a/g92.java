package a;

import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class g92<R> implements c92<R>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6187a;

    public g92(int i) {
        this.f6187a = i;
    }

    @Override // a.c92
    public int h() {
        return this.f6187a;
    }

    public String toString() {
        String strE = o92.e(this);
        f92.c(strE, "Reflection.renderLambdaToString(this)");
        return strE;
    }
}
