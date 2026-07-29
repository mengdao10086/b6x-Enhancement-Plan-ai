package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R;
import g.n0;
import g.p0;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class i extends BaseAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f20131d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f20132e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final Calendar f20133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20135c;

    static {
        f20132e = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public i() {
        Calendar calendarV = r.v();
        this.f20133a = calendarV;
        this.f20134b = calendarV.getMaximum(7);
        this.f20135c = calendarV.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    @p0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i10) {
        if (i10 >= this.f20134b) {
            return null;
        }
        return Integer.valueOf(b(i10));
    }

    public final int b(int i10) {
        int i11 = i10 + this.f20135c;
        int i12 = this.f20134b;
        return i11 > i12 ? i11 - i12 : i11;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f20134b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @p0
    @SuppressLint({"WrongConstant"})
    public View getView(int i10, @p0 View view, @n0 ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f20133a.set(7, b(i10));
        textView.setText(this.f20133a.getDisplayName(7, f20132e, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), this.f20133a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public i(int i10) {
        Calendar calendarV = r.v();
        this.f20133a = calendarV;
        this.f20134b = calendarV.getMaximum(7);
        this.f20135c = i10;
    }
}
