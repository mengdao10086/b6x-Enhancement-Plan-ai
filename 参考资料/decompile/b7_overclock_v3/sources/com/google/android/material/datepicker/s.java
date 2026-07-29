package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.timepicker.TimeModel;
import g.n0;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class s extends RecyclerView.g<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialCalendar<?> f20162a;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20163a;

        public a(int i10) {
            this.f20163a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s.this.f20162a.Z5(s.this.f20162a.R5().s(Month.g(this.f20163a, s.this.f20162a.T5().f20082b)));
            s.this.f20162a.a6(MaterialCalendar.CalendarSelector.DAY);
        }
    }

    public static class b extends RecyclerView.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f20165a;

        public b(TextView textView) {
            super(textView);
            this.f20165a = textView;
        }
    }

    public s(MaterialCalendar<?> materialCalendar) {
        this.f20162a = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f20162a.R5().U();
    }

    @n0
    public final View.OnClickListener m(int i10) {
        return new a(i10);
    }

    public int n(int i10) {
        return i10 - this.f20162a.R5().T().f20083c;
    }

    public int o(int i10) {
        return this.f20162a.R5().T().f20083c + i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@n0 b bVar, int i10) {
        int iO = o(i10);
        String string = bVar.f20165a.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        bVar.f20165a.setText(String.format(Locale.getDefault(), TimeModel.f21107i, Integer.valueOf(iO)));
        bVar.f20165a.setContentDescription(String.format(string, Integer.valueOf(iO)));
        com.google.android.material.datepicker.b bVarS5 = this.f20162a.S5();
        Calendar calendarT = r.t();
        com.google.android.material.datepicker.a aVar = calendarT.get(1) == iO ? bVarS5.f20116f : bVarS5.f20114d;
        Iterator<Long> it2 = this.f20162a.G5().H().iterator();
        while (it2.hasNext()) {
            calendarT.setTimeInMillis(it2.next().longValue());
            if (calendarT.get(1) == iO) {
                aVar = bVarS5.f20115e;
            }
        }
        aVar.f(bVar.f20165a);
        bVar.f20165a.setOnClickListener(m(iO));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @n0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@n0 ViewGroup viewGroup, int i10) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
