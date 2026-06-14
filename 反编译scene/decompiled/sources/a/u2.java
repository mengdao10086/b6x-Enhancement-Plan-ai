package a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class u2 extends f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fa<Long> f7557a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ja<Integer> f3116a;

    public u2(u2 u2Var, z2 z2Var, Resources resources) {
        ja<Integer> jaVar;
        super(u2Var, z2Var, resources);
        if (u2Var != null) {
            this.f7557a = u2Var.f7557a;
            jaVar = u2Var.f3116a;
        } else {
            this.f7557a = new fa<>();
            jaVar = new ja<>();
        }
        this.f3116a = jaVar;
    }

    public static long D(int i, int i2) {
        return ((long) i2) | (((long) i) << 32);
    }

    public int B(int[] iArr, Drawable drawable, int i) {
        int iZ = super.z(iArr, drawable);
        this.f3116a.j(iZ, Integer.valueOf(i));
        return iZ;
    }

    public int C(int i, int i2, Drawable drawable, boolean z) {
        int iA = super.a(drawable);
        long jD = D(i, i2);
        long j = z ? 8589934592L : 0L;
        long j2 = iA;
        this.f7557a.a(jD, Long.valueOf(j2 | j));
        if (z) {
            this.f7557a.a(D(i2, i), Long.valueOf(4294967296L | j2 | j));
        }
        return iA;
    }

    public int E(int i) {
        if (i < 0) {
            return 0;
        }
        return this.f3116a.f(i, 0).intValue();
    }

    public int F(int[] iArr) {
        int iA = super.A(iArr);
        return iA >= 0 ? iA : super.A(StateSet.WILD_CARD);
    }

    public int G(int i, int i2) {
        return (int) this.f7557a.f(D(i, i2), -1L).longValue();
    }

    public boolean H(int i, int i2) {
        return (this.f7557a.f(D(i, i2), -1L).longValue() & 4294967296L) != 0;
    }

    public boolean I(int i, int i2) {
        return (this.f7557a.f(D(i, i2), -1L).longValue() & 8589934592L) != 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return new z2(this, null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return new z2(this, resources);
    }

    @Override // a.c3
    public void r() {
        this.f7557a = this.f7557a.clone();
        this.f3116a = this.f3116a.clone();
    }
}
