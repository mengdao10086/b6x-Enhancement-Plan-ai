package a;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class u5 implements b8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f7566a = {x.abc_textfield_search_default_mtrl_alpha, x.abc_textfield_default_mtrl_alpha, x.abc_ab_share_pack_mtrl_alpha};
    public final int[] b = {x.abc_ic_commit_search_api_mtrl_alpha, x.abc_seekbar_tick_mark_material, x.abc_ic_menu_share_mtrl_alpha, x.abc_ic_menu_copy_mtrl_am_alpha, x.abc_ic_menu_cut_mtrl_alpha, x.abc_ic_menu_selectall_mtrl_alpha, x.abc_ic_menu_paste_mtrl_am_alpha};
    public final int[] c = {x.abc_textfield_activated_mtrl_alpha, x.abc_textfield_search_activated_mtrl_alpha, x.abc_cab_background_top_mtrl_alpha, x.abc_text_cursor_material, x.abc_text_select_handle_left_mtrl_dark, x.abc_text_select_handle_middle_mtrl_dark, x.abc_text_select_handle_right_mtrl_dark, x.abc_text_select_handle_left_mtrl_light, x.abc_text_select_handle_middle_mtrl_light, x.abc_text_select_handle_right_mtrl_light};
    public final int[] d = {x.abc_popup_background_mtrl_mult, x.abc_cab_background_internal_bg, x.abc_menu_hardkey_panel_mtrl_mult};
    public final int[] e = {x.abc_tab_indicator_material, x.abc_textfield_search_material};
    public final int[] f = {x.abc_btn_check_material, x.abc_btn_radio_material, x.abc_btn_check_material_anim, x.abc_btn_radio_material_anim};

    @Override // a.b8
    public boolean a(Context context, int i, Drawable drawable) {
        LayerDrawable layerDrawable;
        Drawable drawableFindDrawableByLayerId;
        int i2;
        if (i == x.abc_seekbar_track_material) {
            layerDrawable = (LayerDrawable) drawable;
            l(layerDrawable.findDrawableByLayerId(R.id.background), k8.c(context, t.colorControlNormal), v5.f3232a);
            drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.secondaryProgress);
            i2 = t.colorControlNormal;
        } else {
            if (i != x.abc_ratingbar_material && i != x.abc_ratingbar_indicator_material && i != x.abc_ratingbar_small_material) {
                return false;
            }
            layerDrawable = (LayerDrawable) drawable;
            l(layerDrawable.findDrawableByLayerId(R.id.background), k8.b(context, t.colorControlNormal), v5.f3232a);
            drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.secondaryProgress);
            i2 = t.colorControlActivated;
        }
        l(drawableFindDrawableByLayerId, k8.c(context, i2), v5.f3232a);
        l(layerDrawable.findDrawableByLayerId(R.id.progress), k8.c(context, t.colorControlActivated), v5.f3232a);
        return true;
    }

    @Override // a.b8
    public PorterDuff.Mode b(int i) {
        if (i == x.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061 A[RETURN] */
    @Override // a.b8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
        /*
            r6 = this;
            android.graphics.PorterDuff$Mode r0 = a.v5.a()
            int[] r1 = r6.f7566a
            boolean r1 = r6.f(r1, r8)
            r2 = 16842801(0x1010031, float:2.3693695E-38)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L17
            int r2 = a.t.colorControlNormal
        L14:
            r8 = r3
        L15:
            r1 = r5
            goto L44
        L17:
            int[] r1 = r6.c
            boolean r1 = r6.f(r1, r8)
            if (r1 == 0) goto L22
            int r2 = a.t.colorControlActivated
            goto L14
        L22:
            int[] r1 = r6.d
            boolean r1 = r6.f(r1, r8)
            if (r1 == 0) goto L2d
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L14
        L2d:
            int r1 = a.x.abc_list_divider_mtrl_alpha
            if (r8 != r1) goto L3c
            r2 = 16842800(0x1010030, float:2.3693693E-38)
            r8 = 1109603123(0x42233333, float:40.8)
            int r8 = java.lang.Math.round(r8)
            goto L15
        L3c:
            int r1 = a.x.abc_dialog_material_background
            if (r8 != r1) goto L41
            goto L14
        L41:
            r8 = r3
            r1 = r4
            r2 = r1
        L44:
            if (r1 == 0) goto L61
            boolean r1 = a.e7.a(r9)
            if (r1 == 0) goto L50
            android.graphics.drawable.Drawable r9 = r9.mutate()
        L50:
            int r7 = a.k8.c(r7, r2)
            android.graphics.PorterDuffColorFilter r7 = a.v5.e(r7, r0)
            r9.setColorFilter(r7)
            if (r8 == r3) goto L60
            r9.setAlpha(r8)
        L60:
            return r5
        L61:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.u5.c(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    @Override // a.b8
    public ColorStateList d(Context context, int i) {
        if (i == x.abc_edit_text_material) {
            return r2.c(context, v.abc_tint_edittext);
        }
        if (i == x.abc_switch_track_mtrl_alpha) {
            return r2.c(context, v.abc_tint_switch_track);
        }
        if (i == x.abc_switch_thumb_material) {
            return k(context);
        }
        if (i == x.abc_btn_default_mtrl_shape) {
            return j(context);
        }
        if (i == x.abc_btn_borderless_material) {
            return g(context);
        }
        if (i == x.abc_btn_colored_material) {
            return i(context);
        }
        if (i == x.abc_spinner_mtrl_am_alpha || i == x.abc_spinner_textfield_background_material) {
            return r2.c(context, v.abc_tint_spinner);
        }
        if (f(this.b, i)) {
            return k8.e(context, t.colorControlNormal);
        }
        if (f(this.e, i)) {
            return r2.c(context, v.abc_tint_default);
        }
        if (f(this.f, i)) {
            return r2.c(context, v.abc_tint_btn_checkable);
        }
        if (i == x.abc_seekbar_thumb_material) {
            return r2.c(context, v.abc_tint_seek_thumb);
        }
        return null;
    }

    @Override // a.b8
    public Drawable e(d8 d8Var, Context context, int i) {
        if (i == x.abc_cab_background_top_material) {
            return new LayerDrawable(new Drawable[]{d8Var.j(context, x.abc_cab_background_internal_bg), d8Var.j(context, x.abc_cab_background_top_mtrl_alpha)});
        }
        return null;
    }

    public final boolean f(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public final ColorStateList g(Context context) {
        return h(context, 0);
    }

    public final ColorStateList h(Context context, int i) {
        int iC = k8.c(context, t.colorControlHighlight);
        return new ColorStateList(new int[][]{k8.f1608a, k8.c, k8.b, k8.e}, new int[]{k8.b(context, t.colorButtonNormal), tc.b(iC, i), tc.b(iC, i), i});
    }

    public final ColorStateList i(Context context) {
        return h(context, k8.c(context, t.colorAccent));
    }

    public final ColorStateList j(Context context) {
        return h(context, k8.c(context, t.colorButtonNormal));
    }

    public final ColorStateList k(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListE = k8.e(context, t.colorSwitchThumbNormal);
        if (colorStateListE == null || !colorStateListE.isStateful()) {
            iArr[0] = k8.f1608a;
            iArr2[0] = k8.b(context, t.colorSwitchThumbNormal);
            iArr[1] = k8.d;
            iArr2[1] = k8.c(context, t.colorControlActivated);
            iArr[2] = k8.e;
            iArr2[2] = k8.c(context, t.colorSwitchThumbNormal);
        } else {
            iArr[0] = k8.f1608a;
            iArr2[0] = colorStateListE.getColorForState(iArr[0], 0);
            iArr[1] = k8.d;
            iArr2[1] = k8.c(context, t.colorControlActivated);
            iArr[2] = k8.e;
            iArr2[2] = colorStateListE.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public final void l(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (e7.a(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = v5.f3232a;
        }
        drawable.setColorFilter(v5.e(i, mode));
    }
}
