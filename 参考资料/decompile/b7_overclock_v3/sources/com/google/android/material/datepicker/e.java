package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import g.n0;
import g.p0;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import kotlin.text.y;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends com.google.android.material.internal.s {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f20123g = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final TextInputLayout f20124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateFormat f20125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CalendarConstraints f20126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f20127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f20128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f20129f;

    public e(final String str, DateFormat dateFormat, @n0 TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f20125b = dateFormat;
        this.f20124a = textInputLayout;
        this.f20126c = calendarConstraints;
        this.f20127d = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.f20128e = new Runnable() { // from class: com.google.android.material.datepicker.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f20121a.e(str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(long j10) {
        this.f20124a.setError(String.format(this.f20127d, i(h.c(j10))));
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String str) {
        TextInputLayout textInputLayout = this.f20124a;
        DateFormat dateFormat = this.f20125b;
        Context context = textInputLayout.getContext();
        textInputLayout.setError(context.getString(R.string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_use), i(str)) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_example), i(dateFormat.format(new Date(r.t().getTimeInMillis())))));
        f();
    }

    public final Runnable c(final long j10) {
        return new Runnable() { // from class: com.google.android.material.datepicker.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f20119a.d(j10);
            }
        };
    }

    public void f() {
    }

    public abstract void g(@p0 Long l10);

    public void h(View view, Runnable runnable) {
        view.postDelayed(runnable, 1000L);
    }

    public final String i(String str) {
        return str.replace(zc.f.f58383m, y.f38193g);
    }

    @Override // com.google.android.material.internal.s, android.text.TextWatcher
    public void onTextChanged(@n0 CharSequence charSequence, int i10, int i11, int i12) {
        this.f20124a.removeCallbacks(this.f20128e);
        this.f20124a.removeCallbacks(this.f20129f);
        this.f20124a.setError(null);
        g(null);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            Date date = this.f20125b.parse(charSequence.toString());
            this.f20124a.setError(null);
            long time = date.getTime();
            if (this.f20126c.z().D(time) && this.f20126c.V(time)) {
                g(Long.valueOf(date.getTime()));
                return;
            }
            Runnable runnableC = c(time);
            this.f20129f = runnableC;
            h(this.f20124a, runnableC);
        } catch (ParseException unused) {
            h(this.f20124a, this.f20128e);
        }
    }
}
