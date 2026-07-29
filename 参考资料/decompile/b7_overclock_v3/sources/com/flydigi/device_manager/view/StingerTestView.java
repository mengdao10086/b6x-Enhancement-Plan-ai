package com.flydigi.device_manager.view;

import aj.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.view.StingerTestView;
import com.umeng.analytics.pro.an;
import dj.g;
import dj.o;
import g.n0;
import g.p0;
import io.reactivex.disposables.b;
import java.util.concurrent.TimeUnit;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
public class StingerTestView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f15511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f15512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f15513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f15514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f15515e;

    public StingerTestView(@n0 Context context) {
        this(context, null);
    }

    public static /* synthetic */ Long e(Long l10) throws Exception {
        return Long.valueOf(l10.longValue() + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Long l10) throws Exception {
        TextView textView = this.f15514d;
        if (textView != null) {
            textView.setText(l10 + an.aB);
        }
    }

    public static /* synthetic */ void g(Throwable th2) throws Exception {
    }

    public final void d() {
        this.f15513c = (TextView) findViewById(R.id.tv_freq);
        this.f15514d = (TextView) findViewById(R.id.tv_time);
    }

    public void h() {
        this.f15511a = 0L;
        this.f15512b = 0L;
        setPressed(false);
        this.f15514d.setText("0s");
        this.f15513c.setText("0/0s");
        b bVar = this.f15515e;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    public final void i() {
        this.f15515e = z.g3(1L, TimeUnit.SECONDS).A3(new o() { // from class: t7.m
            @Override // dj.o
            public final Object apply(Object obj) {
                return StingerTestView.e((Long) obj);
            }
        }).J5(lj.b.a()).b4(a.c()).F5(new g() { // from class: t7.k
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f50917a.f((Long) obj);
            }
        }, new g() { // from class: t7.l
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                StingerTestView.g((Throwable) obj);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f15515e;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            setPressed(true);
            if (this.f15511a == 0) {
                this.f15511a = System.currentTimeMillis();
                i();
                return true;
            }
            if (this.f15512b >= Long.MAX_VALUE) {
                this.f15512b = 0L;
            }
            this.f15512b++;
            TextView textView = this.f15513c;
            textView.setText(this.f15512b + fh.a.f28350w + ((System.currentTimeMillis() - this.f15511a) / 1000.0f) + an.aB);
        } else if (actionMasked == 1 || actionMasked == 3) {
            setPressed(false);
        }
        return true;
    }

    public StingerTestView(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StingerTestView(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(R.layout.device_view_stinger_test, (ViewGroup) this, true);
        d();
    }
}
