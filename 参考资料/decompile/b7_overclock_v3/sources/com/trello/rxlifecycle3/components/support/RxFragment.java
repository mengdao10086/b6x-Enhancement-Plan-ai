package com.trello.rxlifecycle3.components.support;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.trello.rxlifecycle3.android.FragmentEvent;
import g.i0;
import g.j;
import g.n0;
import g.o;
import g.p0;
import io.reactivex.subjects.a;
import xi.z;
import zg.b;
import zg.c;
import zg.d;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RxFragment extends Fragment implements b<FragmentEvent> {

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public final a<FragmentEvent> f22908c8;

    public RxFragment() {
        this.f22908c8 = a.o8();
    }

    @Override // zg.b
    @j
    @n0
    /* JADX INFO: renamed from: E5, reason: merged with bridge method [inline-methods] */
    public final <T> c<T> v1(@n0 FragmentEvent fragmentEvent) {
        return d.c(this.f22908c8, fragmentEvent);
    }

    @Override // androidx.fragment.app.Fragment
    public void G3(Activity activity) {
        super.G3(activity);
        this.f22908c8.onNext(FragmentEvent.ATTACH);
    }

    @Override // androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        this.f22908c8.onNext(FragmentEvent.CREATE);
    }

    @Override // zg.b
    @j
    @n0
    public final z<FragmentEvent> L() {
        return this.f22908c8.c3();
    }

    @Override // androidx.fragment.app.Fragment
    public void P3() {
        this.f22908c8.onNext(FragmentEvent.DESTROY);
        super.P3();
    }

    @Override // androidx.fragment.app.Fragment
    public void R3() {
        this.f22908c8.onNext(FragmentEvent.DESTROY_VIEW);
        super.R3();
    }

    @Override // androidx.fragment.app.Fragment
    public void S3() {
        this.f22908c8.onNext(FragmentEvent.DETACH);
        super.S3();
    }

    @Override // androidx.fragment.app.Fragment
    public void a4() {
        this.f22908c8.onNext(FragmentEvent.PAUSE);
        super.a4();
    }

    @Override // androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        this.f22908c8.onNext(FragmentEvent.RESUME);
    }

    @Override // androidx.fragment.app.Fragment
    public void h4() {
        super.h4();
        this.f22908c8.onNext(FragmentEvent.START);
    }

    @Override // androidx.fragment.app.Fragment
    public void i4() {
        this.f22908c8.onNext(FragmentEvent.STOP);
        super.i4();
    }

    @Override // androidx.fragment.app.Fragment
    public void j4(View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        this.f22908c8.onNext(FragmentEvent.CREATE_VIEW);
    }

    @Override // zg.b
    @j
    @n0
    public final <T> c<T> y1() {
        return ah.b.b(this.f22908c8);
    }

    @o
    public RxFragment(@i0 int i10) {
        super(i10);
        this.f22908c8 = a.o8();
    }
}
