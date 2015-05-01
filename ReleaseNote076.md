# ZKGrails 0.7.6 Release Note #

30 Nov 2009. This version of ZKGrails is a maintenance release for 0.7 series. It supports Grails 1.1.2 and ZK 3.6.3.

# Issues #

  * [Issue 22](https://code.google.com/p/zkgrails/issues/detail?id=22)    Support embeding ZUL into GSP (was Support render(zul:"index.zul"))
  * [Issue 68](https://code.google.com/p/zkgrails/issues/detail?id=68)	Upgrade ZK for 0.7 series to 3.6.3
  * [Issue 69](https://code.google.com/p/zkgrails/issues/detail?id=69)	Cherry-pick ZkBuilder's patch
  * [Issue 70](https://code.google.com/p/zkgrails/issues/detail?id=70)	Backport onEvent to call invokeMethod in GrailsComposer
  * [Issue 72](https://code.google.com/p/zkgrails/issues/detail?id=72)	NPE on ZkBuilder with zkgrails 0.7.6
  * [Issue 73](https://code.google.com/p/zkgrails/issues/detail?id=73)    Creating the "build" property for GrailsComposer

# Enhancement #

  * This version includes ZK 3.6.3.
  * You can now embed a ZUL page (as fragments) into a GSP using two tags: `<z:head/>` and `<z:body/>`. So you can leverage UrlMapping and also Sitemesh decoration for your ZUL pages. Thanks wehe@gmx.at, for this contribution.

> Both tags accept zul="your zul page" attribute, like: `<z:body zul="/test/index.zul"/>`. And by default, these tags **automatically** detect from which controller or action you're rendering. If you're rendering a page from `TestController.index`, then both tags find the `/test/index.zul` file for you. This is the same convention used by Grails' views.

  * You can now use the `build` property, a ZkBuilder of the current ZUL page, inside your GrailsComposer to create ZK user-interface.