#
# A simple makefile for compiling  java classes
# Type make to build your classes
#

# define a makefile variable for the java compiler
#
JCC = javac

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information
#
JFLAGS = -g


default: Server.class NaiveClient.class Bufferclient.class


Server.class: Server.java
	$(JCC) $(JFLAGS) Server.java

NaiveClient:NaiveClient.class
NaiveClient.class: NaiveClient.java
	$(JCC) $(JFLAGS) NaiveClient.java

Bufferclient:Bufferclient.class
Bufferclient.class: Bufferclient.java
	$(JCC) $(JFLAGS) Bufferclient.java


# To start over from scratch , type 'make clean'.  
# Removes all .class files, so that the next make rebuilds them
#
clean: 
	$(RM) *.class