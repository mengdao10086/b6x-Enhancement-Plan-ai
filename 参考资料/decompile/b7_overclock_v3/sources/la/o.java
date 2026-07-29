package la;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o<T extends Entry> extends d<T> implements qa.h<T> {
    public float A;
    public DashPathEffect B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f39519y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f39520z;

    public o(List<T> list, String str) {
        super(list, str);
        this.f39519y = true;
        this.f39520z = true;
        this.A = 0.5f;
        this.B = null;
        this.A = xa.k.e(0.5f);
    }

    @Override // qa.h
    public float K() {
        return this.A;
    }

    public void U1(o oVar) {
        super.S1(oVar);
        oVar.f39520z = this.f39520z;
        oVar.f39519y = this.f39519y;
        oVar.A = this.A;
        oVar.B = this.B;
    }

    public void V1() {
        this.B = null;
    }

    public void W1(float f10, float f11, float f12) {
        this.B = new DashPathEffect(new float[]{f10, f11}, f12);
    }

    public boolean X1() {
        return this.B != null;
    }

    public void Y1(boolean z10) {
        a2(z10);
        Z1(z10);
    }

    public void Z1(boolean z10) {
        this.f39520z = z10;
    }

    public void a2(boolean z10) {
        this.f39519y = z10;
    }

    public void b2(float f10) {
        this.A = xa.k.e(f10);
    }

    @Override // qa.h
    public boolean j1() {
        return this.f39519y;
    }

    @Override // qa.h
    public boolean n1() {
        return this.f39520z;
    }

    @Override // qa.h
    public DashPathEffect w0() {
        return this.B;
    }
}
