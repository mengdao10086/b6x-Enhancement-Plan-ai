package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.i1
    public final Set<LiveData> f7373a = Collections.newSetFromMap(new IdentityHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoomDatabase f7374b;

    public f1(RoomDatabase roomDatabase) {
        this.f7374b = roomDatabase;
    }

    public <T> LiveData<T> a(String[] strArr, boolean z10, Callable<T> callable) {
        return new x2(this.f7374b, this, z10, callable, strArr);
    }

    public void b(LiveData liveData) {
        this.f7373a.add(liveData);
    }

    public void c(LiveData liveData) {
        this.f7373a.remove(liveData);
    }
}
