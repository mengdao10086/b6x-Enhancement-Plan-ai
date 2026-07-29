package mh;

import android.R;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* JADX INFO: loaded from: classes5.dex */
public class i extends StateListDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41250a;

    public i(Drawable drawable, int i10) {
        this.f41250a = i10;
        addState(new int[]{R.attr.state_selected}, drawable);
        addState(new int[0], drawable);
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z10 = false;
        for (int i10 : iArr) {
            if (i10 == 16842913) {
                z10 = true;
            }
        }
        if (z10) {
            super.setColorFilter(this.f41250a, PorterDuff.Mode.SRC_ATOP);
        } else {
            super.clearColorFilter();
        }
        return super.onStateChange(iArr);
    }
}
