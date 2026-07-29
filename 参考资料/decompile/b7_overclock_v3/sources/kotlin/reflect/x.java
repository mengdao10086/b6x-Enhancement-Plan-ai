package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/WildcardTypeImpl\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,230:1\n26#2:231\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/WildcardTypeImpl\n*L\n163#1:231\n*E\n"})
@kotlin.q
public final class x implements WildcardType, u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final a f38026c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final x f38027d = new x(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public final Type f38028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public final Type f38029b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final x a() {
            return x.f38027d;
        }
    }

    public x(@yt.l Type type, @yt.l Type type2) {
        this.f38028a = type;
        this.f38029b = type2;
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    @yt.k
    public Type[] getLowerBounds() {
        Type type = this.f38029b;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.u
    @yt.k
    public String getTypeName() {
        if (this.f38029b != null) {
            return "? super " + TypesJVMKt.j(this.f38029b);
        }
        Type type = this.f38028a;
        if (type == null || f0.g(type, Object.class)) {
            return "?";
        }
        return "? extends " + TypesJVMKt.j(this.f38028a);
    }

    @Override // java.lang.reflect.WildcardType
    @yt.k
    public Type[] getUpperBounds() {
        Type[] typeArr = new Type[1];
        Type type = this.f38028a;
        if (type == null) {
            type = Object.class;
        }
        typeArr[0] = type;
        return typeArr;
    }

    public int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    @yt.k
    public String toString() {
        return getTypeName();
    }
}
