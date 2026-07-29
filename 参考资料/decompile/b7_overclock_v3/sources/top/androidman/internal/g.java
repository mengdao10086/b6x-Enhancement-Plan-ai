package top.androidman.internal;

import android.graphics.drawable.GradientDrawable;
import yt.k;

/* JADX INFO: loaded from: classes6.dex */
public final class g {
    @k
    public static final GradientDrawable.Orientation a(int i10) {
        switch (i10) {
            case 1:
                return GradientDrawable.Orientation.TOP_BOTTOM;
            case 2:
                return GradientDrawable.Orientation.TR_BL;
            case 3:
                return GradientDrawable.Orientation.RIGHT_LEFT;
            case 4:
                return GradientDrawable.Orientation.BR_TL;
            case 5:
                return GradientDrawable.Orientation.BOTTOM_TOP;
            case 6:
                return GradientDrawable.Orientation.BL_TR;
            case 7:
                return GradientDrawable.Orientation.LEFT_RIGHT;
            case 8:
                return GradientDrawable.Orientation.TL_BR;
            default:
                return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }
}
