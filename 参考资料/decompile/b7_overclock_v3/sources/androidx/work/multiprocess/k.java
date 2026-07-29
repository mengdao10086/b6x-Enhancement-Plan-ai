package androidx.work.multiprocess;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.work.u;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class k extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RemoteWorkManagerClient f8692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f8693b;

    public k(@n0 RemoteWorkManagerClient remoteWorkManagerClient, @n0 u uVar) {
        this.f8692a = remoteWorkManagerClient;
        this.f8693b = uVar;
    }

    @Override // androidx.work.multiprocess.j
    @SuppressLint({"EnqueueWork"})
    @n0
    public j b(@n0 List<j> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<j> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((k) it2.next()).f8693b);
        }
        return new k(this.f8692a, u.a(arrayList));
    }

    @Override // androidx.work.multiprocess.j
    @n0
    public ListenableFuture<Void> c() {
        return this.f8692a.i(this.f8693b);
    }

    @Override // androidx.work.multiprocess.j
    @SuppressLint({"EnqueueWork"})
    @n0
    public j e(@n0 List<androidx.work.m> list) {
        return new k(this.f8692a, this.f8693b.g(list));
    }
}
