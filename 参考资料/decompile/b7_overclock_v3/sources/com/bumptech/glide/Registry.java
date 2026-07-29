package com.bumptech.glide;

import androidx.core.util.n;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.s;
import g.n0;
import g.p0;
import h4.o;
import h4.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Registry {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12059k = "Animation";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Deprecated
    public static final String f12060l = "Animation";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f12061m = "Bitmap";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f12062n = "BitmapDrawable";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f12063o = "legacy_prepend_all";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f12064p = "legacy_append";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f12065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r4.a f12066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r4.e f12067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r4.f f12068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bumptech.glide.load.data.f f12069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o4.f f12070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r4.b f12071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final r4.d f12072h = new r4.d();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final r4.c f12073i = new r4.c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final n.a<List<Throwable>> f12074j;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@n0 String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@n0 Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(@n0 M m10, @n0 List<h4.n<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m10);
        }

        public NoModelLoaderAvailableException(@n0 Class<?> cls, @n0 Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@n0 Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@n0 Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        n.a<List<Throwable>> aVarF = w4.a.f();
        this.f12074j = aVarF;
        this.f12065a = new p(aVarF);
        this.f12066b = new r4.a();
        this.f12067c = new r4.e();
        this.f12068d = new r4.f();
        this.f12069e = new com.bumptech.glide.load.data.f();
        this.f12070f = new o4.f();
        this.f12071g = new r4.b();
        z(Arrays.asList("Animation", f12061m, f12062n));
    }

    @n0
    public <Data> Registry a(@n0 Class<Data> cls, @n0 c4.a<Data> aVar) {
        this.f12066b.a(cls, aVar);
        return this;
    }

    @n0
    public <TResource> Registry b(@n0 Class<TResource> cls, @n0 c4.g<TResource> gVar) {
        this.f12068d.a(cls, gVar);
        return this;
    }

    @n0
    public <Data, TResource> Registry c(@n0 Class<Data> cls, @n0 Class<TResource> cls2, @n0 c4.f<Data, TResource> fVar) {
        e(f12064p, cls, cls2, fVar);
        return this;
    }

    @n0
    public <Model, Data> Registry d(@n0 Class<Model> cls, @n0 Class<Data> cls2, @n0 o<Model, Data> oVar) {
        this.f12065a.a(cls, cls2, oVar);
        return this;
    }

    @n0
    public <Data, TResource> Registry e(@n0 String str, @n0 Class<Data> cls, @n0 Class<TResource> cls2, @n0 c4.f<Data, TResource> fVar) {
        this.f12067c.a(str, fVar, cls, cls2);
        return this;
    }

    @n0
    public final <Data, TResource, Transcode> List<com.bumptech.glide.load.engine.g<Data, TResource, Transcode>> f(@n0 Class<Data> cls, @n0 Class<TResource> cls2, @n0 Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f12067c.d(cls, cls2)) {
            for (Class cls5 : this.f12070f.b(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.load.engine.g(cls, cls4, cls5, this.f12067c.b(cls, cls4), this.f12070f.a(cls4, cls5), this.f12074j));
            }
        }
        return arrayList;
    }

    @n0
    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> listB = this.f12071g.b();
        if (listB.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return listB;
    }

    @p0
    public <Data, TResource, Transcode> q<Data, TResource, Transcode> h(@n0 Class<Data> cls, @n0 Class<TResource> cls2, @n0 Class<Transcode> cls3) {
        q<Data, TResource, Transcode> qVarA = this.f12073i.a(cls, cls2, cls3);
        if (this.f12073i.c(qVarA)) {
            return null;
        }
        if (qVarA == null) {
            List<com.bumptech.glide.load.engine.g<Data, TResource, Transcode>> listF = f(cls, cls2, cls3);
            qVarA = listF.isEmpty() ? null : new q<>(cls, cls2, cls3, listF, this.f12074j);
            this.f12073i.d(cls, cls2, cls3, qVarA);
        }
        return qVarA;
    }

    @n0
    public <Model> List<h4.n<Model, ?>> i(@n0 Model model) {
        return this.f12065a.e(model);
    }

    @n0
    public <Model, TResource, Transcode> List<Class<?>> j(@n0 Class<Model> cls, @n0 Class<TResource> cls2, @n0 Class<Transcode> cls3) {
        List<Class<?>> listB = this.f12072h.b(cls, cls2, cls3);
        if (listB == null) {
            listB = new ArrayList<>();
            Iterator<Class<?>> it2 = this.f12065a.d(cls).iterator();
            while (it2.hasNext()) {
                for (Class<?> cls4 : this.f12067c.d(it2.next(), cls2)) {
                    if (!this.f12070f.b(cls4, cls3).isEmpty() && !listB.contains(cls4)) {
                        listB.add(cls4);
                    }
                }
            }
            this.f12072h.c(cls, cls2, cls3, Collections.unmodifiableList(listB));
        }
        return listB;
    }

    @n0
    public <X> c4.g<X> k(@n0 s<X> sVar) throws NoResultEncoderAvailableException {
        c4.g<X> gVarB = this.f12068d.b(sVar.d());
        if (gVarB != null) {
            return gVarB;
        }
        throw new NoResultEncoderAvailableException(sVar.d());
    }

    @n0
    public <X> com.bumptech.glide.load.data.e<X> l(@n0 X x10) {
        return this.f12069e.a(x10);
    }

    @n0
    public <X> c4.a<X> m(@n0 X x10) throws NoSourceEncoderAvailableException {
        c4.a<X> aVarB = this.f12066b.b(x10.getClass());
        if (aVarB != null) {
            return aVarB;
        }
        throw new NoSourceEncoderAvailableException(x10.getClass());
    }

    public boolean n(@n0 s<?> sVar) {
        return this.f12068d.b(sVar.d()) != null;
    }

    @n0
    public <Data> Registry o(@n0 Class<Data> cls, @n0 c4.a<Data> aVar) {
        this.f12066b.c(cls, aVar);
        return this;
    }

    @n0
    public <TResource> Registry p(@n0 Class<TResource> cls, @n0 c4.g<TResource> gVar) {
        this.f12068d.c(cls, gVar);
        return this;
    }

    @n0
    public <Data, TResource> Registry q(@n0 Class<Data> cls, @n0 Class<TResource> cls2, @n0 c4.f<Data, TResource> fVar) {
        s(f12063o, cls, cls2, fVar);
        return this;
    }

    @n0
    public <Model, Data> Registry r(@n0 Class<Model> cls, @n0 Class<Data> cls2, @n0 o<Model, Data> oVar) {
        this.f12065a.g(cls, cls2, oVar);
        return this;
    }

    @n0
    public <Data, TResource> Registry s(@n0 String str, @n0 Class<Data> cls, @n0 Class<TResource> cls2, @n0 c4.f<Data, TResource> fVar) {
        this.f12067c.e(str, fVar, cls, cls2);
        return this;
    }

    @n0
    public Registry t(@n0 ImageHeaderParser imageHeaderParser) {
        this.f12071g.a(imageHeaderParser);
        return this;
    }

    @n0
    public Registry u(@n0 e.a<?> aVar) {
        this.f12069e.b(aVar);
        return this;
    }

    @n0
    @Deprecated
    public <Data> Registry v(@n0 Class<Data> cls, @n0 c4.a<Data> aVar) {
        return a(cls, aVar);
    }

    @n0
    @Deprecated
    public <TResource> Registry w(@n0 Class<TResource> cls, @n0 c4.g<TResource> gVar) {
        return b(cls, gVar);
    }

    @n0
    public <TResource, Transcode> Registry x(@n0 Class<TResource> cls, @n0 Class<Transcode> cls2, @n0 o4.e<TResource, Transcode> eVar) {
        this.f12070f.c(cls, cls2, eVar);
        return this;
    }

    @n0
    public <Model, Data> Registry y(@n0 Class<Model> cls, @n0 Class<Data> cls2, @n0 o<? extends Model, ? extends Data> oVar) {
        this.f12065a.i(cls, cls2, oVar);
        return this;
    }

    @n0
    public final Registry z(@n0 List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add(f12063o);
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        arrayList.add(f12064p);
        this.f12067c.f(arrayList);
        return this;
    }
}
