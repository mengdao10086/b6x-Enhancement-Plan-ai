package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import g.d1;
import g.n0;
import g.p0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialTextInputPicker<S> extends o<S> {

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public static final String f20074g8 = "THEME_RES_ID_KEY";

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public static final String f20075h8 = "DATE_SELECTOR_KEY";

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public static final String f20076i8 = "CALENDAR_CONSTRAINTS_KEY";

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    @d1
    public int f20077d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    @p0
    public DateSelector<S> f20078e8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    @p0
    public CalendarConstraints f20079f8;

    public class a extends n<S> {
        public a() {
        }

        @Override // com.google.android.material.datepicker.n
        public void a() {
            Iterator<n<S>> it2 = MaterialTextInputPicker.this.f20155c8.iterator();
            while (it2.hasNext()) {
                it2.next().a();
            }
        }

        @Override // com.google.android.material.datepicker.n
        public void b(S s10) {
            Iterator<n<S>> it2 = MaterialTextInputPicker.this.f20155c8.iterator();
            while (it2.hasNext()) {
                it2.next().b(s10);
            }
        }
    }

    @n0
    public static <T> MaterialTextInputPicker<T> I5(DateSelector<T> dateSelector, @d1 int i10, @n0 CalendarConstraints calendarConstraints) {
        MaterialTextInputPicker<T> materialTextInputPicker = new MaterialTextInputPicker<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        materialTextInputPicker.c5(bundle);
        return materialTextInputPicker;
    }

    @Override // com.google.android.material.datepicker.o
    @n0
    public DateSelector<S> G5() {
        DateSelector<S> dateSelector = this.f20078e8;
        if (dateSelector != null) {
            return dateSelector;
        }
        throw new IllegalStateException("dateSelector should not be null. Use MaterialTextInputPicker#newInstance() to create this fragment with a DateSelector, and call this method after the fragment has been created.");
    }

    @Override // androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        if (bundle == null) {
            bundle = T1();
        }
        this.f20077d8 = bundle.getInt("THEME_RES_ID_KEY");
        this.f20078e8 = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f20079f8 = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @n0
    public View O3(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        return this.f20078e8.v(layoutInflater.cloneInContext(new ContextThemeWrapper(X1(), this.f20077d8)), viewGroup, bundle, this.f20079f8, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void g4(@n0 Bundle bundle) {
        super.g4(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f20077d8);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f20078e8);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f20079f8);
    }
}
