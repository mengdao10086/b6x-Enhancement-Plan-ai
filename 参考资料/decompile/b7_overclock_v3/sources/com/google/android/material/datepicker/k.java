package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import g.d1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.TESTS})
public class k extends DatePickerDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.f
    public static final int f20136c = 16843612;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @d1
    public static final int f20137d = R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final Drawable f20138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Rect f20139b;

    public k(@n0 Context context) {
        this(context, 0);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(this.f20138a);
        getWindow().getDecorView().setOnTouchListener(new wd.a(this, this.f20139b));
    }

    public k(@n0 Context context, int i10) {
        this(context, i10, null, -1, -1, -1);
    }

    public k(@n0 Context context, @p0 DatePickerDialog.OnDateSetListener onDateSetListener, int i10, int i11, int i12) {
        this(context, 0, onDateSetListener, i10, i11, i12);
    }

    public k(@n0 Context context, int i10, @p0 DatePickerDialog.OnDateSetListener onDateSetListener, int i11, int i12, int i13) {
        super(context, i10, onDateSetListener, i11, i12, i13);
        Context context2 = getContext();
        int iG = ie.b.g(getContext(), R.attr.colorSurface, getClass().getCanonicalName());
        int i14 = f20137d;
        le.j jVar = new le.j(context2, null, 16843612, i14);
        jVar.o0(ColorStateList.valueOf(iG));
        Rect rectA = wd.c.a(context2, 16843612, i14);
        this.f20139b = rectA;
        this.f20138a = wd.c.b(jVar, rectA);
    }
}
