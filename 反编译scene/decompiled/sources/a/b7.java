package a;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class b7 extends ToggleButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v6 f5678a;

    public b7(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    public b7(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k8.a(this, getContext());
        v6 v6Var = new v6(this);
        this.f5678a = v6Var;
        v6Var.m(attributeSet, i);
    }
}
