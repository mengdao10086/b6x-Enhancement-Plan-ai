package jc;

import android.net.Uri;
import cc.c0;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.cache.a;
import com.google.android.exoplayer2.upstream.k;
import g.p0;
import hb.e;
import hc.f;
import hc.g;
import hd.g0;
import ic.c;
import ic.h;
import ic.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends c0<ic.b> {

    /* JADX INFO: renamed from: jc.a$a, reason: collision with other inner class name */
    public class C0412a extends g0<e, IOException> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.google.android.exoplayer2.upstream.a f36309h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f36310i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ i f36311j;

        public C0412a(com.google.android.exoplayer2.upstream.a aVar, int i10, i iVar) {
            this.f36309h = aVar;
            this.f36310i = i10;
            this.f36311j = iVar;
        }

        @Override // hd.g0
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public e d() throws IOException {
            return f.c(this.f36309h, this.f36310i, this.f36311j);
        }
    }

    @Deprecated
    public a(Uri uri, List<StreamKey> list, a.d dVar) {
        this(uri, list, dVar, androidx.profileinstaller.f.f6454a);
    }

    public static void l(long j10, String str, h hVar, ArrayList<c0.c> arrayList) {
        arrayList.add(new c0.c(j10, new com.google.android.exoplayer2.upstream.b(hVar.b(str), hVar.f32076a, hVar.f32077b)));
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0084 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(com.google.android.exoplayer2.upstream.a r23, ic.a r24, long r25, long r27, boolean r29, java.util.ArrayList<cc.c0.c> r30) throws java.lang.InterruptedException, java.io.IOException {
        /*
            r22 = this;
            r1 = r24
            r2 = r25
            r4 = r29
            r5 = r30
            r0 = 0
            r6 = 0
        La:
            java.util.List<ic.i> r0 = r1.f32028c
            int r0 = r0.size()
            if (r6 >= r0) goto L8a
            java.util.List<ic.i> r0 = r1.f32028c
            java.lang.Object r0 = r0.get(r6)
            ic.i r0 = (ic.i) r0
            int r7 = r1.f32027b     // Catch: java.io.IOException -> L7b
            r8 = r22
            r9 = r23
            hc.e r7 = r8.n(r9, r7, r0, r4)     // Catch: java.io.IOException -> L79
            if (r7 == 0) goto L6d
            r10 = r27
            int r12 = r7.i(r10)
            r13 = -1
            if (r12 == r13) goto L65
            java.lang.String r13 = r0.f32083d
            ic.h r14 = r0.n()
            if (r14 == 0) goto L3a
            l(r2, r13, r14, r5)
        L3a:
            ic.h r0 = r0.m()
            if (r0 == 0) goto L43
            l(r2, r13, r0, r5)
        L43:
            long r14 = r7.h()
            long r0 = (long) r12
            long r0 = r0 + r14
            r16 = 1
            long r0 = r0 - r16
        L4d:
            int r12 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r12 > 0) goto L84
            long r18 = r7.a(r14)
            r20 = r0
            long r0 = r2 + r18
            ic.h r12 = r7.e(r14)
            l(r0, r13, r12, r5)
            long r14 = r14 + r16
            r0 = r20
            goto L4d
        L65:
            com.google.android.exoplayer2.offline.DownloadException r0 = new com.google.android.exoplayer2.offline.DownloadException
            java.lang.String r1 = "Unbounded segment index"
            r0.<init>(r1)
            throw r0
        L6d:
            r10 = r27
            com.google.android.exoplayer2.offline.DownloadException r0 = new com.google.android.exoplayer2.offline.DownloadException     // Catch: java.io.IOException -> L77
            java.lang.String r1 = "Missing segment index"
            r0.<init>(r1)     // Catch: java.io.IOException -> L77
            throw r0     // Catch: java.io.IOException -> L77
        L77:
            r0 = move-exception
            goto L82
        L79:
            r0 = move-exception
            goto L80
        L7b:
            r0 = move-exception
            r8 = r22
            r9 = r23
        L80:
            r10 = r27
        L82:
            if (r4 == 0) goto L89
        L84:
            int r6 = r6 + 1
            r1 = r24
            goto La
        L89:
            throw r0
        L8a:
            r8 = r22
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jc.a.m(com.google.android.exoplayer2.upstream.a, ic.a, long, long, boolean, java.util.ArrayList):void");
    }

    @p0
    public final hc.e n(com.google.android.exoplayer2.upstream.a aVar, int i10, i iVar, boolean z10) throws InterruptedException, IOException {
        hc.e eVarL = iVar.l();
        if (eVarL != null) {
            return eVarL;
        }
        e eVar = (e) e(new C0412a(aVar, i10, iVar), z10);
        if (eVar == null) {
            return null;
        }
        return new g(eVar, iVar.f32084e);
    }

    @Override // cc.c0
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public List<c0.c> h(com.google.android.exoplayer2.upstream.a aVar, ic.b bVar, boolean z10) throws InterruptedException, IOException {
        ArrayList<c0.c> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < bVar.e(); i10++) {
            ic.f fVarD = bVar.d(i10);
            long jC = ya.g.c(fVarD.f32067b);
            long jG = bVar.g(i10);
            int i11 = 0;
            for (List<ic.a> list = fVarD.f32068c; i11 < list.size(); list = list) {
                m(aVar, list.get(i11), jC, jG, z10, arrayList);
                i11++;
            }
        }
        return arrayList;
    }

    public a(v0 v0Var, a.d dVar) {
        this(v0Var, dVar, androidx.profileinstaller.f.f6454a);
    }

    @Deprecated
    public a(Uri uri, List<StreamKey> list, a.d dVar, Executor executor) {
        this(new v0.c().F(uri).C(list).a(), dVar, executor);
    }

    public a(v0 v0Var, a.d dVar, Executor executor) {
        this(v0Var, new c(), dVar, executor);
    }

    public a(v0 v0Var, k.a<ic.b> aVar, a.d dVar, Executor executor) {
        super(v0Var, aVar, dVar, executor);
    }
}
