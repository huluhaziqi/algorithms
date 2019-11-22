.source PerfectSquare.java
.class public super lin/java/test/algorithms/bfs_dfs/PerfectSquare
.super java/lang/Object


.method public <init> ()V
.limit stack 1
.limit locals 1
.line 8
l0:    aload_0
l1:    invokespecial java/lang/Object/<init> ()V
l4:    return

.end method

.method public static main ([Ljava/lang/String;)V
.limit stack 2
.limit locals 4
.line 11
l0:    bipush 12
l2:    istore_1
.line 12
l3:    new lin/java/test/algorithms/bfs_dfs/PerfectSquare
l6:    dup
l7:    invokespecial lin/java/test/algorithms/bfs_dfs/PerfectSquare/<init> ()V
l10:    iload_1
l11:    invokevirtual lin/java/test/algorithms/bfs_dfs/PerfectSquare/generate (I)Ljava/util/List;
l14:    astore_2
.line 13
l15:    new lin/java/test/algorithms/bfs_dfs/PerfectSquare
l18:    dup
l19:    invokespecial lin/java/test/algorithms/bfs_dfs/PerfectSquare/<init> ()V
l22:    iload_1
l23:    invokevirtual lin/java/test/algorithms/bfs_dfs/PerfectSquare/numSquares2 (I)I
l26:    istore_3
.line 14
l27:    getstatic java/lang/System/out Ljava/io/PrintStream;
l30:    iload_3
l31:    invokevirtual java/io/PrintStream/println (I)V
.line 15
l34:    return

.end method

.method public numSquares2 (I)I
.limit stack 3
.limit locals 11
.line 18
l0:    aload_0
l1:    iload_1
l2:    invokevirtual lin/java/test/algorithms/bfs_dfs/PerfectSquare/generate (I)Ljava/util/List;
l5:    astore_2
.line 19
l6:    new java/util/LinkedList
l9:    dup
l10:    invokespecial java/util/LinkedList/<init> ()V
l13:    astore_3
.line 20
l14:    iload_1
l15:    iconst_1
l16:    iadd
l17:    newarray boolean
l19:    astore 4
.line 21
l21:    aload_3
l22:    iload_1
l23:    invokestatic java/lang/Integer/valueOf (I)Ljava/lang/Integer;
l26:    invokeinterface java/util/Queue/add (Ljava/lang/Object;)Z 2
l31:    pop
.line 22
l32:    aload 4
l34:    iload_1
l35:    iconst_1
l36:    bastore
.line 23
l37:    iconst_0
l38:    istore 5
.line 24
l40:    aload_3
l41:    invokeinterface java/util/Queue/isEmpty ()Z 1
l46:    ifne l179
.line 25
l49:    aload_3
l50:    invokeinterface java/util/Queue/size ()I 1
l55:    istore 6
.line 26
l57:    iinc 5 1
.line 27
l60:    iload 6
l62:    iinc 6 -1
l65:    ifle l176
.line 28
l68:    aload_3
l69:    invokeinterface java/util/Queue/poll ()Ljava/lang/Object; 1
l74:    checkcast java/lang/Integer
l77:    invokevirtual java/lang/Integer/intValue ()I
l80:    istore 7
.line 29
l82:    aload_2
l83:    invokeinterface java/util/List/iterator ()Ljava/util/Iterator; 1
l88:    astore 8
l90:    aload 8
l92:    invokeinterface java/util/Iterator/hasNext ()Z 1
l97:    ifeq l173
l100:    aload 8
l102:    invokeinterface java/util/Iterator/next ()Ljava/lang/Object; 1
l107:    checkcast java/lang/Integer
l110:    invokevirtual java/lang/Integer/intValue ()I
l113:    istore 9
.line 30
l115:    iload 7
l117:    iload 9
l119:    isub
l120:    istore 10
.line 31
l122:    iload 10
l124:    ifge l130
.line 32
l127:    goto l173
.line 33
l130:    iload 10
l132:    ifne l138
.line 34
l135:    iload 5
l137:    ireturn
.line 35
l138:    aload 4
l140:    iload 10
l142:    baload
l143:    ifeq l149
.line 36
l146:    goto l90
.line 37
l149:    aload 4
l151:    iload 10
l153:    iconst_1
l154:    bastore
.line 38
l155:    aload_3
l156:    iload 7
l158:    iload 9
l160:    isub
l161:    invokestatic java/lang/Integer/valueOf (I)Ljava/lang/Integer;
l164:    invokeinterface java/util/Queue/add (Ljava/lang/Object;)Z 2
l169:    pop
.line 39
l170:    goto l90
.line 40
l173:    goto l60
.line 41
l176:    goto l40
.line 42
l179:    iload_1
l180:    ireturn

.end method

.method public numSquares (I)I
.limit stack 6
.limit locals 6
.line 46
l0:    aload_0
l1:    iload_1
l2:    invokevirtual lin/java/test/algorithms/bfs_dfs/PerfectSquare/generate (I)Ljava/util/List;
l5:    astore_2
.line 47
l6:    iload_1
l7:    iconst_1
l8:    iadd
l9:    newarray int
l11:    astore_3
.line 48
l12:    iconst_1
l13:    istore 4
l15:    iload 4
l17:    iload_1
l18:    if_icmpgt l99
.line 49
l21:    aload_3
l22:    iload 4
l24:    ldc 2147483647
l26:    iastore
.line 50
l27:    iload 4
l29:    aload_2
l30:    iconst_0
l31:    invokeinterface java/util/List/get (I)Ljava/lang/Object; 2
l36:    checkcast java/lang/Integer
l39:    invokevirtual java/lang/Integer/intValue ()I
l42:    isub
l43:    iflt l93
l46:    aload_3
l47:    iload 4
l49:    aload_2
l50:    iconst_0
l51:    invokeinterface java/util/List/get (I)Ljava/lang/Object; 2
l56:    checkcast java/lang/Integer
l59:    invokevirtual java/lang/Integer/intValue ()I
l62:    isub
l63:    iaload
l64:    ldc 2147483647
l66:    if_icmpeq l93
.line 51
l69:    aload_3
l70:    iload 4
l72:    aload_3
l73:    iload 4
l75:    aload_2
l76:    iconst_0
l77:    invokeinterface java/util/List/get (I)Ljava/lang/Object; 2
l82:    checkcast java/lang/Integer
l85:    invokevirtual java/lang/Integer/intValue ()I
l88:    isub
l89:    iaload
l90:    iconst_1
l91:    iadd
l92:    iastore
.line 48
l93:    iinc 4 1
l96:    goto l15
.line 54
l99:    iconst_1
l100:    istore 4
l102:    iload 4
l104:    aload_2
l105:    invokeinterface java/util/List/size ()I 1
l110:    if_icmpge l210
.line 55
l113:    iconst_1
l114:    istore 5
l116:    iload 5
l118:    iload_1
l119:    if_icmpgt l204
.line 56
l122:    iload 5
l124:    aload_2
l125:    iload 4
l127:    invokeinterface java/util/List/get (I)Ljava/lang/Object; 2
l132:    checkcast java/lang/Integer
l135:    invokevirtual java/lang/Integer/intValue ()I
l138:    isub
l139:    iflt l198
l142:    aload_3
l143:    iload 4
l145:    aload_2
l146:    iload 4
l148:    invokeinterface java/util/List/get (I)Ljava/lang/Object; 2
l153:    checkcast java/lang/Integer
l156:    invokevirtual java/lang/Integer/intValue ()I
l159:    isub
l160:    iaload
l161:    ldc 2147483647
l163:    if_icmpeq l198
.line 57
l166:    aload_3
l167:    iload 5
l169:    aload_3
l170:    iload 5
l172:    aload_2
l173:    iload 4
l175:    invokeinterface java/util/List/get (I)Ljava/lang/Object; 2
l180:    checkcast java/lang/Integer
l183:    invokevirtual java/lang/Integer/intValue ()I
l186:    isub
l187:    iaload
l188:    iconst_1
l189:    iadd
l190:    aload_3
l191:    iload 5
l193:    iaload
l194:    invokestatic java/lang/Math/min (II)I
l197:    iastore
.line 55
l198:    iinc 5 1
l201:    goto l116
.line 54
l204:    iinc 4 1
l207:    goto l102
.line 61
l210:    aload_3
l211:    iload_1
l212:    iaload
l213:    ireturn

.end method

.method generate (I)Ljava/util/List;
.limit stack 2
.limit locals 5
.line 65
l0:    new java/util/ArrayList
l3:    dup
l4:    invokespecial java/util/ArrayList/<init> ()V
l7:    astore_2
.line 67
l8:    iconst_1
l9:    istore_3
.line 68
l10:    iconst_3
l11:    istore 4
.line 69
l13:    iload_3
l14:    iload_1
l15:    if_icmpgt l40
.line 70
l18:    aload_2
l19:    iload_3
l20:    invokestatic java/lang/Integer/valueOf (I)Ljava/lang/Integer;
l23:    invokeinterface java/util/List/add (Ljava/lang/Object;)Z 2
l28:    pop
.line 71
l29:    iload_3
l30:    iload 4
l32:    iadd
l33:    istore_3
.line 72
l34:    iinc 4 2
l37:    goto l13
.line 74
l40:    aload_2
l41:    areturn

.end method

