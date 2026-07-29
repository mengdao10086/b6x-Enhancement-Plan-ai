package ch;

import android.os.Bundle;
import androidx.fragment.app.g;
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
public abstract class b extends g implements zg.b<ActivityEvent> {
    public final io.reactivex.subjects.a<ActivityEvent> C;

    public b() {
        this.C = io.reactivex.subjects.a.o8();
    }

    @Override // zg.b
    @j
    @n0
    /* JADX INFO: renamed from: H3, reason: merged with bridge method [inline-methods] */
    public final <T> c<T> v1(@n0 ActivityEvent activityEvent) {
        return d.c(this.C, activityEvent);
    }

    @Override // zg.b
    @j
    @n0
    public final z<ActivityEvent> L() {
        return this.C.c3();
    }

    @Override // androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    @i
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        this.C.onNext(ActivityEvent.CREATE);
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    @i
    public void onDestroy() {
        this.C.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    @i
    public void onPause() {
        this.C.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    @i
    public void onResume() {
        super.onResume();
        this.C.onNext(ActivityEvent.RESUME);
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    @i
    public void onStart() {
        super.onStart();
        this.C.onNext(ActivityEvent.START);
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    @i
    public void onStop() {
        this.C.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    @Override // zg.b
    @j
    @n0
    public final <T> c<T> y1() {
        return ah.b.a(this.C);
    }

    @o
    public b(@i0 int i10) {
        super(i10);
        this.C = io.reactivex.subjects.a.o8();
    }
}
