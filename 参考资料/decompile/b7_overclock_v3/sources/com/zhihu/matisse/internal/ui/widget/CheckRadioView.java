package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.zhihu.matisse.R;
import j0.i;

/* JADX INFO: loaded from: classes5.dex */
public class CheckRadioView extends AppCompatImageView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f25114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f25115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25116f;

    public CheckRadioView(Context context) {
        super(context);
        b();
    }

    public final void b() {
        this.f25115e = i.e(getResources(), R.color.zhihu_item_checkCircle_backgroundColor, getContext().getTheme());
        this.f25116f = i.e(getResources(), R.color.zhihu_check_original_radio_disable, getContext().getTheme());
        setChecked(false);
    }

    public void setChecked(boolean z10) {
        if (z10) {
            setImageResource(R.drawable.ic_preview_radio_on);
            Drawable drawable = getDrawable();
            this.f25114d = drawable;
            drawable.setColorFilter(this.f25115e, PorterDuff.Mode.SRC_IN);
            return;
        }
        setImageResource(R.drawable.ic_preview_radio_off);
        Drawable drawable2 = getDrawable();
        this.f25114d = drawable2;
        drawable2.setColorFilter(this.f25116f, PorterDuff.Mode.SRC_IN);
    }

    public void setColor(int i10) {
        if (this.f25114d == null) {
            this.f25114d = getDrawable();
        }
        this.f25114d.setColorFilter(i10, PorterDuff.Mode.SRC_IN);
    }

    public CheckRadioView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
