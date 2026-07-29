package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nFastServiceLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,161:1\n77#1,5:162\n77#1,5:168\n131#1,13:183\n1#2:167\n1360#3:173\n1446#3,5:174\n1549#3:179\n1620#3,3:180\n1064#4,2:196\n*S KotlinDebug\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoader\n*L\n60#1:162,5\n61#1:168,5\n117#1:183,13\n99#1:173\n99#1:174,5\n101#1:179\n101#1:180,3\n153#1:196,2\n*E\n"})
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final m f38813a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final String f38814b = "META-INF/services/";

    public final z a(Class<z> cls, String str) {
        try {
            return cls.cast(Class.forName(str, true, cls.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final <S> S b(String str, ClassLoader classLoader, Class<S> cls) throws ClassNotFoundException {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    public final <S> List<S> c(Class<S> cls, ClassLoader classLoader) {
        try {
            return e(cls, classLoader);
        } catch (Throwable unused) {
            return CollectionsKt___CollectionsKt.Q5(ServiceLoader.load(cls, classLoader));
        }
    }

    @yt.k
    public final List<z> d() {
        z zVar;
        if (!n.a()) {
            return c(z.class, z.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            z zVar2 = null;
            try {
                zVar = (z) z.class.cast(Class.forName("kotlinx.coroutines.android.a", true, z.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                zVar = null;
            }
            if (zVar != null) {
                arrayList.add(zVar);
            }
            try {
                zVar2 = (z) z.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, z.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (zVar2 == null) {
                return arrayList;
            }
            arrayList.add(zVar2);
            return arrayList;
        } catch (Throwable unused3) {
            return c(z.class, z.class.getClassLoader());
        }
    }

    @yt.k
    public final <S> List<S> e(@yt.k Class<S> cls, @yt.k ClassLoader classLoader) {
        ArrayList list = Collections.list(classLoader.getResources(f38814b + cls.getName()));
        kotlin.jvm.internal.f0.o(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            kotlin.collections.x.n0(arrayList, f38813a.f((URL) it2.next()));
        }
        Set setV5 = CollectionsKt___CollectionsKt.V5(arrayList);
        if (!(!setV5.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.t.Y(setV5, 10));
        Iterator it3 = setV5.iterator();
        while (it3.hasNext()) {
            arrayList2.add(f38813a.b((String) it3.next(), classLoader, cls));
        }
        return arrayList2;
    }

    public final List<String> f(URL url) throws IllegalAccessException, InvocationTargetException {
        BufferedReader bufferedReader;
        String string = url.toString();
        if (!kotlin.text.u.v2(string, "jar", false, 2, null)) {
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> listG = f38813a.g(bufferedReader);
                kotlin.io.b.a(bufferedReader, null);
                return listG;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } finally {
                }
            }
        }
        String strX5 = StringsKt__StringsKt.x5(StringsKt__StringsKt.q5(string, "jar:file:", null, 2, null), PublicSuffixDatabase.f43873i, null, 2, null);
        String strQ5 = StringsKt__StringsKt.q5(string, "!/", null, 2, null);
        JarFile jarFile = new JarFile(strX5, false);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(strQ5)), "UTF-8"));
            try {
                List<String> listG2 = f38813a.g(bufferedReader);
                kotlin.io.b.a(bufferedReader, null);
                jarFile.close();
                return listG2;
            } finally {
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                try {
                    jarFile.close();
                    throw th4;
                } catch (Throwable th5) {
                    kotlin.o.a(th3, th5);
                    throw th3;
                }
            }
        }
    }

    public final List<String> g(BufferedReader bufferedReader) throws IOException {
        boolean z10;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return CollectionsKt___CollectionsKt.Q5(linkedHashSet);
            }
            String string = StringsKt__StringsKt.F5(StringsKt__StringsKt.y5(line, "#", null, 2, null)).toString();
            int i10 = 0;
            while (true) {
                if (i10 >= string.length()) {
                    z10 = true;
                    break;
                }
                char cCharAt = string.charAt(i10);
                if (!(cCharAt == '.' || Character.isJavaIdentifierPart(cCharAt))) {
                    z10 = false;
                    break;
                }
                i10++;
            }
            if (!z10) {
                throw new IllegalArgumentException(("Illegal service provider class name: " + string).toString());
            }
            if (string.length() > 0) {
                linkedHashSet.add(string);
            }
        }
    }

    public final <R> R h(JarFile jarFile, ik.l<? super JarFile, ? extends R> lVar) throws IllegalAccessException, InvocationTargetException {
        try {
            R rI = lVar.i(jarFile);
            kotlin.jvm.internal.c0.d(1);
            jarFile.close();
            kotlin.jvm.internal.c0.c(1);
            return rI;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                kotlin.jvm.internal.c0.d(1);
                try {
                    jarFile.close();
                    kotlin.jvm.internal.c0.c(1);
                    throw th3;
                } catch (Throwable th4) {
                    kotlin.o.a(th2, th4);
                    throw th2;
                }
            }
        }
    }
}
