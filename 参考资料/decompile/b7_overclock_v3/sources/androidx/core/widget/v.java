package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public interface v {
    @p0
    ColorStateList getSupportCompoundDrawablesTintList();

    @p0
    PorterDuff.Mode getSupportCompoundDrawablesTintMode();

    void setSupportCompoundDrawablesTintList(@p0 ColorStateList colorStateList);

    void setSupportCompoundDrawablesTintMode(@p0 PorterDuff.Mode mode);
}
