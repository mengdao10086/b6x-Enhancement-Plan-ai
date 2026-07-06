package com.google.android.material.theme;

import a.a2;
import a.d6;
import a.gw;
import a.j20;
import a.jy;
import a.o5;
import a.q5;
import a.r5;
import a.w6;
import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class MaterialComponentsViewInflater extends a2 {
    @Override // a.a2
    public o5 b(Context context, AttributeSet attributeSet) {
        return new j20(context, attributeSet);
    }

    @Override // a.a2
    public q5 c(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // a.a2
    public r5 d(Context context, AttributeSet attributeSet) {
        return new gw(context, attributeSet);
    }

    @Override // a.a2
    public d6 j(Context context, AttributeSet attributeSet) {
        return new jy(context, attributeSet);
    }

    @Override // a.a2
    public w6 n(Context context, AttributeSet attributeSet) {
        return new MaterialTextView(context, attributeSet);
    }
}
