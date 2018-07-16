.source a.java
.class public super lin/java/test/test/a
.super java/lang/Object


.method public <init> ()V
.limit stack 1
.limit locals 1
.line 3
l0:    aload_0
l1:    invokespecial java/lang/Object/<init> ()V
l4:    return

.end method

.method public static main ([Ljava/lang/String;)V
.limit stack 2
.limit locals 1
.line 5
l0:    getstatic java/lang/System/out Ljava/io/PrintStream;
l3:    ldc "hello world"
l5:    invokevirtual java/io/PrintStream/println (Ljava/lang/String;)V
.line 6
l8:    return

.end method

