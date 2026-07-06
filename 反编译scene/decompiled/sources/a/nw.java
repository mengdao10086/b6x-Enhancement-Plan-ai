package a;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class nw<S> extends wk {
    public static boolean C1(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(my.c(context, zu.materialCalendarStyle, mw.class.getCanonicalName()), new int[]{R.attr.windowFullscreen});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }
}
