package bh;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import com.trello.rxlifecycle3.android.FragmentEvent;
import g.i;
import g.j;
import g.n0;
import g.p0;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c extends DialogFragment implements zg.b<FragmentEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.subjects.a<FragmentEvent> f9439a = io.reactivex.subjects.a.o8();

    @Override // zg.b
    @j
    @n0
    public final z<FragmentEvent> L() {
        return this.f9439a.c3();
    }

    @Override // zg.b
    @j
    @n0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final <T> zg.c<T> v1(@n0 FragmentEvent fragmentEvent) {
        return zg.d.c(this.f9439a, fragmentEvent);
    }

    @Override // android.app.Fragment
    @i
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9439a.onNext(FragmentEvent.ATTACH);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @i
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9439a.onNext(FragmentEvent.CREATE);
    }

    @Override // android.app.Fragment
    @i
    public void onDestroy() {
        this.f9439a.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @i
    public void onDestroyView() {
        this.f9439a.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @i
    public void onDetach() {
        this.f9439a.onNext(FragmentEvent.DETACH);
        super.onDetach();
    }

    @Override // android.app.Fragment
    @i
    public void onPause() {
        this.f9439a.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    @Override // android.app.Fragment
    @i
    public void onResume() {
        super.onResume();
        this.f9439a.onNext(FragmentEvent.RESUME);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @i
    public void onStart() {
        super.onStart();
        this.f9439a.onNext(FragmentEvent.START);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @i
    public void onStop() {
        this.f9439a.onNext(FragmentEvent.STOP);
        super.onStop();
    }

    @Override // android.app.Fragment
    @i
    public void onViewCreated(View view, @p0 Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f9439a.onNext(FragmentEvent.CREATE_VIEW);
    }

    @Override // zg.b
    @j
    @n0
    public final <T> zg.c<T> y1() {
        return ah.b.b(this.f9439a);
    }
}
