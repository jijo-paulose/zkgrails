# ZKGrails 1.0-M2 Release Notes #

5 Feb 2010. This version of ZKGrails is a milestone release for the 1.0 series. It supports Grails 1.2 and ZK 5. ZKGrails is now released under LGPL.

**Note that** as it is still a milestone release, users are expected to encounter existing bugs. Please help us make the better plugin by reporting them to the issue tracker.

## Issues ##
  * [issue 78](https://code.google.com/p/zkgrails/issues/detail?id=78) ZulResponse broken with ZK5
  * [issue 67](https://code.google.com/p/zkgrails/issues/detail?id=67) CreateZulWithFacade is still not complete
  * [issue 85](https://code.google.com/p/zkgrails/issues/detail?id=85) Support Grails tag libs in ZUL
  * [issue 92](https://code.google.com/p/zkgrails/issues/detail?id=92) Write a composer resolver
  * [issue 64](https://code.google.com/p/zkgrails/issues/detail?id=64) Cannot create zul for domain class inside package and cannot create-zul-with-facade.
  * [issue 74](https://code.google.com/p/zkgrails/issues/detail?id=74) Make ZK's session in composers behave like http session in grails composer
  * [issue 77](https://code.google.com/p/zkgrails/issues/detail?id=77) tag lib for i3-label resource from gsp
  * [issue 82](https://code.google.com/p/zkgrails/issues/detail?id=82) NPE when adding a event handler with ZkBuilder
  * [issue 86](https://code.google.com/p/zkgrails/issues/detail?id=86) Upgrade to ZK 5.0 final
  * [issue 87](https://code.google.com/p/zkgrails/issues/detail?id=87) Split ZKGrails into 2 versions, CE and EE
  * [issue 89](https://code.google.com/p/zkgrails/issues/detail?id=89) 'resource' Taglib in ZUL renders the plugin path, not the app's path.
  * [issue 90](https://code.google.com/p/zkgrails/issues/detail?id=90) `<window apply="${myComposer}">` won't work because GSP looks up and return no results
  * [issue 91](https://code.google.com/p/zkgrails/issues/detail?id=91) Update ZK patches to the zk-delta repository
  * [issue 93](https://code.google.com/p/zkgrails/issues/detail?id=93) Able to turn off tablib support using a configuration

## Enhancements ##

  * This version supports ZK 5 final.
  * Now you can use Grails tag libraries to create custom components.
  * This version introduces **a breaking change** on using `#{..}` instead of `${..}` because `${..}` expressions will be recognised by the GSP tag library parser.
  * If you would like to disable the GSP tag library feature, you can put:
```
grails.zk.taglib.disabled = true
```
in `grails-app/conf/Config.groovy`.
  * Support beans under package. The `apply` attribute now looks up Spring Beans automatically without specifying the bean name as an #{..} expression. For example:
```
  <window apply="test.indexComposer">
```
> The only exception is that if the composer is in the default package (bad practice). Then you have to enclose with #{}. Like:
```
  <window apply="#{indexComposer}">
```