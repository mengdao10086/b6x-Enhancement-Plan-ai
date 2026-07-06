package com.google.android.material.datepicker;

import a.dv;
import a.eh;
import a.kw;
import a.lf;
import a.lw;
import a.ni;
import a.nw;
import a.ow;
import a.qw;
import a.rf;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.Calendar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f8304a;

    public class a extends rf {
        public a(MaterialCalendarGridView materialCalendarGridView) {
        }

        @Override // a.rf
        public void g(View view, ni niVar) {
            super.g(view, niVar);
            niVar.c0(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8304a = qw.b();
        if (nw.C1(getContext())) {
            setNextFocusLeftId(dv.cancel_button);
            setNextFocusRightId(dv.confirm_button);
        }
        eh.k0(this, new a(this));
    }

    public static int c(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    public static boolean d(Long l, Long l2, Long l3, Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    public final void a(int i, Rect rect) {
        int iB;
        if (i == 33) {
            iB = getAdapter().f();
        } else {
            if (i != 130) {
                super.onFocusChanged(true, i, rect);
                return;
            }
            iB = getAdapter().b();
        }
        setSelection(iB);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ow getAdapter() {
        return (ow) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int iA;
        int iC;
        int iA2;
        int iC2;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        ow adapter = getAdapter();
        lw<?> lwVar = adapter.f2310a;
        kw kwVar = adapter.f7060a;
        Long lC = adapter.c(adapter.b());
        Long lC2 = adapter.c(adapter.f());
        for (lf<Long, Long> lfVar : lwVar.o()) {
            Long l = lfVar.f6700a;
            if (l != null) {
                if (lfVar.b == null) {
                    continue;
                } else {
                    long jLongValue = l.longValue();
                    long jLongValue2 = lfVar.b.longValue();
                    if (d(lC, lC2, Long.valueOf(jLongValue), Long.valueOf(jLongValue2))) {
                        return;
                    }
                    if (jLongValue < lC.longValue()) {
                        iA = adapter.b();
                        iC = adapter.d(iA) ? 0 : materialCalendarGridView.getChildAt(iA - 1).getRight();
                    } else {
                        materialCalendarGridView.f8304a.setTimeInMillis(jLongValue);
                        iA = adapter.a(materialCalendarGridView.f8304a.get(5));
                        iC = c(materialCalendarGridView.getChildAt(iA));
                    }
                    if (jLongValue2 > lC2.longValue()) {
                        iA2 = Math.min(adapter.f(), getChildCount() - 1);
                        iC2 = adapter.e(iA2) ? getWidth() : materialCalendarGridView.getChildAt(iA2).getRight();
                    } else {
                        materialCalendarGridView.f8304a.setTimeInMillis(jLongValue2);
                        iA2 = adapter.a(materialCalendarGridView.f8304a.get(5));
                        iC2 = c(materialCalendarGridView.getChildAt(iA2));
                    }
                    int itemId = (int) adapter.getItemId(iA);
                    int itemId2 = (int) adapter.getItemId(iA2);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (getNumColumns() + numColumns) - 1;
                        View childAt = materialCalendarGridView.getChildAt(numColumns);
                        canvas.drawRect(numColumns > iA ? 0 : iC, childAt.getTop() + kwVar.f6647a.b(), iA2 > numColumns2 ? getWidth() : iC2, childAt.getBottom() - kwVar.f6647a.a(), kwVar.f1692a);
                        itemId++;
                        materialCalendarGridView = this;
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            a(i, rect);
        } else {
            super.onFocusChanged(false, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter adapter) {
        setAdapter((ListAdapter) adapter);
        throw null;
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter listAdapter) {
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), ow.class.getCanonicalName()));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        if (i < getAdapter().b()) {
            i = getAdapter().b();
        }
        super.setSelection(i);
    }
}
