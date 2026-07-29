package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.b;
import g.b0;
import g.i1;
import g.n0;
import g.p0;
import java.util.List;
import java.util.Map;
import s4.k;
import s4.r;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ContextWrapper {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @i1
    public static final j<?, ?> f12112k = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f12113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Registry f12114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f12115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b.a f12116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.bumptech.glide.request.g<Object>> f12117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Class<?>, j<?, ?>> f12118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.i f12119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f12120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f12121i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    @b0("this")
    public com.bumptech.glide.request.h f12122j;

    public d(@n0 Context context, @n0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar, @n0 Registry registry, @n0 k kVar, @n0 b.a aVar, @n0 Map<Class<?>, j<?, ?>> map, @n0 List<com.bumptech.glide.request.g<Object>> list, @n0 com.bumptech.glide.load.engine.i iVar, @n0 e eVar, int i10) {
        super(context.getApplicationContext());
        this.f12113a = bVar;
        this.f12114b = registry;
        this.f12115c = kVar;
        this.f12116d = aVar;
        this.f12117e = list;
        this.f12118f = map;
        this.f12119g = iVar;
        this.f12120h = eVar;
        this.f12121i = i10;
    }

    @n0
    public <X> r<ImageView, X> a(@n0 ImageView imageView, @n0 Class<X> cls) {
        return this.f12115c.a(imageView, cls);
    }

    @n0
    public com.bumptech.glide.load.engine.bitmap_recycle.b b() {
        return this.f12113a;
    }

    public List<com.bumptech.glide.request.g<Object>> c() {
        return this.f12117e;
    }

    public synchronized com.bumptech.glide.request.h d() {
        if (this.f12122j == null) {
            this.f12122j = this.f12116d.a().s0();
        }
        return this.f12122j;
    }

    @n0
    public <T> j<?, T> e(@n0 Class<T> cls) {
        j<?, T> jVar = (j) this.f12118f.get(cls);
        if (jVar == null) {
            for (Map.Entry<Class<?>, j<?, ?>> entry : this.f12118f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    jVar = (j) entry.getValue();
                }
            }
        }
        return jVar == null ? (j<?, T>) f12112k : jVar;
    }

    @n0
    public com.bumptech.glide.load.engine.i f() {
        return this.f12119g;
    }

    public e g() {
        return this.f12120h;
    }

    public int h() {
        return this.f12121i;
    }

    @n0
    public Registry i() {
        return this.f12114b;
    }
}
