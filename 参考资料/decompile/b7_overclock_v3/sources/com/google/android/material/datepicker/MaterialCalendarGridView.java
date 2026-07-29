package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.internal.b0;
import g.n0;
import g.p0;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f20038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f20039b;

    public class a extends androidx.core.view.a {
        public a() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @n0 a1.d dVar) {
            super.g(view, dVar);
            dVar.d1(null);
        }
    }

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    public static int d(@n0 View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    public static boolean e(@p0 Long l10, @p0 Long l11, @p0 Long l12, @p0 Long l13) {
        return l10 == null || l11 == null || l12 == null || l13 == null || l12.longValue() > l11.longValue() || l13.longValue() < l10.longValue();
    }

    public final void a(int i10, Rect rect) {
        if (i10 == 33) {
            setSelection(getAdapter().i());
        } else if (i10 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i10, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public l getAdapter() {
        return (l) super.getAdapter();
    }

    public final View c(int i10) {
        return getChildAt(i10 - getFirstVisiblePosition());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(@n0 Canvas canvas) {
        int iA;
        int iD;
        int iA2;
        int iD2;
        int i10;
        int width;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        l adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.f20143b;
        b bVar = adapter.f20145d;
        int iMax = Math.max(adapter.b(), getFirstVisiblePosition());
        int iMin = Math.min(adapter.i(), getLastVisiblePosition());
        Long item = adapter.getItem(iMax);
        Long item2 = adapter.getItem(iMin);
        Iterator<androidx.core.util.k<Long, Long>> it2 = dateSelector.h().iterator();
        while (it2.hasNext()) {
            androidx.core.util.k<Long, Long> next = it2.next();
            Long l10 = next.f4741a;
            if (l10 == null) {
                materialCalendarGridView = this;
            } else if (next.f4742b != null) {
                long jLongValue = l10.longValue();
                long jLongValue2 = next.f4742b.longValue();
                if (!e(item, item2, Long.valueOf(jLongValue), Long.valueOf(jLongValue2))) {
                    boolean zL = b0.l(this);
                    if (jLongValue < item.longValue()) {
                        iD = adapter.f(iMax) ? 0 : !zL ? materialCalendarGridView.c(iMax - 1).getRight() : materialCalendarGridView.c(iMax - 1).getLeft();
                        iA = iMax;
                    } else {
                        materialCalendarGridView.f20038a.setTimeInMillis(jLongValue);
                        iA = adapter.a(materialCalendarGridView.f20038a.get(5));
                        iD = d(materialCalendarGridView.c(iA));
                    }
                    if (jLongValue2 > item2.longValue()) {
                        iD2 = adapter.g(iMin) ? getWidth() : !zL ? materialCalendarGridView.c(iMin).getRight() : materialCalendarGridView.c(iMin).getLeft();
                        iA2 = iMin;
                    } else {
                        materialCalendarGridView.f20038a.setTimeInMillis(jLongValue2);
                        iA2 = adapter.a(materialCalendarGridView.f20038a.get(5));
                        iD2 = d(materialCalendarGridView.c(iA2));
                    }
                    int itemId = (int) adapter.getItemId(iA);
                    int i11 = iMax;
                    int i12 = iMin;
                    int itemId2 = (int) adapter.getItemId(iA2);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        l lVar = adapter;
                        int numColumns2 = (numColumns + getNumColumns()) - 1;
                        View viewC = materialCalendarGridView.c(numColumns);
                        int top2 = viewC.getTop() + bVar.f20111a.e();
                        Iterator<androidx.core.util.k<Long, Long>> it3 = it2;
                        int bottom = viewC.getBottom() - bVar.f20111a.b();
                        if (zL) {
                            int i13 = iA2 > numColumns2 ? 0 : iD2;
                            int width2 = numColumns > iA ? getWidth() : iD;
                            i10 = i13;
                            width = width2;
                        } else {
                            i10 = numColumns > iA ? 0 : iD;
                            width = iA2 > numColumns2 ? getWidth() : iD2;
                        }
                        canvas.drawRect(i10, top2, width, bottom, bVar.f20118h);
                        itemId++;
                        materialCalendarGridView = this;
                        itemId2 = itemId2;
                        adapter = lVar;
                        it2 = it3;
                    }
                    materialCalendarGridView = this;
                    iMax = i11;
                    iMin = i12;
                }
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        if (z10) {
            a(i10, rect);
        } else {
            super.onFocusChanged(false, i10, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (!super.onKeyDown(i10, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i10) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        if (!this.f20039b) {
            super.onMeasure(i10, i11);
            return;
        }
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i10) {
        if (i10 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i10);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof l)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), l.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f20038a = r.v();
        if (MaterialDatePicker.z6(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.f20039b = MaterialDatePicker.A6(getContext());
        u0.B1(this, new a());
    }
}
