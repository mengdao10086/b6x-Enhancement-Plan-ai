package com.bumptech.glide.load.engine;

import androidx.core.util.n;
import com.bumptech.glide.load.engine.g;
import g.n0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class q<Data, ResourceType, Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<Data> f12462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n.a<List<Throwable>> f12463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<? extends g<Data, ResourceType, Transcode>> f12464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12465d;

    public q(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<g<Data, ResourceType, Transcode>> list, n.a<List<Throwable>> aVar) {
        this.f12462a = cls;
        this.f12463b = aVar;
        this.f12464c = (List) v4.m.c(list);
        this.f12465d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + zc.a.f58317e;
    }

    public Class<Data> a() {
        return this.f12462a;
    }

    public s<Transcode> b(com.bumptech.glide.load.data.e<Data> eVar, @n0 c4.e eVar2, int i10, int i11, g.a<ResourceType> aVar) throws GlideException {
        List<Throwable> list = (List) v4.m.d(this.f12463b.a());
        try {
            return c(eVar, eVar2, i10, i11, aVar, list);
        } finally {
            this.f12463b.b(list);
        }
    }

    public final s<Transcode> c(com.bumptech.glide.load.data.e<Data> eVar, @n0 c4.e eVar2, int i10, int i11, g.a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        int size = this.f12464c.size();
        s<Transcode> sVarA = null;
        for (int i12 = 0; i12 < size; i12++) {
            try {
                sVarA = this.f12464c.get(i12).a(eVar, i10, i11, eVar2, aVar);
            } catch (GlideException e10) {
                list.add(e10);
            }
            if (sVarA != null) {
                break;
            }
        }
        if (sVarA != null) {
            return sVarA;
        }
        throw new GlideException(this.f12465d, new ArrayList(list));
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f12464c.toArray()) + '}';
    }
}
