package com.omarea.ui;

import a.bc2;
import a.e31;
import a.f31;
import a.f92;
import a.hz0;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class HelpIcon extends RelativeLayout {
    public HelpIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        View viewInflate = View.inflate(context, 2131558604, this);
        if (viewInflate == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        if (!Scene.f4798a.g().getBoolean(hz0.f1282a.Q(), true)) {
            viewInflate.setVisibility(8);
        }
        if (attributeSet != null) {
            int attributeCount = attributeSet.getAttributeCount();
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                if (f92.a(attributeName, "text")) {
                    String attributeValue = attributeSet.getAttributeValue(i);
                    f92.c(attributeValue, "attrValue");
                    if (bc2.x(attributeValue, "@", false, 2, null)) {
                        f92.b(context);
                        attributeValue = context.getString(Integer.parseInt(bc2.t(attributeValue, "@", "", false, 4, null)));
                    }
                    ((ImageButton) viewInflate.findViewById(R.id.button1)).setOnClickListener(new e31(attributeValue, context, viewInflate));
                } else if (f92.a(attributeName, "layout_res")) {
                    ((ImageButton) viewInflate.findViewById(R.id.button1)).setOnClickListener(new f31(attributeSet.getAttributeValue(i), context, viewInflate));
                }
            }
        }
    }
}
