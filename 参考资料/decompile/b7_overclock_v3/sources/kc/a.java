package kc;

import android.net.Uri;
import androidx.profileinstaller.f;
import cc.c0;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.upstream.cache.a;
import com.google.android.exoplayer2.upstream.k;
import hd.s0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import lc.e;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends c0<e> {
    @Deprecated
    public a(Uri uri, List<StreamKey> list, a.d dVar) {
        this(uri, list, dVar, f.f6454a);
    }

    public final void l(List<Uri> list, List<com.google.android.exoplayer2.upstream.b> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            list2.add(c0.f(list.get(i10)));
        }
    }

    public final void m(c cVar, c.e eVar, HashSet<Uri> hashSet, ArrayList<c0.c> arrayList) {
        String str = cVar.f39566a;
        long j10 = cVar.f18029f + eVar.f18055e;
        String str2 = eVar.f18057g;
        if (str2 != null) {
            Uri uriE = s0.e(str, str2);
            if (hashSet.add(uriE)) {
                arrayList.add(new c0.c(j10, c0.f(uriE)));
            }
        }
        arrayList.add(new c0.c(j10, new com.google.android.exoplayer2.upstream.b(s0.e(str, eVar.f18051a), eVar.f18059i, eVar.f18060j)));
    }

    @Override // cc.c0
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public List<c0.c> h(com.google.android.exoplayer2.upstream.a aVar, e eVar, boolean z10) throws InterruptedException, IOException {
        ArrayList<com.google.android.exoplayer2.upstream.b> arrayList = new ArrayList();
        if (eVar instanceof com.google.android.exoplayer2.source.hls.playlist.b) {
            l(((com.google.android.exoplayer2.source.hls.playlist.b) eVar).f18004d, arrayList);
        } else {
            arrayList.add(c0.f(Uri.parse(eVar.f39566a)));
        }
        ArrayList<c0.c> arrayList2 = new ArrayList<>();
        HashSet<Uri> hashSet = new HashSet<>();
        for (com.google.android.exoplayer2.upstream.b bVar : arrayList) {
            arrayList2.add(new c0.c(0L, bVar));
            try {
                c cVar = (c) g(aVar, bVar, z10);
                c.e eVar2 = null;
                List<c.e> list = cVar.f18039p;
                for (int i10 = 0; i10 < list.size(); i10++) {
                    c.e eVar3 = list.get(i10);
                    c.e eVar4 = eVar3.f18052b;
                    if (eVar4 != null && eVar4 != eVar2) {
                        m(cVar, eVar4, hashSet, arrayList2);
                        eVar2 = eVar4;
                    }
                    m(cVar, eVar3, hashSet, arrayList2);
                }
            } catch (IOException e10) {
                if (!z10) {
                    throw e10;
                }
            }
        }
        return arrayList2;
    }

    public a(v0 v0Var, a.d dVar) {
        this(v0Var, dVar, f.f6454a);
    }

    @Deprecated
    public a(Uri uri, List<StreamKey> list, a.d dVar, Executor executor) {
        this(new v0.c().F(uri).C(list).a(), dVar, executor);
    }

    public a(v0 v0Var, a.d dVar, Executor executor) {
        this(v0Var, new HlsPlaylistParser(), dVar, executor);
    }

    public a(v0 v0Var, k.a<e> aVar, a.d dVar, Executor executor) {
        super(v0Var, aVar, dVar, executor);
    }
}
