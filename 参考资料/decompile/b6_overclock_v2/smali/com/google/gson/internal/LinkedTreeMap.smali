.class public final Lcom/google/gson/internal/LinkedTreeMap;
.super Ljava/util/AbstractMap;
.source "LinkedTreeMap.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/gson/internal/LinkedTreeMap$KeySet;,
        Lcom/google/gson/internal/LinkedTreeMap$EntrySet;,
        Lcom/google/gson/internal/LinkedTreeMap$LinkedTreeMapIterator;,
        Lcom/google/gson/internal/LinkedTreeMap$Node;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/AbstractMap<",
        "TK;TV;>;",
        "Ljava/io/Serializable;"
    }
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z

.field private static final NATURAL_ORDER:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator<",
            "Ljava/lang/Comparable;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field comparator:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator<",
            "-TK;>;"
        }
    .end annotation
.end field

.field private entrySet:Lcom/google/gson/internal/LinkedTreeMap$EntrySet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/gson/internal/LinkedTreeMap<",
            "TK;TV;>.EntrySet;"
        }
    .end annotation
.end field

.field final header:Lcom/google/gson/internal/LinkedTreeMap$Node;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/gson/internal/LinkedTreeMap$Node<",
            "TK;TV;>;"
        }
    .end annotation
.end field

.field private keySet:Lcom/google/gson/internal/LinkedTreeMap$KeySet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/gson/internal/LinkedTreeMap<",
            "TK;TV;>.KeySet;"
        }
    .end annotation
.end field

.field modCount:I

.field root:Lcom/google/gson/internal/LinkedTreeMap$Node;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/gson/internal/LinkedTreeMap$Node<",
            "TK;TV;>;"
        }
    .end annotation
.end field

.field size:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/google/gson/internal/LinkedTreeMap$1;

    invoke-direct {v0}, Lcom/google/gson/internal/LinkedTreeMap$1;-><init>()V

    sput-object v0, Lcom/google/gson/internal/LinkedTreeMap;->NATURAL_ORDER:Ljava/util/Comparator;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    sget-object v0, Lcom/google/gson/internal/LinkedTreeMap;->NATURAL_ORDER:Ljava/util/Comparator;

    invoke-direct {p0, v0}, Lcom/google/gson/internal/LinkedTreeMap;-><init>(Ljava/util/Comparator;)V

    return-void
.end method

.method public constructor <init>(Ljava/util/Comparator;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Comparator<",
            "-TK;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/util/AbstractMap;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/gson/internal/LinkedTreeMap;->size:I

    iput v0, p0, Lcom/google/gson/internal/LinkedTreeMap;->modCount:I

    new-instance v0, Lcom/google/gson/internal/LinkedTreeMap$Node;

    invoke-direct {v0}, Lcom/google/gson/internal/LinkedTreeMap$Node;-><init>()V

    iput-object v0, p0, Lcom/google/gson/internal/LinkedTreeMap;->header:Lcom/google/gson/internal/LinkedTreeMap$Node;

    if-eqz p1, :cond_12

    goto :goto_14

    :cond_12
    sget-object p1, Lcom/google/gson/internal/LinkedTreeMap;->NATURAL_ORDER:Ljava/util/Comparator;

    :goto_14
    iput-object p1, p0, Lcom/google/gson/internal/LinkedTreeMap;->comparator:Ljava/util/Comparator;

    return-void
.end method

.method private equal(Ljava/lang/Object;Ljava/lang/Object;)Z
    .registers 3

    if-eq p1, p2, :cond_d

    if-eqz p1, :cond_b

    invoke-virtual {p1, p2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_b

    goto :goto_d

    :cond_b
    const/4 p1, 0x0

    goto :goto_e

    :cond_d
    :goto_d
    const/4 p1, 0x1

    :goto_e
    return p1
.end method

.method private rebalance(Lcom/google/gson/internal/LinkedTreeMap$Node;Z)V
    .registers 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/gson/internal/LinkedTreeMap$Node<",
            "TK;TV;>;Z)V"
        }
    .end annotation

    :goto_0
    if-eqz p1, :cond_79

    iget-object v0, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object v1, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    const/4 v2, 0x0

    if-eqz v0, :cond_c

    iget v3, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    goto :goto_d

    :cond_c
    move v3, v2

    :goto_d
    if-eqz v1, :cond_12

    iget v4, v1, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    goto :goto_13

    :cond_12
    move v4, v2

    :goto_13
    sub-int v5, v3, v4

    const/4 v6, -0x2

    if-ne v5, v6, :cond_3c

    iget-object v0, v1, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object v3, v1, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    if-eqz v3, :cond_21

    iget v3, v3, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    goto :goto_22

    :cond_21
    move v3, v2

    :goto_22
    if-eqz v0, :cond_26

    iget v2, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    :cond_26
    sub-int/2addr v2, v3

    const/4 v0, -0x1

    if-eq v2, v0, :cond_36

    if-nez v2, :cond_2f

    if-nez p2, :cond_2f

    goto :goto_36

    :cond_2f
    invoke-direct {p0, v1}, Lcom/google/gson/internal/LinkedTreeMap;->rotateRight(Lcom/google/gson/internal/LinkedTreeMap$Node;)V

    invoke-direct {p0, p1}, Lcom/google/gson/internal/LinkedTreeMap;->rotateLeft(Lcom/google/gson/internal/LinkedTreeMap$Node;)V

    goto :goto_39

    :cond_36
    :goto_36
    invoke-direct {p0, p1}, Lcom/google/gson/internal/LinkedTreeMap;->rotateLeft(Lcom/google/gson/internal/LinkedTreeMap$Node;)V

    :goto_39
    if-eqz p2, :cond_76

    goto :goto_79

    :cond_3c
    const/4 v1, 0x2

    const/4 v6, 0x1

    if-ne v5, v1, :cond_63

    iget-object v1, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object v3, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    if-eqz v3, :cond_49

    iget v3, v3, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    goto :goto_4a

    :cond_49
    move v3, v2

    :goto_4a
    if-eqz v1, :cond_4e

    iget v2, v1, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    :cond_4e
    sub-int/2addr v2, v3

    if-eq v2, v6, :cond_5d

    if-nez v2, :cond_56

    if-nez p2, :cond_56

    goto :goto_5d

    :cond_56
    invoke-direct {p0, v0}, Lcom/google/gson/internal/LinkedTreeMap;->rotateLeft(Lcom/google/gson/internal/LinkedTreeMap$Node;)V

    invoke-direct {p0, p1}, Lcom/google/gson/internal/LinkedTreeMap;->rotateRight(Lcom/google/gson/internal/LinkedTreeMap$Node;)V

    goto :goto_60

    :cond_5d
    :goto_5d
    invoke-direct {p0, p1}, Lcom/google/gson/internal/LinkedTreeMap;->rotateRight(Lcom/google/gson/internal/LinkedTreeMap$Node;)V

    :goto_60
    if-eqz p2, :cond_76

    goto :goto_79

    :cond_63
    if-nez v5, :cond_6c

    add-int/lit8 v3, v3, 0x1

    iput v3, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    if-eqz p2, :cond_76

    goto :goto_79

    :cond_6c
    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v0

    add-int/2addr v0, v6

    iput v0, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    if-nez p2, :cond_76

    goto :goto_79

    :cond_76
    iget-object p1, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->parent:Lcom/google/gson/internal/LinkedTreeMap$Node;

    goto :goto_0

    :cond_79
    :goto_79
    return-void
.end method

.method private replaceInParent(Lcom/google/gson/internal/LinkedTreeMap$Node;Lcom/google/gson/internal/LinkedTreeMap$Node;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/gson/internal/LinkedTreeMap$Node<",
            "TK;TV;>;",
            "Lcom/google/gson/internal/LinkedTreeMap$Node<",
            "TK;TV;>;)V"
        }
    .end annotation

    iget-object v0, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->parent:Lcom/google/gson/internal/LinkedTreeMap$Node;

    const/4 v1, 0x0

    iput-object v1, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->parent:Lcom/google/gson/internal/LinkedTreeMap$Node;

    if-eqz p2, :cond_9

    iput-object v0, p2, Lcom/google/gson/internal/LinkedTreeMap$Node;->parent:Lcom/google/gson/internal/LinkedTreeMap$Node;

    :cond_9
    if-eqz v0, :cond_15

    iget-object v1, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    if-ne v1, p1, :cond_12

    iput-object p2, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    goto :goto_17

    :cond_12
    iput-object p2, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    goto :goto_17

    :cond_15
    iput-object p2, p0, Lcom/google/gson/internal/LinkedTreeMap;->root:Lcom/google/gson/internal/LinkedTreeMap$Node;

    :goto_17
    return-void
.end method

.method private rotateLeft(Lcom/google/gson/internal/LinkedTreeMap$Node;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/gson/internal/LinkedTreeMap$Node<",
            "TK;TV;>;)V"
        }
    .end annotation

    iget-object v0, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object v1, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object v2, v1, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object v3, v1, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iput-object v2, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    if-eqz v2, :cond_e

    iput-object p1, v2, Lcom/google/gson/internal/LinkedTreeMap$Node;->parent:Lcom/google/gson/internal/LinkedTreeMap$Node;

    :cond_e
    invoke-direct {p0, p1, v1}, Lcom/google/gson/internal/LinkedTreeMap;->replaceInParent(Lcom/google/gson/internal/LinkedTreeMap$Node;Lcom/google/gson/internal/LinkedTreeMap$Node;)V

    iput-object p1, v1, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iput-object v1, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->parent:Lcom/google/gson/internal/LinkedTreeMap$Node;

    const/4 v4, 0x0

    if-eqz v0, :cond_1b

    iget v0, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    goto :goto_1c

    :cond_1b
    move v0, v4

    :goto_1c
    if-eqz v2, :cond_21

    iget v2, v2, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    goto :goto_22

    :cond_21
    move v2, v4

    :goto_22
    invoke-static {v0, v2}, Ljava/lang/Math;->max(II)I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    iput v0, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    iget p1, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    if-eqz v3, :cond_30

    iget v4, v3, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    :cond_30
    invoke-static {p1, v4}, Ljava/lang/Math;->max(II)I

    move-result p1

    add-int/lit8 p1, p1, 0x1

    iput p1, v1, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    return-void
.end method

.method private rotateRight(Lcom/google/gson/internal/LinkedTreeMap$Node;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/gson/internal/LinkedTreeMap$Node<",
            "TK;TV;>;)V"
        }
    .end annotation

    iget-object v0, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object v1, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object v2, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object v3, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iput-object v3, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    if-eqz v3, :cond_e

    iput-object p1, v3, Lcom/google/gson/internal/LinkedTreeMap$Node;->parent:Lcom/google/gson/internal/LinkedTreeMap$Node;

    :cond_e
    invoke-direct {p0, p1, v0}, Lcom/google/gson/internal/LinkedTreeMap;->replaceInParent(Lcom/google/gson/internal/LinkedTreeMap$Node;Lcom/google/gson/internal/LinkedTreeMap$Node;)V

    iput-object p1, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iput-object v0, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->parent:Lcom/google/gson/internal/LinkedTreeMap$Node;

    const/4 v4, 0x0

    if-eqz v1, :cond_1b

    iget v1, v1, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    goto :goto_1c

    :cond_1b
    move v1, v4

    :goto_1c
    if-eqz v3, :cond_21

    iget v3, v3, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    goto :goto_22

    :cond_21
    move v3, v4

    :goto_22
    invoke-static {v1, v3}, Ljava/lang/Math;->max(II)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    iput v1, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    iget p1, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    if-eqz v2, :cond_30

    iget v4, v2, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    :cond_30
    invoke-static {p1, v4}, Ljava/lang/Math;->max(II)I

    move-result p1

    add-int/lit8 p1, p1, 0x1

    iput p1, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    return-void
.end method

.method private writeReplace()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/ObjectStreamException;
        }
    .end annotation

    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0, p0}, Ljava/util/LinkedHashMap;-><init>(Ljava/util/Map;)V

    return-object v0
.end method


# virtual methods
.method public clear()V
    .registers 2

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/gson/internal/LinkedTreeMap;->root:Lcom/google/gson/internal/LinkedTreeMap$Node;

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/gson/internal/LinkedTreeMap;->size:I

    iget v0, p0, Lcom/google/gson/internal/LinkedTreeMap;->modCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/gson/internal/LinkedTreeMap;->modCount:I

    iget-object v0, p0, Lcom/google/gson/internal/LinkedTreeMap;->header:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iput-object v0, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->prev:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iput-object v0, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->next:Lcom/google/gson/internal/LinkedTreeMap$Node;

    return-void
.end method

.method public containsKey(Ljava/lang/Object;)Z
    .registers 2

    invoke-virtual {p0, p1}, Lcom/google/gson/internal/LinkedTreeMap;->findByObject(Ljava/lang/Object;)Lcom/google/gson/internal/LinkedTreeMap$Node;

    move-result-object p1

    if-eqz p1, :cond_8

    const/4 p1, 0x1

    goto :goto_9

    :cond_8
    const/4 p1, 0x0

    :goto_9
    return p1
.end method

.method public entrySet()Ljava/util/Set;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set<",
            "Ljava/util/Map$Entry<",
            "TK;TV;>;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/gson/internal/LinkedTreeMap;->entrySet:Lcom/google/gson/internal/LinkedTreeMap$EntrySet;

    if-eqz v0, :cond_5

    goto :goto_c

    :cond_5
    new-instance v0, Lcom/google/gson/internal/LinkedTreeMap$EntrySet;

    invoke-direct {v0, p0}, Lcom/google/gson/internal/LinkedTreeMap$EntrySet;-><init>(Lcom/google/gson/internal/LinkedTreeMap;)V

    iput-object v0, p0, Lcom/google/gson/internal/LinkedTreeMap;->entrySet:Lcom/google/gson/internal/LinkedTreeMap$EntrySet;

    :goto_c
    return-object v0
.end method

.method find(Ljava/lang/Object;Z)Lcom/google/gson/internal/LinkedTreeMap$Node;
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;Z)",
            "Lcom/google/gson/internal/LinkedTreeMap$Node<",
            "TK;TV;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/gson/internal/LinkedTreeMap;->comparator:Ljava/util/Comparator;

    iget-object v1, p0, Lcom/google/gson/internal/LinkedTreeMap;->root:Lcom/google/gson/internal/LinkedTreeMap$Node;

    const/4 v2, 0x0

    if-eqz v1, :cond_2e

    sget-object v3, Lcom/google/gson/internal/LinkedTreeMap;->NATURAL_ORDER:Ljava/util/Comparator;

    if-ne v0, v3, :cond_f

    move-object v3, p1

    check-cast v3, Ljava/lang/Comparable;

    goto :goto_10

    :cond_f
    move-object v3, v2

    :goto_10
    if-eqz v3, :cond_19

    iget-object v4, v1, Lcom/google/gson/internal/LinkedTreeMap$Node;->key:Ljava/lang/Object;

    invoke-interface {v3, v4}, Ljava/lang/Comparable;->compareTo(Ljava/lang/Object;)I

    move-result v4

    goto :goto_1f

    :cond_19
    iget-object v4, v1, Lcom/google/gson/internal/LinkedTreeMap$Node;->key:Ljava/lang/Object;

    invoke-interface {v0, p1, v4}, Ljava/util/Comparator;->compare(Ljava/lang/Object;Ljava/lang/Object;)I

    move-result v4

    :goto_1f
    if-nez v4, :cond_22

    return-object v1

    :cond_22
    if-gez v4, :cond_27

    iget-object v5, v1, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    goto :goto_29

    :cond_27
    iget-object v5, v1, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    :goto_29
    if-nez v5, :cond_2c

    goto :goto_2f

    :cond_2c
    move-object v1, v5

    goto :goto_10

    :cond_2e
    const/4 v4, 0x0

    :goto_2f
    if-nez p2, :cond_32

    return-object v2

    :cond_32
    iget-object p2, p0, Lcom/google/gson/internal/LinkedTreeMap;->header:Lcom/google/gson/internal/LinkedTreeMap$Node;

    const/4 v2, 0x1

    if-nez v1, :cond_6b

    sget-object v3, Lcom/google/gson/internal/LinkedTreeMap;->NATURAL_ORDER:Ljava/util/Comparator;

    if-ne v0, v3, :cond_61

    instance-of v0, p1, Ljava/lang/Comparable;

    if-eqz v0, :cond_40

    goto :goto_61

    :cond_40
    new-instance p2, Ljava/lang/ClassCastException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string v0, " is not Comparable"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/ClassCastException;-><init>(Ljava/lang/String;)V

    throw p2

    :cond_61
    :goto_61
    new-instance v0, Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object v3, p2, Lcom/google/gson/internal/LinkedTreeMap$Node;->prev:Lcom/google/gson/internal/LinkedTreeMap$Node;

    invoke-direct {v0, v1, p1, p2, v3}, Lcom/google/gson/internal/LinkedTreeMap$Node;-><init>(Lcom/google/gson/internal/LinkedTreeMap$Node;Ljava/lang/Object;Lcom/google/gson/internal/LinkedTreeMap$Node;Lcom/google/gson/internal/LinkedTreeMap$Node;)V

    iput-object v0, p0, Lcom/google/gson/internal/LinkedTreeMap;->root:Lcom/google/gson/internal/LinkedTreeMap$Node;

    goto :goto_7c

    :cond_6b
    new-instance v0, Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object v3, p2, Lcom/google/gson/internal/LinkedTreeMap$Node;->prev:Lcom/google/gson/internal/LinkedTreeMap$Node;

    invoke-direct {v0, v1, p1, p2, v3}, Lcom/google/gson/internal/LinkedTreeMap$Node;-><init>(Lcom/google/gson/internal/LinkedTreeMap$Node;Ljava/lang/Object;Lcom/google/gson/internal/LinkedTreeMap$Node;Lcom/google/gson/internal/LinkedTreeMap$Node;)V

    if-gez v4, :cond_77

    iput-object v0, v1, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    goto :goto_79

    :cond_77
    iput-object v0, v1, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    :goto_79
    invoke-direct {p0, v1, v2}, Lcom/google/gson/internal/LinkedTreeMap;->rebalance(Lcom/google/gson/internal/LinkedTreeMap$Node;Z)V

    :goto_7c
    iget p1, p0, Lcom/google/gson/internal/LinkedTreeMap;->size:I

    add-int/2addr p1, v2

    iput p1, p0, Lcom/google/gson/internal/LinkedTreeMap;->size:I

    iget p1, p0, Lcom/google/gson/internal/LinkedTreeMap;->modCount:I

    add-int/2addr p1, v2

    iput p1, p0, Lcom/google/gson/internal/LinkedTreeMap;->modCount:I

    return-object v0
.end method

.method findByEntry(Ljava/util/Map$Entry;)Lcom/google/gson/internal/LinkedTreeMap$Node;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map$Entry<",
            "**>;)",
            "Lcom/google/gson/internal/LinkedTreeMap$Node<",
            "TK;TV;>;"
        }
    .end annotation

    invoke-interface {p1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/google/gson/internal/LinkedTreeMap;->findByObject(Ljava/lang/Object;)Lcom/google/gson/internal/LinkedTreeMap$Node;

    move-result-object v0

    if-eqz v0, :cond_18

    iget-object v1, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->value:Ljava/lang/Object;

    invoke-interface {p1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object p1

    invoke-direct {p0, v1, p1}, Lcom/google/gson/internal/LinkedTreeMap;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_18

    const/4 p1, 0x1

    goto :goto_19

    :cond_18
    const/4 p1, 0x0

    :goto_19
    if-eqz p1, :cond_1c

    goto :goto_1d

    :cond_1c
    const/4 v0, 0x0

    :goto_1d
    return-object v0
.end method

.method findByObject(Ljava/lang/Object;)Lcom/google/gson/internal/LinkedTreeMap$Node;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Lcom/google/gson/internal/LinkedTreeMap$Node<",
            "TK;TV;>;"
        }
    .end annotation

    const/4 v0, 0x0

    if-eqz p1, :cond_9

    const/4 v1, 0x0

    :try_start_4
    invoke-virtual {p0, p1, v1}, Lcom/google/gson/internal/LinkedTreeMap;->find(Ljava/lang/Object;Z)Lcom/google/gson/internal/LinkedTreeMap$Node;

    move-result-object v0
    :try_end_8
    .catch Ljava/lang/ClassCastException; {:try_start_4 .. :try_end_8} :catch_9

    nop

    :catch_9
    :cond_9
    return-object v0
.end method

.method public get(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")TV;"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/google/gson/internal/LinkedTreeMap;->findByObject(Ljava/lang/Object;)Lcom/google/gson/internal/LinkedTreeMap$Node;

    move-result-object p1

    if-eqz p1, :cond_9

    iget-object p1, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->value:Ljava/lang/Object;

    goto :goto_a

    :cond_9
    const/4 p1, 0x0

    :goto_a
    return-object p1
.end method

.method public keySet()Ljava/util/Set;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set<",
            "TK;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/gson/internal/LinkedTreeMap;->keySet:Lcom/google/gson/internal/LinkedTreeMap$KeySet;

    if-eqz v0, :cond_5

    goto :goto_c

    :cond_5
    new-instance v0, Lcom/google/gson/internal/LinkedTreeMap$KeySet;

    invoke-direct {v0, p0}, Lcom/google/gson/internal/LinkedTreeMap$KeySet;-><init>(Lcom/google/gson/internal/LinkedTreeMap;)V

    iput-object v0, p0, Lcom/google/gson/internal/LinkedTreeMap;->keySet:Lcom/google/gson/internal/LinkedTreeMap$KeySet;

    :goto_c
    return-object v0
.end method

.method public put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)TV;"
        }
    .end annotation

    if-eqz p1, :cond_c

    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lcom/google/gson/internal/LinkedTreeMap;->find(Ljava/lang/Object;Z)Lcom/google/gson/internal/LinkedTreeMap$Node;

    move-result-object p1

    iget-object v0, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->value:Ljava/lang/Object;

    iput-object p2, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->value:Ljava/lang/Object;

    return-object v0

    :cond_c
    new-instance p1, Ljava/lang/NullPointerException;

    const-string p2, "key == null"

    invoke-direct {p1, p2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public remove(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")TV;"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/google/gson/internal/LinkedTreeMap;->removeInternalByKey(Ljava/lang/Object;)Lcom/google/gson/internal/LinkedTreeMap$Node;

    move-result-object p1

    if-eqz p1, :cond_9

    iget-object p1, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->value:Ljava/lang/Object;

    goto :goto_a

    :cond_9
    const/4 p1, 0x0

    :goto_a
    return-object p1
.end method

.method removeInternal(Lcom/google/gson/internal/LinkedTreeMap$Node;Z)V
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/gson/internal/LinkedTreeMap$Node<",
            "TK;TV;>;Z)V"
        }
    .end annotation

    if-eqz p2, :cond_e

    iget-object p2, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->prev:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object v0, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->next:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iput-object v0, p2, Lcom/google/gson/internal/LinkedTreeMap$Node;->next:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object p2, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->next:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object v0, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->prev:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iput-object v0, p2, Lcom/google/gson/internal/LinkedTreeMap$Node;->prev:Lcom/google/gson/internal/LinkedTreeMap$Node;

    :cond_e
    iget-object p2, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object v0, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iget-object v1, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->parent:Lcom/google/gson/internal/LinkedTreeMap$Node;

    const/4 v2, 0x0

    const/4 v3, 0x0

    if-eqz p2, :cond_52

    if-eqz v0, :cond_52

    iget v1, p2, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    iget v4, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    if-le v1, v4, :cond_25

    invoke-virtual {p2}, Lcom/google/gson/internal/LinkedTreeMap$Node;->last()Lcom/google/gson/internal/LinkedTreeMap$Node;

    move-result-object p2

    goto :goto_29

    :cond_25
    invoke-virtual {v0}, Lcom/google/gson/internal/LinkedTreeMap$Node;->first()Lcom/google/gson/internal/LinkedTreeMap$Node;

    move-result-object p2

    :goto_29
    invoke-virtual {p0, p2, v2}, Lcom/google/gson/internal/LinkedTreeMap;->removeInternal(Lcom/google/gson/internal/LinkedTreeMap$Node;Z)V

    iget-object v0, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    if-eqz v0, :cond_39

    iget v1, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    iput-object v0, p2, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iput-object p2, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->parent:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iput-object v3, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    goto :goto_3a

    :cond_39
    move v1, v2

    :goto_3a
    iget-object v0, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    if-eqz v0, :cond_46

    iget v2, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    iput-object v0, p2, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iput-object p2, v0, Lcom/google/gson/internal/LinkedTreeMap$Node;->parent:Lcom/google/gson/internal/LinkedTreeMap$Node;

    iput-object v3, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    :cond_46
    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    iput v0, p2, Lcom/google/gson/internal/LinkedTreeMap$Node;->height:I

    invoke-direct {p0, p1, p2}, Lcom/google/gson/internal/LinkedTreeMap;->replaceInParent(Lcom/google/gson/internal/LinkedTreeMap$Node;Lcom/google/gson/internal/LinkedTreeMap$Node;)V

    return-void

    :cond_52
    if-eqz p2, :cond_5a

    invoke-direct {p0, p1, p2}, Lcom/google/gson/internal/LinkedTreeMap;->replaceInParent(Lcom/google/gson/internal/LinkedTreeMap$Node;Lcom/google/gson/internal/LinkedTreeMap$Node;)V

    iput-object v3, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->left:Lcom/google/gson/internal/LinkedTreeMap$Node;

    goto :goto_65

    :cond_5a
    if-eqz v0, :cond_62

    invoke-direct {p0, p1, v0}, Lcom/google/gson/internal/LinkedTreeMap;->replaceInParent(Lcom/google/gson/internal/LinkedTreeMap$Node;Lcom/google/gson/internal/LinkedTreeMap$Node;)V

    iput-object v3, p1, Lcom/google/gson/internal/LinkedTreeMap$Node;->right:Lcom/google/gson/internal/LinkedTreeMap$Node;

    goto :goto_65

    :cond_62
    invoke-direct {p0, p1, v3}, Lcom/google/gson/internal/LinkedTreeMap;->replaceInParent(Lcom/google/gson/internal/LinkedTreeMap$Node;Lcom/google/gson/internal/LinkedTreeMap$Node;)V

    :goto_65
    invoke-direct {p0, v1, v2}, Lcom/google/gson/internal/LinkedTreeMap;->rebalance(Lcom/google/gson/internal/LinkedTreeMap$Node;Z)V

    iget p1, p0, Lcom/google/gson/internal/LinkedTreeMap;->size:I

    add-int/lit8 p1, p1, -0x1

    iput p1, p0, Lcom/google/gson/internal/LinkedTreeMap;->size:I

    iget p1, p0, Lcom/google/gson/internal/LinkedTreeMap;->modCount:I

    add-int/lit8 p1, p1, 0x1

    iput p1, p0, Lcom/google/gson/internal/LinkedTreeMap;->modCount:I

    return-void
.end method

.method removeInternalByKey(Ljava/lang/Object;)Lcom/google/gson/internal/LinkedTreeMap$Node;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Lcom/google/gson/internal/LinkedTreeMap$Node<",
            "TK;TV;>;"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/google/gson/internal/LinkedTreeMap;->findByObject(Ljava/lang/Object;)Lcom/google/gson/internal/LinkedTreeMap$Node;

    move-result-object p1

    if-eqz p1, :cond_a

    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lcom/google/gson/internal/LinkedTreeMap;->removeInternal(Lcom/google/gson/internal/LinkedTreeMap$Node;Z)V

    :cond_a
    return-object p1
.end method

.method public size()I
    .registers 2

    iget v0, p0, Lcom/google/gson/internal/LinkedTreeMap;->size:I

    return v0
.end method
