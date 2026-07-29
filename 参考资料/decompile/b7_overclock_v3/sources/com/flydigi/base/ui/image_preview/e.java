package com.flydigi.base.ui.image_preview;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final boolean b(Context context) {
        return Build.VERSION.SDK_INT >= 29 || h0.d.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
