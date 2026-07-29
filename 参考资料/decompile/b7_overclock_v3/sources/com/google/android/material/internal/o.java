package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b> f20477a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public b f20478b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public ValueAnimator f20479c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Animator.AnimatorListener f20480d = new a();

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            o oVar = o.this;
            if (oVar.f20479c == animator) {
                oVar.f20479c = null;
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f20482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ValueAnimator f20483b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.f20482a = iArr;
            this.f20483b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f20480d);
        this.f20477a.add(bVar);
    }

    public final void b() {
        ValueAnimator valueAnimator = this.f20479c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f20479c = null;
        }
    }

    public void c() {
        ValueAnimator valueAnimator = this.f20479c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f20479c = null;
        }
    }

    public void d(int[] iArr) {
        b bVar;
        int size = this.f20477a.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                bVar = null;
                break;
            }
            bVar = this.f20477a.get(i10);
            if (StateSet.stateSetMatches(bVar.f20482a, iArr)) {
                break;
            } else {
                i10++;
            }
        }
        b bVar2 = this.f20478b;
        if (bVar == bVar2) {
            return;
        }
        if (bVar2 != null) {
            b();
        }
        this.f20478b = bVar;
        if (bVar != null) {
            e(bVar);
        }
    }

    public final void e(@n0 b bVar) {
        ValueAnimator valueAnimator = bVar.f20483b;
        this.f20479c = valueAnimator;
        valueAnimator.start();
    }
}
