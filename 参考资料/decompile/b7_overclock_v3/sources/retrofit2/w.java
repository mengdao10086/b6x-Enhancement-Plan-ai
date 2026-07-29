package retrofit2;

import com.blankj.utilcode.util.i0;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.e0;

/* JADX INFO: loaded from: classes6.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type[] f48744a = new Type[0];

    public static final class a implements GenericArrayType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f48745a;

        public a(Type type) {
            this.f48745a = type;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && w.d(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f48745a;
        }

        public int hashCode() {
            return this.f48745a.hashCode();
        }

        public String toString() {
            return w.t(this.f48745a) + okhttp3.u.f43953p;
        }
    }

    public static final class b implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Type f48746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f48747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Type[] f48748c;

        public b(@Nullable Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                Objects.requireNonNull(type3, "typeArgument == null");
                w.b(type3);
            }
            this.f48746a = type;
            this.f48747b = type2;
            this.f48748c = (Type[]) typeArr.clone();
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && w.d(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f48748c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        @Nullable
        public Type getOwnerType() {
            return this.f48746a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f48747b;
        }

        public int hashCode() {
            int iHashCode = Arrays.hashCode(this.f48748c) ^ this.f48747b.hashCode();
            Type type = this.f48746a;
            return iHashCode ^ (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            Type[] typeArr = this.f48748c;
            if (typeArr.length == 0) {
                return w.t(this.f48747b);
            }
            StringBuilder sb2 = new StringBuilder((typeArr.length + 1) * 30);
            sb2.append(w.t(this.f48747b));
            sb2.append("<");
            sb2.append(w.t(this.f48748c[0]));
            for (int i10 = 1; i10 < this.f48748c.length; i10++) {
                sb2.append(", ");
                sb2.append(w.t(this.f48748c[i10]));
            }
            sb2.append(">");
            return sb2.toString();
        }
    }

    public static final class c implements WildcardType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f48749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final Type f48750b;

        public c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length != 1) {
                Objects.requireNonNull(typeArr[0]);
                w.b(typeArr[0]);
                this.f48750b = null;
                this.f48749a = typeArr[0];
                return;
            }
            Objects.requireNonNull(typeArr2[0]);
            w.b(typeArr2[0]);
            if (typeArr[0] != Object.class) {
                throw new IllegalArgumentException();
            }
            this.f48750b = typeArr2[0];
            this.f48749a = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && w.d(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f48750b;
            return type != null ? new Type[]{type} : w.f48744a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f48749a};
        }

        public int hashCode() {
            Type type = this.f48750b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f48749a.hashCode() + 31);
        }

        public String toString() {
            if (this.f48750b != null) {
                return "? super " + w.t(this.f48750b);
            }
            if (this.f48749a == Object.class) {
                return "?";
            }
            return "? extends " + w.t(this.f48749a);
        }
    }

    public static e0 a(e0 e0Var) throws IOException {
        okio.j jVar = new okio.j();
        e0Var.source().J1(jVar);
        return e0.create(e0Var.contentType(), e0Var.contentLength(), jVar);
    }

    public static void b(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    @Nullable
    public static Class<?> c(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static boolean d(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return d(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    public static Type e(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (interfaces[i10] == cls2) {
                    return cls.getGenericInterfaces()[i10];
                }
                if (cls2.isAssignableFrom(interfaces[i10])) {
                    return e(cls.getGenericInterfaces()[i10], interfaces[i10], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return e(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type f(int i10, ParameterizedType parameterizedType) {
        Type type = parameterizedType.getActualTypeArguments()[i10];
        return type instanceof WildcardType ? ((WildcardType) type).getLowerBounds()[0] : type;
    }

    public static Type g(int i10, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i10 >= 0 && i10 < actualTypeArguments.length) {
            Type type = actualTypeArguments[i10];
            return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
        }
        throw new IllegalArgumentException("Index " + i10 + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
    }

    public static Class<?> h(Type type) {
        Objects.requireNonNull(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(h(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return h(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    public static Type i(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return q(type, cls, e(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    public static boolean j(@Nullable Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (j(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return j(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? i0.f11859x : type.getClass().getName()));
    }

    public static int k(Object[] objArr, Object obj) {
        for (int i10 = 0; i10 < objArr.length; i10++) {
            if (obj.equals(objArr[i10])) {
                return i10;
            }
        }
        throw new NoSuchElementException();
    }

    public static boolean l(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    public static RuntimeException m(Method method, String str, Object... objArr) {
        return n(method, null, str, objArr);
    }

    public static RuntimeException n(Method method, @Nullable Throwable th2, String str, Object... objArr) {
        return new IllegalArgumentException(String.format(str, objArr) + "\n    for method " + method.getDeclaringClass().getSimpleName() + j3.b.f36044h + method.getName(), th2);
    }

    public static RuntimeException o(Method method, int i10, String str, Object... objArr) {
        return m(method, str + " (parameter #" + (i10 + 1) + ee.a.f26979d, objArr);
    }

    public static RuntimeException p(Method method, Throwable th2, int i10, String str, Object... objArr) {
        return n(method, th2, str + " (parameter #" + (i10 + 1) + ee.a.f26979d, objArr);
    }

    public static Type q(Type type, Class<?> cls, Type type2) {
        Type type3 = type2;
        while (type3 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type3;
            Type typeR = r(type, cls, typeVariable);
            if (typeR == typeVariable) {
                return typeR;
            }
            type3 = typeR;
        }
        if (type3 instanceof Class) {
            Class cls2 = (Class) type3;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type typeQ = q(type, cls, componentType);
                return componentType == typeQ ? cls2 : new a(typeQ);
            }
        }
        if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type typeQ2 = q(type, cls, genericComponentType);
            return genericComponentType == typeQ2 ? genericArrayType : new a(typeQ2);
        }
        if (type3 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            Type ownerType = parameterizedType.getOwnerType();
            Type typeQ3 = q(type, cls, ownerType);
            boolean z10 = typeQ3 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i10 = 0; i10 < length; i10++) {
                Type typeQ4 = q(type, cls, actualTypeArguments[i10]);
                if (typeQ4 != actualTypeArguments[i10]) {
                    if (!z10) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z10 = true;
                    }
                    actualTypeArguments[i10] = typeQ4;
                }
            }
            return z10 ? new b(typeQ3, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        }
        boolean z11 = type3 instanceof WildcardType;
        Type type4 = type3;
        if (z11) {
            WildcardType wildcardType = (WildcardType) type3;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type typeQ5 = q(type, cls, lowerBounds[0]);
                type4 = wildcardType;
                if (typeQ5 != lowerBounds[0]) {
                    return new c(new Type[]{Object.class}, new Type[]{typeQ5});
                }
            } else {
                type4 = wildcardType;
                if (upperBounds.length == 1) {
                    Type typeQ6 = q(type, cls, upperBounds[0]);
                    type4 = wildcardType;
                    if (typeQ6 != upperBounds[0]) {
                        return new c(new Type[]{typeQ6}, f48744a);
                    }
                }
            }
        }
        return type4;
    }

    public static Type r(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> clsC = c(typeVariable);
        if (clsC == null) {
            return typeVariable;
        }
        Type typeE = e(type, cls, clsC);
        if (!(typeE instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) typeE).getActualTypeArguments()[k(clsC.getTypeParameters(), typeVariable)];
    }

    public static void s(Throwable th2) {
        if (th2 instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th2);
        }
        if (th2 instanceof ThreadDeath) {
            throw ((ThreadDeath) th2);
        }
        if (th2 instanceof LinkageError) {
            throw ((LinkageError) th2);
        }
    }

    public static String t(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
