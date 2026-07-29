package kotlin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypeVariableImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,230:1\n1549#2:231\n1620#2,3:232\n37#3,2:235\n26#4:237\n26#4:238\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypeVariableImpl\n*L\n116#1:231\n116#1:232,3\n116#1:235,2\n134#1:237\n137#1:238\n*E\n"})
@kotlin.q
public final class w implements TypeVariable<GenericDeclaration>, u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final s f38025a;

    public w(@yt.k s typeParameter) {
        f0.p(typeParameter, "typeParameter");
        this.f38025a = typeParameter;
    }

    @yt.l
    public final <T extends Annotation> T a(@yt.k Class<T> annotationClass) {
        f0.p(annotationClass, "annotationClass");
        return null;
    }

    @yt.k
    public final Annotation[] b() {
        return new Annotation[0];
    }

    @yt.k
    public final Annotation[] c() {
        return new Annotation[0];
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            if (f0.g(getName(), typeVariable.getName()) && f0.g(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    @yt.k
    public Type[] getBounds() {
        List<r> upperBounds = this.f38025a.getUpperBounds();
        ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(upperBounds, 10));
        Iterator<T> it2 = upperBounds.iterator();
        while (it2.hasNext()) {
            arrayList.add(TypesJVMKt.c((r) it2.next(), true));
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    @yt.k
    public GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.f38025a));
    }

    @Override // java.lang.reflect.TypeVariable
    @yt.k
    public String getName() {
        return this.f38025a.getName();
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.u
    @yt.k
    public String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    @yt.k
    public String toString() {
        return getTypeName();
    }
}
