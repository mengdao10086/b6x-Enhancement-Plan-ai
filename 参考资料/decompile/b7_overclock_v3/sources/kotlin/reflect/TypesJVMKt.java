package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.t0;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,230:1\n1#2:231\n1549#3:232\n1620#3,3:233\n1549#3:236\n1620#3,3:237\n1549#3:240\n1620#3,3:241\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n*L\n69#1:232\n69#1:233,3\n71#1:236\n71#1:237,3\n77#1:240\n77#1:241,3\n*E\n"})
public final class TypesJVMKt {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38017a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f38017a = iArr;
        }
    }

    @kotlin.q
    public static final Type c(r rVar, boolean z10) {
        g gVarV0 = rVar.v0();
        if (gVarV0 instanceof s) {
            return new w((s) gVarV0);
        }
        if (!(gVarV0 instanceof d)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + rVar);
        }
        d dVar = (d) gVarV0;
        Class clsG = z10 ? hk.a.g(dVar) : hk.a.e(dVar);
        List<t> listU0 = rVar.u0();
        if (listU0.isEmpty()) {
            return clsG;
        }
        if (!clsG.isArray()) {
            return e(clsG, listU0);
        }
        if (clsG.getComponentType().isPrimitive()) {
            return clsG;
        }
        t tVar = (t) CollectionsKt___CollectionsKt.f5(listU0);
        if (tVar == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + rVar);
        }
        KVariance kVarianceA = tVar.a();
        r rVarB = tVar.b();
        int i10 = kVarianceA == null ? -1 : a.f38017a[kVarianceA.ordinal()];
        if (i10 == -1 || i10 == 1) {
            return clsG;
        }
        if (i10 != 2 && i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        f0.m(rVarB);
        Type typeD = d(rVarB, false, 1, null);
        return typeD instanceof Class ? clsG : new kotlin.reflect.a(typeD);
    }

    public static /* synthetic */ Type d(r rVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return c(rVar, z10);
    }

    @kotlin.q
    public static final Type e(Class<?> cls, List<t> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(g((t) it2.next()));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(kotlin.collections.t.Y(list, 10));
            Iterator<T> it3 = list.iterator();
            while (it3.hasNext()) {
                arrayList2.add(g((t) it3.next()));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeE = e(declaringClass, list.subList(length, list.size()));
        List<t> listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(kotlin.collections.t.Y(listSubList, 10));
        Iterator<T> it4 = listSubList.iterator();
        while (it4.hasNext()) {
            arrayList3.add(g((t) it4.next()));
        }
        return new ParameterizedTypeImpl(cls, typeE, arrayList3);
    }

    @yt.k
    public static final Type f(@yt.k r rVar) {
        Type typeQ;
        f0.p(rVar, "<this>");
        return (!(rVar instanceof g0) || (typeQ = ((g0) rVar).Q()) == null) ? d(rVar, false, 1, null) : typeQ;
    }

    public static final Type g(t tVar) {
        KVariance kVarianceH = tVar.h();
        if (kVarianceH == null) {
            return x.f38026c.a();
        }
        r rVarG = tVar.g();
        f0.m(rVarG);
        int i10 = a.f38017a[kVarianceH.ordinal()];
        if (i10 == 1) {
            return new x(null, c(rVarG, true));
        }
        if (i10 == 2) {
            return c(rVarG, true);
        }
        if (i10 == 3) {
            return new x(c(rVarG, true), null);
        }
        throw new NoWhenBranchMatchedException();
    }

    @v0(version = "1.4")
    @bk.h
    @kotlin.q
    public static /* synthetic */ void h(r rVar) {
    }

    @kotlin.q
    public static /* synthetic */ void i(t tVar) {
    }

    public static final String j(Type type) {
        String name;
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            kotlin.sequences.m mVarN = SequencesKt__SequencesKt.n(type, TypesJVMKt$typeToString$unwrap$1.f38018c);
            name = ((Class) SequencesKt___SequencesKt.f1(mVarN)).getName() + kotlin.text.u.h2(okhttp3.u.f43953p, SequencesKt___SequencesKt.g0(mVarN));
        } else {
            name = cls.getName();
        }
        f0.o(name, "{\n        if (type.isArr…   } else type.name\n    }");
        return name;
    }
}
