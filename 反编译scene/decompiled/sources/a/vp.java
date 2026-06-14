package a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vp extends wp {
    public vp(RecyclerView.o oVar) {
        super(oVar, null);
    }

    @Override // a.wp
    public int d(View view) {
        return ((wp) this).f3465a.Y(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
    }

    @Override // a.wp
    public int e(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return ((wp) this).f3465a.b0(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
    }

    @Override // a.wp
    public int f(View view) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return ((wp) this).f3465a.c0(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
    }

    @Override // a.wp
    public int g(View view) {
        return ((wp) this).f3465a.e0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
    }

    @Override // a.wp
    public int h() {
        return ((wp) this).f3465a.g0();
    }

    @Override // a.wp
    public int i() {
        return ((wp) this).f3465a.g0() - ((wp) this).f3465a.getPaddingBottom();
    }

    @Override // a.wp
    public int j() {
        return ((wp) this).f3465a.getPaddingBottom();
    }

    @Override // a.wp
    public int k() {
        return ((wp) this).f3465a.h0();
    }

    @Override // a.wp
    public int l() {
        return ((wp) this).f3465a.u0();
    }

    @Override // a.wp
    public int m() {
        return ((wp) this).f3465a.getPaddingTop();
    }

    @Override // a.wp
    public int n() {
        return (((wp) this).f3465a.g0() - ((wp) this).f3465a.getPaddingTop()) - ((wp) this).f3465a.getPaddingBottom();
    }

    @Override // a.wp
    public int p(View view) {
        ((wp) this).f3465a.s0(view, true, ((wp) this).f3464a);
        return ((wp) this).f3464a.bottom;
    }

    @Override // a.wp
    public int q(View view) {
        ((wp) this).f3465a.s0(view, true, ((wp) this).f3464a);
        return ((wp) this).f3464a.top;
    }

    @Override // a.wp
    public void r(int i) {
        ((wp) this).f3465a.J0(i);
    }
}
