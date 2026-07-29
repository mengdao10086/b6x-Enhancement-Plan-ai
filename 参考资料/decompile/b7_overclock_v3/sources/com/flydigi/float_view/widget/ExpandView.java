package com.flydigi.float_view.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.a;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyMacro;
import h0.d;
import m9.m;
import w7.u;
import y0.c;

/* JADX INFO: loaded from: classes7.dex */
public class ExpandView extends RelativeLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f15750i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f15751j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f15752k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f15753l = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GamepadInfo f15755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f15756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CFGPropertyKey f15757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CFGPropertyJS f15758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CFGPropertyMacro f15759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f15761h;

    public ExpandView(Context context) {
        this(context, null);
    }

    public boolean a() {
        return this.f15757d != null ? !this.f15755b.isGamepadKeyboard() && m.a(this.f15757d.key_id) : (this.f15759f == null || this.f15755b.isGamepadKeyboard() || !m.a(this.f15759f.key_id)) ? false : true;
    }

    public boolean b(int i10, int i11) {
        CFGPropertyKey cFGPropertyKey = this.f15757d;
        if (cFGPropertyKey != null) {
            int i12 = cFGPropertyKey.comboKeyFirst;
            if (i12 == i10 && cFGPropertyKey.comboKeySecond == i11) {
                return true;
            }
            return i12 == i11 && cFGPropertyKey.comboKeySecond == i10;
        }
        CFGPropertyMacro cFGPropertyMacro = this.f15759f;
        if (cFGPropertyMacro == null) {
            return false;
        }
        int i13 = cFGPropertyMacro.comboKeyFirst;
        if (i13 == i10 && cFGPropertyMacro.comboKeySecond == i11) {
            return true;
        }
        return i13 == i11 && cFGPropertyMacro.comboKeySecond == i10;
    }

    public boolean c() {
        return this.f15761h;
    }

    public void d() {
        this.f15757d = null;
        this.f15758e = null;
        this.f15759f = null;
    }

    public void e(int i10, boolean z10) {
        this.f15754a = i10;
        if (z10) {
            return;
        }
        int dimensionPixelSize = i10 == 1 ? getContext().getResources().getDimensionPixelSize(R.dimen.qb_px_88) : getContext().getResources().getDimensionPixelSize(R.dimen.qb_px_48);
        setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        this.f15756c.f54471b.getLayoutParams().width = dimensionPixelSize;
        this.f15756c.f54471b.getLayoutParams().height = dimensionPixelSize;
        this.f15756c.f54471b.setVisibility(4);
    }

    public final void f(CFGPropertyJS cFGPropertyJS, GamepadInfo gamepadInfo, boolean z10) {
        this.f15756c.f54472c.setVisibility(0);
        this.f15756c.f54473d.setVisibility(8);
        this.f15756c.f54472c.setImageDrawable(a.k(getContext(), cFGPropertyJS.key_id, gamepadInfo, z10));
        m(cFGPropertyJS.key_id, z10);
    }

    public final void g(CFGPropertyKey cFGPropertyKey, GamepadInfo gamepadInfo, boolean z10) {
        if (!z10) {
            int i10 = cFGPropertyKey.key_id;
            if (i10 == 240 || i10 == 241 || i10 == 242 || i10 == 116 || i10 == 103 || i10 == 104 || i10 == 100 || i10 == 101 || i10 == 102 || i10 == 106 || i10 == 105) {
                this.f15756c.f54472c.setVisibility(0);
                this.f15756c.f54473d.setVisibility(8);
                this.f15756c.f54472c.setImageDrawable(a.k(getContext(), cFGPropertyKey.key_id, gamepadInfo, z10));
            } else {
                this.f15756c.f54473d.setVisibility(0);
                this.f15756c.f54472c.setVisibility(8);
                this.f15756c.f54473d.setText(a.l(cFGPropertyKey, gamepadInfo));
            }
        } else if (m.a(cFGPropertyKey.key_id)) {
            this.f15756c.f54473d.setVisibility(0);
            this.f15756c.f54472c.setVisibility(8);
            this.f15756c.f54473d.setText(a.l(cFGPropertyKey, gamepadInfo));
        } else {
            this.f15756c.f54472c.setVisibility(0);
            this.f15756c.f54473d.setVisibility(8);
            this.f15756c.f54472c.setImageDrawable(a.k(getContext(), cFGPropertyKey.key_id, gamepadInfo, z10));
        }
        m(cFGPropertyKey.key_id, z10);
    }

    public int getComboKeyFirst() {
        CFGPropertyKey cFGPropertyKey = this.f15757d;
        if (cFGPropertyKey != null) {
            return cFGPropertyKey.comboKeyFirst;
        }
        CFGPropertyMacro cFGPropertyMacro = this.f15759f;
        if (cFGPropertyMacro != null) {
            return cFGPropertyMacro.comboKeyFirst;
        }
        return -1;
    }

    public int getComboKeySecond() {
        CFGPropertyKey cFGPropertyKey = this.f15757d;
        if (cFGPropertyKey != null) {
            return cFGPropertyKey.comboKeySecond;
        }
        CFGPropertyMacro cFGPropertyMacro = this.f15759f;
        if (cFGPropertyMacro != null) {
            return cFGPropertyMacro.comboKeySecond;
        }
        return -1;
    }

    public int getConfigType() {
        return this.f15754a;
    }

    public int getKeyId() {
        CFGPropertyKey cFGPropertyKey = this.f15757d;
        if (cFGPropertyKey != null) {
            return cFGPropertyKey.key_id;
        }
        CFGPropertyJS cFGPropertyJS = this.f15758e;
        if (cFGPropertyJS != null) {
            return cFGPropertyJS.key_id;
        }
        CFGPropertyMacro cFGPropertyMacro = this.f15759f;
        if (cFGPropertyMacro != null) {
            return cFGPropertyMacro.key_id;
        }
        return -1;
    }

    public CFGPropertyJS getPropertyJs() {
        return this.f15758e;
    }

    public CFGPropertyKey getPropertyKey() {
        return this.f15757d;
    }

    public CFGPropertyMacro getPropertyMacro() {
        return this.f15759f;
    }

    public final void h(CFGPropertyMacro cFGPropertyMacro, GamepadInfo gamepadInfo, boolean z10) {
        int i10 = cFGPropertyMacro.key_id;
        if (i10 == 240 || i10 == 241 || i10 == 242 || i10 == 116 || i10 == 103 || i10 == 104 || i10 == 100 || i10 == 101 || i10 == 102 || i10 == 106 || i10 == 105) {
            this.f15756c.f54472c.setVisibility(0);
            this.f15756c.f54473d.setVisibility(8);
            this.f15756c.f54472c.setImageDrawable(a.k(getContext(), cFGPropertyMacro.key_id, gamepadInfo, z10));
        } else {
            this.f15756c.f54473d.setVisibility(0);
            this.f15756c.f54472c.setVisibility(8);
            this.f15756c.f54473d.setText(a.m(cFGPropertyMacro, gamepadInfo));
        }
        m(cFGPropertyMacro.key_id, z10);
    }

    public void i(int i10, GamepadInfo gamepadInfo, boolean z10) {
        if (i10 == 240 || i10 == 241 || i10 == 242 || i10 == 116 || i10 == 103 || i10 == 104 || i10 == 100 || i10 == 101 || i10 == 102 || i10 == 106 || i10 == 105) {
            this.f15756c.f54472c.setVisibility(0);
            this.f15756c.f54473d.setVisibility(8);
            this.f15756c.f54472c.setImageDrawable(a.k(getContext(), i10, gamepadInfo, z10));
        } else {
            this.f15756c.f54473d.setVisibility(0);
            this.f15756c.f54472c.setVisibility(8);
            if (i10 == 256) {
                this.f15756c.f54473d.setText(getContext().getString(R.string.floatview_combo_key));
            } else {
                this.f15756c.f54473d.setText(c.a(a.n(i10, gamepadInfo), 0));
            }
        }
        m(i10, z10);
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.f15760g;
    }

    public void j(CFGPropertyJS cFGPropertyJS, GamepadInfo gamepadInfo, boolean z10) {
        this.f15755b = gamepadInfo;
        this.f15758e = cFGPropertyJS;
        e(1, z10);
        f(cFGPropertyJS, gamepadInfo, z10);
    }

    public void k(CFGPropertyKey cFGPropertyKey, GamepadInfo gamepadInfo, boolean z10) {
        this.f15755b = gamepadInfo;
        this.f15757d = cFGPropertyKey;
        if (cFGPropertyKey.key_id == 116) {
            this.f15754a = 0;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.qb_px_88);
            setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
            this.f15756c.f54472c.clearColorFilter();
        } else {
            e(0, z10);
        }
        g(cFGPropertyKey, gamepadInfo, z10);
    }

    public void l(CFGPropertyMacro cFGPropertyMacro, GamepadInfo gamepadInfo, boolean z10) {
        this.f15755b = gamepadInfo;
        this.f15759f = cFGPropertyMacro;
        e(2, z10);
        h(cFGPropertyMacro, gamepadInfo, z10);
    }

    public final void m(int i10, boolean z10) {
        int dimensionPixelSize;
        if (i10 == 240 || i10 == 241 || i10 == 242 || i10 == 116) {
            dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.qb_px_64);
        } else {
            dimensionPixelSize = getContext().getResources().getDimensionPixelSize(z10 ? R.dimen.qb_px_24 : R.dimen.qb_px_28);
        }
        this.f15756c.f54473d.getLayoutParams().width = dimensionPixelSize;
        this.f15756c.f54473d.getLayoutParams().height = dimensionPixelSize;
        this.f15756c.f54472c.getLayoutParams().width = dimensionPixelSize;
        this.f15756c.f54472c.getLayoutParams().height = dimensionPixelSize;
        this.f15756c.f54473d.setBackgroundResource(z10 ? R.drawable.floatview_shape_bg_key_hint : R.drawable.floatview_shape_bg_key);
        this.f15756c.f54473d.setTextColor(d.f(getContext(), z10 ? R.color.color_000000_a40 : R.color.color_white));
        if (i10 == 240 || i10 == 241 || i10 == 242 || i10 == 116) {
            this.f15756c.f54471b.setImageResource(R.drawable.bg_selected_for_joystick);
        } else {
            this.f15756c.f54471b.setImageResource(R.drawable.bg_selected_for_key);
        }
        if (this.f15754a == 2) {
            this.f15756c.f54472c.setColorFilter(d.f(getContext(), R.color.colorPrimaryA80));
            this.f15756c.f54473d.setBackgroundResource(R.drawable.floatview_shape_bg_key_macro);
        } else {
            this.f15756c.f54472c.clearColorFilter();
            n0.c.c(this.f15756c.f54473d.getBackground());
        }
        if (z10) {
            this.f15756c.f54472c.setAlpha(0.4f);
        }
    }

    public void n(int i10) {
        this.f15756c.f54473d.getLayoutParams().width = i10;
        this.f15756c.f54473d.getLayoutParams().height = i10;
        this.f15756c.f54472c.getLayoutParams().width = i10;
        this.f15756c.f54472c.getLayoutParams().height = i10;
    }

    public void setComboKeyMode(int i10) {
        CFGPropertyKey cFGPropertyKey = this.f15757d;
        if (cFGPropertyKey != null) {
            cFGPropertyKey.comboKeyMode = i10;
            return;
        }
        CFGPropertyMacro cFGPropertyMacro = this.f15759f;
        if (cFGPropertyMacro != null) {
            cFGPropertyMacro.comboKeyMode = i10;
        }
    }

    public void setNumber(int i10) {
        if (this.f15758e == null) {
            this.f15756c.f54474e.setText(String.valueOf(i10));
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z10) {
        this.f15760g = z10;
        if (z10) {
            this.f15756c.f54471b.setVisibility(0);
            this.f15756c.f54474e.setVisibility(0);
        } else {
            this.f15761h = false;
            this.f15756c.f54471b.setVisibility(4);
            this.f15756c.f54474e.setVisibility(4);
        }
    }

    public void setUIFocus(boolean z10) {
        this.f15761h = z10;
    }

    public ExpandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f15754a = 0;
        this.f15760g = false;
        u uVarD = u.d(LayoutInflater.from(context), this, true);
        this.f15756c = uVarD;
        uVarD.f54473d.setTypeface(Typeface.createFromAsset(context.getAssets(), "iconfont.ttf"));
    }
}
