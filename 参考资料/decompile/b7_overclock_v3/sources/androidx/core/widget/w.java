package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import androidx.annotation.RestrictTo;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface w {
    @p0
    ColorStateList getSupportImageTintList();

    @p0
    PorterDuff.Mode getSupportImageTintMode();

    void setSupportImageTintList(@p0 ColorStateList colorStateList);

    void setSupportImageTintMode(@p0 PorterDuff.Mode mode);
}
