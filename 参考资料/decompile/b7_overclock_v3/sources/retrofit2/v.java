package retrofit2;

import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes6.dex */
public final class v implements u {

    /* JADX INFO: renamed from: t5, reason: collision with root package name */
    public static final u f48743t5 = new v();

    public static Annotation[] a(Annotation[] annotationArr) {
        if (w.l(annotationArr, u.class)) {
            return annotationArr;
        }
        Annotation[] annotationArr2 = new Annotation[annotationArr.length + 1];
        annotationArr2[0] = f48743t5;
        System.arraycopy(annotationArr, 0, annotationArr2, 1, annotationArr.length);
        return annotationArr2;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return u.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object obj) {
        return obj instanceof u;
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return "@" + u.class.getName() + "()";
    }
}
