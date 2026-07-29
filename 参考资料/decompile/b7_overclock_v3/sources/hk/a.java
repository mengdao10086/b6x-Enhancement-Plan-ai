package hk;

import java.lang.annotation.Annotation;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.t0;
import kotlin.v0;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@h(name = "JvmClassMappingKt")
public final class a {
    @yt.k
    public static final <T extends Annotation> kotlin.reflect.d<? extends T> a(@yt.k T t10) {
        f0.p(t10, "<this>");
        Class<? extends Annotation> clsAnnotationType = t10.annotationType();
        f0.o(clsAnnotationType, "this as java.lang.annota…otation).annotationType()");
        kotlin.reflect.d<? extends T> dVarI = i(clsAnnotationType);
        f0.n(dVarI, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return dVarI;
    }

    public static final <E extends Enum<E>> Class<E> b(Enum<E> r12) {
        f0.p(r12, "<this>");
        Class<E> declaringClass = r12.getDeclaringClass();
        f0.o(declaringClass, "this as java.lang.Enum<E>).declaringClass");
        return declaringClass;
    }

    @bk.f
    @v0(version = "1.7")
    public static /* synthetic */ void c(Enum r02) {
    }

    @yt.k
    public static final <T> Class<T> d(@yt.k T t10) {
        f0.p(t10, "<this>");
        Class<T> cls = (Class<T>) t10.getClass();
        f0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return cls;
    }

    @h(name = "getJavaClass")
    @yt.k
    public static final <T> Class<T> e(@yt.k kotlin.reflect.d<T> dVar) {
        f0.p(dVar, "<this>");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.r) dVar).h();
        f0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return cls;
    }

    public static /* synthetic */ void f(kotlin.reflect.d dVar) {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @yt.k
    public static final <T> Class<T> g(@yt.k kotlin.reflect.d<T> dVar) {
        f0.p(dVar, "<this>");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.r) dVar).h();
        if (!cls.isPrimitive()) {
            f0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    cls = (Class<T>) Double.class;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    cls = (Class<T>) Integer.class;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    cls = (Class<T>) Byte.class;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    cls = (Class<T>) Character.class;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    cls = (Class<T>) Long.class;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    cls = (Class<T>) Void.class;
                }
                break;
            case 64711720:
                if (name.equals(w.b.f53670f)) {
                    cls = (Class<T>) Boolean.class;
                }
                break;
            case 97526364:
                if (name.equals(w.b.f53667c)) {
                    cls = (Class<T>) Float.class;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    cls = (Class<T>) Short.class;
                }
                break;
        }
        f0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return cls;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @yt.l
    public static final <T> Class<T> h(@yt.k kotlin.reflect.d<T> dVar) {
        f0.p(dVar, "<this>");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.r) dVar).h();
        if (cls.isPrimitive()) {
            f0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    @h(name = "getKotlinClass")
    @yt.k
    public static final <T> kotlin.reflect.d<T> i(@yt.k Class<T> cls) {
        f0.p(cls, "<this>");
        return n0.d(cls);
    }

    @h(name = "getRuntimeClassOfKClassInstance")
    @yt.k
    public static final <T> Class<kotlin.reflect.d<T>> j(@yt.k kotlin.reflect.d<T> dVar) {
        f0.p(dVar, "<this>");
        Class<kotlin.reflect.d<T>> cls = (Class<kotlin.reflect.d<T>>) dVar.getClass();
        f0.n(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return cls;
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @t0(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void k(kotlin.reflect.d dVar) {
    }

    public static final /* synthetic */ boolean l(Object[] objArr) {
        f0.p(objArr, "<this>");
        f0.y(4, i1.a.f31577d5);
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }
}
