package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import androidx.annotation.RestrictTo;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface t {
    @p0
    ColorStateList getSupportCheckMarkTintList();

    @p0
    PorterDuff.Mode getSupportCheckMarkTintMode();

    void setSupportCheckMarkTintList(@p0 ColorStateList colorStateList);

    void setSupportCheckMarkTintMode(@p0 PorterDuff.Mode mode);
}
