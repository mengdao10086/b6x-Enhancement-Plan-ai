package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import g.p0;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class l extends BaseAdapter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f20140f = r.v().getMaximum(4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f20141g = (r.v().getMaximum(5) + r.v().getMaximum(7)) - 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Month f20142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateSelector<?> f20143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Collection<Long> f20144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f20145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CalendarConstraints f20146e;

    public l(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f20142a = month;
        this.f20143b = dateSelector;
        this.f20146e = calendarConstraints;
        this.f20144c = dateSelector.H();
    }

    public int a(int i10) {
        return b() + (i10 - 1);
    }

    public int b() {
        return this.f20142a.F(this.f20146e.F());
    }

    @Override // android.widget.Adapter
    @p0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i10) {
        if (i10 < b() || i10 > i()) {
            return null;
        }
        return Long.valueOf(this.f20142a.M(j(i10)));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
    @Override // android.widget.Adapter
    @g.n0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.TextView getView(int r6, @g.p0 android.view.View r7, @g.n0 android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.e(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L75
            com.google.android.material.datepicker.Month r8 = r5.f20142a
            int r2 = r8.f20085e
            if (r7 < r2) goto L2d
            goto L75
        L2d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            com.google.android.material.datepicker.Month r8 = r5.f20142a
            long r7 = r8.M(r7)
            com.google.android.material.datepicker.Month r3 = r5.f20142a
            int r3 = r3.f20083c
            com.google.android.material.datepicker.Month r4 = com.google.android.material.datepicker.Month.s()
            int r4 = r4.f20083c
            if (r3 != r4) goto L67
            java.lang.String r7 = com.google.android.material.datepicker.h.g(r7)
            r0.setContentDescription(r7)
            goto L6e
        L67:
            java.lang.String r7 = com.google.android.material.datepicker.h.l(r7)
            r0.setContentDescription(r7)
        L6e:
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L7d
        L75:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L7d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L84
            return r0
        L84:
            long r6 = r6.longValue()
            r5.k(r0, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.l.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    public final void e(Context context) {
        if (this.f20145d == null) {
            this.f20145d = new b(context);
        }
    }

    public boolean f(int i10) {
        return i10 % this.f20142a.f20084d == 0;
    }

    public boolean g(int i10) {
        return (i10 + 1) % this.f20142a.f20084d == 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return f20141g;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10 / this.f20142a.f20084d;
    }

    public final boolean h(long j10) {
        Iterator<Long> it2 = this.f20143b.H().iterator();
        while (it2.hasNext()) {
            if (r.a(j10) == r.a(it2.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public int i() {
        return (b() + this.f20142a.f20085e) - 1;
    }

    public int j(int i10) {
        return (i10 - b()) + 1;
    }

    public final void k(@p0 TextView textView, long j10) {
        a aVar;
        if (textView == null) {
            return;
        }
        if (this.f20146e.z().D(j10)) {
            textView.setEnabled(true);
            aVar = h(j10) ? this.f20145d.f20112b : r.t().getTimeInMillis() == j10 ? this.f20145d.f20113c : this.f20145d.f20111a;
        } else {
            textView.setEnabled(false);
            aVar = this.f20145d.f20117g;
        }
        aVar.f(textView);
    }

    public final void l(MaterialCalendarGridView materialCalendarGridView, long j10) {
        if (Month.j(j10).equals(this.f20142a)) {
            k((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(this.f20142a.S(j10)) - materialCalendarGridView.getFirstVisiblePosition()), j10);
        }
    }

    public void m(MaterialCalendarGridView materialCalendarGridView) {
        Iterator<Long> it2 = this.f20144c.iterator();
        while (it2.hasNext()) {
            l(materialCalendarGridView, it2.next().longValue());
        }
        DateSelector<?> dateSelector = this.f20143b;
        if (dateSelector != null) {
            Iterator<Long> it3 = dateSelector.H().iterator();
            while (it3.hasNext()) {
                l(materialCalendarGridView, it3.next().longValue());
            }
            this.f20144c = this.f20143b.H();
        }
    }

    public boolean n(int i10) {
        return i10 >= b() && i10 <= i();
    }
}
