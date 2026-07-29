package qa;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import java.util.List;
import na.l;

/* JADX INFO: loaded from: classes3.dex */
public interface e<T extends Entry> {
    void A0(float f10);

    boolean C();

    List<Integer> C0();

    Legend.LegendForm D();

    void E(Typeface typeface);

    void F0(float f10, float f11);

    int H();

    void H0(List<Integer> list);

    void I(l lVar);

    String J();

    List<T> J0(float f10);

    void K0();

    float L();

    List<ua.a> N0();

    ua.a O();

    int P(int i10);

    void R(int i10);

    float R0();

    float U();

    l V();

    boolean V0();

    float Y();

    T Z(int i10);

    YAxis.AxisDependency a1();

    void b(xa.g gVar);

    boolean b1(int i10);

    void c(boolean z10);

    void c1(boolean z10);

    void clear();

    float d0();

    int e1();

    int f0(int i10);

    xa.g f1();

    int g1();

    boolean i1();

    boolean isVisible();

    void k0(boolean z10);

    void l(YAxis.AxisDependency axisDependency);

    void l1(T t10);

    Typeface m0();

    ua.a m1(int i10);

    float o();

    boolean o0();

    void o1(String str);

    boolean p0(T t10);

    float q();

    int q0(float f10, float f11, DataSet.Rounding rounding);

    boolean r(float f10);

    boolean removeFirst();

    boolean removeLast();

    void setVisible(boolean z10);

    int t(T t10);

    boolean t0(T t10);

    T u0(float f10, float f11, DataSet.Rounding rounding);

    int v0(int i10);

    DashPathEffect x();

    T y(float f10, float f11);

    boolean y0(T t10);
}
