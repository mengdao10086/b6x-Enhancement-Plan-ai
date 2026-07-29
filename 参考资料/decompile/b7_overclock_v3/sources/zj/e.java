package zj;

import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.v0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,134:1\n37#2,2:135\n*S KotlinDebug\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n*L\n131#1:135,2\n*E\n"})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f58598a = 1;

    public static final void a(int i10, int i11) {
        if (i11 <= i10) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i10 + ", got " + i11 + ". Please update the Kotlin standard library.").toString());
    }

    public static final d b(BaseContinuationImpl baseContinuationImpl) {
        return (d) baseContinuationImpl.getClass().getAnnotation(d.class);
    }

    public static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @hk.h(name = "getSpilledVariableFieldMapping")
    @v0(version = "1.3")
    @l
    public static final String[] d(@k BaseContinuationImpl baseContinuationImpl) {
        f0.p(baseContinuationImpl, "<this>");
        d dVarB = b(baseContinuationImpl);
        if (dVarB == null) {
            return null;
        }
        a(1, dVarB.v());
        ArrayList arrayList = new ArrayList();
        int iC = c(baseContinuationImpl);
        int[] iArrI = dVarB.i();
        int length = iArrI.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (iArrI[i10] == iC) {
                arrayList.add(dVarB.s()[i10]);
                arrayList.add(dVarB.n()[i10]);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @hk.h(name = "getStackTraceElement")
    @v0(version = "1.3")
    @l
    public static final StackTraceElement e(@k BaseContinuationImpl baseContinuationImpl) {
        String strC;
        f0.p(baseContinuationImpl, "<this>");
        d dVarB = b(baseContinuationImpl);
        if (dVarB == null) {
            return null;
        }
        a(1, dVarB.v());
        int iC = c(baseContinuationImpl);
        int i10 = iC < 0 ? -1 : dVarB.l()[iC];
        String strB = g.f58599a.b(baseContinuationImpl);
        if (strB == null) {
            strC = dVarB.c();
        } else {
            strC = strB + zc.f.f58380j + dVarB.c();
        }
        return new StackTraceElement(strC, dVarB.m(), dVarB.f(), i10);
    }
}
