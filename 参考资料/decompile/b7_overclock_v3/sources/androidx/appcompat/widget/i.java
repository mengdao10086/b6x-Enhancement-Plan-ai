package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f2498b = "AppCompatDrawableManag";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f2499c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PorterDuff.Mode f2500d = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static i f2501e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n0 f2502a;

    public class a implements n0.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f2503a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f2504b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f2505c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f2506d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f2507e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[] f2508f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

        /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0061 A[RETURN] */
        @Override // androidx.appcompat.widget.n0.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(@g.n0 android.content.Context r7, int r8, @g.n0 android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.i.a()
                int[] r1 = r6.f2503a
                boolean r1 = r6.f(r1, r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L17
                int r2 = androidx.appcompat.R.attr.colorControlNormal
            L14:
                r8 = -1
            L15:
                r1 = 1
                goto L44
            L17:
                int[] r1 = r6.f2505c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L22
                int r2 = androidx.appcompat.R.attr.colorControlActivated
                goto L14
            L22:
                int[] r1 = r6.f2506d
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L2d
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L14
            L2d:
                int r1 = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha
                if (r8 != r1) goto L3c
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                goto L15
            L3c:
                int r1 = androidx.appcompat.R.drawable.abc_dialog_material_background
                if (r8 != r1) goto L41
                goto L14
            L41:
                r8 = -1
                r1 = 0
                r2 = 0
            L44:
                if (r1 == 0) goto L61
                boolean r1 = androidx.appcompat.widget.d0.a(r9)
                if (r1 == 0) goto L50
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L50:
                int r7 = androidx.appcompat.widget.t0.d(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.i.e(r7, r0)
                r9.setColorFilter(r7)
                if (r8 == r3) goto L60
                r9.setAlpha(r8)
            L60:
                return r5
            L61:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i.a.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.n0.f
        public PorterDuff.Mode b(int i10) {
            if (i10 == R.drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.n0.f
        public Drawable c(@g.n0 n0 n0Var, @g.n0 Context context, int i10) {
            if (i10 == R.drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{n0Var.j(context, R.drawable.abc_cab_background_internal_bg), n0Var.j(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (i10 == R.drawable.abc_ratingbar_material) {
                return l(n0Var, context, R.dimen.abc_star_big);
            }
            if (i10 == R.drawable.abc_ratingbar_indicator_material) {
                return l(n0Var, context, R.dimen.abc_star_medium);
            }
            if (i10 == R.drawable.abc_ratingbar_small_material) {
                return l(n0Var, context, R.dimen.abc_star_small);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.n0.f
        public ColorStateList d(@g.n0 Context context, int i10) {
            if (i10 == R.drawable.abc_edit_text_material) {
                return i.a.a(context, R.color.abc_tint_edittext);
            }
            if (i10 == R.drawable.abc_switch_track_mtrl_alpha) {
                return i.a.a(context, R.color.abc_tint_switch_track);
            }
            if (i10 == R.drawable.abc_switch_thumb_material) {
                return k(context);
            }
            if (i10 == R.drawable.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i10 == R.drawable.abc_btn_borderless_material) {
                return g(context);
            }
            if (i10 == R.drawable.abc_btn_colored_material) {
                return i(context);
            }
            if (i10 == R.drawable.abc_spinner_mtrl_am_alpha || i10 == R.drawable.abc_spinner_textfield_background_material) {
                return i.a.a(context, R.color.abc_tint_spinner);
            }
            if (f(this.f2504b, i10)) {
                return t0.f(context, R.attr.colorControlNormal);
            }
            if (f(this.f2507e, i10)) {
                return i.a.a(context, R.color.abc_tint_default);
            }
            if (f(this.f2508f, i10)) {
                return i.a.a(context, R.color.abc_tint_btn_checkable);
            }
            if (i10 == R.drawable.abc_seekbar_thumb_material) {
                return i.a.a(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.n0.f
        public boolean e(@g.n0 Context context, int i10, @g.n0 Drawable drawable) {
            if (i10 == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
                int i11 = R.attr.colorControlNormal;
                m(drawableFindDrawableByLayerId, t0.d(context, i11), i.f2500d);
                m(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), t0.d(context, i11), i.f2500d);
                m(layerDrawable.findDrawableByLayerId(android.R.id.progress), t0.d(context, R.attr.colorControlActivated), i.f2500d);
                return true;
            }
            if (i10 != R.drawable.abc_ratingbar_material && i10 != R.drawable.abc_ratingbar_indicator_material && i10 != R.drawable.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(android.R.id.background), t0.c(context, R.attr.colorControlNormal), i.f2500d);
            Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress);
            int i12 = R.attr.colorControlActivated;
            m(drawableFindDrawableByLayerId2, t0.d(context, i12), i.f2500d);
            m(layerDrawable2.findDrawableByLayerId(android.R.id.progress), t0.d(context, i12), i.f2500d);
            return true;
        }

        public final boolean f(int[] iArr, int i10) {
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList g(@g.n0 Context context) {
            return h(context, 0);
        }

        public final ColorStateList h(@g.n0 Context context, @g.l int i10) {
            int iD = t0.d(context, R.attr.colorControlHighlight);
            return new ColorStateList(new int[][]{t0.f2702c, t0.f2705f, t0.f2703d, t0.f2709j}, new int[]{t0.c(context, R.attr.colorButtonNormal), m0.g.t(iD, i10), m0.g.t(iD, i10), i10});
        }

        public final ColorStateList i(@g.n0 Context context) {
            return h(context, t0.d(context, R.attr.colorAccent));
        }

        public final ColorStateList j(@g.n0 Context context) {
            return h(context, t0.d(context, R.attr.colorButtonNormal));
        }

        public final ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i10 = R.attr.colorSwitchThumbNormal;
            ColorStateList colorStateListF = t0.f(context, i10);
            if (colorStateListF == null || !colorStateListF.isStateful()) {
                iArr[0] = t0.f2702c;
                iArr2[0] = t0.c(context, i10);
                iArr[1] = t0.f2706g;
                iArr2[1] = t0.d(context, R.attr.colorControlActivated);
                iArr[2] = t0.f2709j;
                iArr2[2] = t0.d(context, i10);
            } else {
                iArr[0] = t0.f2702c;
                iArr2[0] = colorStateListF.getColorForState(iArr[0], 0);
                iArr[1] = t0.f2706g;
                iArr2[1] = t0.d(context, R.attr.colorControlActivated);
                iArr[2] = t0.f2709j;
                iArr2[2] = colorStateListF.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        public final LayerDrawable l(@g.n0 n0 n0Var, @g.n0 Context context, @g.q int i10) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
            Drawable drawableJ = n0Var.j(context, R.drawable.abc_star_black_48dp);
            Drawable drawableJ2 = n0Var.j(context, R.drawable.abc_star_half_black_48dp);
            if ((drawableJ instanceof BitmapDrawable) && drawableJ.getIntrinsicWidth() == dimensionPixelSize && drawableJ.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableJ;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableJ.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableJ.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableJ2 instanceof BitmapDrawable) && drawableJ2.getIntrinsicWidth() == dimensionPixelSize && drawableJ2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableJ2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableJ2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableJ2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, android.R.id.background);
            layerDrawable.setId(1, android.R.id.secondaryProgress);
            layerDrawable.setId(2, android.R.id.progress);
            return layerDrawable;
        }

        public final void m(Drawable drawable, int i10, PorterDuff.Mode mode) {
            if (d0.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = i.f2500d;
            }
            drawable.setColorFilter(i.e(i10, mode));
        }
    }

    public static synchronized i b() {
        if (f2501e == null) {
            i();
        }
        return f2501e;
    }

    public static synchronized PorterDuffColorFilter e(int i10, PorterDuff.Mode mode) {
        return n0.l(i10, mode);
    }

    public static synchronized void i() {
        if (f2501e == null) {
            i iVar = new i();
            f2501e = iVar;
            iVar.f2502a = n0.h();
            f2501e.f2502a.u(new a());
        }
    }

    public static void j(Drawable drawable, w0 w0Var, int[] iArr) {
        n0.w(drawable, w0Var, iArr);
    }

    public synchronized Drawable c(@g.n0 Context context, @g.v int i10) {
        return this.f2502a.j(context, i10);
    }

    public synchronized Drawable d(@g.n0 Context context, @g.v int i10, boolean z10) {
        return this.f2502a.k(context, i10, z10);
    }

    public synchronized ColorStateList f(@g.n0 Context context, @g.v int i10) {
        return this.f2502a.m(context, i10);
    }

    public synchronized void g(@g.n0 Context context) {
        this.f2502a.s(context);
    }

    public synchronized Drawable h(@g.n0 Context context, @g.n0 g1 g1Var, @g.v int i10) {
        return this.f2502a.t(context, g1Var, i10);
    }

    public boolean k(@g.n0 Context context, @g.v int i10, @g.n0 Drawable drawable) {
        return this.f2502a.x(context, i10, drawable);
    }
}
