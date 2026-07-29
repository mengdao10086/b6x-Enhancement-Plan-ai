package com.flydigi.sdk.bluetooth;

import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class AbstractDataInteractionControllerKt {
    @yt.k
    public static final String a(@yt.k byte[] bArr, @yt.k CharSequence separator) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(separator, "separator");
        return ArraysKt___ArraysKt.Gh(bArr, separator, null, null, 0, null, new ik.l<Byte, CharSequence>() { // from class: com.flydigi.sdk.bluetooth.AbstractDataInteractionControllerKt$toHexString$1
            @yt.k
            public final CharSequence b(byte b10) {
                v0 v0Var = v0.f37964a;
                String str = String.format("%02X", Arrays.copyOf(new Object[]{Integer.valueOf(b10 & 255)}, 1));
                kotlin.jvm.internal.f0.o(str, "format(format, *args)");
                return str;
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ CharSequence i(Byte b10) {
                return b(b10.byteValue());
            }
        }, 30, null);
    }

    public static /* synthetic */ String b(byte[] bArr, CharSequence charSequence, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charSequence = ag.c.f654g;
        }
        return a(bArr, charSequence);
    }
}
