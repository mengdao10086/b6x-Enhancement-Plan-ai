package com.google.android.exoplayer2.trackselection;

import ad.f;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.b;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    public interface a {
        b a(b.a aVar);
    }

    public static b[] a(b.a[] aVarArr, a aVar) {
        b[] bVarArr = new b[aVarArr.length];
        boolean z10 = false;
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            b.a aVar2 = aVarArr[i10];
            if (aVar2 != null) {
                int[] iArr = aVar2.f18624b;
                if (iArr.length <= 1 || z10) {
                    bVarArr[i10] = new f(aVar2.f18623a, iArr[0], aVar2.f18625c, aVar2.f18626d);
                } else {
                    bVarArr[i10] = aVar.a(aVar2);
                    z10 = true;
                }
            }
        }
        return bVarArr;
    }

    public static DefaultTrackSelector.Parameters b(DefaultTrackSelector.Parameters parameters, int i10, TrackGroupArray trackGroupArray, boolean z10, @p0 DefaultTrackSelector.SelectionOverride selectionOverride) {
        DefaultTrackSelector.d dVarZ = parameters.a().o(i10).Z(i10, z10);
        if (selectionOverride != null) {
            dVarZ.b0(i10, trackGroupArray, selectionOverride);
        }
        return dVarZ.a();
    }
}
