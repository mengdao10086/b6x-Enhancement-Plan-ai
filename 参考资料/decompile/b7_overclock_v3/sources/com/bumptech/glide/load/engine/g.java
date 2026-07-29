package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.n;
import g.n0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g<DataType, ResourceType, Transcode> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f12372f = "DecodePath";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<DataType> f12373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<? extends c4.f<DataType, ResourceType>> f12374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o4.e<ResourceType, Transcode> f12375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n.a<List<Throwable>> f12376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f12377e;

    public interface a<ResourceType> {
        @n0
        s<ResourceType> a(@n0 s<ResourceType> sVar);
    }

    public g(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends c4.f<DataType, ResourceType>> list, o4.e<ResourceType, Transcode> eVar, n.a<List<Throwable>> aVar) {
        this.f12373a = cls;
        this.f12374b = list;
        this.f12375c = eVar;
        this.f12376d = aVar;
        this.f12377e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + zc.a.f58317e;
    }

    public s<Transcode> a(com.bumptech.glide.load.data.e<DataType> eVar, int i10, int i11, @n0 c4.e eVar2, a<ResourceType> aVar) throws GlideException {
        return this.f12375c.a(aVar.a(b(eVar, i10, i11, eVar2)), eVar2);
    }

    @n0
    public final s<ResourceType> b(com.bumptech.glide.load.data.e<DataType> eVar, int i10, int i11, @n0 c4.e eVar2) throws GlideException {
        List<Throwable> list = (List) v4.m.d(this.f12376d.a());
        try {
            return c(eVar, i10, i11, eVar2, list);
        } finally {
            this.f12376d.b(list);
        }
    }

    @n0
    public final s<ResourceType> c(com.bumptech.glide.load.data.e<DataType> eVar, int i10, int i11, @n0 c4.e eVar2, List<Throwable> list) throws GlideException {
        int size = this.f12374b.size();
        s<ResourceType> sVarB = null;
        for (int i12 = 0; i12 < size; i12++) {
            c4.f<DataType, ResourceType> fVar = this.f12374b.get(i12);
            try {
                if (fVar.a(eVar.a(), eVar2)) {
                    sVarB = fVar.b(eVar.a(), i10, i11, eVar2);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e10) {
                if (Log.isLoggable(f12372f, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to decode data for ");
                    sb2.append(fVar);
                }
                list.add(e10);
            }
            if (sVarB != null) {
                break;
            }
        }
        if (sVarB != null) {
            return sVarB;
        }
        throw new GlideException(this.f12377e, new ArrayList(list));
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f12373a + ", decoders=" + this.f12374b + ", transcoder=" + this.f12375c + '}';
    }
}
