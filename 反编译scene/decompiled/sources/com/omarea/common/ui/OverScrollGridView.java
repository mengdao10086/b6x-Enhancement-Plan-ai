package com.omarea.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class OverScrollGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8356a;

    public OverScrollGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8356a = 400;
    }

    @Override // android.view.View
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, this.f8356a, z);
    }

    public void setMaxOverScrollY(int i) {
        this.f8356a = i;
    }
}
