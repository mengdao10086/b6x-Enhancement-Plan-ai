package la;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n<T extends Entry> extends o<T> implements qa.g<T> {
    public int C;
    public Drawable D;
    public int E;
    public float F;
    public boolean G;

    public n(List<T> list, String str) {
        super(list, str);
        this.C = Color.rgb(140, 234, 255);
        this.E = 85;
        this.F = 2.5f;
        this.G = false;
    }

    @Override // qa.g
    public Drawable S() {
        return this.D;
    }

    @Override // qa.g
    public boolean b0() {
        return this.G;
    }

    public void c2(n nVar) {
        super.U1(nVar);
        nVar.G = this.G;
        nVar.E = this.E;
        nVar.C = this.C;
        nVar.D = this.D;
        nVar.F = this.F;
    }

    public void d2(int i10) {
        this.E = i10;
    }

    public void e2(int i10) {
        this.C = i10;
        this.D = null;
    }

    @TargetApi(18)
    public void f2(Drawable drawable) {
        this.D = drawable;
    }

    public void g2(float f10) {
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (f10 > 10.0f) {
            f10 = 10.0f;
        }
        this.F = xa.k.e(f10);
    }

    @Override // qa.g
    public int h() {
        return this.C;
    }

    @Override // qa.g
    public int m() {
        return this.E;
    }

    @Override // qa.g
    public void s0(boolean z10) {
        this.G = z10;
    }

    @Override // qa.g
    public float v() {
        return this.F;
    }
}
