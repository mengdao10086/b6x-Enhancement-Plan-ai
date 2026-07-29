package h;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.d0;
import kotlin.k;
import kotlin.t0;
import sj.c;
import sj.d;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@k(message = "This annotation has been replaced by `@OptIn`", replaceWith = @t0(expression = "OptIn", imports = {"androidx.annotation.OptIn"}))
@c(AnnotationRetention.BINARY)
@d0(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B$\u0012\"\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00030\u0002\"\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003R!\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lh/a;", "", "", "Lkotlin/reflect/d;", "markerClass", "()[Ljava/lang/Class;", "annotation-experimental_release"}, k = 1, mv = {1, 7, 1})
@Retention(RetentionPolicy.CLASS)
@d(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FILE, AnnotationTarget.TYPEALIAS})
public @interface a {
    Class<? extends Annotation>[] markerClass();
}
