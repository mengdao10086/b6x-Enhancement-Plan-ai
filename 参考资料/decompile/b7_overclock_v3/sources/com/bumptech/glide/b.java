package com.bumptech.glide;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.c;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bitmap.c0;
import com.bumptech.glide.load.resource.bitmap.e0;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.load.resource.bitmap.w;
import com.bumptech.glide.load.resource.bitmap.y;
import com.bumptech.glide.load.resource.bitmap.z;
import g.b0;
import g.i1;
import g.n0;
import g.p0;
import g4.d;
import h4.a;
import h4.b;
import h4.d;
import h4.e;
import h4.f;
import h4.k;
import h4.s;
import h4.t;
import h4.u;
import h4.v;
import h4.w;
import h4.x;
import i4.b;
import i4.d;
import i4.e;
import i4.f;
import i4.g;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k4.a;
import p4.p;
import v4.m;

/* JADX INFO: loaded from: classes2.dex */
public class b implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f12075m = "image_manager_disk_cache";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f12076n = "Glide";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @b0("Glide.class")
    public static volatile b f12077o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile boolean f12078p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.i f12079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f12080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e4.j f12081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f12082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Registry f12083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f12084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p f12085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p4.d f12086h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f12088j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    @b0("this")
    public g4.b f12090l;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @b0("managers")
    public final List<i> f12087i = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MemoryCategory f12089k = MemoryCategory.NORMAL;

    public interface a {
        @n0
        com.bumptech.glide.request.h a();
    }

    public b(@n0 Context context, @n0 com.bumptech.glide.load.engine.i iVar, @n0 e4.j jVar, @n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar, @n0 p pVar, @n0 p4.d dVar, int i10, @n0 a aVar, @n0 Map<Class<?>, j<?, ?>> map, @n0 List<com.bumptech.glide.request.g<Object>> list, e eVar2) {
        Object obj;
        c4.f c0Var;
        c4.f kVar;
        int i11;
        this.f12079a = iVar;
        this.f12080b = eVar;
        this.f12084f = bVar;
        this.f12081c = jVar;
        this.f12085g = pVar;
        this.f12086h = dVar;
        this.f12088j = aVar;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f12083e = registry;
        registry.t(new DefaultImageHeaderParser());
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 27) {
            registry.t(new r());
        }
        List<ImageHeaderParser> listG = registry.g();
        n4.a aVar2 = new n4.a(context, listG, eVar, bVar);
        c4.f<ParcelFileDescriptor, Bitmap> fVarH = VideoDecoder.h(eVar);
        o oVar = new o(registry.g(), resources.getDisplayMetrics(), eVar, bVar);
        if (i12 < 28 || !eVar2.b(c.d.class)) {
            com.bumptech.glide.load.resource.bitmap.j jVar2 = new com.bumptech.glide.load.resource.bitmap.j(oVar);
            obj = String.class;
            c0Var = new c0(oVar, bVar);
            kVar = jVar2;
        } else {
            c0Var = new w();
            kVar = new k();
            obj = String.class;
        }
        if (i12 < 28 || !eVar2.b(c.C0118c.class)) {
            i11 = i12;
        } else {
            i11 = i12;
            registry.e("Animation", InputStream.class, Drawable.class, l4.a.f(listG, bVar));
            registry.e("Animation", ByteBuffer.class, Drawable.class, l4.a.a(listG, bVar));
        }
        l4.f fVar = new l4.f(context);
        s.c cVar = new s.c(resources);
        s.d dVar2 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar3 = new s.a(resources);
        com.bumptech.glide.load.resource.bitmap.e eVar3 = new com.bumptech.glide.load.resource.bitmap.e(bVar);
        o4.a aVar4 = new o4.a();
        o4.d dVar3 = new o4.d();
        ContentResolver contentResolver = context.getContentResolver();
        registry.a(ByteBuffer.class, new h4.c()).a(InputStream.class, new t(bVar)).e(Registry.f12061m, ByteBuffer.class, Bitmap.class, kVar).e(Registry.f12061m, InputStream.class, Bitmap.class, c0Var);
        if (ParcelFileDescriptorRewinder.c()) {
            registry.e(Registry.f12061m, ParcelFileDescriptor.class, Bitmap.class, new y(oVar));
        }
        registry.e(Registry.f12061m, ParcelFileDescriptor.class, Bitmap.class, fVarH).e(Registry.f12061m, AssetFileDescriptor.class, Bitmap.class, VideoDecoder.c(eVar)).d(Bitmap.class, Bitmap.class, v.a.b()).e(Registry.f12061m, Bitmap.class, Bitmap.class, new e0()).b(Bitmap.class, eVar3).e(Registry.f12062n, ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, kVar)).e(Registry.f12062n, InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, c0Var)).e(Registry.f12062n, ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, fVarH)).b(BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.b(eVar, eVar3)).e("Animation", InputStream.class, n4.c.class, new n4.j(listG, aVar2, bVar)).e("Animation", ByteBuffer.class, n4.c.class, aVar2).b(n4.c.class, new n4.d()).d(a4.a.class, a4.a.class, v.a.b()).e(Registry.f12061m, a4.a.class, Bitmap.class, new n4.h(eVar)).c(Uri.class, Drawable.class, fVar).c(Uri.class, Bitmap.class, new z(fVar, eVar)).u(new a.C0419a()).d(File.class, ByteBuffer.class, new d.b()).d(File.class, InputStream.class, new f.e()).c(File.class, File.class, new m4.a()).d(File.class, ParcelFileDescriptor.class, new f.b()).d(File.class, File.class, v.a.b()).u(new k.a(bVar));
        if (ParcelFileDescriptorRewinder.c()) {
            registry.u(new ParcelFileDescriptorRewinder.a());
        }
        Class cls = Integer.TYPE;
        Object obj2 = obj;
        registry.d(cls, InputStream.class, cVar).d(cls, ParcelFileDescriptor.class, bVar2).d(Integer.class, InputStream.class, cVar).d(Integer.class, ParcelFileDescriptor.class, bVar2).d(Integer.class, Uri.class, dVar2).d(cls, AssetFileDescriptor.class, aVar3).d(Integer.class, AssetFileDescriptor.class, aVar3).d(cls, Uri.class, dVar2).d(obj2, InputStream.class, new e.c()).d(Uri.class, InputStream.class, new e.c()).d(obj2, InputStream.class, new u.c()).d(obj2, ParcelFileDescriptor.class, new u.b()).d(obj2, AssetFileDescriptor.class, new u.a()).d(Uri.class, InputStream.class, new a.c(context.getAssets())).d(Uri.class, AssetFileDescriptor.class, new a.b(context.getAssets())).d(Uri.class, InputStream.class, new d.a(context)).d(Uri.class, InputStream.class, new e.a(context));
        int i13 = i11;
        if (i13 >= 29) {
            registry.d(Uri.class, InputStream.class, new f.c(context));
            registry.d(Uri.class, ParcelFileDescriptor.class, new f.b(context));
        }
        registry.d(Uri.class, InputStream.class, new w.d(contentResolver)).d(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).d(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).d(Uri.class, InputStream.class, new x.a()).d(URL.class, InputStream.class, new g.a()).d(Uri.class, File.class, new k.a(context)).d(h4.g.class, InputStream.class, new b.a()).d(byte[].class, ByteBuffer.class, new b.a()).d(byte[].class, InputStream.class, new b.d()).d(Uri.class, Uri.class, v.a.b()).d(Drawable.class, Drawable.class, v.a.b()).c(Drawable.class, Drawable.class, new l4.g()).x(Bitmap.class, BitmapDrawable.class, new o4.b(resources)).x(Bitmap.class, byte[].class, aVar4).x(Drawable.class, byte[].class, new o4.c(eVar, aVar4, dVar3)).x(n4.c.class, byte[].class, dVar3);
        if (i13 >= 23) {
            c4.f<ByteBuffer, Bitmap> fVarD = VideoDecoder.d(eVar);
            registry.c(ByteBuffer.class, Bitmap.class, fVarD);
            registry.c(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, fVarD));
        }
        this.f12082d = new d(context, bVar, registry, new s4.k(), aVar, map, list, iVar, eVar2, i10);
    }

    @n0
    public static i C(@n0 Activity activity) {
        return p(activity).j(activity);
    }

    @n0
    @Deprecated
    public static i D(@n0 Fragment fragment) {
        return p(fragment.getActivity()).k(fragment);
    }

    @n0
    public static i E(@n0 Context context) {
        return p(context).l(context);
    }

    @n0
    public static i F(@n0 View view) {
        return p(view.getContext()).m(view);
    }

    @n0
    public static i G(@n0 androidx.fragment.app.Fragment fragment) {
        return p(fragment.X1()).n(fragment);
    }

    @n0
    public static i H(@n0 androidx.fragment.app.g gVar) {
        return p(gVar).o(gVar);
    }

    @b0("Glide.class")
    public static void a(@n0 Context context, @p0 GeneratedAppGlideModule generatedAppGlideModule) {
        if (f12078p) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        f12078p = true;
        s(context, generatedAppGlideModule);
        f12078p = false;
    }

    @i1
    public static void d() {
        com.bumptech.glide.load.resource.bitmap.u.d().l();
    }

    @n0
    public static b e(@n0 Context context) {
        if (f12077o == null) {
            GeneratedAppGlideModule generatedAppGlideModuleF = f(context.getApplicationContext());
            synchronized (b.class) {
                if (f12077o == null) {
                    a(context, generatedAppGlideModuleF);
                }
            }
        }
        return f12077o;
    }

    @p0
    public static GeneratedAppGlideModule f(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (IllegalAccessException e10) {
            z(e10);
            return null;
        } catch (InstantiationException e11) {
            z(e11);
            return null;
        } catch (NoSuchMethodException e12) {
            z(e12);
            return null;
        } catch (InvocationTargetException e13) {
            z(e13);
            return null;
        }
    }

    @p0
    public static File l(@n0 Context context) {
        return m(context, "image_manager_disk_cache");
    }

    @p0
    public static File m(@n0 Context context, @n0 String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        File file = new File(cacheDir, str);
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    @n0
    public static p p(@p0 Context context) {
        m.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return e(context).o();
    }

    @i1
    public static void q(@n0 Context context, @n0 c cVar) {
        GeneratedAppGlideModule generatedAppGlideModuleF = f(context);
        synchronized (b.class) {
            if (f12077o != null) {
                y();
            }
            t(context, cVar, generatedAppGlideModuleF);
        }
    }

    @i1
    @Deprecated
    public static synchronized void r(b bVar) {
        if (f12077o != null) {
            y();
        }
        f12077o = bVar;
    }

    @b0("Glide.class")
    public static void s(@n0 Context context, @p0 GeneratedAppGlideModule generatedAppGlideModule) {
        t(context, new c(), generatedAppGlideModule);
    }

    @b0("Glide.class")
    public static void t(@n0 Context context, @n0 c cVar, @p0 GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<q4.c> listEmptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            listEmptyList = new q4.e(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> setD = generatedAppGlideModule.d();
            Iterator<q4.c> it2 = listEmptyList.iterator();
            while (it2.hasNext()) {
                q4.c next = it2.next();
                if (setD.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("AppGlideModule excludes manifest GlideModule: ");
                        sb2.append(next);
                    }
                    it2.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (q4.c cVar2 : listEmptyList) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Discovered GlideModule from manifest: ");
                sb3.append(cVar2.getClass());
            }
        }
        cVar.u(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        Iterator<q4.c> it3 = listEmptyList.iterator();
        while (it3.hasNext()) {
            it3.next().a(applicationContext, cVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, cVar);
        }
        b bVarB = cVar.b(applicationContext);
        for (q4.c cVar3 : listEmptyList) {
            try {
                cVar3.b(applicationContext, bVarB, bVarB.f12083e);
            } catch (AbstractMethodError e10) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + cVar3.getClass().getName(), e10);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, bVarB, bVarB.f12083e);
        }
        applicationContext.registerComponentCallbacks(bVarB);
        f12077o = bVarB;
    }

    @i1
    public static void y() {
        synchronized (b.class) {
            if (f12077o != null) {
                f12077o.j().getApplicationContext().unregisterComponentCallbacks(f12077o);
                f12077o.f12079a.m();
            }
            f12077o = null;
        }
    }

    public static void z(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public void A(int i10) {
        v4.o.b();
        synchronized (this.f12087i) {
            Iterator<i> it2 = this.f12087i.iterator();
            while (it2.hasNext()) {
                it2.next().onTrimMemory(i10);
            }
        }
        this.f12081c.b(i10);
        this.f12080b.b(i10);
        this.f12084f.b(i10);
    }

    public void B(i iVar) {
        synchronized (this.f12087i) {
            if (!this.f12087i.contains(iVar)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.f12087i.remove(iVar);
        }
    }

    public void b() {
        v4.o.a();
        this.f12079a.e();
    }

    public void c() {
        v4.o.b();
        this.f12081c.c();
        this.f12080b.c();
        this.f12084f.c();
    }

    @n0
    public com.bumptech.glide.load.engine.bitmap_recycle.b g() {
        return this.f12084f;
    }

    @n0
    public com.bumptech.glide.load.engine.bitmap_recycle.e h() {
        return this.f12080b;
    }

    public p4.d i() {
        return this.f12086h;
    }

    @n0
    public Context j() {
        return this.f12082d.getBaseContext();
    }

    @n0
    public d k() {
        return this.f12082d;
    }

    @n0
    public Registry n() {
        return this.f12083e;
    }

    @n0
    public p o() {
        return this.f12085g;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        c();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        A(i10);
    }

    public synchronized void u(@n0 d.a... aVarArr) {
        if (this.f12090l == null) {
            this.f12090l = new g4.b(this.f12081c, this.f12080b, (DecodeFormat) this.f12088j.a().L().c(o.f12607g));
        }
        this.f12090l.c(aVarArr);
    }

    public void v(i iVar) {
        synchronized (this.f12087i) {
            if (this.f12087i.contains(iVar)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.f12087i.add(iVar);
        }
    }

    public boolean w(@n0 s4.p<?> pVar) {
        synchronized (this.f12087i) {
            Iterator<i> it2 = this.f12087i.iterator();
            while (it2.hasNext()) {
                if (it2.next().c0(pVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    @n0
    public MemoryCategory x(@n0 MemoryCategory memoryCategory) {
        v4.o.b();
        this.f12081c.d(memoryCategory.getMultiplier());
        this.f12080b.d(memoryCategory.getMultiplier());
        MemoryCategory memoryCategory2 = this.f12089k;
        this.f12089k = memoryCategory;
        return memoryCategory2;
    }
}
