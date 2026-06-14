package com.omarea.ui;

import a.v61;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class NavItem extends RelativeLayout {
    public NavItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v61.NavItem);
        LayoutInflater.from(context).inflate(attributeSet != null ? typedArrayObtainStyledAttributes.getResourceId(1, 2131558671) : 2131558671, (ViewGroup) this, true);
        if (attributeSet != null) {
            String str = "" + ((Object) typedArrayObtainStyledAttributes.getText(2));
            ((ImageView) findViewById(R.id.icon)).setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(0));
            ((TextView) findViewById(R.id.title)).setText(str);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public CharSequence getText() {
        return ((TextView) findViewById(R.id.title)).getText();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        ImageView imageView = (ImageView) findViewById(R.id.icon);
        TextView textView = (TextView) findViewById(R.id.title);
        imageView.setAlpha(z ? 1.0f : 0.5f);
        textView.setAlpha(z ? 1.0f : 0.5f);
    }

    public void setText(String str) {
        ((TextView) findViewById(R.id.title)).setText(str);
    }
}
