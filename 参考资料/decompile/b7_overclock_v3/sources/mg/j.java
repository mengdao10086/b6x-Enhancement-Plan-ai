package mg;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.google.common.collect.LinkedHashMultimap;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import g.l;
import g.n;
import g.n0;
import g.p0;
import g.x;

/* JADX INFO: loaded from: classes5.dex */
public interface j {
    j A(boolean z10);

    j C(boolean z10);

    j E();

    j F(sg.c cVar);

    j I(boolean z10);

    j L(sg.d dVar);

    j M();

    j N();

    boolean O(int i10, int i11, float f10, boolean z10);

    j P(float f10);

    j Q(@n0 g gVar, int i10, int i11);

    j R(float f10);

    j S(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10);

    j T(boolean z10);

    j U(int i10, boolean z10, boolean z11);

    j V(@n0 Interpolator interpolator);

    j W(@n int... iArr);

    j X(int i10);

    boolean Y();

    j Z(boolean z10);

    j a(boolean z10);

    j a0(boolean z10);

    j b(boolean z10);

    j b0(boolean z10);

    j c(k kVar);

    j c0(boolean z10);

    boolean d(int i10);

    j d0(boolean z10);

    boolean e();

    j e0(@n0 f fVar);

    j f(boolean z10);

    j f0(boolean z10);

    j g();

    j g0(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10);

    @n0
    ViewGroup getLayout();

    @p0
    f getRefreshFooter();

    @p0
    g getRefreshHeader();

    @n0
    RefreshState getState();

    j h(@n0 f fVar, int i10, int i11);

    j h0(boolean z10);

    j i();

    j i0(float f10);

    j j(boolean z10);

    j j0(int i10, boolean z10, Boolean bool);

    j k(@n0 View view);

    boolean k0();

    j l(sg.e eVar);

    j m(boolean z10);

    j m0(boolean z10);

    j n(@x(from = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR, to = 10.0d) float f10);

    j n0(boolean z10);

    boolean o(int i10, int i11, float f10, boolean z10);

    @Deprecated
    j o0(boolean z10);

    j p(@n0 g gVar);

    j p0(boolean z10);

    j q(int i10);

    j r(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10);

    j s(boolean z10);

    j setPrimaryColors(@l int... iArr);

    j t(float f10);

    j u(int i10);

    j v(@n0 View view, int i10, int i11);

    j w();

    j x(sg.b bVar);

    j y(@x(from = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR, to = 10.0d) float f10);

    boolean z();
}
