package ya;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.l;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class e1 {

    public static final class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f56629e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f56630f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f56631g = 2;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f56632h = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ec.x f56633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HandlerThread f56634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final hd.n f56635c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SettableFuture<TrackGroupArray> f56636d;

        public final class a implements Handler.Callback {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final int f56637e = 100;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final C0669a f56638a = new C0669a();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public com.google.android.exoplayer2.source.l f56639b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public com.google.android.exoplayer2.source.k f56640c;

            /* JADX INFO: renamed from: ya.e1$b$a$a, reason: collision with other inner class name */
            public final class C0669a implements l.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final C0670a f56642a = new C0670a();

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final ed.b f56643b = new ed.m(true, 65536);

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public boolean f56644c;

                /* JADX INFO: renamed from: ya.e1$b$a$a$a, reason: collision with other inner class name */
                public final class C0670a implements k.a {
                    public C0670a() {
                    }

                    @Override // com.google.android.exoplayer2.source.s.a
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public void i(com.google.android.exoplayer2.source.k kVar) {
                        b.this.f56635c.d(2).sendToTarget();
                    }

                    @Override // com.google.android.exoplayer2.source.k.a
                    public void l(com.google.android.exoplayer2.source.k kVar) {
                        b.this.f56636d.set(kVar.r());
                        b.this.f56635c.d(3).sendToTarget();
                    }
                }

                public C0669a() {
                }

                @Override // com.google.android.exoplayer2.source.l.b
                public void b(com.google.android.exoplayer2.source.l lVar, x1 x1Var) {
                    if (this.f56644c) {
                        return;
                    }
                    this.f56644c = true;
                    a.this.f56640c = lVar.a(new l.a(x1Var.m(0)), this.f56643b, 0L);
                    a.this.f56640c.q(this.f56642a, 0L);
                }
            }

            public a() {
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 0) {
                    com.google.android.exoplayer2.source.l lVarC = b.this.f56633a.c((v0) message.obj);
                    this.f56639b = lVarC;
                    lVarC.s(this.f56638a, null);
                    b.this.f56635c.g(1);
                    return true;
                }
                if (i10 == 1) {
                    try {
                        com.google.android.exoplayer2.source.k kVar = this.f56640c;
                        if (kVar == null) {
                            ((com.google.android.exoplayer2.source.l) hd.a.g(this.f56639b)).n();
                        } else {
                            kVar.m();
                        }
                        b.this.f56635c.b(1, 100);
                    } catch (Exception e10) {
                        b.this.f56636d.setException(e10);
                        b.this.f56635c.d(3).sendToTarget();
                    }
                    return true;
                }
                if (i10 == 2) {
                    ((com.google.android.exoplayer2.source.k) hd.a.g(this.f56640c)).e(0L);
                    return true;
                }
                if (i10 != 3) {
                    return false;
                }
                if (this.f56640c != null) {
                    ((com.google.android.exoplayer2.source.l) hd.a.g(this.f56639b)).p(this.f56640c);
                }
                ((com.google.android.exoplayer2.source.l) hd.a.g(this.f56639b)).b(this.f56638a);
                b.this.f56635c.l(null);
                b.this.f56634b.quit();
                return true;
            }
        }

        public b(ec.x xVar, hd.c cVar) {
            this.f56633a = xVar;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:MetadataRetriever");
            this.f56634b = handlerThread;
            handlerThread.start();
            this.f56635c = cVar.c(handlerThread.getLooper(), new a());
            this.f56636d = SettableFuture.create();
        }

        public ListenableFuture<TrackGroupArray> e(v0 v0Var) {
            this.f56635c.k(0, v0Var).sendToTarget();
            return this.f56636d;
        }
    }

    public static ListenableFuture<TrackGroupArray> a(Context context, v0 v0Var) {
        return b(context, v0Var, hd.c.f30965a);
    }

    @g.i1
    public static ListenableFuture<TrackGroupArray> b(Context context, v0 v0Var, hd.c cVar) {
        return d(new com.google.android.exoplayer2.source.e(context, new hb.h().k(6)), v0Var, cVar);
    }

    public static ListenableFuture<TrackGroupArray> c(ec.x xVar, v0 v0Var) {
        return d(xVar, v0Var, hd.c.f30965a);
    }

    public static ListenableFuture<TrackGroupArray> d(ec.x xVar, v0 v0Var, hd.c cVar) {
        return new b(xVar, cVar).e(v0Var);
    }
}
