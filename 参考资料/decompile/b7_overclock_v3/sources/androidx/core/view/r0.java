package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

/* JADX INFO: loaded from: classes2.dex */
public interface r0 {
    @g.p0
    ColorStateList getSupportBackgroundTintList();

    @g.p0
    PorterDuff.Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(@g.p0 ColorStateList colorStateList);

    void setSupportBackgroundTintMode(@g.p0 PorterDuff.Mode mode);
}
