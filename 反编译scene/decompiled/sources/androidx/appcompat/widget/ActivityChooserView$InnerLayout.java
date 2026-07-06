package androidx.appcompat.widget;

import a.o8;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ActivityChooserView$InnerLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f8153a = {R.attr.background};

    public ActivityChooserView$InnerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        o8 o8VarU = o8.u(context, attributeSet, f8153a);
        setBackgroundDrawable(o8VarU.g(0));
        o8VarU.w();
    }
}
