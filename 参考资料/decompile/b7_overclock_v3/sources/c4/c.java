package c4;

import android.content.Context;
import com.bumptech.glide.load.engine.s;
import g.n0;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class c<T> implements h<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Collection<? extends h<T>> f9746c;

    @SafeVarargs
    public c(@n0 h<T>... hVarArr) {
        if (hVarArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f9746c = Arrays.asList(hVarArr);
    }

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        Iterator<? extends h<T>> it2 = this.f9746c.iterator();
        while (it2.hasNext()) {
            it2.next().a(messageDigest);
        }
    }

    @Override // c4.h
    @n0
    public s<T> b(@n0 Context context, @n0 s<T> sVar, int i10, int i11) {
        Iterator<? extends h<T>> it2 = this.f9746c.iterator();
        s<T> sVar2 = sVar;
        while (it2.hasNext()) {
            s<T> sVarB = it2.next().b(context, sVar2, i10, i11);
            if (sVar2 != null && !sVar2.equals(sVar) && !sVar2.equals(sVarB)) {
                sVar2.a();
            }
            sVar2 = sVarB;
        }
        return sVar2;
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f9746c.equals(((c) obj).f9746c);
        }
        return false;
    }

    @Override // c4.b
    public int hashCode() {
        return this.f9746c.hashCode();
    }

    public c(@n0 Collection<? extends h<T>> collection) {
        if (!collection.isEmpty()) {
            this.f9746c = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
}
