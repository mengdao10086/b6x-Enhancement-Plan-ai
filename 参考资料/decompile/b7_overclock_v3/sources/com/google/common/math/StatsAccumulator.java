package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtIncompatible
public final class StatsAccumulator {
    private long count = 0;
    private double mean = 0.0d;
    private double sumOfSquaresOfDeltas = 0.0d;
    private double min = Double.NaN;
    private double max = Double.NaN;

    public static double calculateNewMeanNonFinite(double d10, double d11) {
        if (Doubles.isFinite(d10)) {
            return d11;
        }
        if (Doubles.isFinite(d11) || d10 == d11) {
            return d10;
        }
        return Double.NaN;
    }

    public void add(double d10) {
        long j10 = this.count;
        if (j10 == 0) {
            this.count = 1L;
            this.mean = d10;
            this.min = d10;
            this.max = d10;
            if (Doubles.isFinite(d10)) {
                return;
            }
            this.sumOfSquaresOfDeltas = Double.NaN;
            return;
        }
        this.count = j10 + 1;
        if (Doubles.isFinite(d10) && Doubles.isFinite(this.mean)) {
            double d11 = this.mean;
            double d12 = d10 - d11;
            double d13 = d11 + (d12 / this.count);
            this.mean = d13;
            this.sumOfSquaresOfDeltas += d12 * (d10 - d13);
        } else {
            this.mean = calculateNewMeanNonFinite(this.mean, d10);
            this.sumOfSquaresOfDeltas = Double.NaN;
        }
        this.min = Math.min(this.min, d10);
        this.max = Math.max(this.max, d10);
    }

    public void addAll(Iterable<? extends Number> iterable) {
        Iterator<? extends Number> it2 = iterable.iterator();
        while (it2.hasNext()) {
            add(it2.next().doubleValue());
        }
    }

    public long count() {
        return this.count;
    }

    public double max() {
        Preconditions.checkState(this.count != 0);
        return this.max;
    }

    public double mean() {
        Preconditions.checkState(this.count != 0);
        return this.mean;
    }

    public double min() {
        Preconditions.checkState(this.count != 0);
        return this.min;
    }

    public final double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public final double populationVariance() {
        Preconditions.checkState(this.count != 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / this.count;
    }

    public final double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public final double sampleVariance() {
        Preconditions.checkState(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (this.count - 1);
    }

    public Stats snapshot() {
        return new Stats(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
    }

    public final double sum() {
        return this.mean * this.count;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public void addAll(Iterator<? extends Number> it2) {
        while (it2.hasNext()) {
            add(it2.next().doubleValue());
        }
    }

    public void addAll(double... dArr) {
        for (double d10 : dArr) {
            add(d10);
        }
    }

    public void addAll(int... iArr) {
        for (int i10 : iArr) {
            add(i10);
        }
    }

    public void addAll(long... jArr) {
        for (long j10 : jArr) {
            add(j10);
        }
    }

    public void addAll(Stats stats) {
        if (stats.count() == 0) {
            return;
        }
        long j10 = this.count;
        if (j10 == 0) {
            this.count = stats.count();
            this.mean = stats.mean();
            this.sumOfSquaresOfDeltas = stats.sumOfSquaresOfDeltas();
            this.min = stats.min();
            this.max = stats.max();
            return;
        }
        this.count = j10 + stats.count();
        if (Doubles.isFinite(this.mean) && Doubles.isFinite(stats.mean())) {
            double dMean = stats.mean();
            double d10 = this.mean;
            double d11 = dMean - d10;
            this.mean = d10 + ((stats.count() * d11) / this.count);
            this.sumOfSquaresOfDeltas += stats.sumOfSquaresOfDeltas() + (d11 * (stats.mean() - this.mean) * stats.count());
        } else {
            this.mean = calculateNewMeanNonFinite(this.mean, stats.mean());
            this.sumOfSquaresOfDeltas = Double.NaN;
        }
        this.min = Math.min(this.min, stats.min());
        this.max = Math.max(this.max, stats.max());
    }
}
