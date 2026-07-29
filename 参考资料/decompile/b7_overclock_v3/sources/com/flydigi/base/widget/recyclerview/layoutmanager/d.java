package com.flydigi.base.widget.recyclerview.layoutmanager;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13663d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f13664e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f13665f = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.o f13666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f13668c;

    public class a extends d {
        public a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int d(View view) {
            return this.f13666a.j0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f13666a.i0(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f13666a.h0(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int g(View view) {
            return this.f13666a.g0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int h() {
            return this.f13666a.B0();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int i() {
            return this.f13666a.B0() - this.f13666a.getPaddingRight();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int j() {
            return this.f13666a.getPaddingRight();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int k() {
            return this.f13666a.C0();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int l() {
            return this.f13666a.n0();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int m() {
            return this.f13666a.getPaddingLeft();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int n() {
            return (this.f13666a.B0() - this.f13666a.getPaddingLeft()) - this.f13666a.getPaddingRight();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int p() {
            return (this.f13666a.m0() - this.f13666a.getPaddingTop()) - this.f13666a.getPaddingBottom();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int q(View view) {
            this.f13666a.A0(view, true, this.f13668c);
            return this.f13668c.right;
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int r(View view) {
            this.f13666a.A0(view, true, this.f13668c);
            return this.f13668c.left;
        }
    }

    public class b extends d {
        public b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int d(View view) {
            return this.f13666a.e0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f13666a.h0(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f13666a.i0(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int g(View view) {
            return this.f13666a.k0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int h() {
            return this.f13666a.m0();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int i() {
            return this.f13666a.m0() - this.f13666a.getPaddingBottom();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int j() {
            return this.f13666a.getPaddingBottom();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int k() {
            return this.f13666a.n0();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int l() {
            return this.f13666a.C0();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int m() {
            return this.f13666a.getPaddingTop();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int n() {
            return (this.f13666a.m0() - this.f13666a.getPaddingTop()) - this.f13666a.getPaddingBottom();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int p() {
            return (this.f13666a.B0() - this.f13666a.getPaddingLeft()) - this.f13666a.getPaddingRight();
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int q(View view) {
            this.f13666a.A0(view, true, this.f13668c);
            return this.f13668c.bottom;
        }

        @Override // com.flydigi.base.widget.recyclerview.layoutmanager.d
        public int r(View view) {
            this.f13666a.A0(view, true, this.f13668c);
            return this.f13668c.top;
        }
    }

    public /* synthetic */ d(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static d a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static d b(RecyclerView.o oVar, int i10) {
        if (i10 == 0) {
            return a(oVar);
        }
        if (i10 == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static d c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f13667b) {
            return 0;
        }
        return n() - this.f13667b;
    }

    public abstract int p();

    public abstract int q(View view);

    public abstract int r(View view);

    public void s() {
        this.f13667b = n();
    }

    public d(RecyclerView.o oVar) {
        this.f13667b = Integer.MIN_VALUE;
        this.f13668c = new Rect();
        this.f13666a = oVar;
    }
}
