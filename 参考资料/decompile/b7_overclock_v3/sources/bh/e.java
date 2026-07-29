package bh;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.View;
import com.trello.rxlifecycle3.android.FragmentEvent;
import g.i;
import g.j;
import g.n0;
import g.p0;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public abstract class e extends PreferenceFragment implements zg.b<FragmentEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.subjects.a<FragmentEvent> f9441a = io.reactivex.subjects.a.o8();

    @Override // zg.b
    @j
    @n0
    public final z<FragmentEvent> L() {
        return this.f9441a.c3();
    }

    @Override // zg.b
    @j
    @n0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final <T> zg.c<T> v1(@n0 FragmentEvent fragmentEvent) {
        return zg.d.c(this.f9441a, fragmentEvent);
    }

    @Override // android.app.Fragment
    @i
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9441a.onNext(FragmentEvent.ATTACH);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    @i
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        this.f9441a.onNext(FragmentEvent.CREATE);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    @i
    public void onDestroy() {
        this.f9441a.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    @i
    public void onDestroyView() {
        this.f9441a.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    @i
    public void onDetach() {
        this.f9441a.onNext(FragmentEvent.DETACH);
        super.onDetach();
    }

    @Override // android.app.Fragment
    @i
    public void onPause() {
        this.f9441a.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    @Override // android.app.Fragment
    @i
    public void onResume() {
        super.onResume();
        this.f9441a.onNext(FragmentEvent.RESUME);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    @i
    public void onStart() {
        super.onStart();
        this.f9441a.onNext(FragmentEvent.START);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    @i
    public void onStop() {
        this.f9441a.onNext(FragmentEvent.STOP);
        super.onStop();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    @i
    public void onViewCreated(View view, @p0 Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f9441a.onNext(FragmentEvent.CREATE_VIEW);
    }

    @Override // zg.b
    @j
    @n0
    public final <T> zg.c<T> y1() {
        return ah.b.b(this.f9441a);
    }
}
