package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import cd.i0;
import cd.j0;
import com.google.android.exoplayer2.ui.SubtitleView;
import g.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import qc.b;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends View implements SubtitleView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i0> f18691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<qc.b> f18692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f18694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public qc.a f18695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f18696f;

    public a(Context context) {
        this(context, null);
    }

    public static qc.b b(qc.b bVar) {
        b.c cVarA = bVar.a().v(-3.4028235E38f).w(Integer.MIN_VALUE).A(null);
        if (bVar.f47236e == 0) {
            cVarA.t(1.0f - bVar.f47235d, 0);
        } else {
            cVarA.t((-bVar.f47235d) - 1.0f, 1);
        }
        int i10 = bVar.f47237f;
        if (i10 == 0) {
            cVarA.u(2);
        } else if (i10 == 2) {
            cVarA.u(0);
        }
        return cVarA.a();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<qc.b> list, qc.a aVar, float f10, int i10, float f11) {
        this.f18692b = list;
        this.f18695e = aVar;
        this.f18694d = f10;
        this.f18693c = i10;
        this.f18696f = f11;
        while (this.f18691a.size() < list.size()) {
            this.f18691a.add(new i0(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<qc.b> list = this.f18692b;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i10 = paddingBottom - paddingTop;
        float fA = j0.a(this.f18693c, this.f18694d, height, i10);
        if (fA <= 0.0f) {
            return;
        }
        int size = list.size();
        int i11 = 0;
        while (i11 < size) {
            qc.b bVarB = list.get(i11);
            if (bVarB.f47246o != Integer.MIN_VALUE) {
                bVarB = b(bVarB);
            }
            qc.b bVar = bVarB;
            int i12 = paddingBottom;
            this.f18691a.get(i11).b(bVar, this.f18695e, fA, j0.a(bVar.f47244m, bVar.f47245n, height, i10), this.f18696f, canvas, paddingLeft, paddingTop, width, i12);
            i11++;
            size = size;
            i10 = i10;
            paddingBottom = i12;
            width = width;
        }
    }

    public a(Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18691a = new ArrayList();
        this.f18692b = Collections.emptyList();
        this.f18693c = 0;
        this.f18694d = 0.0533f;
        this.f18695e = qc.a.f47215m;
        this.f18696f = 0.08f;
    }
}
