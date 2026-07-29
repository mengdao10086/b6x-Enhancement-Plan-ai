package ad;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.l;
import g.p0;
import ya.q1;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public a f569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public ed.d f570b;

    public interface a {
        void d();
    }

    public final ed.d a() {
        return (ed.d) hd.a.g(this.f570b);
    }

    public final void b(a aVar, ed.d dVar) {
        this.f569a = aVar;
        this.f570b = dVar;
    }

    public final void c() {
        a aVar = this.f569a;
        if (aVar != null) {
            aVar.d();
        }
    }

    public abstract void d(@p0 Object obj);

    public abstract k e(q1[] q1VarArr, TrackGroupArray trackGroupArray, l.a aVar, x1 x1Var) throws ExoPlaybackException;
}
