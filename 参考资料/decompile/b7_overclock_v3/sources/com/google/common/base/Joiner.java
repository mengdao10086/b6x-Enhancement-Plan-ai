package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public class Joiner {
    private final String separator;

    public static final class MapJoiner {
        private final Joiner joiner;
        private final String keyValueSeparator;

        @CanIgnoreReturnValue
        public <A extends Appendable> A appendTo(A a10, Map<?, ?> map) throws IOException {
            return (A) appendTo(a10, map.entrySet());
        }

        public String join(Map<?, ?> map) {
            return join(map.entrySet());
        }

        public MapJoiner useForNull(String str) {
            return new MapJoiner(this.joiner.useForNull(str), this.keyValueSeparator);
        }

        private MapJoiner(Joiner joiner, String str) {
            this.joiner = joiner;
            this.keyValueSeparator = (String) Preconditions.checkNotNull(str);
        }

        @CanIgnoreReturnValue
        public StringBuilder appendTo(StringBuilder sb2, Map<?, ?> map) {
            return appendTo(sb2, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        @Beta
        public String join(Iterable<? extends Map.Entry<?, ?>> iterable) {
            return join(iterable.iterator());
        }

        @CanIgnoreReturnValue
        @Beta
        public <A extends Appendable> A appendTo(A a10, Iterable<? extends Map.Entry<?, ?>> iterable) throws IOException {
            return (A) appendTo(a10, iterable.iterator());
        }

        @Beta
        public String join(Iterator<? extends Map.Entry<?, ?>> it2) {
            return appendTo(new StringBuilder(), it2).toString();
        }

        @CanIgnoreReturnValue
        @Beta
        public <A extends Appendable> A appendTo(A a10, Iterator<? extends Map.Entry<?, ?>> it2) throws IOException {
            Preconditions.checkNotNull(a10);
            if (it2.hasNext()) {
                Map.Entry<?, ?> next = it2.next();
                a10.append(this.joiner.toString(next.getKey()));
                a10.append(this.keyValueSeparator);
                a10.append(this.joiner.toString(next.getValue()));
                while (it2.hasNext()) {
                    a10.append(this.joiner.separator);
                    Map.Entry<?, ?> next2 = it2.next();
                    a10.append(this.joiner.toString(next2.getKey()));
                    a10.append(this.keyValueSeparator);
                    a10.append(this.joiner.toString(next2.getValue()));
                }
            }
            return a10;
        }

        @CanIgnoreReturnValue
        @Beta
        public StringBuilder appendTo(StringBuilder sb2, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return appendTo(sb2, iterable.iterator());
        }

        @CanIgnoreReturnValue
        @Beta
        public StringBuilder appendTo(StringBuilder sb2, Iterator<? extends Map.Entry<?, ?>> it2) {
            try {
                appendTo(sb2, it2);
                return sb2;
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    private static Iterable<Object> iterable(final Object obj, final Object obj2, final Object[] objArr) {
        Preconditions.checkNotNull(objArr);
        return new AbstractList<Object>() { // from class: com.google.common.base.Joiner.3
            @Override // java.util.AbstractList, java.util.List
            public Object get(int i10) {
                return i10 != 0 ? i10 != 1 ? objArr[i10 - 2] : obj2 : obj;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return objArr.length + 2;
            }
        };
    }

    public static Joiner on(String str) {
        return new Joiner(str);
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A a10, Iterable<?> iterable) throws IOException {
        return (A) appendTo(a10, iterable.iterator());
    }

    public final String join(Iterable<?> iterable) {
        return join(iterable.iterator());
    }

    public Joiner skipNulls() {
        return new Joiner(this) { // from class: com.google.common.base.Joiner.2
            @Override // com.google.common.base.Joiner
            public <A extends Appendable> A appendTo(A a10, Iterator<?> it2) throws IOException {
                Preconditions.checkNotNull(a10, "appendable");
                Preconditions.checkNotNull(it2, "parts");
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    if (next != null) {
                        a10.append(Joiner.this.toString(next));
                        break;
                    }
                }
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    if (next2 != null) {
                        a10.append(Joiner.this.separator);
                        a10.append(Joiner.this.toString(next2));
                    }
                }
                return a10;
            }

            @Override // com.google.common.base.Joiner
            public Joiner useForNull(String str) {
                throw new UnsupportedOperationException("already specified skipNulls");
            }

            @Override // com.google.common.base.Joiner
            public MapJoiner withKeyValueSeparator(String str) {
                throw new UnsupportedOperationException("can't use .skipNulls() with maps");
            }
        };
    }

    public CharSequence toString(Object obj) {
        Preconditions.checkNotNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public Joiner useForNull(final String str) {
        Preconditions.checkNotNull(str);
        return new Joiner(this) { // from class: com.google.common.base.Joiner.1
            @Override // com.google.common.base.Joiner
            public Joiner skipNulls() {
                throw new UnsupportedOperationException("already specified useForNull");
            }

            @Override // com.google.common.base.Joiner
            public CharSequence toString(@NullableDecl Object obj) {
                return obj == null ? str : Joiner.this.toString(obj);
            }

            @Override // com.google.common.base.Joiner
            public Joiner useForNull(String str2) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    public MapJoiner withKeyValueSeparator(char c10) {
        return withKeyValueSeparator(String.valueOf(c10));
    }

    private Joiner(String str) {
        this.separator = (String) Preconditions.checkNotNull(str);
    }

    public static Joiner on(char c10) {
        return new Joiner(String.valueOf(c10));
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A a10, Iterator<?> it2) throws IOException {
        Preconditions.checkNotNull(a10);
        if (it2.hasNext()) {
            a10.append(toString(it2.next()));
            while (it2.hasNext()) {
                a10.append(this.separator);
                a10.append(toString(it2.next()));
            }
        }
        return a10;
    }

    public final String join(Iterator<?> it2) {
        return appendTo(new StringBuilder(), it2).toString();
    }

    public MapJoiner withKeyValueSeparator(String str) {
        return new MapJoiner(str);
    }

    public final String join(Object[] objArr) {
        return join(Arrays.asList(objArr));
    }

    private Joiner(Joiner joiner) {
        this.separator = joiner.separator;
    }

    public final String join(@NullableDecl Object obj, @NullableDecl Object obj2, Object... objArr) {
        return join(iterable(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A a10, Object[] objArr) throws IOException {
        return (A) appendTo(a10, Arrays.asList(objArr));
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A a10, @NullableDecl Object obj, @NullableDecl Object obj2, Object... objArr) throws IOException {
        return (A) appendTo(a10, iterable(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb2, Iterable<?> iterable) {
        return appendTo(sb2, iterable.iterator());
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb2, Iterator<?> it2) {
        try {
            appendTo(sb2, it2);
            return sb2;
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb2, Object[] objArr) {
        return appendTo(sb2, (Iterable<?>) Arrays.asList(objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb2, @NullableDecl Object obj, @NullableDecl Object obj2, Object... objArr) {
        return appendTo(sb2, iterable(obj, obj2, objArr));
    }
}
