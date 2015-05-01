# ZKGrails 1.0-M3 Release Notes #

5 Apr 2010. This version of ZKGrails is a milestone release for the 1.0 series. It supports Grails 1.2.x and ZK 5.0.1. ZKGrails is released under LGPL.

**Note that** as it is still a milestone release, users are expected to encounter existing bugs. Please help us make the better plugin by reporting them to the issue tracker.

## Issues ##
  * [issue 95](https://code.google.com/p/zkgrails/issues/detail?id=95)    (chanwit)     There is a potential bug at "@{..}" and "a$b.c" when enabled GSP taglib
  * [issue 96](https://code.google.com/p/zkgrails/issues/detail?id=96)    (omadruga)    IE and Opera won't work with heigth="100%" with 

&lt;z:head&gt;

...
  * [issue 36](https://code.google.com/p/zkgrails/issues/detail?id=36)    (chanwit)     Make facade's scope configurable
  * [issue 59](https://code.google.com/p/zkgrails/issues/detail?id=59)    -           Recognize grails taglibs (and other implicit variables) in composers
  * [issue 99](https://code.google.com/p/zkgrails/issues/detail?id=99)    (chanwit)     Upgrade to ZK 5.0.1
  * [issue 100](https://code.google.com/p/zkgrails/issues/detail?id=100)   (omadruga)    Enhancements to ZkBuilder
  * [issue 102](https://code.google.com/p/zkgrails/issues/detail?id=102)   (chanwit)     Use Map as a forward value (forward:[onClick:"onA,onB"])
  * [issue 104](https://code.google.com/p/zkgrails/issues/detail?id=104)   (fmcypriano)  Porting [issue 103](https://code.google.com/p/zkgrails/issues/detail?id=103) to ZKGrails 1.0 series
  * [issue 105](https://code.google.com/p/zkgrails/issues/detail?id=105)   (chanwit)     No Hibernate Session bound to thread, when playing with the ToDo demo

## Enhancements ##
  * This version contains ZK 5.0.1.
  * ZkBuilder now supports client-side event handlers, if a code assigned to a handler is String.
  * ZkBuilder also supports the `forward` attribute.
  * In GrailsComposer, every event handle is now automatically fired under a Spring transaction.
  * Binder supports a new method to load a list of components.