package io.objectbox.relation;

import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.ToManyGetter;
import io.objectbox.internal.ToOneGetter;
import java.io.Serializable;
import javax.annotation.concurrent.Immutable;
import li.c;

/* JADX INFO: loaded from: classes5.dex */
@c
@Immutable
public class RelationInfo<SOURCE, TARGET> implements Serializable {
    private static final long serialVersionUID = 7412962174183812632L;
    public final ToManyGetter<TARGET> backlinkToManyGetter;
    public final ToOneGetter<TARGET> backlinkToOneGetter;
    public final int relationId;
    public final EntityInfo<SOURCE> sourceInfo;
    public final Property<?> targetIdProperty;
    public final EntityInfo<TARGET> targetInfo;
    public final int targetRelationId;
    public final ToManyGetter<SOURCE> toManyGetter;
    public final ToOneGetter<SOURCE> toOneGetter;

    /* JADX WARN: Multi-variable type inference failed */
    public RelationInfo(EntityInfo<SOURCE> entityInfo, EntityInfo<TARGET> entityInfo2, Property<SOURCE> property, ToOneGetter<SOURCE> toOneGetter) {
        this.sourceInfo = entityInfo;
        this.targetInfo = entityInfo2;
        this.targetIdProperty = property;
        this.toOneGetter = toOneGetter;
        this.targetRelationId = 0;
        this.backlinkToOneGetter = null;
        this.backlinkToManyGetter = null;
        this.toManyGetter = null;
        this.relationId = 0;
    }

    public boolean a() {
        return (this.backlinkToManyGetter == null && this.backlinkToOneGetter == null) ? false : true;
    }

    public String toString() {
        return "RelationInfo from " + this.sourceInfo.getEntityClass() + " to " + this.targetInfo.getEntityClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RelationInfo(EntityInfo<SOURCE> entityInfo, EntityInfo<TARGET> entityInfo2, ToManyGetter<SOURCE> toManyGetter, Property<TARGET> property, ToOneGetter<TARGET> toOneGetter) {
        this.sourceInfo = entityInfo;
        this.targetInfo = entityInfo2;
        this.targetIdProperty = property;
        this.toManyGetter = toManyGetter;
        this.backlinkToOneGetter = toOneGetter;
        this.targetRelationId = 0;
        this.toOneGetter = null;
        this.backlinkToManyGetter = null;
        this.relationId = 0;
    }

    public RelationInfo(EntityInfo<SOURCE> entityInfo, EntityInfo<TARGET> entityInfo2, ToManyGetter<SOURCE> toManyGetter, ToManyGetter<TARGET> toManyGetter2, int i10) {
        this.sourceInfo = entityInfo;
        this.targetInfo = entityInfo2;
        this.toManyGetter = toManyGetter;
        this.targetRelationId = i10;
        this.backlinkToManyGetter = toManyGetter2;
        this.targetIdProperty = null;
        this.toOneGetter = null;
        this.backlinkToOneGetter = null;
        this.relationId = 0;
    }

    public RelationInfo(EntityInfo<SOURCE> entityInfo, EntityInfo<TARGET> entityInfo2, ToManyGetter<SOURCE> toManyGetter, int i10) {
        this.sourceInfo = entityInfo;
        this.targetInfo = entityInfo2;
        this.toManyGetter = toManyGetter;
        this.relationId = i10;
        this.targetRelationId = 0;
        this.targetIdProperty = null;
        this.toOneGetter = null;
        this.backlinkToOneGetter = null;
        this.backlinkToManyGetter = null;
    }
}
