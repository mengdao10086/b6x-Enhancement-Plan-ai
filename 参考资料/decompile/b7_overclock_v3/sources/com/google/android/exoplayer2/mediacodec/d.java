package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f17214a = new d() { // from class: tb.j
        @Override // com.google.android.exoplayer2.mediacodec.d
        public final List a(String str, boolean z10, boolean z11) {
            return MediaCodecUtil.s(str, z10, z11);
        }
    };

    List<c> a(String str, boolean z10, boolean z11) throws MediaCodecUtil.DecoderQueryException;
}
