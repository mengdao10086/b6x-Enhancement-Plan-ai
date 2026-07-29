package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.y0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ExpandedMenuView extends ListView implements e.b, k, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f1847c = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f1848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1849b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean a(h hVar) {
        return this.f1848a.O(hVar, 0);
    }

    @Override // androidx.appcompat.view.menu.k
    public void e(e eVar) {
        this.f1848a = eVar;
    }

    @Override // androidx.appcompat.view.menu.k
    public int getWindowAnimations() {
        return this.f1849b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        a((h) getAdapter().getItem(i10));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        y0 y0VarG = y0.G(context, attributeSet, f1847c, i10, 0);
        if (y0VarG.C(0)) {
            setBackgroundDrawable(y0VarG.h(0));
        }
        if (y0VarG.C(1)) {
            setDivider(y0VarG.h(1));
        }
        y0VarG.I();
    }
}
