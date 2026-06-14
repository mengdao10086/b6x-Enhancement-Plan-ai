package com.omarea.ui;

import a.fj0;
import a.t61;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class Tags extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fj0 f8405a;

    public Tags(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(2131558693, (ViewGroup) this, true);
    }

    public fj0 b(String[] strArr, int i) {
        removeAllViews();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (String str : strArr) {
            CompoundButton compoundButton = (CompoundButton) layoutInflaterFrom.inflate(2131558692, (ViewGroup) this, false).findViewById(t61.tag);
            addView(compoundButton);
            compoundButton.setText(str);
            if (i2 == i) {
                compoundButton.setChecked(true);
            }
            arrayList.add(compoundButton);
            i2++;
        }
        fj0 fj0Var = new fj0((Iterator<? extends CompoundButton>) arrayList.iterator());
        this.f8405a = fj0Var;
        return fj0Var;
    }

    public int getCheckedIndex() {
        return this.f8405a.g();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        setAlpha(z ? 1.0f : 0.5f);
    }
}
