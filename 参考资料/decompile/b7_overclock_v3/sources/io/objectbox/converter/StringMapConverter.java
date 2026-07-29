package io.objectbox.converter;

import io.objectbox.flatbuffers.FlexBuffers;
import io.objectbox.flatbuffers.a;
import io.objectbox.flatbuffers.j;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class StringMapConverter implements PropertyConverter<Map<String, String>, byte[]> {
    private static final AtomicReference<j> cachedBuilder = new AtomicReference<>();

    @Override // io.objectbox.converter.PropertyConverter
    public byte[] convertToDatabaseValue(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        j andSet = cachedBuilder.getAndSet(null);
        if (andSet == null) {
            andSet = new j(new a(512), 3);
        }
        int iD = andSet.D();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("Map keys or values must not be null");
            }
            andSet.x(entry.getKey(), entry.getValue());
        }
        andSet.f(null, iD);
        ByteBuffer byteBufferH = andSet.h();
        byte[] bArr = new byte[byteBufferH.limit()];
        byteBufferH.get(bArr);
        if (byteBufferH.limit() <= 262144) {
            andSet.c();
            cachedBuilder.getAndSet(andSet);
        }
        return bArr;
    }

    @Override // io.objectbox.converter.PropertyConverter
    public Map<String, String> convertToEntityProperty(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        FlexBuffers.d dVarH = FlexBuffers.g(new a(bArr, bArr.length)).h();
        int iB = dVarH.b();
        FlexBuffers.c cVarM = dVarH.m();
        FlexBuffers.j jVarN = dVarH.n();
        HashMap map = new HashMap((int) ((((double) iB) / 0.75d) + 1.0d));
        for (int i10 = 0; i10 < iB; i10++) {
            map.put(cVarM.a(i10).toString(), jVarN.d(i10).i());
        }
        return map;
    }
}
