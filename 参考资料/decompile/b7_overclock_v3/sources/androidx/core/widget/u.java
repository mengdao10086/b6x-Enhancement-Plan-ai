package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public interface u {
    @p0
    ColorStateList getSupportButtonTintList();

    @p0
    PorterDuff.Mode getSupportButtonTintMode();

    void setSupportButtonTintList(@p0 ColorStateList colorStateList);

    void setSupportButtonTintMode(@p0 PorterDuff.Mode mode);
}
