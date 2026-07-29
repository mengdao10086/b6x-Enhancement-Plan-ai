package bh;

import android.app.Activity;
import android.os.Bundle;
import com.trello.rxlifecycle3.android.ActivityEvent;
import g.i;
import g.j;
import g.n0;
import g.p0;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b extends Activity implements zg.b<ActivityEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.subjects.a<ActivityEvent> f9438a = io.reactivex.subjects.a.o8();

    @Override // zg.b
    @j
    @n0
    public final z<ActivityEvent> L() {
        return this.f9438a.c3();
    }

    @Override // zg.b
    @j
    @n0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final <T> zg.c<T> v1(@n0 ActivityEvent activityEvent) {
        return zg.d.c(this.f9438a, activityEvent);
    }

    @Override // android.app.Activity
    @i
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        this.f9438a.onNext(ActivityEvent.CREATE);
    }

    @Override // android.app.Activity
    @i
    public void onDestroy() {
        this.f9438a.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Activity
    @i
    public void onPause() {
        this.f9438a.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override // android.app.Activity
    @i
    public void onResume() {
        super.onResume();
        this.f9438a.onNext(ActivityEvent.RESUME);
    }

    @Override // android.app.Activity
    @i
    public void onStart() {
        super.onStart();
        this.f9438a.onNext(ActivityEvent.START);
    }

    @Override // android.app.Activity
    @i
    public void onStop() {
        this.f9438a.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    @Override // zg.b
    @j
    @n0
    public final <T> zg.c<T> y1() {
        return ah.b.a(this.f9438a);
    }
}
