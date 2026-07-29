package com.google.android.exoplayer2.source.hls;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.common.primitives.Ints;
import hd.p0;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import rb.h0;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f17829d = {8, 13, 11, 2, 0, 1, 7};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17831c;

    public e() {
        this(0, true);
    }

    public static void b(int i10, List<Integer> list) {
        if (Ints.indexOf(f17829d, i10) == -1 || list.contains(Integer.valueOf(i10))) {
            return;
        }
        list.add(Integer.valueOf(i10));
    }

    public static ob.g e(p0 p0Var, Format format, @g.p0 List<Format> list) {
        int i10 = g(format) ? 4 : 0;
        if (list == null) {
            list = Collections.emptyList();
        }
        return new ob.g(i10, p0Var, null, list);
    }

    public static h0 f(int i10, boolean z10, Format format, @g.p0 List<Format> list, p0 p0Var) {
        int i11 = i10 | 16;
        if (list != null) {
            i11 |= 32;
        } else {
            list = z10 ? Collections.singletonList(new Format.b().e0(hd.w.f31195l0).E()) : Collections.emptyList();
        }
        String str = format.f16695i;
        if (!TextUtils.isEmpty(str)) {
            if (!hd.w.b(str, hd.w.A)) {
                i11 |= 2;
            }
            if (!hd.w.b(str, hd.w.f31190j)) {
                i11 |= 4;
            }
        }
        return new h0(2, p0Var, new rb.j(i11, list));
    }

    public static boolean g(Format format) {
        Metadata metadata = format.f16696j;
        if (metadata == null) {
            return false;
        }
        for (int i10 = 0; i10 < metadata.g(); i10++) {
            if (metadata.e(i10) instanceof HlsTrackMetadataEntry) {
                return !((HlsTrackMetadataEntry) r2).f17808c.isEmpty();
            }
        }
        return false;
    }

    public static boolean h(hb.k kVar, hb.l lVar) throws IOException {
        try {
            boolean zI = kVar.i(lVar);
            lVar.n();
            return zI;
        } catch (EOFException unused) {
            lVar.n();
            return false;
        } catch (Throwable th2) {
            lVar.n();
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.h
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public c a(Uri uri, Format format, @g.p0 List<Format> list, p0 p0Var, Map<String, List<String>> map, hb.l lVar) throws IOException {
        int iA = hd.k.a(format.f16699l);
        int iB = hd.k.b(map);
        int iC = hd.k.c(uri);
        int[] iArr = f17829d;
        ArrayList arrayList = new ArrayList(iArr.length);
        b(iA, arrayList);
        b(iB, arrayList);
        b(iC, arrayList);
        for (int i10 : iArr) {
            b(i10, arrayList);
        }
        hb.k kVar = null;
        lVar.n();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            int iIntValue = ((Integer) arrayList.get(i11)).intValue();
            hb.k kVar2 = (hb.k) hd.a.g(d(iIntValue, format, list, p0Var));
            if (h(kVar2, lVar)) {
                return new c(kVar2, format, p0Var);
            }
            if (kVar == null && (iIntValue == iA || iIntValue == iB || iIntValue == iC || iIntValue == 11)) {
                kVar = kVar2;
            }
        }
        return new c((hb.k) hd.a.g(kVar), format, p0Var);
    }

    @g.p0
    @SuppressLint({"SwitchIntDef"})
    public final hb.k d(int i10, Format format, @g.p0 List<Format> list, p0 p0Var) {
        if (i10 == 0) {
            return new rb.b();
        }
        if (i10 == 1) {
            return new rb.e();
        }
        if (i10 == 2) {
            return new rb.h();
        }
        if (i10 == 7) {
            return new nb.f(0, 0L);
        }
        if (i10 == 8) {
            return e(p0Var, format, list);
        }
        if (i10 == 11) {
            return f(this.f17830b, this.f17831c, format, list, p0Var);
        }
        if (i10 != 13) {
            return null;
        }
        return new w(format.f16689c, p0Var);
    }

    public e(int i10, boolean z10) {
        this.f17830b = i10;
        this.f17831c = z10;
    }
}
