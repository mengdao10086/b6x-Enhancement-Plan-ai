package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.b;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.e;
import com.google.common.collect.ImmutableList;
import g.p0;
import hd.u0;
import id.o;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import ya.h1;
import ya.i1;
import ya.j1;
import ya.k1;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public class g extends FrameLayout implements b.a {
    public static final int B = 0;
    public static final int C = 1;
    public static final int C1 = 4;
    public static final int D = 2;
    public static final int K0 = 1;
    public static final int K1 = 3;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f18792k0 = 0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f18793k1 = 2;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f18794v1 = 3;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f18795v2 = -1;
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f18796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final AspectRatioFrameLayout f18797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final View f18798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final View f18799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final ImageView f18800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public final SubtitleView f18801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public final View f18802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public final TextView f18803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public final e f18804i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public final FrameLayout f18805j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public final FrameLayout f18806k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public j1 f18807l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f18808m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @p0
    public e.d f18809n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f18810o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public Drawable f18811p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f18812q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f18813r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f18814s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @p0
    public hd.i<? super ExoPlaybackException> f18815t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @p0
    public CharSequence f18816u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f18817v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f18818w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f18819x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f18820y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f18821z;

    public final class a implements j1.f, qc.k, o, View.OnLayoutChangeListener, dd.e, e.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x1.b f18822a = new x1.b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public Object f18823b;

        public a() {
        }

        @Override // ya.j1.f
        public /* synthetic */ void B(boolean z10) {
            k1.c(this, z10);
        }

        @Override // ya.j1.f
        public /* synthetic */ void D(boolean z10, int i10) {
            k1.m(this, z10, i10);
        }

        @Override // qc.k
        public void I(List<qc.b> list) {
            if (g.this.f18801f != null) {
                g.this.f18801f.I(list);
            }
        }

        @Override // ya.j1.f
        public void R(boolean z10, int i10) {
            g.this.O();
            g.this.Q();
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

        @Override // com.google.android.exoplayer2.ui.e.d
        public void a(int i10) {
            g.this.P();
        }

        @Override // ya.j1.f
        public /* synthetic */ void b(h1 h1Var) {
            k1.i(this, h1Var);
        }

        @Override // ya.j1.f
        public /* synthetic */ void b0(boolean z10) {
            k1.e(this, z10);
        }

        @Override // id.o
        public void c(int i10, int i11, int i12, float f10) {
            float f11 = (i11 == 0 || i10 == 0) ? 1.0f : (i10 * f10) / i11;
            if (g.this.f18799d instanceof TextureView) {
                if (i12 == 90 || i12 == 270) {
                    f11 = 1.0f / f11;
                }
                if (g.this.f18821z != 0) {
                    g.this.f18799d.removeOnLayoutChangeListener(this);
                }
                g.this.f18821z = i12;
                if (g.this.f18821z != 0) {
                    g.this.f18799d.addOnLayoutChangeListener(this);
                }
                g.r((TextureView) g.this.f18799d, g.this.f18821z);
            }
            g gVar = g.this;
            gVar.C(f11, gVar.f18797b, g.this.f18799d);
        }

        @Override // id.o
        public void d() {
            if (g.this.f18798c != null) {
                g.this.f18798c.setVisibility(4);
            }
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
        public void h(TrackGroupArray trackGroupArray, ad.i iVar) {
            j1 j1Var = (j1) hd.a.g(g.this.f18807l);
            x1 x1VarN1 = j1Var.n1();
            if (x1VarN1.r()) {
                this.f18823b = null;
            } else if (j1Var.l1().e()) {
                Object obj = this.f18823b;
                if (obj != null) {
                    int iB = x1VarN1.b(obj);
                    if (iB != -1) {
                        if (j1Var.r0() == x1VarN1.f(iB, this.f18822a).f57234c) {
                            return;
                        }
                    }
                    this.f18823b = null;
                }
            } else {
                this.f18823b = x1VarN1.g(j1Var.U(), this.f18822a, true).f57233b;
            }
            g.this.S(false);
        }

        @Override // ya.j1.f
        public void i(int i10) {
            if (g.this.A() && g.this.f18819x) {
                g.this.x();
            }
        }

        @Override // id.o
        public /* synthetic */ void j(int i10, int i11) {
            id.n.b(this, i10, i11);
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

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            g.r((TextureView) view, g.this.f18821z);
        }

        @Override // dd.e
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return g.this.N();
        }

        @Override // ya.j1.f
        public /* synthetic */ void p(j1 j1Var, j1.g gVar) {
            k1.a(this, j1Var, gVar);
        }

        @Override // ya.j1.f
        public void r(int i10) {
            g.this.O();
            g.this.R();
            g.this.Q();
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

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public g(Context context) {
        this(context, null);
    }

    public static void I(AspectRatioFrameLayout aspectRatioFrameLayout, int i10) {
        aspectRatioFrameLayout.setResizeMode(i10);
    }

    public static void M(j1 j1Var, @p0 g gVar, @p0 g gVar2) {
        if (gVar == gVar2) {
            return;
        }
        if (gVar2 != null) {
            gVar2.setPlayer(j1Var);
        }
        if (gVar != null) {
            gVar.setPlayer(null);
        }
    }

    public static void r(TextureView textureView, int i10) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i10 != 0) {
            float f10 = width / 2.0f;
            float f11 = height / 2.0f;
            matrix.postRotate(i10, f10, f11);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f10, f11);
        }
        textureView.setTransform(matrix);
    }

    public static void t(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R.color.exo_edit_mode_background_color));
    }

    @g.v0(23)
    public static void u(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.exo_edit_mode_logo, null));
        imageView.setBackgroundColor(resources.getColor(R.color.exo_edit_mode_background_color, null));
    }

    public final boolean A() {
        j1 j1Var = this.f18807l;
        return j1Var != null && j1Var.r() && this.f18807l.D();
    }

    public final void B(boolean z10) {
        if (!(A() && this.f18819x) && U()) {
            boolean z11 = this.f18804i.J() && this.f18804i.getShowTimeoutMs() <= 0;
            boolean zJ = J();
            if (z10 || z11 || zJ) {
                L(zJ);
            }
        }
    }

    public void C(float f10, @p0 AspectRatioFrameLayout aspectRatioFrameLayout, @p0 View view) {
        if (aspectRatioFrameLayout != null) {
            if (view instanceof dd.h) {
                f10 = 0.0f;
            }
            aspectRatioFrameLayout.setAspectRatio(f10);
        }
    }

    public void D() {
        View view = this.f18799d;
        if (view instanceof dd.h) {
            ((dd.h) view).onPause();
        }
    }

    public void E() {
        View view = this.f18799d;
        if (view instanceof dd.h) {
            ((dd.h) view).onResume();
        }
    }

    @RequiresNonNull({"artworkView"})
    public final boolean F(Metadata metadata) {
        byte[] bArr;
        int i10;
        int i11 = -1;
        boolean zG = false;
        for (int i12 = 0; i12 < metadata.g(); i12++) {
            Metadata.Entry entryE = metadata.e(i12);
            if (entryE instanceof ApicFrame) {
                ApicFrame apicFrame = (ApicFrame) entryE;
                bArr = apicFrame.f17280e;
                i10 = apicFrame.f17279d;
            } else if (entryE instanceof PictureFrame) {
                PictureFrame pictureFrame = (PictureFrame) entryE;
                bArr = pictureFrame.f17255h;
                i10 = pictureFrame.f17248a;
            } else {
                continue;
            }
            if (i11 == -1 || i10 == 3) {
                zG = G(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
                if (i10 == 3) {
                    break;
                }
                i11 = i10;
            }
        }
        return zG;
    }

    @RequiresNonNull({"artworkView"})
    public final boolean G(@p0 Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                C(intrinsicWidth / intrinsicHeight, this.f18797b, this.f18800e);
                this.f18800e.setImageDrawable(drawable);
                this.f18800e.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public void H(@p0 long[] jArr, @p0 boolean[] zArr) {
        hd.a.k(this.f18804i);
        this.f18804i.O(jArr, zArr);
    }

    public final boolean J() {
        j1 j1Var = this.f18807l;
        if (j1Var == null) {
            return true;
        }
        int iD = j1Var.d();
        return this.f18818w && (iD == 1 || iD == 4 || !this.f18807l.D());
    }

    public void K() {
        L(J());
    }

    public final void L(boolean z10) {
        if (U()) {
            this.f18804i.setShowTimeoutMs(z10 ? 0 : this.f18817v);
            this.f18804i.Q();
        }
    }

    public final boolean N() {
        if (!U() || this.f18807l == null) {
            return false;
        }
        if (!this.f18804i.J()) {
            B(true);
        } else if (this.f18820y) {
            this.f18804i.G();
        }
        return true;
    }

    public final void O() {
        int i10;
        if (this.f18802g != null) {
            j1 j1Var = this.f18807l;
            boolean z10 = true;
            if (j1Var == null || j1Var.d() != 2 || ((i10 = this.f18812q) != 2 && (i10 != 1 || !this.f18807l.D()))) {
                z10 = false;
            }
            this.f18802g.setVisibility(z10 ? 0 : 8);
        }
    }

    public final void P() {
        e eVar = this.f18804i;
        if (eVar == null || !this.f18808m) {
            setContentDescription(null);
        } else if (eVar.getVisibility() == 0) {
            setContentDescription(this.f18820y ? getResources().getString(R.string.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R.string.exo_controls_show));
        }
    }

    public final void Q() {
        if (A() && this.f18819x) {
            x();
        } else {
            B(false);
        }
    }

    public final void R() {
        hd.i<? super ExoPlaybackException> iVar;
        TextView textView = this.f18803h;
        if (textView != null) {
            CharSequence charSequence = this.f18816u;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f18803h.setVisibility(0);
                return;
            }
            j1 j1Var = this.f18807l;
            ExoPlaybackException exoPlaybackExceptionW0 = j1Var != null ? j1Var.w0() : null;
            if (exoPlaybackExceptionW0 == null || (iVar = this.f18815t) == null) {
                this.f18803h.setVisibility(8);
            } else {
                this.f18803h.setText((CharSequence) iVar.a(exoPlaybackExceptionW0).second);
                this.f18803h.setVisibility(0);
            }
        }
    }

    public final void S(boolean z10) {
        j1 j1Var = this.f18807l;
        if (j1Var == null || j1Var.l1().e()) {
            if (this.f18813r) {
                return;
            }
            w();
            s();
            return;
        }
        if (z10 && !this.f18813r) {
            s();
        }
        ad.i iVarA1 = j1Var.A1();
        for (int i10 = 0; i10 < iVarA1.f566a; i10++) {
            if (j1Var.E1(i10) == 2 && iVarA1.a(i10) != null) {
                w();
                return;
            }
        }
        s();
        if (T()) {
            Iterator<Metadata> it2 = j1Var.P().iterator();
            while (it2.hasNext()) {
                if (F(it2.next())) {
                    return;
                }
            }
            if (G(this.f18811p)) {
                return;
            }
        }
        w();
    }

    @EnsuresNonNullIf(expression = {"artworkView"}, result = true)
    public final boolean T() {
        if (!this.f18810o) {
            return false;
        }
        hd.a.k(this.f18800e);
        return true;
    }

    @EnsuresNonNullIf(expression = {"controller"}, result = true)
    public final boolean U() {
        if (!this.f18808m) {
            return false;
        }
        hd.a.k(this.f18804i);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.ads.b.a
    public /* synthetic */ View[] a() {
        return fc.a.b(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        j1 j1Var = this.f18807l;
        if (j1Var != null && j1Var.r()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean z10 = z(keyEvent.getKeyCode());
        if ((z10 && U() && !this.f18804i.J()) || v(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            B(true);
            return true;
        }
        if (!z10 || !U()) {
            return false;
        }
        B(true);
        return false;
    }

    @Override // com.google.android.exoplayer2.source.ads.b.a
    public List<b.c> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f18806k;
        if (frameLayout != null) {
            arrayList.add(new b.c(frameLayout, 3, "Transparent overlay does not impact viewability"));
        }
        e eVar = this.f18804i;
        if (eVar != null) {
            arrayList.add(new b.c(eVar, 0));
        }
        return ImmutableList.copyOf((Collection) arrayList);
    }

    @Override // com.google.android.exoplayer2.source.ads.b.a
    public ViewGroup getAdViewGroup() {
        return (ViewGroup) hd.a.l(this.f18805j, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.f18818w;
    }

    public boolean getControllerHideOnTouch() {
        return this.f18820y;
    }

    public int getControllerShowTimeoutMs() {
        return this.f18817v;
    }

    @p0
    public Drawable getDefaultArtwork() {
        return this.f18811p;
    }

    @p0
    public FrameLayout getOverlayFrameLayout() {
        return this.f18806k;
    }

    @p0
    public j1 getPlayer() {
        return this.f18807l;
    }

    public int getResizeMode() {
        hd.a.k(this.f18797b);
        return this.f18797b.getResizeMode();
    }

    @p0
    public SubtitleView getSubtitleView() {
        return this.f18801f;
    }

    public boolean getUseArtwork() {
        return this.f18810o;
    }

    public boolean getUseController() {
        return this.f18808m;
    }

    @p0
    public View getVideoSurfaceView() {
        return this.f18799d;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!U() || this.f18807l == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.A = true;
            return true;
        }
        if (action != 1 || !this.A) {
            return false;
        }
        this.A = false;
        performClick();
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!U() || this.f18807l == null) {
            return false;
        }
        B(true);
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return N();
    }

    public final void s() {
        View view = this.f18798c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void setAspectRatioListener(@p0 AspectRatioFrameLayout.b bVar) {
        hd.a.k(this.f18797b);
        this.f18797b.setAspectRatioListener(bVar);
    }

    public void setControlDispatcher(ya.h hVar) {
        hd.a.k(this.f18804i);
        this.f18804i.setControlDispatcher(hVar);
    }

    public void setControllerAutoShow(boolean z10) {
        this.f18818w = z10;
    }

    public void setControllerHideDuringAds(boolean z10) {
        this.f18819x = z10;
    }

    public void setControllerHideOnTouch(boolean z10) {
        hd.a.k(this.f18804i);
        this.f18820y = z10;
        P();
    }

    public void setControllerShowTimeoutMs(int i10) {
        hd.a.k(this.f18804i);
        this.f18817v = i10;
        if (this.f18804i.J()) {
            K();
        }
    }

    public void setControllerVisibilityListener(@p0 e.d dVar) {
        hd.a.k(this.f18804i);
        e.d dVar2 = this.f18809n;
        if (dVar2 == dVar) {
            return;
        }
        if (dVar2 != null) {
            this.f18804i.K(dVar2);
        }
        this.f18809n = dVar;
        if (dVar != null) {
            this.f18804i.z(dVar);
        }
    }

    public void setCustomErrorMessage(@p0 CharSequence charSequence) {
        hd.a.i(this.f18803h != null);
        this.f18816u = charSequence;
        R();
    }

    public void setDefaultArtwork(@p0 Drawable drawable) {
        if (this.f18811p != drawable) {
            this.f18811p = drawable;
            S(false);
        }
    }

    public void setErrorMessageProvider(@p0 hd.i<? super ExoPlaybackException> iVar) {
        if (this.f18815t != iVar) {
            this.f18815t = iVar;
            R();
        }
    }

    @Deprecated
    public void setFastForwardIncrementMs(int i10) {
        hd.a.k(this.f18804i);
        this.f18804i.setFastForwardIncrementMs(i10);
    }

    public void setKeepContentOnPlayerReset(boolean z10) {
        if (this.f18813r != z10) {
            this.f18813r = z10;
            S(false);
        }
    }

    @Deprecated
    public void setPlaybackPreparer(@p0 i1 i1Var) {
        hd.a.k(this.f18804i);
        this.f18804i.setPlaybackPreparer(i1Var);
    }

    public void setPlayer(@p0 j1 j1Var) {
        hd.a.i(Looper.myLooper() == Looper.getMainLooper());
        hd.a.a(j1Var == null || j1Var.p1() == Looper.getMainLooper());
        j1 j1Var2 = this.f18807l;
        if (j1Var2 == j1Var) {
            return;
        }
        if (j1Var2 != null) {
            j1Var2.K0(this.f18796a);
            j1.p pVarY0 = j1Var2.y0();
            if (pVarY0 != null) {
                pVarY0.B0(this.f18796a);
                View view = this.f18799d;
                if (view instanceof TextureView) {
                    pVarY0.W((TextureView) view);
                } else if (view instanceof dd.h) {
                    ((dd.h) view).setVideoComponent(null);
                } else if (view instanceof SurfaceView) {
                    pVarY0.e1((SurfaceView) view);
                }
            }
            j1.n nVarK1 = j1Var2.K1();
            if (nVarK1 != null) {
                nVarK1.z(this.f18796a);
            }
        }
        SubtitleView subtitleView = this.f18801f;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.f18807l = j1Var;
        if (U()) {
            this.f18804i.setPlayer(j1Var);
        }
        O();
        R();
        S(true);
        if (j1Var == null) {
            x();
            return;
        }
        j1.p pVarY02 = j1Var.y0();
        if (pVarY02 != null) {
            View view2 = this.f18799d;
            if (view2 instanceof TextureView) {
                pVarY02.x1((TextureView) view2);
            } else if (view2 instanceof dd.h) {
                ((dd.h) view2).setVideoComponent(pVarY02);
            } else if (view2 instanceof SurfaceView) {
                pVarY02.g0((SurfaceView) view2);
            }
            pVarY02.P0(this.f18796a);
        }
        j1.n nVarK12 = j1Var.K1();
        if (nVarK12 != null) {
            nVarK12.I(this.f18796a);
            SubtitleView subtitleView2 = this.f18801f;
            if (subtitleView2 != null) {
                subtitleView2.setCues(nVarK12.Q0());
            }
        }
        j1Var.y(this.f18796a);
        B(false);
    }

    public void setRepeatToggleModes(int i10) {
        hd.a.k(this.f18804i);
        this.f18804i.setRepeatToggleModes(i10);
    }

    public void setResizeMode(int i10) {
        hd.a.k(this.f18797b);
        this.f18797b.setResizeMode(i10);
    }

    @Deprecated
    public void setRewindIncrementMs(int i10) {
        hd.a.k(this.f18804i);
        this.f18804i.setRewindIncrementMs(i10);
    }

    public void setShowBuffering(int i10) {
        if (this.f18812q != i10) {
            this.f18812q = i10;
            O();
        }
    }

    public void setShowFastForwardButton(boolean z10) {
        hd.a.k(this.f18804i);
        this.f18804i.setShowFastForwardButton(z10);
    }

    public void setShowMultiWindowTimeBar(boolean z10) {
        hd.a.k(this.f18804i);
        this.f18804i.setShowMultiWindowTimeBar(z10);
    }

    public void setShowNextButton(boolean z10) {
        hd.a.k(this.f18804i);
        this.f18804i.setShowNextButton(z10);
    }

    public void setShowPreviousButton(boolean z10) {
        hd.a.k(this.f18804i);
        this.f18804i.setShowPreviousButton(z10);
    }

    public void setShowRewindButton(boolean z10) {
        hd.a.k(this.f18804i);
        this.f18804i.setShowRewindButton(z10);
    }

    public void setShowShuffleButton(boolean z10) {
        hd.a.k(this.f18804i);
        this.f18804i.setShowShuffleButton(z10);
    }

    public void setShutterBackgroundColor(int i10) {
        View view = this.f18798c;
        if (view != null) {
            view.setBackgroundColor(i10);
        }
    }

    public void setUseArtwork(boolean z10) {
        hd.a.i((z10 && this.f18800e == null) ? false : true);
        if (this.f18810o != z10) {
            this.f18810o = z10;
            S(false);
        }
    }

    public void setUseController(boolean z10) {
        hd.a.i((z10 && this.f18804i == null) ? false : true);
        if (this.f18808m == z10) {
            return;
        }
        this.f18808m = z10;
        if (U()) {
            this.f18804i.setPlayer(this.f18807l);
        } else {
            e eVar = this.f18804i;
            if (eVar != null) {
                eVar.G();
                this.f18804i.setPlayer(null);
            }
        }
        P();
    }

    public void setUseSensorRotation(boolean z10) {
        if (this.f18814s != z10) {
            this.f18814s = z10;
            View view = this.f18799d;
            if (view instanceof dd.h) {
                ((dd.h) view).setUseSensorRotation(z10);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        View view = this.f18799d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i10);
        }
    }

    public boolean v(KeyEvent keyEvent) {
        return U() && this.f18804i.B(keyEvent);
    }

    public final void w() {
        ImageView imageView = this.f18800e;
        if (imageView != null) {
            imageView.setImageResource(android.R.color.transparent);
            this.f18800e.setVisibility(4);
        }
    }

    public void x() {
        e eVar = this.f18804i;
        if (eVar != null) {
            eVar.G();
        }
    }

    public boolean y() {
        e eVar = this.f18804i;
        return eVar != null && eVar.J();
    }

    @SuppressLint({"InlinedApi"})
    public final boolean z(int i10) {
        return i10 == 19 || i10 == 270 || i10 == 22 || i10 == 271 || i10 == 20 || i10 == 269 || i10 == 21 || i10 == 268 || i10 == 23;
    }

    public g(Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public g(Context context, @p0 AttributeSet attributeSet, int i10) {
        boolean z10;
        boolean z11;
        int integer;
        int i11;
        int i12;
        boolean z12;
        int i13;
        boolean z13;
        boolean z14;
        int i14;
        int i15;
        boolean z15;
        super(context, attributeSet, i10);
        a aVar = new a();
        this.f18796a = aVar;
        if (isInEditMode()) {
            this.f18797b = null;
            this.f18798c = null;
            this.f18799d = null;
            this.f18800e = null;
            this.f18801f = null;
            this.f18802g = null;
            this.f18803h = null;
            this.f18804i = null;
            this.f18805j = null;
            this.f18806k = null;
            ImageView imageView = new ImageView(context);
            if (u0.f31154a >= 23) {
                u(getResources(), imageView);
            } else {
                t(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i16 = R.layout.exo_player_view;
        this.f18814s = true;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PlayerView, 0, 0);
            try {
                int i17 = R.styleable.PlayerView_shutter_background_color;
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i17);
                int color = typedArrayObtainStyledAttributes.getColor(i17, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerView_player_layout_id, i16);
                boolean z16 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerView_use_artwork, true);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PlayerView_default_artwork, 0);
                boolean z17 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerView_use_controller, true);
                int i18 = typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerView_surface_type, 1);
                int i19 = typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerView_resize_mode, 0);
                int i20 = typedArrayObtainStyledAttributes.getInt(R.styleable.PlayerView_show_timeout, 5000);
                boolean z18 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerView_hide_on_touch, true);
                boolean z19 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerView_auto_show, true);
                integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.PlayerView_show_buffering, 0);
                this.f18813r = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerView_keep_content_on_player_reset, this.f18813r);
                boolean z20 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerView_hide_during_ads, true);
                this.f18814s = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PlayerView_use_sensor_rotation, this.f18814s);
                typedArrayObtainStyledAttributes.recycle();
                i12 = i18;
                i16 = resourceId;
                z10 = z19;
                i15 = i20;
                z15 = z17;
                z11 = z20;
                i14 = resourceId2;
                z14 = z16;
                z13 = zHasValue;
                i13 = color;
                z12 = z18;
                i11 = i19;
            } catch (Throwable th2) {
                typedArrayObtainStyledAttributes.recycle();
                throw th2;
            }
        } else {
            z10 = true;
            z11 = true;
            integer = 0;
            i11 = 0;
            i12 = 1;
            z12 = true;
            i13 = 0;
            z13 = false;
            z14 = true;
            i14 = 0;
            i15 = 5000;
            z15 = true;
        }
        LayoutInflater.from(context).inflate(i16, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R.id.exo_content_frame);
        this.f18797b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            I(aspectRatioFrameLayout, i11);
        }
        View viewFindViewById = findViewById(R.id.exo_shutter);
        this.f18798c = viewFindViewById;
        if (viewFindViewById != null && z13) {
            viewFindViewById.setBackgroundColor(i13);
        }
        if (aspectRatioFrameLayout != null && i12 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i12 == 2) {
                this.f18799d = new TextureView(context);
            } else if (i12 == 3) {
                dd.h hVar = new dd.h(context);
                hVar.setSingleTapListener(aVar);
                hVar.setUseSensorRotation(this.f18814s);
                this.f18799d = hVar;
            } else if (i12 != 4) {
                this.f18799d = new SurfaceView(context);
            } else {
                this.f18799d = new id.h(context);
            }
            this.f18799d.setLayoutParams(layoutParams);
            aspectRatioFrameLayout.addView(this.f18799d, 0);
        } else {
            this.f18799d = null;
        }
        this.f18805j = (FrameLayout) findViewById(R.id.exo_ad_overlay);
        this.f18806k = (FrameLayout) findViewById(R.id.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R.id.exo_artwork);
        this.f18800e = imageView2;
        this.f18810o = z14 && imageView2 != null;
        if (i14 != 0) {
            this.f18811p = h0.d.i(getContext(), i14);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R.id.exo_subtitles);
        this.f18801f = subtitleView;
        if (subtitleView != null) {
            subtitleView.e();
            subtitleView.f();
        }
        View viewFindViewById2 = findViewById(R.id.exo_buffering);
        this.f18802g = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.f18812q = integer;
        TextView textView = (TextView) findViewById(R.id.exo_error_message);
        this.f18803h = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i21 = R.id.exo_controller;
        e eVar = (e) findViewById(i21);
        View viewFindViewById3 = findViewById(R.id.exo_controller_placeholder);
        if (eVar != null) {
            this.f18804i = eVar;
        } else if (viewFindViewById3 != null) {
            e eVar2 = new e(context, null, 0, attributeSet);
            this.f18804i = eVar2;
            eVar2.setId(i21);
            eVar2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(eVar2, iIndexOfChild);
        } else {
            this.f18804i = null;
        }
        e eVar3 = this.f18804i;
        this.f18817v = eVar3 != null ? i15 : 0;
        this.f18820y = z12;
        this.f18818w = z10;
        this.f18819x = z11;
        this.f18808m = z15 && eVar3 != null;
        x();
        P();
        e eVar4 = this.f18804i;
        if (eVar4 != null) {
            eVar4.z(aVar);
        }
    }
}
