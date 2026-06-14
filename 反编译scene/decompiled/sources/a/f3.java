package a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class f3 extends c3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[][] f6068a;

    public f3(f3 f3Var, g3 g3Var, Resources resources) {
        super(f3Var, g3Var, resources);
        if (f3Var != null) {
            this.f6068a = f3Var.f6068a;
        } else {
            this.f6068a = new int[f()][];
        }
    }

    public int A(int[] iArr) {
        int[][] iArr2 = this.f6068a;
        int iH = h();
        for (int i = 0; i < iH; i++) {
            if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                return i;
            }
        }
        return -1;
    }

    @Override // a.c3
    public void o(int i, int i2) {
        super.o(i, i2);
        int[][] iArr = new int[i2][];
        System.arraycopy(this.f6068a, 0, iArr, 0, i);
        this.f6068a = iArr;
    }

    public int z(int[] iArr, Drawable drawable) {
        int iA = a(drawable);
        this.f6068a[iA] = iArr;
        return iA;
    }
}
