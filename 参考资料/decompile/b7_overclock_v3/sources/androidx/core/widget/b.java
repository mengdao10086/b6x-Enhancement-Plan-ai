package androidx.core.widget;

import android.os.Build;
import androidx.annotation.RestrictTo;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface b {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static final boolean O;

    static {
        O = Build.VERSION.SDK_INT >= 27;
    }

    int getAutoSizeMaxTextSize();

    int getAutoSizeMinTextSize();

    int getAutoSizeStepGranularity();

    int[] getAutoSizeTextAvailableSizes();

    int getAutoSizeTextType();

    void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) throws IllegalArgumentException;

    void setAutoSizeTextTypeUniformWithPresetSizes(@n0 int[] iArr, int i10) throws IllegalArgumentException;

    void setAutoSizeTextTypeWithDefaults(int i10);
}
