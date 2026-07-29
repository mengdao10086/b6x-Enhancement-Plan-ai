package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import g.c1;
import g.d1;
import g.n0;
import g.p0;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface DateSelector<S> extends Parcelable {
    @d1
    int B(Context context);

    boolean G();

    @n0
    Collection<Long> H();

    @p0
    S J();

    void P(long j10);

    @n0
    String d(Context context);

    @n0
    Collection<androidx.core.util.k<Long, Long>> h();

    void i(@n0 S s10);

    @n0
    View v(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle, @n0 CalendarConstraints calendarConstraints, @n0 n<S> nVar);

    @c1
    int w();
}
