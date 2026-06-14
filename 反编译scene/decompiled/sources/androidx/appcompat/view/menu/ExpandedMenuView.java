package androidx.appcompat.view.menu;

import a.i4;
import a.l4;
import a.o8;
import a.w4;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ExpandedMenuView extends ListView implements i4.b, w4, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f8141a = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f3997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i4 f3998a;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        o8 o8VarV = o8.v(context, attributeSet, f8141a, i, 0);
        if (o8VarV.s(0)) {
            setBackgroundDrawable(o8VarV.g(0));
        }
        if (o8VarV.s(1)) {
            setDivider(o8VarV.g(1));
        }
        o8VarV.w();
    }

    @Override // a.i4.b
    public boolean c(l4 l4Var) {
        return this.f3998a.L(l4Var, 0);
    }

    @Override // a.w4
    public void d(i4 i4Var) {
        this.f3998a = i4Var;
    }

    public int getWindowAnimations() {
        return this.f3997a;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        c((l4) getAdapter().getItem(i));
    }
}
