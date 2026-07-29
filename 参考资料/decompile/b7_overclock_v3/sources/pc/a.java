package pc;

import android.net.Uri;
import androidx.profileinstaller.f;
import cc.c0;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.cache.a;
import com.google.android.exoplayer2.upstream.k;
import hd.u0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends c0<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> {
    @Deprecated
    public a(Uri uri, List<StreamKey> list, a.d dVar) {
        this(uri, list, dVar, f.f6454a);
    }

    @Override // cc.c0
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public List<c0.c> h(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar2, boolean z10) {
        ArrayList arrayList = new ArrayList();
        for (a.b bVar : aVar2.f18410f) {
            for (int i10 = 0; i10 < bVar.f18429j.length; i10++) {
                for (int i11 = 0; i11 < bVar.f18430k; i11++) {
                    arrayList.add(new c0.c(bVar.e(i11), new com.google.android.exoplayer2.upstream.b(bVar.a(i10, i11))));
                }
            }
        }
        return arrayList;
    }

    public a(v0 v0Var, a.d dVar) {
        this(v0Var, dVar, f.f6454a);
    }

    @Deprecated
    public a(Uri uri, List<StreamKey> list, a.d dVar, Executor executor) {
        this(new v0.c().F(uri).C(list).a(), dVar, executor);
    }

    public a(v0 v0Var, a.d dVar, Executor executor) {
        this(v0Var.a().F(u0.H(((v0.g) hd.a.g(v0Var.f57132b)).f57183a)).a(), new SsManifestParser(), dVar, executor);
    }

    public a(v0 v0Var, k.a<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> aVar, a.d dVar, Executor executor) {
        super(v0Var, aVar, dVar, executor);
    }
}
