package androidx.work.multiprocess;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.WorkInfo;
import androidx.work.multiprocess.b;
import androidx.work.multiprocess.d;
import androidx.work.multiprocess.parcelable.ParcelableUpdateRequest;
import androidx.work.multiprocess.parcelable.ParcelableWorkContinuationImpl;
import androidx.work.multiprocess.parcelable.ParcelableWorkInfos;
import androidx.work.multiprocess.parcelable.ParcelableWorkQuery;
import androidx.work.multiprocess.parcelable.ParcelableWorkRequests;
import androidx.work.o;
import com.google.common.util.concurrent.ListenableFuture;
import g.k0;
import g.n0;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import v2.r;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class m extends b.AbstractBinderC0087b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static byte[] f8694p = new byte[0];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final l2.i f8695o;

    public class a extends androidx.work.multiprocess.d<o.b.c> {
        public a(Executor executor, androidx.work.multiprocess.c cVar, ListenableFuture listenableFuture) {
            super(executor, cVar, listenableFuture);
        }

        @Override // androidx.work.multiprocess.d
        @n0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public byte[] b(@n0 o.b.c cVar) {
            return m.f8694p;
        }
    }

    public class b extends androidx.work.multiprocess.d<o.b.c> {
        public b(Executor executor, androidx.work.multiprocess.c cVar, ListenableFuture listenableFuture) {
            super(executor, cVar, listenableFuture);
        }

        @Override // androidx.work.multiprocess.d
        @n0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public byte[] b(@n0 o.b.c cVar) {
            return m.f8694p;
        }
    }

    public class c extends androidx.work.multiprocess.d<o.b.c> {
        public c(Executor executor, androidx.work.multiprocess.c cVar, ListenableFuture listenableFuture) {
            super(executor, cVar, listenableFuture);
        }

        @Override // androidx.work.multiprocess.d
        @n0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public byte[] b(@n0 o.b.c cVar) {
            return m.f8694p;
        }
    }

    public class d extends androidx.work.multiprocess.d<o.b.c> {
        public d(Executor executor, androidx.work.multiprocess.c cVar, ListenableFuture listenableFuture) {
            super(executor, cVar, listenableFuture);
        }

        @Override // androidx.work.multiprocess.d
        @n0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public byte[] b(@n0 o.b.c cVar) {
            return m.f8694p;
        }
    }

    public class e extends androidx.work.multiprocess.d<o.b.c> {
        public e(Executor executor, androidx.work.multiprocess.c cVar, ListenableFuture listenableFuture) {
            super(executor, cVar, listenableFuture);
        }

        @Override // androidx.work.multiprocess.d
        @n0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public byte[] b(@n0 o.b.c cVar) {
            return m.f8694p;
        }
    }

    public class f extends androidx.work.multiprocess.d<o.b.c> {
        public f(Executor executor, androidx.work.multiprocess.c cVar, ListenableFuture listenableFuture) {
            super(executor, cVar, listenableFuture);
        }

        @Override // androidx.work.multiprocess.d
        @n0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public byte[] b(@n0 o.b.c cVar) {
            return m.f8694p;
        }
    }

    public class g extends androidx.work.multiprocess.d<List<WorkInfo>> {
        public g(Executor executor, androidx.work.multiprocess.c cVar, ListenableFuture listenableFuture) {
            super(executor, cVar, listenableFuture);
        }

        @Override // androidx.work.multiprocess.d
        @n0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public byte[] b(@n0 List<WorkInfo> list) {
            return x2.a.a(new ParcelableWorkInfos(list));
        }
    }

    public class h extends androidx.work.multiprocess.d<Void> {
        public h(Executor executor, androidx.work.multiprocess.c cVar, ListenableFuture listenableFuture) {
            super(executor, cVar, listenableFuture);
        }

        @Override // androidx.work.multiprocess.d
        @n0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public byte[] b(@n0 Void r12) {
            return m.f8694p;
        }
    }

    public m(@n0 Context context) {
        this.f8695o = l2.i.H(context);
    }

    @Override // androidx.work.multiprocess.b
    public void F0(@n0 String str, @n0 androidx.work.multiprocess.c cVar) {
        try {
            new d(this.f8695o.O().d(), cVar, this.f8695o.f(str).getResult()).a();
        } catch (Throwable th2) {
            d.a.a(cVar, th2);
        }
    }

    @Override // androidx.work.multiprocess.b
    public void L(@n0 androidx.work.multiprocess.c cVar) {
        try {
            new f(this.f8695o.O().d(), cVar, this.f8695o.e().getResult()).a();
        } catch (Throwable th2) {
            d.a.a(cVar, th2);
        }
    }

    @Override // androidx.work.multiprocess.b
    public void N0(@n0 byte[] bArr, @n0 androidx.work.multiprocess.c cVar) {
        try {
            ParcelableUpdateRequest parcelableUpdateRequest = (ParcelableUpdateRequest) x2.a.b(bArr, ParcelableUpdateRequest.CREATOR);
            Context contextE = this.f8695o.E();
            w2.a aVarO = this.f8695o.O();
            new h(aVarO.d(), cVar, new r(this.f8695o.M(), aVarO).a(contextE, UUID.fromString(parcelableUpdateRequest.b()), parcelableUpdateRequest.a())).a();
        } catch (Throwable th2) {
            d.a.a(cVar, th2);
        }
    }

    @Override // androidx.work.multiprocess.b
    public void P0(@n0 byte[] bArr, @n0 androidx.work.multiprocess.c cVar) {
        try {
            new b(this.f8695o.O().d(), cVar, ((ParcelableWorkContinuationImpl) x2.a.b(bArr, ParcelableWorkContinuationImpl.CREATOR)).b(this.f8695o).c().getResult()).a();
        } catch (Throwable th2) {
            d.a.a(cVar, th2);
        }
    }

    @Override // androidx.work.multiprocess.b
    public void b(@n0 String str, @n0 androidx.work.multiprocess.c cVar) {
        try {
            new e(this.f8695o.O().d(), cVar, this.f8695o.g(str).getResult()).a();
        } catch (Throwable th2) {
            d.a.a(cVar, th2);
        }
    }

    @Override // androidx.work.multiprocess.b
    @k0
    public void c(@n0 byte[] bArr, @n0 androidx.work.multiprocess.c cVar) {
        try {
            new a(this.f8695o.O().d(), cVar, this.f8695o.k(((ParcelableWorkRequests) x2.a.b(bArr, ParcelableWorkRequests.CREATOR)).a()).getResult()).a();
        } catch (Throwable th2) {
            d.a.a(cVar, th2);
        }
    }

    @Override // androidx.work.multiprocess.b
    public void e0(@n0 byte[] bArr, @n0 androidx.work.multiprocess.c cVar) {
        try {
            new g(this.f8695o.O().d(), cVar, this.f8695o.u(((ParcelableWorkQuery) x2.a.b(bArr, ParcelableWorkQuery.CREATOR)).a())).a();
        } catch (Throwable th2) {
            d.a.a(cVar, th2);
        }
    }

    @Override // androidx.work.multiprocess.b
    public void r0(@n0 String str, @n0 androidx.work.multiprocess.c cVar) {
        try {
            new c(this.f8695o.O().d(), cVar, this.f8695o.h(UUID.fromString(str)).getResult()).a();
        } catch (Throwable th2) {
            d.a.a(cVar, th2);
        }
    }
}
