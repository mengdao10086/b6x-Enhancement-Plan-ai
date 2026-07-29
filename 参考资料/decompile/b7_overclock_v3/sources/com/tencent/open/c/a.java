package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes5.dex */
public class a extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f22726a = a.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f22727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f22728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC0250a f22729d;

    /* JADX INFO: renamed from: com.tencent.open.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0250a {
        void a();

        void a(int i10);
    }

    public a(Context context) {
        super(context);
        this.f22727b = null;
        this.f22728c = false;
        this.f22729d = null;
        this.f22727b = new Rect();
    }

    public void a(InterfaceC0250a interfaceC0250a) {
        this.f22729d = interfaceC0250a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i11);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f22727b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f22727b.top) - size;
        InterfaceC0250a interfaceC0250a = this.f22729d;
        if (interfaceC0250a != null && size != 0) {
            if (height > 100) {
                interfaceC0250a.a((Math.abs(this.f22727b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0250a.a();
            }
        }
        super.onMeasure(i10, i11);
    }
}
