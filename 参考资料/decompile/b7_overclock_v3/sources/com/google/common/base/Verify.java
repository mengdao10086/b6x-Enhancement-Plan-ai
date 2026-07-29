package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public final class Verify {
    private Verify() {
    }

    public static void verify(boolean z10) {
        if (!z10) {
            throw new VerifyException();
        }
    }

    @CanIgnoreReturnValue
    public static <T> T verifyNotNull(@NullableDecl T t10) {
        return (T) verifyNotNull(t10, "expected a non-null reference", new Object[0]);
    }

    public static void verify(boolean z10, @NullableDecl String str, @NullableDecl Object... objArr) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T verifyNotNull(@NullableDecl T t10, @NullableDecl String str, @NullableDecl Object... objArr) {
        verify(t10 != null, str, objArr);
        return t10;
    }

    public static void verify(boolean z10, @NullableDecl String str, char c10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c10)));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, int i10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i10)));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, long j10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j10)));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, @NullableDecl Object obj) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, obj));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, char c10, char c11) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c10), Character.valueOf(c11)));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, int i10, char c10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i10), Character.valueOf(c10)));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, long j10, char c10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j10), Character.valueOf(c10)));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, @NullableDecl Object obj, char c10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Character.valueOf(c10)));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, char c10, int i10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c10), Integer.valueOf(i10)));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, int i10, int i11) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i10), Integer.valueOf(i11)));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, long j10, int i10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j10), Integer.valueOf(i10)));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, @NullableDecl Object obj, int i10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Integer.valueOf(i10)));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, char c10, long j10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c10), Long.valueOf(j10)));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, int i10, long j10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i10), Long.valueOf(j10)));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, long j10, long j11) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j10), Long.valueOf(j11)));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, @NullableDecl Object obj, long j10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Long.valueOf(j10)));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, char c10, @NullableDecl Object obj) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c10), obj));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, int i10, @NullableDecl Object obj) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i10), obj));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, long j10, @NullableDecl Object obj) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j10), obj));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void verify(boolean z10, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3, @NullableDecl Object obj4) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }
}
