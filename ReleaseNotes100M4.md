# ZKGrails 1.0-M4 Release Notes #

14 May 2010. This version of ZKGrails is a milestone release for the 1.0 series. It supports Grails 1.2.x and ZK 5.0.2. ZKGrails is released under LGPL.

**Note that** as it is still a milestone release, users are expected to encounter existing bugs. Please help us make the better plugin by reporting them to the issue tracker.

## Issues ##
  * [issue 27](https://code.google.com/p/zkgrails/issues/detail?id=27)	(chanwit	) It would be great to built-in support zk unit testing
  * [issue 42](https://code.google.com/p/zkgrails/issues/detail?id=42)	(fmcypriano	) Auto copy theme jar to plugins/zk/lib
  * [issue 52](https://code.google.com/p/zkgrails/issues/detail?id=52)	(chanwit	) Acegi Plugin Compatibility
  * [issue 60](https://code.google.com/p/zkgrails/issues/detail?id=60)	(chanwit	) there is something wrong when used zkgrails with freemarker plugin
  * [issue 61](https://code.google.com/p/zkgrails/issues/detail?id=61)	(chanwit	) Can not create zul for domain class inside package
  * [issue 66](https://code.google.com/p/zkgrails/issues/detail?id=66)	(chanwit	) Composer and Facade Spring's beans do not support package
  * [issue 71](https://code.google.com/p/zkgrails/issues/detail?id=71)	(chanwit	) Allow to use scaffold = true
  * [issue 75](https://code.google.com/p/zkgrails/issues/detail?id=75)	(omadruga	)  grails create-zul test/index does not work
  * [issue 96](https://code.google.com/p/zkgrails/issues/detail?id=96)	(omadruga	) IE and Opera won't work with heigth="100%" with 

&lt;z:head&gt;

...
  * [issue 105](https://code.google.com/p/zkgrails/issues/detail?id=105)	(chanwit	) No Hibernate Session bound to thread, when playing with the ToDo demo
  * [issue 108](https://code.google.com/p/zkgrails/issues/detail?id=108)	(omadruga	) Can't use forward on zk builder
  * [issue 109](https://code.google.com/p/zkgrails/issues/detail?id=109)	(omadruga	) create-zul without package fails
  * [issue 110](https://code.google.com/p/zkgrails/issues/detail?id=110)	(omadruga	) create-zul com.myapp.IndexComposer creates a IndexComposerComposer file
  * [issue 111](https://code.google.com/p/zkgrails/issues/detail?id=111)	(omadruga	) create-zul the .zul file is old and the apply attribute is not working anymore
  * [issue 112](https://code.google.com/p/zkgrails/issues/detail?id=112)	(chanwit	) Support withTransaction { ... } in GrailsComposer
  * [issue 113](https://code.google.com/p/zkgrails/issues/detail?id=113)	(chanwit	) zul not display correct in chinese
  * [issue 114](https://code.google.com/p/zkgrails/issues/detail?id=114)	(omadruga	) Creation of appengine-web.xml should be optional
  * [issue 115](https://code.google.com/p/zkgrails/issues/detail?id=115)	(chanwit	) Support for custom url mapping with zkLoader servlet
  * [issue 116](https://code.google.com/p/zkgrails/issues/detail?id=116)	(omadruga	) new ZulResponse algorithm introduced a major performance penalty
  * [issue 118](https://code.google.com/p/zkgrails/issues/detail?id=118)	(chanwit	) Sitemesh Content Blocks stop working when installing zkgrails M3
  * [issue 119](https://code.google.com/p/zkgrails/issues/detail?id=119)	(chanwit	) ${g.resource()} is not working properly for ZUL pages
  * [issue 121](https://code.google.com/p/zkgrails/issues/detail?id=121)	(chanwit	) No such property: zkPluginDir in the EE version
  * [issue 122](https://code.google.com/p/zkgrails/issues/detail?id=122)	(chanwit	) Upgrade to ZK 5.0.2
  * [issue 123](https://code.google.com/p/zkgrails/issues/detail?id=123)	(chanwit	) Include /zk/non\_package\_composer\_tests.zul for testing
  * [issue 125](https://code.google.com/p/zkgrails/issues/detail?id=125)	(chanwit	) Implement Comet artefact
  * [issue 126](https://code.google.com/p/zkgrails/issues/detail?id=126)	(chanwit	) Test case for Comet
  * [issue 127](https://code.google.com/p/zkgrails/issues/detail?id=127)	(omadruga	) NPE on ZKGrailsPageFilter.java:125
  * [issue 128](https://code.google.com/p/zkgrails/issues/detail?id=128)	(omadruga	) NPE on ZkBuilder with grails 1.3.0
demo

## Enhancements ##
  * This version ships with ZK 5.0.2.
  * New `Comet` artefacts to support real-time updates via server pulling / push.
  * Support custom extensions. You can now have your own file extension rather than .zul.
  * ZKGrails is also now available as two versions, CE and EE.
  * This version supports functional testing via grails-selenium-rc plugin. You can use `TestIdGenerator` to make your ZUL pages testable.