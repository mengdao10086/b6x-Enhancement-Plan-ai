package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtIncompatible
public final class PairedStatsAccumulator {
    private final StatsAccumulator xStats = new StatsAccumulator();
    private final StatsAccumulator yStats = new StatsAccumulator();
    private double sumOfProductsOfDeltas = 0.0d;

    private static double ensureInUnitRange(double d10) {
        if (d10 >= 1.0d) {
            return 1.0d;
        }
        if (d10 <= -1.0d) {
            return -1.0d;
        }
        return d10;
    }

    private double ensurePositive(double d10) {
        if (d10 > 0.0d) {
            return d10;
        }
        return Double.MIN_VALUE;
    }

    public void add(double d10, double d11) {
        this.xStats.add(d10);
        if (!Doubles.isFinite(d10) || !Doubles.isFinite(d11)) {
            this.sumOfProductsOfDeltas = Double.NaN;
        } else if (this.xStats.count() > 1) {
            this.sumOfProductsOfDeltas += (d10 - this.xStats.mean()) * (d11 - this.yStats.mean());
        }
        this.yStats.add(d11);
    }

    public void addAll(PairedStats pairedStats) {
        if (pairedStats.count() == 0) {
            return;
        }
        this.xStats.addAll(pairedStats.xStats());
        if (this.yStats.count() == 0) {
            this.sumOfProductsOfDeltas = pairedStats.sumOfProductsOfDeltas();
        } else {
            this.sumOfProductsOfDeltas += pairedStats.sumOfProductsOfDeltas() + ((pairedStats.xStats().mean() - this.xStats.mean()) * (pairedStats.yStats().mean() - this.yStats.mean()) * pairedStats.count());
        }
        this.yStats.addAll(pairedStats.yStats());
    }

    public long count() {
        return this.xStats.count();
    }

    public final LinearTransformation leastSquaresFit() {
        Preconditions.checkState(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return LinearTransformation.forNaN();
        }
        double dSumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        if (dSumOfSquaresOfDeltas > 0.0d) {
            return this.yStats.sumOfSquaresOfDeltas() > 0.0d ? LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / dSumOfSquaresOfDeltas) : LinearTransformation.horizontal(this.yStats.mean());
        }
        Preconditions.checkState(this.yStats.sumOfSquaresOfDeltas() > 0.0d);
        return LinearTransformation.vertical(this.xStats.mean());
    }

    public final double pearsonsCorrelationCoefficient() {
        Preconditions.checkState(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return Double.NaN;
        }
        double dSumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        double dSumOfSquaresOfDeltas2 = this.yStats.sumOfSquaresOfDeltas();
        Preconditions.checkState(dSumOfSquaresOfDeltas > 0.0d);
        Preconditions.checkState(dSumOfSquaresOfDeltas2 > 0.0d);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(dSumOfSquaresOfDeltas * dSumOfSquaresOfDeltas2)));
    }

    public double populationCovariance() {
        Preconditions.checkState(count() != 0);
        return this.sumOfProductsOfDeltas / count();
    }

    public final double sampleCovariance() {
        Preconditions.checkState(count() > 1);
        return this.sumOfProductsOfDeltas / (count() - 1);
    }

    public PairedStats snapshot() {
        return new PairedStats(this.xStats.snapshot(), this.yStats.snapshot(), this.sumOfProductsOfDeltas);
    }

    public Stats xStats() {
        return this.xStats.snapshot();
    }

    public Stats yStats() {
        return this.yStats.snapshot();
    }
}
