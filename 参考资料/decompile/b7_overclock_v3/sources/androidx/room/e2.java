package androidx.room;

import androidx.room.RoomDatabase;
import c2.e;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class e2 implements e.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e.c f7368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoomDatabase.e f7369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f7370c;

    public e2(@g.n0 e.c cVar, @g.n0 RoomDatabase.e eVar, @g.n0 Executor executor) {
        this.f7368a = cVar;
        this.f7369b = eVar;
        this.f7370c = executor;
    }

    @Override // c2.e.c
    @g.n0
    public c2.e a(@g.n0 e.b bVar) {
        return new d2(this.f7368a.a(bVar), this.f7369b, this.f7370c);
    }
}
