package ch;

import android.os.Bundle;
import androidx.appcompat.app.f;
import com.trello.rxlifecycle3.android.ActivityEvent;
import g.i;
import g.i0;
import g.j;
import g.n0;
import g.o;
import g.p0;
import xi.z;
import zg.c;
import zg.d;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends f implements zg.b<ActivityEvent> {
    public final io.reactivex.subjects.a<ActivityEvent> K0;

    public a() {
        this.K0 = io.reactivex.subjects.a.o8();
    }

    @Override // zg.b
    @j
    @n0
    public final z<ActivityEvent> L() {
        return this.K0.c3();
    }

    @Override // zg.b
    @j
    @n0
    /* JADX INFO: renamed from: Z3, reason: merged with bridge method [inline-methods] */
    public final <T> c<T> v1(@n0 ActivityEvent activityEvent) {
        return d.c(this.K0, activityEvent);
    }

    @Override // androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    @i
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        this.K0.onNext(ActivityEvent.CREATE);
    }

    @Override // androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    @i
    public void onDestroy() {
        this.K0.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    @i
    public void onPause() {
        this.K0.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    @i
    public void onResume() {
        super.onResume();
        this.K0.onNext(ActivityEvent.RESUME);
    }

    @Override // androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    @i
    public void onStart() {
        super.onStart();
        this.K0.onNext(ActivityEvent.START);
    }

    @Override // androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    @i
    public void onStop() {
        this.K0.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    @Override // zg.b
    @j
    @n0
    public final <T> c<T> y1() {
        return ah.b.a(this.K0);
    }

    @o
    public a(@i0 int i10) {
        super(i10);
        this.K0 = io.reactivex.subjects.a.o8();
    }
}
