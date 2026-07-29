package o8;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro;

/* JADX INFO: loaded from: classes7.dex */
public class b extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w7.l0 f42812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CFGSubPropertyMacro f42813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f42814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f42815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f42816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f42817f;

    public b(Context context) {
        this(context, null);
    }

    public boolean a() {
        return this.f42815d;
    }

    public void b(int i10, int i11, int i12, GamepadInfo gamepadInfo) {
        if (i10 == 240 || i10 == 241 || i10 == 242 || i10 == 116 || i10 == 103 || i10 == 104 || i10 == 100 || i10 == 101 || i10 == 102 || i10 == 106 || i10 == 105) {
            this.f42812a.f54246c.setVisibility(0);
            this.f42812a.f54247d.setVisibility(8);
            this.f42812a.f54246c.setImageDrawable(com.flydigi.sdk.gamepad.extension.a.k(getContext(), i10, gamepadInfo, false));
        } else {
            this.f42812a.f54247d.setVisibility(0);
            this.f42812a.f54246c.setVisibility(8);
            if (i10 == 256) {
                this.f42812a.f54247d.setText(String.format("%s+%s", y0.c.a(com.flydigi.sdk.gamepad.extension.a.n(o9.b.a(i11), gamepadInfo), 0), y0.c.a(com.flydigi.sdk.gamepad.extension.a.n(o9.b.a(i12), gamepadInfo), 0)));
            } else {
                this.f42812a.f54247d.setText(y0.c.a(com.flydigi.sdk.gamepad.extension.a.n(i10, gamepadInfo), 0));
            }
        }
        c(i10);
    }

    public final void c(int i10) {
        this.f42812a.f54247d.setBackgroundResource(R.drawable.floatview_shape_bg_key);
        this.f42812a.f54247d.setTextColor(h0.d.f(getContext(), R.color.color_white));
        if (i10 == 240 || i10 == 241 || i10 == 116) {
            this.f42812a.f54245b.setImageResource(R.drawable.bg_selected_for_joystick);
        } else {
            this.f42812a.f54245b.setImageResource(R.drawable.bg_selected_for_key);
        }
    }

    public int getNumber() {
        return this.f42817f;
    }

    public CFGSubPropertyMacro getPropertyMacro() {
        return this.f42813b;
    }

    public boolean getReset() {
        return this.f42816e;
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.f42814c;
    }

    public void setNumber(int i10) {
        this.f42817f = i10;
        this.f42812a.f54248e.setVisibility(0);
        this.f42812a.f54248e.setText(String.valueOf(i10));
    }

    public void setPropertyMacro(CFGSubPropertyMacro cFGSubPropertyMacro) {
        this.f42813b = cFGSubPropertyMacro;
    }

    public void setReset(boolean z10) {
        this.f42816e = z10;
    }

    @Override // android.view.View
    public void setSelected(boolean z10) {
        this.f42814c = z10;
        if (z10) {
            this.f42812a.f54245b.setVisibility(0);
        } else {
            this.f42815d = false;
            this.f42812a.f54245b.setVisibility(4);
        }
    }

    public void setUIFocus(boolean z10) {
        this.f42815d = z10;
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f42814c = false;
        this.f42816e = true;
        this.f42817f = 1;
        w7.l0 l0VarD = w7.l0.d(LayoutInflater.from(context), this, true);
        this.f42812a = l0VarD;
        l0VarD.f54247d.setTypeface(Typeface.createFromAsset(context.getAssets(), "iconfont.ttf"));
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.qb_px_48);
        setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
    }
}
