package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.u0;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public class m extends RecyclerView.g<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final CalendarConstraints f20147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateSelector<?> f20148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MaterialCalendar.k f20149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20150d;

    public class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarGridView f20151a;

        public a(MaterialCalendarGridView materialCalendarGridView) {
            this.f20151a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (this.f20151a.getAdapter().n(i10)) {
                m.this.f20149c.a(this.f20151a.getAdapter().getItem(i10).longValue());
            }
        }
    }

    public static class b extends RecyclerView.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f20153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MaterialCalendarGridView f20154b;

        public b(@n0 LinearLayout linearLayout, boolean z10) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.f20153a = textView;
            u0.C1(textView, true);
            this.f20154b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (z10) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    public m(@n0 Context context, DateSelector<?> dateSelector, @n0 CalendarConstraints calendarConstraints, MaterialCalendar.k kVar) {
        Month monthT = calendarConstraints.T();
        Month monthC = calendarConstraints.C();
        Month monthS = calendarConstraints.S();
        if (monthT.compareTo(monthS) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (monthS.compareTo(monthC) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f20150d = (l.f20140f * MaterialCalendar.U5(context)) + (MaterialDatePicker.z6(context) ? MaterialCalendar.U5(context) : 0);
        this.f20147a = calendarConstraints;
        this.f20148b = dateSelector;
        this.f20149c = kVar;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f20147a.M();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i10) {
        return this.f20147a.T().V(i10).U();
    }

    @n0
    public Month m(int i10) {
        return this.f20147a.T().V(i10);
    }

    @n0
    public CharSequence n(int i10) {
        return m(i10).T();
    }

    public int o(@n0 Month month) {
        return this.f20147a.T().W(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@n0 b bVar, int i10) {
        Month monthV = this.f20147a.T().V(i10);
        bVar.f20153a.setText(monthV.T());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f20154b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthV.equals(materialCalendarGridView.getAdapter().f20142a)) {
            l lVar = new l(monthV, this.f20148b, this.f20147a);
            materialCalendarGridView.setNumColumns(monthV.f20084d);
            materialCalendarGridView.setAdapter((ListAdapter) lVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().m(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @n0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@n0 ViewGroup viewGroup, int i10) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.z6(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.p(-1, this.f20150d));
        return new b(linearLayout, true);
    }
}
