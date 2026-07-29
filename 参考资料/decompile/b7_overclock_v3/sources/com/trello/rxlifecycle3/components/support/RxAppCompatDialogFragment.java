package com.trello.rxlifecycle3.components.support;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.trello.rxlifecycle3.android.FragmentEvent;
import g.i;
import g.j;
import g.n0;
import g.p0;
import io.reactivex.subjects.a;
import xi.z;
import zg.b;
import zg.c;
import zg.d;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RxAppCompatDialogFragment extends AppCompatDialogFragment implements b<FragmentEvent> {
    public final a<FragmentEvent> D8 = a.o8();

    @Override // androidx.fragment.app.Fragment
    @i
    public void G3(Activity activity) {
        super.G3(activity);
        this.D8.onNext(FragmentEvent.ATTACH);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @i
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        this.D8.onNext(FragmentEvent.CREATE);
    }

    @Override // zg.b
    @j
    @n0
    public final z<FragmentEvent> L() {
        return this.D8.c3();
    }

    @Override // androidx.fragment.app.Fragment
    @i
    public void P3() {
        this.D8.onNext(FragmentEvent.DESTROY);
        super.P3();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @i
    public void R3() {
        this.D8.onNext(FragmentEvent.DESTROY_VIEW);
        super.R3();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @i
    public void S3() {
        this.D8.onNext(FragmentEvent.DETACH);
        super.S3();
    }

    @Override // androidx.fragment.app.Fragment
    @i
    public void a4() {
        this.D8.onNext(FragmentEvent.PAUSE);
        super.a4();
    }

    @Override // zg.b
    @j
    @n0
    /* JADX INFO: renamed from: b6, reason: merged with bridge method [inline-methods] */
    public final <T> c<T> v1(@n0 FragmentEvent fragmentEvent) {
        return d.c(this.D8, fragmentEvent);
    }

    @Override // androidx.fragment.app.Fragment
    @i
    public void f4() {
        super.f4();
        this.D8.onNext(FragmentEvent.RESUME);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @i
    public void h4() {
        super.h4();
        this.D8.onNext(FragmentEvent.START);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @i
    public void i4() {
        this.D8.onNext(FragmentEvent.STOP);
        super.i4();
    }

    @Override // androidx.fragment.app.Fragment
    @i
    public void j4(View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        this.D8.onNext(FragmentEvent.CREATE_VIEW);
    }

    @Override // zg.b
    @j
    @n0
    public final <T> c<T> y1() {
        return ah.b.b(this.D8);
    }
}
