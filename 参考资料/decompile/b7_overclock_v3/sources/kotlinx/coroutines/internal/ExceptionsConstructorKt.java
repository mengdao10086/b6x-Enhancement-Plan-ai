package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.d1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,116:1\n1#2:117\n11335#3:118\n11670#3,3:119\n12904#3,3:136\n1963#4,14:122\n*S KotlinDebug\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n*L\n45#1:118\n45#1:119,3\n82#1:136,3\n63#1:122,14\n*E\n"})
public final class ExceptionsConstructorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38759a = e(Throwable.class, -1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final j f38760b;

    static {
        j jVar;
        try {
            jVar = n.a() ? a1.f38779a : c.f38785a;
        } catch (Throwable unused) {
            jVar = a1.f38779a;
        }
        f38760b = jVar;
    }

    public static final <E extends Throwable> ik.l<Throwable, Throwable> b(Class<E> cls) {
        Object next;
        ik.l<Throwable, Throwable> lVar;
        Pair pairA;
        ExceptionsConstructorKt$createConstructor$nullResult$1 exceptionsConstructorKt$createConstructor$nullResult$1 = new ik.l() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$nullResult$1
            @Override // ik.l
            @yt.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Void i(@yt.k Throwable th2) {
                return null;
            }
        };
        if (f38759a != e(cls, 0)) {
            return exceptionsConstructorKt$createConstructor$nullResult$1;
        }
        Constructor<?>[] constructors = cls.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.length);
        int length = constructors.length;
        int i10 = 0;
        while (true) {
            next = null;
            if (i10 >= length) {
                break;
            }
            final Constructor<?> constructor = constructors[i10];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            int length2 = parameterTypes.length;
            if (length2 == 0) {
                pairA = d1.a(f(new ik.l<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // ik.l
                    @yt.k
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Throwable i(@yt.k Throwable th2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
                        Object objNewInstance = constructor.newInstance(new Object[0]);
                        kotlin.jvm.internal.f0.n(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                        Throwable th3 = (Throwable) objNewInstance;
                        th3.initCause(th2);
                        return th3;
                    }
                }), 0);
            } else if (length2 != 1) {
                pairA = length2 != 2 ? d1.a(null, -1) : (kotlin.jvm.internal.f0.g(parameterTypes[0], String.class) && kotlin.jvm.internal.f0.g(parameterTypes[1], Throwable.class)) ? d1.a(f(new ik.l<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // ik.l
                    @yt.k
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Throwable i(@yt.k Throwable th2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
                        Object objNewInstance = constructor.newInstance(th2.getMessage(), th2);
                        kotlin.jvm.internal.f0.n(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                        return (Throwable) objNewInstance;
                    }
                }), 3) : d1.a(null, -1);
            } else {
                Class<?> cls2 = parameterTypes[0];
                pairA = kotlin.jvm.internal.f0.g(cls2, String.class) ? d1.a(f(new ik.l<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // ik.l
                    @yt.k
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Throwable i(@yt.k Throwable th2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
                        Object objNewInstance = constructor.newInstance(th2.getMessage());
                        kotlin.jvm.internal.f0.n(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                        Throwable th3 = (Throwable) objNewInstance;
                        th3.initCause(th2);
                        return th3;
                    }
                }), 2) : kotlin.jvm.internal.f0.g(cls2, Throwable.class) ? d1.a(f(new ik.l<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // ik.l
                    @yt.k
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Throwable i(@yt.k Throwable th2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
                        Object objNewInstance = constructor.newInstance(th2);
                        kotlin.jvm.internal.f0.n(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
                        return (Throwable) objNewInstance;
                    }
                }), 1) : d1.a(null, -1);
            }
            arrayList.add(pairA);
            i10++;
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                int iIntValue = ((Number) ((Pair) next).h()).intValue();
                do {
                    Object next2 = it2.next();
                    int iIntValue2 = ((Number) ((Pair) next2).h()).intValue();
                    if (iIntValue < iIntValue2) {
                        next = next2;
                        iIntValue = iIntValue2;
                    }
                } while (it2.hasNext());
            }
        }
        Pair pair = (Pair) next;
        return (pair == null || (lVar = (ik.l) pair.f()) == null) ? exceptionsConstructorKt$createConstructor$nullResult$1 : lVar;
    }

    public static final int c(Class<?> cls, int i10) {
        do {
            int length = cls.getDeclaredFields().length;
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                if (!Modifier.isStatic(r0[i12].getModifiers())) {
                    i11++;
                }
            }
            i10 += i11;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i10;
    }

    public static /* synthetic */ int d(Class cls, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return c(cls, i10);
    }

    public static final int e(Class<?> cls, int i10) {
        Object objB;
        hk.a.i(cls);
        try {
            Result.a aVar = Result.f37633a;
            objB = Result.b(Integer.valueOf(d(cls, 0, 1, null)));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            objB = Result.b(kotlin.u0.a(th2));
        }
        Integer numValueOf = Integer.valueOf(i10);
        if (Result.l(objB)) {
            objB = numValueOf;
        }
        return ((Number) objB).intValue();
    }

    public static final ik.l<Throwable, Throwable> f(final ik.l<? super Throwable, ? extends Throwable> lVar) {
        return new ik.l<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$safeCtor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // ik.l
            @yt.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Throwable i(@yt.k Throwable th2) {
                Object objB;
                ik.l<Throwable, Throwable> lVar2 = lVar;
                try {
                    Result.a aVar = Result.f37633a;
                    Throwable thI = lVar2.i(th2);
                    if (!kotlin.jvm.internal.f0.g(th2.getMessage(), thI.getMessage()) && !kotlin.jvm.internal.f0.g(thI.getMessage(), th2.toString())) {
                        thI = null;
                    }
                    objB = Result.b(thI);
                } catch (Throwable th3) {
                    Result.a aVar2 = Result.f37633a;
                    objB = Result.b(kotlin.u0.a(th3));
                }
                return (Throwable) (Result.l(objB) ? null : objB);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.l
    public static final <E extends Throwable> E g(@yt.k E e10) {
        Object objB;
        if (!(e10 instanceof kotlinx.coroutines.j0)) {
            return (E) f38760b.a(e10.getClass()).i(e10);
        }
        try {
            Result.a aVar = Result.f37633a;
            objB = Result.b(((kotlinx.coroutines.j0) e10).a());
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            objB = Result.b(kotlin.u0.a(th2));
        }
        if (Result.l(objB)) {
            objB = null;
        }
        return (E) objB;
    }
}
