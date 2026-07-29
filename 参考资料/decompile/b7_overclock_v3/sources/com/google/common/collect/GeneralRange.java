package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(serializable = true)
final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;

    @NullableDecl
    private final T lowerEndpoint;

    @MonotonicNonNullDecl
    private transient GeneralRange<T> reverse;
    private final BoundType upperBoundType;

    @NullableDecl
    private final T upperEndpoint;

    /* JADX WARN: Multi-variable type inference failed */
    private GeneralRange(Comparator<? super T> comparator, boolean z10, @NullableDecl T t10, BoundType boundType, boolean z11, @NullableDecl T t11, BoundType boundType2) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        this.hasLowerBound = z10;
        this.hasUpperBound = z11;
        this.lowerEndpoint = t10;
        this.lowerBoundType = (BoundType) Preconditions.checkNotNull(boundType);
        this.upperEndpoint = t11;
        this.upperBoundType = (BoundType) Preconditions.checkNotNull(boundType2);
        if (z10) {
            comparator.compare(t10, t10);
        }
        if (z11) {
            comparator.compare(t11, t11);
        }
        if (z10 && z11) {
            int iCompare = comparator.compare(t10, t11);
            Preconditions.checkArgument(iCompare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t10, t11);
            if (iCompare == 0) {
                BoundType boundType3 = BoundType.OPEN;
                Preconditions.checkArgument((boundType != boundType3) | (boundType2 != boundType3));
            }
        }
    }

    public static <T> GeneralRange<T> all(Comparator<? super T> comparator) {
        BoundType boundType = BoundType.OPEN;
        return new GeneralRange<>(comparator, false, null, boundType, false, null, boundType);
    }

    public static <T> GeneralRange<T> downTo(Comparator<? super T> comparator, @NullableDecl T t10, BoundType boundType) {
        return new GeneralRange<>(comparator, true, t10, boundType, false, null, BoundType.OPEN);
    }

    public static <T extends Comparable> GeneralRange<T> from(Range<T> range) {
        return new GeneralRange<>(Ordering.natural(), range.hasLowerBound(), range.hasLowerBound() ? range.lowerEndpoint() : null, range.hasLowerBound() ? range.lowerBoundType() : BoundType.OPEN, range.hasUpperBound(), range.hasUpperBound() ? range.upperEndpoint() : null, range.hasUpperBound() ? range.upperBoundType() : BoundType.OPEN);
    }

    public static <T> GeneralRange<T> range(Comparator<? super T> comparator, @NullableDecl T t10, BoundType boundType, @NullableDecl T t11, BoundType boundType2) {
        return new GeneralRange<>(comparator, true, t10, boundType, true, t11, boundType2);
    }

    public static <T> GeneralRange<T> upTo(Comparator<? super T> comparator, @NullableDecl T t10, BoundType boundType) {
        return new GeneralRange<>(comparator, false, null, BoundType.OPEN, true, t10, boundType);
    }

    public Comparator<? super T> comparator() {
        return this.comparator;
    }

    public boolean contains(@NullableDecl T t10) {
        return (tooLow(t10) || tooHigh(t10)) ? false : true;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof GeneralRange)) {
            return false;
        }
        GeneralRange generalRange = (GeneralRange) obj;
        return this.comparator.equals(generalRange.comparator) && this.hasLowerBound == generalRange.hasLowerBound && this.hasUpperBound == generalRange.hasUpperBound && getLowerBoundType().equals(generalRange.getLowerBoundType()) && getUpperBoundType().equals(generalRange.getUpperBoundType()) && Objects.equal(getLowerEndpoint(), generalRange.getLowerEndpoint()) && Objects.equal(getUpperEndpoint(), generalRange.getUpperEndpoint());
    }

    public BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    public T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    public BoundType getUpperBoundType() {
        return this.upperBoundType;
    }

    public T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    public boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    public boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    public int hashCode() {
        return Objects.hashCode(this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType());
    }

    public GeneralRange<T> intersect(GeneralRange<T> generalRange) {
        int iCompare;
        int iCompare2;
        T t10;
        BoundType boundType;
        BoundType boundType2;
        int iCompare3;
        BoundType boundType3;
        Preconditions.checkNotNull(generalRange);
        Preconditions.checkArgument(this.comparator.equals(generalRange.comparator));
        boolean z10 = this.hasLowerBound;
        T lowerEndpoint = getLowerEndpoint();
        BoundType lowerBoundType = getLowerBoundType();
        if (!hasLowerBound()) {
            z10 = generalRange.hasLowerBound;
            lowerEndpoint = generalRange.getLowerEndpoint();
            lowerBoundType = generalRange.getLowerBoundType();
        } else if (generalRange.hasLowerBound() && ((iCompare = this.comparator.compare(getLowerEndpoint(), generalRange.getLowerEndpoint())) < 0 || (iCompare == 0 && generalRange.getLowerBoundType() == BoundType.OPEN))) {
            lowerEndpoint = generalRange.getLowerEndpoint();
            lowerBoundType = generalRange.getLowerBoundType();
        }
        boolean z11 = z10;
        boolean z12 = this.hasUpperBound;
        T upperEndpoint = getUpperEndpoint();
        BoundType upperBoundType = getUpperBoundType();
        if (!hasUpperBound()) {
            z12 = generalRange.hasUpperBound;
            upperEndpoint = generalRange.getUpperEndpoint();
            upperBoundType = generalRange.getUpperBoundType();
        } else if (generalRange.hasUpperBound() && ((iCompare2 = this.comparator.compare(getUpperEndpoint(), generalRange.getUpperEndpoint())) > 0 || (iCompare2 == 0 && generalRange.getUpperBoundType() == BoundType.OPEN))) {
            upperEndpoint = generalRange.getUpperEndpoint();
            upperBoundType = generalRange.getUpperBoundType();
        }
        boolean z13 = z12;
        T t11 = upperEndpoint;
        if (z11 && z13 && ((iCompare3 = this.comparator.compare(lowerEndpoint, t11)) > 0 || (iCompare3 == 0 && lowerBoundType == (boundType3 = BoundType.OPEN) && upperBoundType == boundType3))) {
            boundType = BoundType.OPEN;
            boundType2 = BoundType.CLOSED;
            t10 = t11;
        } else {
            t10 = lowerEndpoint;
            boundType = lowerBoundType;
            boundType2 = upperBoundType;
        }
        return new GeneralRange<>(this.comparator, z11, t10, boundType, z13, t11, boundType2);
    }

    public boolean isEmpty() {
        return (hasUpperBound() && tooLow(getUpperEndpoint())) || (hasLowerBound() && tooHigh(getLowerEndpoint()));
    }

    public GeneralRange<T> reverse() {
        GeneralRange<T> generalRange = this.reverse;
        if (generalRange != null) {
            return generalRange;
        }
        GeneralRange<T> generalRange2 = new GeneralRange<>(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        generalRange2.reverse = this;
        this.reverse = generalRange2;
        return generalRange2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.comparator);
        sb2.append(":");
        BoundType boundType = this.lowerBoundType;
        BoundType boundType2 = BoundType.CLOSED;
        sb2.append(boundType == boundType2 ? '[' : '(');
        sb2.append(this.hasLowerBound ? this.lowerEndpoint : "-∞");
        sb2.append(',');
        sb2.append(this.hasUpperBound ? this.upperEndpoint : "∞");
        sb2.append(this.upperBoundType == boundType2 ? ']' : ')');
        return sb2.toString();
    }

    public boolean tooHigh(@NullableDecl T t10) {
        if (!hasUpperBound()) {
            return false;
        }
        int iCompare = this.comparator.compare(t10, getUpperEndpoint());
        return ((iCompare == 0) & (getUpperBoundType() == BoundType.OPEN)) | (iCompare > 0);
    }

    public boolean tooLow(@NullableDecl T t10) {
        if (!hasLowerBound()) {
            return false;
        }
        int iCompare = this.comparator.compare(t10, getLowerEndpoint());
        return ((iCompare == 0) & (getLowerBoundType() == BoundType.OPEN)) | (iCompare < 0);
    }
}
