package io.objectbox.converter;

import io.objectbox.flatbuffers.FlexBuffers;
import io.objectbox.flatbuffers.a;
import io.objectbox.flatbuffers.j;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class FlexObjectConverter implements PropertyConverter<Object, byte[]> {
    private static final AtomicReference<j> cachedBuilder = new AtomicReference<>();

    private void addMap(j jVar, String str, Map<Object, Object> map) {
        int iD = jVar.D();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key == null || value == null) {
                throw new IllegalArgumentException("Map keys or values must not be null");
            }
            checkMapKeyType(key);
            String string = key.toString();
            if (value instanceof Map) {
                addMap(jVar, string, (Map) value);
            } else if (value instanceof List) {
                addVector(jVar, string, (List) value);
            } else if (value instanceof String) {
                jVar.x(string, (String) value);
            } else if (value instanceof Boolean) {
                jVar.l(string, ((Boolean) value).booleanValue());
            } else if (value instanceof Byte) {
                jVar.t(string, ((Byte) value).intValue());
            } else if (value instanceof Short) {
                jVar.t(string, ((Short) value).intValue());
            } else if (value instanceof Integer) {
                jVar.t(string, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                jVar.u(string, ((Long) value).longValue());
            } else if (value instanceof Float) {
                jVar.q(string, ((Float) value).floatValue());
            } else if (value instanceof Double) {
                jVar.p(string, ((Double) value).doubleValue());
            } else {
                if (!(value instanceof byte[])) {
                    throw new IllegalArgumentException("Map values of this type are not supported: " + value.getClass().getSimpleName());
                }
                jVar.j(string, (byte[]) value);
            }
        }
        jVar.f(str, iD);
    }

    private void addValue(j jVar, Object obj) {
        if (obj instanceof Map) {
            addMap(jVar, null, (Map) obj);
            return;
        }
        if (obj instanceof List) {
            addVector(jVar, null, (List) obj);
            return;
        }
        if (obj instanceof String) {
            jVar.w((String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            jVar.m(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Byte) {
            jVar.r(((Byte) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            jVar.r(((Short) obj).intValue());
            return;
        }
        if (obj instanceof Integer) {
            jVar.r(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            jVar.s(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            jVar.o(((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            jVar.n(((Double) obj).doubleValue());
        } else {
            if (obj instanceof byte[]) {
                jVar.k((byte[]) obj);
                return;
            }
            throw new IllegalArgumentException("Values of this type are not supported: " + obj.getClass().getSimpleName());
        }
    }

    private void addVector(j jVar, String str, List<Object> list) {
        int iE = jVar.E();
        for (Object obj : list) {
            if (obj == null) {
                throw new IllegalArgumentException("List elements must not be null");
            }
            if (obj instanceof Map) {
                addMap(jVar, null, (Map) obj);
            } else if (obj instanceof List) {
                addVector(jVar, null, (List) obj);
            } else if (obj instanceof String) {
                jVar.w((String) obj);
            } else if (obj instanceof Boolean) {
                jVar.m(((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                jVar.r(((Byte) obj).intValue());
            } else if (obj instanceof Short) {
                jVar.r(((Short) obj).intValue());
            } else if (obj instanceof Integer) {
                jVar.r(((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                jVar.s(((Long) obj).longValue());
            } else if (obj instanceof Float) {
                jVar.o(((Float) obj).floatValue());
            } else if (obj instanceof Double) {
                jVar.n(((Double) obj).doubleValue());
            } else {
                if (!(obj instanceof byte[])) {
                    throw new IllegalArgumentException("List values of this type are not supported: " + obj.getClass().getSimpleName());
                }
                jVar.k((byte[]) obj);
            }
        }
        jVar.g(str, iE, false, false);
    }

    private List<Object> buildList(FlexBuffers.j jVar) {
        int iB = jVar.b();
        ArrayList arrayList = new ArrayList(iB);
        Boolean boolValueOf = null;
        for (int i10 = 0; i10 < iB; i10++) {
            FlexBuffers.f fVarD = jVar.d(i10);
            if (fVarD.s()) {
                arrayList.add(buildMap(fVarD.h()));
            } else if (fVarD.y()) {
                arrayList.add(buildList(fVarD.k()));
            } else if (fVarD.v()) {
                arrayList.add(fVarD.i());
            } else if (fVarD.n()) {
                arrayList.add(Boolean.valueOf(fVarD.c()));
            } else if (fVarD.p()) {
                if (boolValueOf == null) {
                    boolValueOf = Boolean.valueOf(shouldRestoreAsLong(fVarD));
                }
                if (boolValueOf.booleanValue()) {
                    arrayList.add(Long.valueOf(fVarD.g()));
                } else {
                    arrayList.add(Integer.valueOf(fVarD.e()));
                }
            } else if (fVarD.o()) {
                arrayList.add(Double.valueOf(fVarD.d()));
            } else {
                if (!fVarD.m()) {
                    throw new IllegalArgumentException("List values of this type are not supported: " + fVarD.getClass().getSimpleName());
                }
                arrayList.add(fVarD.b().f());
            }
        }
        return arrayList;
    }

    private Map<Object, Object> buildMap(FlexBuffers.d dVar) {
        int iB = dVar.b();
        FlexBuffers.c cVarM = dVar.m();
        FlexBuffers.j jVarN = dVar.n();
        HashMap map = new HashMap((int) ((((double) iB) / 0.75d) + 1.0d));
        for (int i10 = 0; i10 < iB; i10++) {
            Object objConvertToKey = convertToKey(cVarM.a(i10).toString());
            FlexBuffers.f fVarD = jVarN.d(i10);
            if (fVarD.s()) {
                map.put(objConvertToKey, buildMap(fVarD.h()));
            } else if (fVarD.y()) {
                map.put(objConvertToKey, buildList(fVarD.k()));
            } else if (fVarD.v()) {
                map.put(objConvertToKey, fVarD.i());
            } else if (fVarD.n()) {
                map.put(objConvertToKey, Boolean.valueOf(fVarD.c()));
            } else if (fVarD.p()) {
                if (shouldRestoreAsLong(fVarD)) {
                    map.put(objConvertToKey, Long.valueOf(fVarD.g()));
                } else {
                    map.put(objConvertToKey, Integer.valueOf(fVarD.e()));
                }
            } else if (fVarD.o()) {
                map.put(objConvertToKey, Double.valueOf(fVarD.d()));
            } else {
                if (!fVarD.m()) {
                    throw new IllegalArgumentException("Map values of this type are not supported: " + fVarD.getClass().getSimpleName());
                }
                map.put(objConvertToKey, fVarD.b().f());
            }
        }
        return map;
    }

    public void checkMapKeyType(Object obj) {
        if (!(obj instanceof String)) {
            throw new IllegalArgumentException("Map keys must be String");
        }
    }

    public Object convertToKey(String str) {
        return str;
    }

    public boolean shouldRestoreAsLong(FlexBuffers.f fVar) {
        try {
            Field declaredField = fVar.getClass().getDeclaredField("parentWidth");
            declaredField.setAccessible(true);
            return ((Integer) declaredField.get(fVar)).intValue() == 8;
        } catch (Exception e10) {
            throw new RuntimeException("FlexMapConverter could not determine FlexBuffers integer bit width.", e10);
        }
    }

    @Override // io.objectbox.converter.PropertyConverter
    public byte[] convertToDatabaseValue(Object obj) {
        if (obj == null) {
            return null;
        }
        AtomicReference<j> atomicReference = cachedBuilder;
        j andSet = atomicReference.getAndSet(null);
        if (andSet == null) {
            andSet = new j(new a(512), 3);
        }
        addValue(andSet, obj);
        ByteBuffer byteBufferH = andSet.h();
        byte[] bArr = new byte[byteBufferH.limit()];
        byteBufferH.get(bArr);
        if (byteBufferH.limit() <= 262144) {
            andSet.c();
            atomicReference.getAndSet(andSet);
        }
        return bArr;
    }

    @Override // io.objectbox.converter.PropertyConverter
    public Object convertToEntityProperty(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        FlexBuffers.f fVarG = FlexBuffers.g(new a(bArr, bArr.length));
        if (fVarG.s()) {
            return buildMap(fVarG.h());
        }
        if (fVarG.y()) {
            return buildList(fVarG.k());
        }
        if (fVarG.v()) {
            return fVarG.i();
        }
        if (fVarG.n()) {
            return Boolean.valueOf(fVarG.c());
        }
        if (fVarG.p()) {
            return shouldRestoreAsLong(fVarG) ? Long.valueOf(fVarG.g()) : Integer.valueOf(fVarG.e());
        }
        if (fVarG.o()) {
            return Double.valueOf(fVarG.d());
        }
        if (fVarG.m()) {
            return fVarG.b().f();
        }
        throw new IllegalArgumentException("FlexBuffers type is not supported: " + fVarG.l());
    }
}
