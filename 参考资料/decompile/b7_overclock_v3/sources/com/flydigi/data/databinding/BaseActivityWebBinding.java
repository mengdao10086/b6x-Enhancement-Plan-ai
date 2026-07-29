package com.flydigi.data.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.flydigi.data.R;
import g.n0;
import g.p0;
import j2.b;
import j2.c;

/* JADX INFO: loaded from: classes7.dex */
public final class BaseActivityWebBinding implements b {

    @n0
    public final ImageButton btnClose;

    @n0
    public final ImageButton btnShare;

    @n0
    public final FrameLayout flContainer;

    @n0
    private final LinearLayout rootView;

    @n0
    public final Toolbar toolbar;

    @n0
    public final TextView tvTitleToolbar;

    private BaseActivityWebBinding(@n0 LinearLayout rootView, @n0 ImageButton btnClose, @n0 ImageButton btnShare, @n0 FrameLayout flContainer, @n0 Toolbar toolbar, @n0 TextView tvTitleToolbar) {
        this.rootView = rootView;
        this.btnClose = btnClose;
        this.btnShare = btnShare;
        this.flContainer = flContainer;
        this.toolbar = toolbar;
        this.tvTitleToolbar = tvTitleToolbar;
    }

    @n0
    public static BaseActivityWebBinding bind(@n0 View rootView) {
        int i10 = R.id.btn_close;
        ImageButton imageButton = (ImageButton) c.a(rootView, i10);
        if (imageButton != null) {
            i10 = R.id.btn_share;
            ImageButton imageButton2 = (ImageButton) c.a(rootView, i10);
            if (imageButton2 != null) {
                i10 = R.id.fl_container;
                FrameLayout frameLayout = (FrameLayout) c.a(rootView, i10);
                if (frameLayout != null) {
                    i10 = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) c.a(rootView, i10);
                    if (toolbar != null) {
                        i10 = R.id.tv_title_toolbar;
                        TextView textView = (TextView) c.a(rootView, i10);
                        if (textView != null) {
                            return new BaseActivityWebBinding((LinearLayout) rootView, imageButton, imageButton2, frameLayout, toolbar, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i10)));
    }

    @n0
    public static BaseActivityWebBinding inflate(@n0 LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    @n0
    public static BaseActivityWebBinding inflate(@n0 LayoutInflater inflater, @p0 ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.base_activity_web, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // j2.b
    @n0
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
