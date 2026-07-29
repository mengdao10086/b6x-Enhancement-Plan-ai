package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cd.k0;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.c;
import com.google.android.exoplayer2.ui.l;
import g.p0;
import hd.e0;
import hd.u0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import ya.h1;
import ya.i1;
import ya.j1;
import ya.k1;
import ya.r0;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public class i extends FrameLayout {

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public static final int f18836r8 = 5000;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public static final int f18837s8 = 0;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public static final int f18838t8 = 200;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public static final int f18839u8 = 100;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public static final int f18840v8 = 1000;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public static final int f18841w8 = 0;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public static final int f18842x8 = 1;
    public final Drawable A;
    public final Drawable B;
    public final float C;
    public final String C1;
    public final Drawable C2;
    public final float D;
    public final String E7;

    @p0
    public j1 F7;
    public ya.h G7;

    @p0
    public f H7;

    @p0
    public i1 I7;

    @p0
    public d J7;
    public final String K0;
    public final String K1;
    public final String K2;
    public boolean K7;
    public boolean L7;
    public boolean M7;
    public boolean N7;
    public boolean O7;
    public int P7;
    public int Q7;
    public int R7;
    public long[] S7;
    public boolean[] T7;
    public long[] U7;
    public boolean[] V7;
    public long W7;
    public long X7;
    public long Y7;
    public com.google.android.exoplayer2.ui.j Z7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f18843a;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public Resources f18844a8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<m> f18845b;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public RecyclerView f18846b8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final View f18847c;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public h f18848c8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final View f18849d;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public e f18850d8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final View f18851e;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public PopupWindow f18852e8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public final View f18853f;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public boolean f18854f8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public final View f18855g;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public int f18856g8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public final TextView f18857h;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    @p0
    public DefaultTrackSelector f18858h8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public final TextView f18859i;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public l f18860i8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public final ImageView f18861j;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public l f18862j8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public final ImageView f18863k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final String f18864k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final Drawable f18865k1;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public k0 f18866k8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public final View f18867l;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    @p0
    public ImageView f18868l8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public final TextView f18869m;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    @p0
    public ImageView f18870m8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @p0
    public final TextView f18871n;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    @p0
    public ImageView f18872n8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public final com.google.android.exoplayer2.ui.l f18873o;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    @p0
    public View f18874o8;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final StringBuilder f18875p;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @p0
    public View f18876p8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Formatter f18877q;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @p0
    public View f18878q8;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final x1.b f18879r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final x1.c f18880s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Runnable f18881t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Drawable f18882u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Drawable f18883v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final Drawable f18884v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public final Drawable f18885v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Drawable f18886w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f18887x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f18888y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f18889z;

    public final class b extends l {
        public b() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(View view) {
            if (i.this.f18858h8 != null) {
                DefaultTrackSelector.d dVarA = i.this.f18858h8.v().a();
                for (int i10 = 0; i10 < this.f18912a.size(); i10++) {
                    dVarA = dVarA.o(this.f18912a.get(i10).intValue());
                }
                ((DefaultTrackSelector) hd.a.g(i.this.f18858h8)).N(dVarA);
            }
            i.this.f18848c8.n(1, i.this.getResources().getString(R.string.exo_track_selection_auto));
            i.this.f18852e8.dismiss();
        }

        @Override // com.google.android.exoplayer2.ui.i.l
        public void n(List<Integer> list, List<k> list2, c.a aVar) {
            boolean z10;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (i11 >= list.size()) {
                    z10 = false;
                    break;
                }
                int iIntValue = list.get(i11).intValue();
                TrackGroupArray trackGroupArrayG = aVar.g(iIntValue);
                if (i.this.f18858h8 != null && i.this.f18858h8.v().T(iIntValue, trackGroupArrayG)) {
                    z10 = true;
                    break;
                }
                i11++;
            }
            if (!list2.isEmpty()) {
                if (z10) {
                    while (true) {
                        if (i10 >= list2.size()) {
                            break;
                        }
                        k kVar = list2.get(i10);
                        if (kVar.f18911e) {
                            i.this.f18848c8.n(1, kVar.f18910d);
                            break;
                        }
                        i10++;
                    }
                } else {
                    i.this.f18848c8.n(1, i.this.getResources().getString(R.string.exo_track_selection_auto));
                }
            } else {
                i.this.f18848c8.n(1, i.this.getResources().getString(R.string.exo_track_selection_none));
            }
            this.f18912a = list;
            this.f18913b = list2;
            this.f18914c = aVar;
        }

        @Override // com.google.android.exoplayer2.ui.i.l
        public void q(C0196i c0196i) {
            boolean z10;
            c0196i.f18904a.setText(R.string.exo_track_selection_auto);
            DefaultTrackSelector.Parameters parametersV = ((DefaultTrackSelector) hd.a.g(i.this.f18858h8)).v();
            int i10 = 0;
            while (true) {
                if (i10 >= this.f18912a.size()) {
                    z10 = false;
                    break;
                }
                int iIntValue = this.f18912a.get(i10).intValue();
                if (parametersV.T(iIntValue, ((c.a) hd.a.g(this.f18914c)).g(iIntValue))) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            c0196i.f18905b.setVisibility(z10 ? 4 : 0);
            c0196i.itemView.setOnClickListener(new View.OnClickListener() { // from class: cd.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f10915a.u(view);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.i.l
        public void s(String str) {
            i.this.f18848c8.n(1, str);
        }
    }

    public final class c implements j1.f, l.a, View.OnClickListener, PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // ya.j1.f
        public /* synthetic */ void B(boolean z10) {
            k1.c(this, z10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void D(boolean z10, int i10) {
            k1.m(this, z10, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void R(boolean z10, int i10) {
            k1.h(this, z10, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void S(x1 x1Var, int i10) {
            k1.s(this, x1Var, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void V(boolean z10) {
            k1.b(this, z10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void Z(v0 v0Var, int i10) {
            k1.g(this, v0Var, i10);
        }

        @Override // com.google.android.exoplayer2.ui.l.a
        public void a(com.google.android.exoplayer2.ui.l lVar, long j10) {
            if (i.this.f18871n != null) {
                i.this.f18871n.setText(u0.p0(i.this.f18875p, i.this.f18877q, j10));
            }
        }

        @Override // ya.j1.f
        public /* synthetic */ void b(h1 h1Var) {
            k1.i(this, h1Var);
        }

        @Override // ya.j1.f
        public /* synthetic */ void b0(boolean z10) {
            k1.e(this, z10);
        }

        @Override // com.google.android.exoplayer2.ui.l.a
        public void c(com.google.android.exoplayer2.ui.l lVar, long j10, boolean z10) {
            i.this.O7 = false;
            if (!z10 && i.this.F7 != null) {
                i iVar = i.this;
                iVar.t0(iVar.F7, j10);
            }
            i.this.Z7.X();
        }

        @Override // com.google.android.exoplayer2.ui.l.a
        public void d(com.google.android.exoplayer2.ui.l lVar, long j10) {
            i.this.O7 = true;
            if (i.this.f18871n != null) {
                i.this.f18871n.setText(u0.p0(i.this.f18875p, i.this.f18877q, j10));
            }
            i.this.Z7.W();
        }

        @Override // ya.j1.f
        public /* synthetic */ void e(int i10) {
            k1.k(this, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void f(x1 x1Var, Object obj, int i10) {
            k1.t(this, x1Var, obj, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void g(boolean z10) {
            k1.f(this, z10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void h(TrackGroupArray trackGroupArray, ad.i iVar) {
            k1.u(this, trackGroupArray, iVar);
        }

        @Override // ya.j1.f
        public /* synthetic */ void i(int i10) {
            k1.n(this, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void k(List list) {
            k1.r(this, list);
        }

        @Override // ya.j1.f
        public /* synthetic */ void m(ExoPlaybackException exoPlaybackException) {
            k1.l(this, exoPlaybackException);
        }

        @Override // ya.j1.f
        public /* synthetic */ void n(boolean z10) {
            k1.d(this, z10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void o() {
            k1.p(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j1 j1Var = i.this.F7;
            if (j1Var == null) {
                return;
            }
            i.this.Z7.X();
            if (i.this.f18849d == view) {
                i.this.G7.f(j1Var);
                return;
            }
            if (i.this.f18847c == view) {
                i.this.G7.l(j1Var);
                return;
            }
            if (i.this.f18853f == view) {
                if (j1Var.d() != 4) {
                    i.this.G7.a(j1Var);
                    return;
                }
                return;
            }
            if (i.this.f18855g == view) {
                i.this.G7.k(j1Var);
                return;
            }
            if (i.this.f18851e == view) {
                i.this.Z(j1Var);
                return;
            }
            if (i.this.f18861j == view) {
                i.this.G7.d(j1Var, e0.a(j1Var.k(), i.this.R7));
                return;
            }
            if (i.this.f18863k == view) {
                i.this.G7.j(j1Var, !j1Var.u1());
                return;
            }
            if (i.this.f18874o8 == view) {
                i.this.Z7.W();
                i iVar = i.this;
                iVar.a0(iVar.f18848c8);
                return;
            }
            if (i.this.f18876p8 == view) {
                i.this.Z7.W();
                i iVar2 = i.this;
                iVar2.a0(iVar2.f18850d8);
            } else if (i.this.f18878q8 == view) {
                i.this.Z7.W();
                i iVar3 = i.this;
                iVar3.a0(iVar3.f18862j8);
            } else if (i.this.f18868l8 == view) {
                i.this.Z7.W();
                i iVar4 = i.this;
                iVar4.a0(iVar4.f18860i8);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (i.this.f18854f8) {
                i.this.Z7.X();
            }
        }

        @Override // ya.j1.f
        public void p(j1 j1Var, j1.g gVar) {
            if (gVar.d(5, 6)) {
                i.this.D0();
            }
            if (gVar.d(5, 6, 8)) {
                i.this.F0();
            }
            if (gVar.c(9)) {
                i.this.G0();
            }
            if (gVar.c(10)) {
                i.this.J0();
            }
            if (gVar.d(9, 10, 12, 0)) {
                i.this.C0();
            }
            if (gVar.d(12, 0)) {
                i.this.K0();
            }
            if (gVar.c(13)) {
                i.this.E0();
            }
            if (gVar.c(2)) {
                i.this.L0();
            }
        }

        @Override // ya.j1.f
        public /* synthetic */ void r(int i10) {
            k1.j(this, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void v(int i10) {
            k1.o(this, i10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void y(boolean z10) {
            k1.q(this, z10);
        }
    }

    public interface d {
        void a(boolean z10);
    }

    public final class e extends RecyclerView.g<C0196i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f18892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f18893b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f18894c;

        public e(String[] strArr, int[] iArr) {
            this.f18892a = strArr;
            this.f18893b = iArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(int i10, View view) {
            if (i10 != this.f18894c) {
                i.this.setPlaybackSpeed(this.f18893b[i10] / 100.0f);
            }
            i.this.f18852e8.dismiss();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int getItemCount() {
            return this.f18892a.length;
        }

        public String m() {
            return this.f18892a[this.f18894c];
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C0196i c0196i, final int i10) {
            String[] strArr = this.f18892a;
            if (i10 < strArr.length) {
                c0196i.f18904a.setText(strArr[i10]);
            }
            c0196i.f18905b.setVisibility(i10 == this.f18894c ? 0 : 4);
            c0196i.itemView.setOnClickListener(new View.OnClickListener() { // from class: cd.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f10916a.n(i10, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public C0196i onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new C0196i(LayoutInflater.from(i.this.getContext()).inflate(R.layout.exo_styled_sub_settings_list_item, (ViewGroup) null));
        }

        public void q(float f10) {
            int iRound = Math.round(f10 * 100.0f);
            int i10 = 0;
            int i11 = 0;
            int i12 = Integer.MAX_VALUE;
            while (true) {
                int[] iArr = this.f18893b;
                if (i10 >= iArr.length) {
                    this.f18894c = i11;
                    return;
                }
                int iAbs = Math.abs(iRound - iArr[i10]);
                if (iAbs < i12) {
                    i11 = i10;
                    i12 = iAbs;
                }
                i10++;
            }
        }
    }

    public interface f {
        void a(long j10, long j11);
    }

    public final class g extends RecyclerView.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f18896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f18897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f18898c;

        public g(View view) {
            super(view);
            this.f18896a = (TextView) view.findViewById(R.id.exo_main_text);
            this.f18897b = (TextView) view.findViewById(R.id.exo_sub_text);
            this.f18898c = (ImageView) view.findViewById(R.id.exo_icon);
            view.setOnClickListener(new View.OnClickListener() { // from class: cd.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f10918a.l(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(View view) {
            i.this.p0(getAdapterPosition());
        }
    }

    public class h extends RecyclerView.g<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f18900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f18901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Drawable[] f18902c;

        public h(String[] strArr, Drawable[] drawableArr) {
            this.f18900a = strArr;
            this.f18901b = new String[strArr.length];
            this.f18902c = drawableArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int getItemCount() {
            return this.f18900a.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public long getItemId(int i10) {
            return i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(g gVar, int i10) {
            gVar.f18896a.setText(this.f18900a[i10]);
            if (this.f18901b[i10] == null) {
                gVar.f18897b.setVisibility(8);
            } else {
                gVar.f18897b.setText(this.f18901b[i10]);
            }
            if (this.f18902c[i10] == null) {
                gVar.f18898c.setVisibility(8);
            } else {
                gVar.f18898c.setImageDrawable(this.f18902c[i10]);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public g onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return i.this.new g(LayoutInflater.from(i.this.getContext()).inflate(R.layout.exo_styled_settings_list_item, (ViewGroup) null));
        }

        public void n(int i10, String str) {
            this.f18901b[i10] = str;
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.ui.i$i, reason: collision with other inner class name */
    public static class C0196i extends RecyclerView.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f18904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f18905b;

        public C0196i(View view) {
            super(view);
            this.f18904a = (TextView) view.findViewById(R.id.exo_text);
            this.f18905b = view.findViewById(R.id.exo_check);
        }
    }

    public final class j extends l {
        public j() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(View view) {
            if (i.this.f18858h8 != null) {
                DefaultTrackSelector.d dVarA = i.this.f18858h8.v().a();
                for (int i10 = 0; i10 < this.f18912a.size(); i10++) {
                    int iIntValue = this.f18912a.get(i10).intValue();
                    dVarA = dVarA.o(iIntValue).Z(iIntValue, true);
                }
                ((DefaultTrackSelector) hd.a.g(i.this.f18858h8)).N(dVarA);
                i.this.f18852e8.dismiss();
            }
        }

        @Override // com.google.android.exoplayer2.ui.i.l
        public void n(List<Integer> list, List<k> list2, c.a aVar) {
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= list2.size()) {
                    break;
                }
                if (list2.get(i10).f18911e) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            if (i.this.f18868l8 != null) {
                ImageView imageView = i.this.f18868l8;
                i iVar = i.this;
                imageView.setImageDrawable(z10 ? iVar.f18865k1 : iVar.f18884v1);
                i.this.f18868l8.setContentDescription(z10 ? i.this.C1 : i.this.K1);
            }
            this.f18912a = list;
            this.f18913b = list2;
            this.f18914c = aVar;
        }

        @Override // com.google.android.exoplayer2.ui.i.l, androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C0196i c0196i, int i10) {
            super.onBindViewHolder(c0196i, i10);
            if (i10 > 0) {
                c0196i.f18905b.setVisibility(this.f18913b.get(i10 + (-1)).f18911e ? 0 : 4);
            }
        }

        @Override // com.google.android.exoplayer2.ui.i.l
        public void q(C0196i c0196i) {
            boolean z10;
            c0196i.f18904a.setText(R.string.exo_track_selection_none);
            int i10 = 0;
            while (true) {
                if (i10 >= this.f18913b.size()) {
                    z10 = true;
                    break;
                } else {
                    if (this.f18913b.get(i10).f18911e) {
                        z10 = false;
                        break;
                    }
                    i10++;
                }
            }
            c0196i.f18905b.setVisibility(z10 ? 0 : 4);
            c0196i.itemView.setOnClickListener(new View.OnClickListener() { // from class: cd.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f10919a.u(view);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.i.l
        public void s(String str) {
        }
    }

    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f18909c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f18910d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f18911e;

        public k(int i10, int i11, int i12, String str, boolean z10) {
            this.f18907a = i10;
            this.f18908b = i11;
            this.f18909c = i12;
            this.f18910d = str;
            this.f18911e = z10;
        }
    }

    public abstract class l extends RecyclerView.g<C0196i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<Integer> f18912a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<k> f18913b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public c.a f18914c = null;

        public l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(k kVar, View view) {
            if (this.f18914c == null || i.this.f18858h8 == null) {
                return;
            }
            DefaultTrackSelector.d dVarA = i.this.f18858h8.v().a();
            for (int i10 = 0; i10 < this.f18912a.size(); i10++) {
                int iIntValue = this.f18912a.get(i10).intValue();
                dVarA = iIntValue == kVar.f18907a ? dVarA.b0(iIntValue, ((c.a) hd.a.g(this.f18914c)).g(iIntValue), new DefaultTrackSelector.SelectionOverride(kVar.f18908b, kVar.f18909c)).Z(iIntValue, false) : dVarA.o(iIntValue).Z(iIntValue, true);
            }
            ((DefaultTrackSelector) hd.a.g(i.this.f18858h8)).N(dVarA);
            s(kVar.f18910d);
            i.this.f18852e8.dismiss();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int getItemCount() {
            if (this.f18913b.isEmpty()) {
                return 0;
            }
            return this.f18913b.size() + 1;
        }

        public void m() {
            this.f18913b = Collections.emptyList();
            this.f18914c = null;
        }

        public abstract void n(List<Integer> list, List<k> list2, c.a aVar);

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: p */
        public void onBindViewHolder(C0196i c0196i, int i10) {
            if (i.this.f18858h8 == null || this.f18914c == null) {
                return;
            }
            if (i10 == 0) {
                q(c0196i);
                return;
            }
            final k kVar = this.f18913b.get(i10 - 1);
            boolean z10 = ((DefaultTrackSelector) hd.a.g(i.this.f18858h8)).v().T(kVar.f18907a, this.f18914c.g(kVar.f18907a)) && kVar.f18911e;
            c0196i.f18904a.setText(kVar.f18910d);
            c0196i.f18905b.setVisibility(z10 ? 0 : 4);
            c0196i.itemView.setOnClickListener(new View.OnClickListener() { // from class: cd.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f10920a.o(kVar, view);
                }
            });
        }

        public abstract void q(C0196i c0196i);

        @Override // androidx.recyclerview.widget.RecyclerView.g
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public C0196i onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new C0196i(LayoutInflater.from(i.this.getContext()).inflate(R.layout.exo_styled_sub_settings_list_item, (ViewGroup) null));
        }

        public abstract void s(String str);
    }

    public interface m {
        void a(int i10);
    }

    static {
        r0.a("goog.exo.ui");
    }

    public i(Context context) {
        this(context, null);
    }

    public static void B0(@p0 View view, boolean z10) {
        if (view == null) {
            return;
        }
        if (z10) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static boolean V(x1 x1Var, x1.c cVar) {
        if (x1Var.q() > 100) {
            return false;
        }
        int iQ = x1Var.q();
        for (int i10 = 0; i10 < iQ; i10++) {
            if (x1Var.n(i10, cVar).f57255p == ya.g.f56663b) {
                return false;
            }
        }
        return true;
    }

    public static int c0(TypedArray typedArray, int i10) {
        return typedArray.getInt(R.styleable.StyledPlayerControlView_repeat_toggle_modes, i10);
    }

    public static void g0(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    @SuppressLint({"InlinedApi"})
    public static boolean j0(int i10) {
        return i10 == 90 || i10 == 89 || i10 == 85 || i10 == 79 || i10 == 126 || i10 == 127 || i10 == 87 || i10 == 88;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f10) {
        j1 j1Var = this.F7;
        if (j1Var == null) {
            return;
        }
        this.G7.i(j1Var, j1Var.e().b(f10));
    }

    public final void A0(@p0 ImageView imageView, boolean z10) {
        if (imageView == null) {
            return;
        }
        if (z10) {
            imageView.setImageDrawable(this.f18885v2);
            imageView.setContentDescription(this.K2);
        } else {
            imageView.setImageDrawable(this.C2);
            imageView.setContentDescription(this.E7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C0() {
        /*
            r8 = this;
            boolean r0 = r8.k0()
            if (r0 == 0) goto L9c
            boolean r0 = r8.L7
            if (r0 != 0) goto Lc
            goto L9c
        Lc:
            ya.j1 r0 = r8.F7
            r1 = 0
            if (r0 == 0) goto L73
            ya.x1 r2 = r0.n1()
            boolean r3 = r2.r()
            if (r3 != 0) goto L73
            boolean r3 = r0.r()
            if (r3 != 0) goto L73
            int r3 = r0.r0()
            ya.x1$c r4 = r8.f18880s
            r2.n(r3, r4)
            ya.x1$c r2 = r8.f18880s
            boolean r3 = r2.f57247h
            r4 = 1
            if (r3 != 0) goto L40
            boolean r2 = r2.h()
            if (r2 == 0) goto L40
            boolean r2 = r0.hasPrevious()
            if (r2 == 0) goto L3e
            goto L40
        L3e:
            r2 = 0
            goto L41
        L40:
            r2 = 1
        L41:
            if (r3 == 0) goto L4d
            ya.h r5 = r8.G7
            boolean r5 = r5.e()
            if (r5 == 0) goto L4d
            r5 = 1
            goto L4e
        L4d:
            r5 = 0
        L4e:
            if (r3 == 0) goto L5a
            ya.h r6 = r8.G7
            boolean r6 = r6.m()
            if (r6 == 0) goto L5a
            r6 = 1
            goto L5b
        L5a:
            r6 = 0
        L5b:
            ya.x1$c r7 = r8.f18880s
            boolean r7 = r7.h()
            if (r7 == 0) goto L69
            ya.x1$c r7 = r8.f18880s
            boolean r7 = r7.f57248i
            if (r7 != 0) goto L6f
        L69:
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L70
        L6f:
            r1 = 1
        L70:
            r0 = r1
            r1 = r5
            goto L77
        L73:
            r0 = 0
            r2 = 0
            r3 = 0
            r6 = 0
        L77:
            if (r1 == 0) goto L7c
            r8.H0()
        L7c:
            if (r6 == 0) goto L81
            r8.z0()
        L81:
            android.view.View r4 = r8.f18847c
            r8.y0(r2, r4)
            android.view.View r2 = r8.f18855g
            r8.y0(r1, r2)
            android.view.View r1 = r8.f18853f
            r8.y0(r6, r1)
            android.view.View r1 = r8.f18849d
            r8.y0(r0, r1)
            com.google.android.exoplayer2.ui.l r0 = r8.f18873o
            if (r0 == 0) goto L9c
            r0.setEnabled(r3)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.i.C0():void");
    }

    public final void D0() {
        if (k0() && this.L7 && this.f18851e != null) {
            if (v0()) {
                ((ImageView) this.f18851e).setImageDrawable(this.f18844a8.getDrawable(R.drawable.exo_styled_controls_pause));
                this.f18851e.setContentDescription(this.f18844a8.getString(R.string.exo_controls_pause_description));
            } else {
                ((ImageView) this.f18851e).setImageDrawable(this.f18844a8.getDrawable(R.drawable.exo_styled_controls_play));
                this.f18851e.setContentDescription(this.f18844a8.getString(R.string.exo_controls_play_description));
            }
        }
    }

    public final void E0() {
        j1 j1Var = this.F7;
        if (j1Var == null) {
            return;
        }
        this.f18850d8.q(j1Var.e().f56785a);
        this.f18848c8.n(0, this.f18850d8.m());
    }

    public final void F0() {
        long jV1;
        if (k0() && this.L7) {
            j1 j1Var = this.F7;
            long jC0 = 0;
            if (j1Var != null) {
                jC0 = this.W7 + j1Var.C0();
                jV1 = this.W7 + j1Var.v1();
            } else {
                jV1 = 0;
            }
            TextView textView = this.f18871n;
            if (textView != null && !this.O7) {
                textView.setText(u0.p0(this.f18875p, this.f18877q, jC0));
            }
            com.google.android.exoplayer2.ui.l lVar = this.f18873o;
            if (lVar != null) {
                lVar.setPosition(jC0);
                this.f18873o.setBufferedPosition(jV1);
            }
            f fVar = this.H7;
            if (fVar != null) {
                fVar.a(jC0, jV1);
            }
            removeCallbacks(this.f18881t);
            int iD = j1Var == null ? 1 : j1Var.d();
            if (j1Var == null || !j1Var.N0()) {
                if (iD == 4 || iD == 1) {
                    return;
                }
                postDelayed(this.f18881t, 1000L);
                return;
            }
            com.google.android.exoplayer2.ui.l lVar2 = this.f18873o;
            long jMin = Math.min(lVar2 != null ? lVar2.getPreferredUpdateDelay() : 1000L, 1000 - (jC0 % 1000));
            float f10 = j1Var.e().f56785a;
            postDelayed(this.f18881t, u0.u(f10 > 0.0f ? (long) (jMin / f10) : 1000L, this.Q7, 1000L));
        }
    }

    public final void G0() {
        ImageView imageView;
        if (k0() && this.L7 && (imageView = this.f18861j) != null) {
            if (this.R7 == 0) {
                y0(false, imageView);
                return;
            }
            j1 j1Var = this.F7;
            if (j1Var == null) {
                y0(false, imageView);
                this.f18861j.setImageDrawable(this.f18882u);
                this.f18861j.setContentDescription(this.f18887x);
                return;
            }
            y0(true, imageView);
            int iK = j1Var.k();
            if (iK == 0) {
                this.f18861j.setImageDrawable(this.f18882u);
                this.f18861j.setContentDescription(this.f18887x);
            } else if (iK == 1) {
                this.f18861j.setImageDrawable(this.f18883v);
                this.f18861j.setContentDescription(this.f18888y);
            } else {
                if (iK != 2) {
                    return;
                }
                this.f18861j.setImageDrawable(this.f18886w);
                this.f18861j.setContentDescription(this.f18889z);
            }
        }
    }

    public final void H0() {
        ya.h hVar = this.G7;
        if (hVar instanceof ya.i) {
            this.X7 = ((ya.i) hVar).o();
        }
        int i10 = (int) (this.X7 / 1000);
        TextView textView = this.f18859i;
        if (textView != null) {
            textView.setText(String.valueOf(i10));
        }
        View view = this.f18855g;
        if (view != null) {
            view.setContentDescription(this.f18844a8.getQuantityString(R.plurals.exo_controls_rewind_by_amount_description, i10, Integer.valueOf(i10)));
        }
    }

    public final void I0() {
        this.f18846b8.measure(0, 0);
        this.f18852e8.setWidth(Math.min(this.f18846b8.getMeasuredWidth(), getWidth() - (this.f18856g8 * 2)));
        this.f18852e8.setHeight(Math.min(getHeight() - (this.f18856g8 * 2), this.f18846b8.getMeasuredHeight()));
    }

    public final void J0() {
        ImageView imageView;
        if (k0() && this.L7 && (imageView = this.f18863k) != null) {
            j1 j1Var = this.F7;
            if (!this.Z7.A(imageView)) {
                y0(false, this.f18863k);
                return;
            }
            if (j1Var == null) {
                y0(false, this.f18863k);
                this.f18863k.setImageDrawable(this.B);
                this.f18863k.setContentDescription(this.K0);
            } else {
                y0(true, this.f18863k);
                this.f18863k.setImageDrawable(j1Var.u1() ? this.A : this.B);
                this.f18863k.setContentDescription(j1Var.u1() ? this.f18864k0 : this.K0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K0() {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.i.K0():void");
    }

    public final void L0() {
        f0();
        y0(this.f18860i8.getItemCount() > 0, this.f18868l8);
    }

    public void U(m mVar) {
        hd.a.g(mVar);
        this.f18845b.add(mVar);
    }

    public boolean W(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        j1 j1Var = this.F7;
        if (j1Var == null || !j0(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (j1Var.d() == 4) {
                return true;
            }
            this.G7.a(j1Var);
            return true;
        }
        if (keyCode == 89) {
            this.G7.k(j1Var);
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            Z(j1Var);
            return true;
        }
        if (keyCode == 87) {
            this.G7.f(j1Var);
            return true;
        }
        if (keyCode == 88) {
            this.G7.l(j1Var);
            return true;
        }
        if (keyCode == 126) {
            Y(j1Var);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        X(j1Var);
        return true;
    }

    public final void X(j1 j1Var) {
        this.G7.h(j1Var, false);
    }

    public final void Y(j1 j1Var) {
        int iD = j1Var.d();
        if (iD == 1) {
            i1 i1Var = this.I7;
            if (i1Var != null) {
                i1Var.a();
            } else {
                this.G7.g(j1Var);
            }
        } else if (iD == 4) {
            s0(j1Var, j1Var.r0(), ya.g.f56663b);
        }
        this.G7.h(j1Var, true);
    }

    public final void Z(j1 j1Var) {
        int iD = j1Var.d();
        if (iD == 1 || iD == 4 || !j1Var.D()) {
            Y(j1Var);
        } else {
            X(j1Var);
        }
    }

    public final void a0(RecyclerView.g<?> gVar) {
        this.f18846b8.setAdapter(gVar);
        I0();
        this.f18854f8 = false;
        this.f18852e8.dismiss();
        this.f18854f8 = true;
        this.f18852e8.showAsDropDown(this, (getWidth() - this.f18852e8.getWidth()) - this.f18856g8, (-this.f18852e8.getHeight()) - this.f18856g8);
    }

    public final void b0(c.a aVar, int i10, List<k> list) {
        TrackGroupArray trackGroupArrayG = aVar.g(i10);
        ad.h hVarA = ((j1) hd.a.g(this.F7)).A1().a(i10);
        for (int i11 = 0; i11 < trackGroupArrayG.f17502a; i11++) {
            TrackGroup trackGroupA = trackGroupArrayG.a(i11);
            for (int i12 = 0; i12 < trackGroupA.f17498a; i12++) {
                Format formatA = trackGroupA.a(i12);
                if (aVar.h(i10, i11, i12) == 4) {
                    list.add(new k(i10, i11, i12, this.f18866k8.a(formatA), (hVarA == null || hVarA.d(formatA) == -1) ? false : true));
                }
            }
        }
    }

    public void d0() {
        this.Z7.C();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return W(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public void e0() {
        this.Z7.F();
    }

    public final void f0() {
        DefaultTrackSelector defaultTrackSelector;
        c.a aVarG;
        this.f18860i8.m();
        this.f18862j8.m();
        if (this.F7 == null || (defaultTrackSelector = this.f18858h8) == null || (aVarG = defaultTrackSelector.g()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (int i10 = 0; i10 < aVarG.c(); i10++) {
            if (aVarG.f(i10) == 3 && this.Z7.A(this.f18868l8)) {
                b0(aVarG, i10, arrayList);
                arrayList3.add(Integer.valueOf(i10));
            } else if (aVarG.f(i10) == 1) {
                b0(aVarG, i10, arrayList2);
                arrayList4.add(Integer.valueOf(i10));
            }
        }
        this.f18860i8.n(arrayList3, arrayList, aVarG);
        this.f18862j8.n(arrayList4, arrayList2, aVarG);
    }

    @p0
    public j1 getPlayer() {
        return this.F7;
    }

    public int getRepeatToggleModes() {
        return this.R7;
    }

    public boolean getShowShuffleButton() {
        return this.Z7.A(this.f18863k);
    }

    public boolean getShowSubtitleButton() {
        return this.Z7.A(this.f18868l8);
    }

    public int getShowTimeoutMs() {
        return this.P7;
    }

    public boolean getShowVrButton() {
        return this.Z7.A(this.f18867l);
    }

    public boolean h0() {
        return this.Z7.I();
    }

    public boolean i0() {
        return this.Z7.J();
    }

    public boolean k0() {
        return getVisibility() == 0;
    }

    public void m0() {
        Iterator<m> it2 = this.f18845b.iterator();
        while (it2.hasNext()) {
            it2.next().a(getVisibility());
        }
    }

    public final void n0(View view) {
        if (this.J7 == null) {
            return;
        }
        boolean z10 = !this.K7;
        this.K7 = z10;
        A0(this.f18870m8, z10);
        A0(this.f18872n8, this.K7);
        d dVar = this.J7;
        if (dVar != null) {
            dVar.a(this.K7);
        }
    }

    public final void o0(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18 = i13 - i11;
        int i19 = i17 - i15;
        if (!(i12 - i10 == i16 - i14 && i18 == i19) && this.f18852e8.isShowing()) {
            I0();
            this.f18852e8.update(view, (getWidth() - this.f18852e8.getWidth()) - this.f18856g8, (-this.f18852e8.getHeight()) - this.f18856g8, -1, -1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Z7.P();
        this.L7 = true;
        if (i0()) {
            this.Z7.X();
        }
        x0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Z7.Q();
        this.L7 = false;
        removeCallbacks(this.f18881t);
        this.Z7.W();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.Z7.R(z10, i10, i11, i12, i13);
    }

    public final void p0(int i10) {
        if (i10 == 0) {
            a0(this.f18850d8);
        } else if (i10 == 1) {
            a0(this.f18862j8);
        } else {
            this.f18852e8.dismiss();
        }
    }

    public void q0(m mVar) {
        this.f18845b.remove(mVar);
    }

    public void r0() {
        View view = this.f18851e;
        if (view != null) {
            view.requestFocus();
        }
    }

    public final boolean s0(j1 j1Var, int i10, long j10) {
        return this.G7.b(j1Var, i10, j10);
    }

    public void setAnimationEnabled(boolean z10) {
        this.Z7.Y(z10);
    }

    public void setControlDispatcher(ya.h hVar) {
        if (this.G7 != hVar) {
            this.G7 = hVar;
            C0();
        }
    }

    public void setOnFullScreenModeChangedListener(@p0 d dVar) {
        this.J7 = dVar;
        B0(this.f18870m8, dVar != null);
        B0(this.f18872n8, dVar != null);
    }

    @Deprecated
    public void setPlaybackPreparer(@p0 i1 i1Var) {
        this.I7 = i1Var;
    }

    public void setPlayer(@p0 j1 j1Var) {
        boolean z10 = true;
        hd.a.i(Looper.myLooper() == Looper.getMainLooper());
        if (j1Var != null && j1Var.p1() != Looper.getMainLooper()) {
            z10 = false;
        }
        hd.a.a(z10);
        j1 j1Var2 = this.F7;
        if (j1Var2 == j1Var) {
            return;
        }
        if (j1Var2 != null) {
            j1Var2.K0(this.f18843a);
        }
        this.F7 = j1Var;
        if (j1Var != null) {
            j1Var.y(this.f18843a);
        }
        if (j1Var instanceof ya.n) {
            ad.j jVarL = ((ya.n) j1Var).L();
            if (jVarL instanceof DefaultTrackSelector) {
                this.f18858h8 = (DefaultTrackSelector) jVarL;
            }
        } else {
            this.f18858h8 = null;
        }
        x0();
    }

    public void setProgressUpdateListener(@p0 f fVar) {
        this.H7 = fVar;
    }

    public void setRepeatToggleModes(int i10) {
        this.R7 = i10;
        j1 j1Var = this.F7;
        if (j1Var != null) {
            int iK = j1Var.k();
            if (i10 == 0 && iK != 0) {
                this.G7.d(this.F7, 0);
            } else if (i10 == 1 && iK == 2) {
                this.G7.d(this.F7, 1);
            } else if (i10 == 2 && iK == 1) {
                this.G7.d(this.F7, 2);
            }
        }
        this.Z7.Z(this.f18861j, i10 != 0);
        G0();
    }

    public void setShowFastForwardButton(boolean z10) {
        this.Z7.Z(this.f18853f, z10);
        C0();
    }

    public void setShowMultiWindowTimeBar(boolean z10) {
        this.M7 = z10;
        K0();
    }

    public void setShowNextButton(boolean z10) {
        this.Z7.Z(this.f18849d, z10);
        C0();
    }

    public void setShowPreviousButton(boolean z10) {
        this.Z7.Z(this.f18847c, z10);
        C0();
    }

    public void setShowRewindButton(boolean z10) {
        this.Z7.Z(this.f18855g, z10);
        C0();
    }

    public void setShowShuffleButton(boolean z10) {
        this.Z7.Z(this.f18863k, z10);
        J0();
    }

    public void setShowSubtitleButton(boolean z10) {
        this.Z7.Z(this.f18868l8, z10);
    }

    public void setShowTimeoutMs(int i10) {
        this.P7 = i10;
        if (i0()) {
            this.Z7.X();
        }
    }

    public void setShowVrButton(boolean z10) {
        this.Z7.Z(this.f18867l, z10);
    }

    public void setTimeBarMinUpdateInterval(int i10) {
        this.Q7 = u0.t(i10, 16, 1000);
    }

    public void setVrButtonListener(@p0 View.OnClickListener onClickListener) {
        View view = this.f18867l;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            y0(onClickListener != null, this.f18867l);
        }
    }

    public final void t0(j1 j1Var, long j10) {
        int iR0;
        x1 x1VarN1 = j1Var.n1();
        if (this.N7 && !x1VarN1.r()) {
            int iQ = x1VarN1.q();
            iR0 = 0;
            while (true) {
                long jD = x1VarN1.n(iR0, this.f18880s).d();
                if (j10 < jD) {
                    break;
                }
                if (iR0 == iQ - 1) {
                    j10 = jD;
                    break;
                } else {
                    j10 -= jD;
                    iR0++;
                }
            }
        } else {
            iR0 = j1Var.r0();
        }
        if (s0(j1Var, iR0, j10)) {
            return;
        }
        F0();
    }

    public void u0(@p0 long[] jArr, @p0 boolean[] zArr) {
        if (jArr == null) {
            this.U7 = new long[0];
            this.V7 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) hd.a.g(zArr);
            hd.a.a(jArr.length == zArr2.length);
            this.U7 = jArr;
            this.V7 = zArr2;
        }
        K0();
    }

    public final boolean v0() {
        j1 j1Var = this.F7;
        return (j1Var == null || j1Var.d() == 4 || this.F7.d() == 1 || !this.F7.D()) ? false : true;
    }

    public void w0() {
        this.Z7.c0();
    }

    public void x0() {
        D0();
        C0();
        G0();
        J0();
        L0();
        E0();
        K0();
    }

    public final void y0(boolean z10, @p0 View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z10);
        view.setAlpha(z10 ? this.C : this.D);
    }

    public final void z0() {
        ya.h hVar = this.G7;
        if (hVar instanceof ya.i) {
            this.Y7 = ((ya.i) hVar).n();
        }
        int i10 = (int) (this.Y7 / 1000);
        TextView textView = this.f18857h;
        if (textView != null) {
            textView.setText(String.valueOf(i10));
        }
        View view = this.f18853f;
        if (view != null) {
            view.setContentDescription(this.f18844a8.getQuantityString(R.plurals.exo_controls_fastforward_by_amount_description, i10, Integer.valueOf(i10)));
        }
    }

    public i(Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i(Context context, @p0 AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, attributeSet);
    }

    public i(Context context, @p0 AttributeSet attributeSet, int i10, @p0 AttributeSet attributeSet2) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        c cVar;
        boolean z18;
        boolean z19;
        super(context, attributeSet, i10);
        int resourceId = R.layout.exo_styled_player_control_view;
        this.X7 = 5000L;
        this.Y7 = 15000L;
        this.P7 = 5000;
        this.R7 = 0;
        this.Q7 = 200;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.StyledPlayerControlView, 0, 0);
            try {
                this.X7 = typedArrayObtainStyledAttributes.getInt(R.styleable.StyledPlayerControlView_rewind_increment, (int) this.X7);
                this.Y7 = typedArrayObtainStyledAttributes.getInt(R.styleable.StyledPlayerControlView_fastforward_increment, (int) this.Y7);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StyledPlayerControlView_controller_layout_id, resourceId);
                this.P7 = typedArrayObtainStyledAttributes.getInt(R.styleable.StyledPlayerControlView_show_timeout, this.P7);
                this.R7 = c0(typedArrayObtainStyledAttributes, this.R7);
                boolean z20 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_rewind_button, true);
                boolean z21 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_fastforward_button, true);
                boolean z22 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_previous_button, true);
                boolean z23 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_next_button, true);
                boolean z24 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_shuffle_button, false);
                boolean z25 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_subtitle_button, false);
                boolean z26 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_show_vr_button, false);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R.styleable.StyledPlayerControlView_time_bar_min_update_interval, this.Q7));
                boolean z27 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StyledPlayerControlView_animation_enabled, true);
                typedArrayObtainStyledAttributes.recycle();
                z16 = z24;
                z17 = z25;
                z12 = z20;
                z13 = z21;
                z14 = z22;
                z10 = z27;
                z15 = z23;
                z11 = z26;
            } catch (Throwable th2) {
                typedArrayObtainStyledAttributes.recycle();
                throw th2;
            }
        } else {
            z10 = true;
            z11 = false;
            z12 = true;
            z13 = true;
            z14 = true;
            z15 = true;
            z16 = false;
            z17 = false;
        }
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        c cVar2 = new c();
        this.f18843a = cVar2;
        this.f18845b = new CopyOnWriteArrayList<>();
        this.f18879r = new x1.b();
        this.f18880s = new x1.c();
        StringBuilder sb2 = new StringBuilder();
        this.f18875p = sb2;
        this.f18877q = new Formatter(sb2, Locale.getDefault());
        this.S7 = new long[0];
        this.T7 = new boolean[0];
        this.U7 = new long[0];
        this.V7 = new boolean[0];
        boolean z28 = z12;
        this.G7 = new ya.i(this.Y7, this.X7);
        this.f18881t = new Runnable() { // from class: cd.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f10914a.F0();
            }
        };
        this.f18869m = (TextView) findViewById(R.id.exo_duration);
        this.f18871n = (TextView) findViewById(R.id.exo_position);
        ImageView imageView = (ImageView) findViewById(R.id.exo_subtitle);
        this.f18868l8 = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar2);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_fullscreen);
        this.f18870m8 = imageView2;
        g0(imageView2, new View.OnClickListener() { // from class: cd.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10911a.n0(view);
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R.id.exo_minimal_fullscreen);
        this.f18872n8 = imageView3;
        g0(imageView3, new View.OnClickListener() { // from class: cd.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10911a.n0(view);
            }
        });
        View viewFindViewById = findViewById(R.id.exo_settings);
        this.f18874o8 = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(cVar2);
        }
        View viewFindViewById2 = findViewById(R.id.exo_playback_speed);
        this.f18876p8 = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar2);
        }
        View viewFindViewById3 = findViewById(R.id.exo_audio_track);
        this.f18878q8 = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar2);
        }
        int i11 = R.id.exo_progress;
        com.google.android.exoplayer2.ui.l lVar = (com.google.android.exoplayer2.ui.l) findViewById(i11);
        View viewFindViewById4 = findViewById(R.id.exo_progress_placeholder);
        if (lVar != null) {
            this.f18873o = lVar;
            cVar = cVar2;
            z18 = z10;
            z19 = z11;
        } else if (viewFindViewById4 != null) {
            cVar = cVar2;
            z18 = z10;
            z19 = z11;
            com.google.android.exoplayer2.ui.b bVar = new com.google.android.exoplayer2.ui.b(context, null, 0, attributeSet2, R.style.ExoStyledControls_TimeBar);
            bVar.setId(i11);
            bVar.setLayoutParams(viewFindViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById4.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById4);
            viewGroup.removeView(viewFindViewById4);
            viewGroup.addView(bVar, iIndexOfChild);
            this.f18873o = bVar;
        } else {
            cVar = cVar2;
            z18 = z10;
            z19 = z11;
            this.f18873o = null;
        }
        com.google.android.exoplayer2.ui.l lVar2 = this.f18873o;
        c cVar3 = cVar;
        if (lVar2 != null) {
            lVar2.c(cVar3);
        }
        View viewFindViewById5 = findViewById(R.id.exo_play_pause);
        this.f18851e = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar3);
        }
        View viewFindViewById6 = findViewById(R.id.exo_prev);
        this.f18847c = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar3);
        }
        View viewFindViewById7 = findViewById(R.id.exo_next);
        this.f18849d = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar3);
        }
        Typeface typefaceJ = j0.i.j(context, R.font.roboto_medium_numbers);
        View viewFindViewById8 = findViewById(R.id.exo_rew);
        TextView textView = viewFindViewById8 == null ? (TextView) findViewById(R.id.exo_rew_with_amount) : null;
        this.f18859i = textView;
        if (textView != null) {
            textView.setTypeface(typefaceJ);
        }
        viewFindViewById8 = viewFindViewById8 == null ? textView : viewFindViewById8;
        this.f18855g = viewFindViewById8;
        if (viewFindViewById8 != null) {
            viewFindViewById8.setOnClickListener(cVar3);
        }
        View viewFindViewById9 = findViewById(R.id.exo_ffwd);
        TextView textView2 = viewFindViewById9 == null ? (TextView) findViewById(R.id.exo_ffwd_with_amount) : null;
        this.f18857h = textView2;
        if (textView2 != null) {
            textView2.setTypeface(typefaceJ);
        }
        viewFindViewById9 = viewFindViewById9 == null ? textView2 : viewFindViewById9;
        this.f18853f = viewFindViewById9;
        if (viewFindViewById9 != null) {
            viewFindViewById9.setOnClickListener(cVar3);
        }
        ImageView imageView4 = (ImageView) findViewById(R.id.exo_repeat_toggle);
        this.f18861j = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(cVar3);
        }
        ImageView imageView5 = (ImageView) findViewById(R.id.exo_shuffle);
        this.f18863k = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(cVar3);
        }
        this.f18844a8 = context.getResources();
        this.C = r2.getInteger(R.integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.D = this.f18844a8.getInteger(R.integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        View viewFindViewById10 = findViewById(R.id.exo_vr);
        this.f18867l = viewFindViewById10;
        if (viewFindViewById10 != null) {
            y0(false, viewFindViewById10);
        }
        com.google.android.exoplayer2.ui.j jVar = new com.google.android.exoplayer2.ui.j(this);
        this.Z7 = jVar;
        jVar.Y(z18);
        this.f18848c8 = new h(new String[]{this.f18844a8.getString(R.string.exo_controls_playback_speed), this.f18844a8.getString(R.string.exo_track_selection_title_audio)}, new Drawable[]{this.f18844a8.getDrawable(R.drawable.exo_styled_controls_speed), this.f18844a8.getDrawable(R.drawable.exo_styled_controls_audiotrack)});
        this.f18856g8 = this.f18844a8.getDimensionPixelSize(R.dimen.exo_settings_offset);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.exo_styled_settings_list, (ViewGroup) null);
        this.f18846b8 = recyclerView;
        recyclerView.setAdapter(this.f18848c8);
        this.f18846b8.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow((View) this.f18846b8, -2, -2, true);
        this.f18852e8 = popupWindow;
        if (u0.f31154a < 23) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.f18852e8.setOnDismissListener(cVar3);
        this.f18854f8 = true;
        this.f18866k8 = new com.google.android.exoplayer2.ui.c(getResources());
        this.f18865k1 = this.f18844a8.getDrawable(R.drawable.exo_styled_controls_subtitle_on);
        this.f18884v1 = this.f18844a8.getDrawable(R.drawable.exo_styled_controls_subtitle_off);
        this.C1 = this.f18844a8.getString(R.string.exo_controls_cc_enabled_description);
        this.K1 = this.f18844a8.getString(R.string.exo_controls_cc_disabled_description);
        this.f18860i8 = new j();
        this.f18862j8 = new b();
        this.f18850d8 = new e(this.f18844a8.getStringArray(R.array.exo_playback_speeds), this.f18844a8.getIntArray(R.array.exo_speed_multiplied_by_100));
        this.f18885v2 = this.f18844a8.getDrawable(R.drawable.exo_styled_controls_fullscreen_exit);
        this.C2 = this.f18844a8.getDrawable(R.drawable.exo_styled_controls_fullscreen_enter);
        this.f18882u = this.f18844a8.getDrawable(R.drawable.exo_styled_controls_repeat_off);
        this.f18883v = this.f18844a8.getDrawable(R.drawable.exo_styled_controls_repeat_one);
        this.f18886w = this.f18844a8.getDrawable(R.drawable.exo_styled_controls_repeat_all);
        this.A = this.f18844a8.getDrawable(R.drawable.exo_styled_controls_shuffle_on);
        this.B = this.f18844a8.getDrawable(R.drawable.exo_styled_controls_shuffle_off);
        this.K2 = this.f18844a8.getString(R.string.exo_controls_fullscreen_exit_description);
        this.E7 = this.f18844a8.getString(R.string.exo_controls_fullscreen_enter_description);
        this.f18887x = this.f18844a8.getString(R.string.exo_controls_repeat_off_description);
        this.f18888y = this.f18844a8.getString(R.string.exo_controls_repeat_one_description);
        this.f18889z = this.f18844a8.getString(R.string.exo_controls_repeat_all_description);
        this.f18864k0 = this.f18844a8.getString(R.string.exo_controls_shuffle_on_description);
        this.K0 = this.f18844a8.getString(R.string.exo_controls_shuffle_off_description);
        this.Z7.Z((ViewGroup) findViewById(R.id.exo_bottom_bar), true);
        this.Z7.Z(this.f18853f, z13);
        this.Z7.Z(this.f18855g, z28);
        this.Z7.Z(this.f18847c, z14);
        this.Z7.Z(this.f18849d, z15);
        this.Z7.Z(this.f18863k, z16);
        this.Z7.Z(this.f18868l8, z17);
        this.Z7.Z(this.f18867l, z19);
        this.Z7.Z(this.f18861j, this.R7 != 0);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: cd.o
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
                this.f10913a.o0(view, i12, i13, i14, i15, i16, i17, i18, i19);
            }
        });
    }
}
