# ZKGrails 1.0-M5 Release Notes #

1 Oct 2010. This version of ZKGrails is a milestone release for the 1.0 series. It supports Grails 1.2.x and ZK 5.0.4. ZKGrails is released under LGPL.

**Note that** as it is still a milestone release, users are expected to encounter existing bugs. Please help us make the better plugin by reporting them to the issue tracker.

## Issues ##
  * [issue 78](https://code.google.com/p/zkgrails/issues/detail?id=78)  (chanwit)  ZulResponse broken with ZK5
  * [issue 79](https://code.google.com/p/zkgrails/issues/detail?id=79)  (chanwit)  Update jasperreport library
  * [issue 96](https://code.google.com/p/zkgrails/issues/detail?id=96)  (omadruga) IE and Opera won't work with heigth="100%" with 

&lt;z:head&gt;

...
  * [issue 129](https://code.google.com/p/zkgrails/issues/detail?id=129) (chanwit)  Support auto-reloading for Comet
  * [issue 132](https://code.google.com/p/zkgrails/issues/detail?id=132) (chanwit)  Modify create-zul command to ignore package to conform Grails' convention
  * [issue 134](https://code.google.com/p/zkgrails/issues/detail?id=134) (chanwit)  Implement 1-1 releationship in scaffolding
  * [issue 135](https://code.google.com/p/zkgrails/issues/detail?id=135) (chanwit)  Implement 1-M releationship in scaffolding
  * [issue 139](https://code.google.com/p/zkgrails/issues/detail?id=139) (omadruga) Comet don't support more than one comet for the same composer
  * [issue 142](https://code.google.com/p/zkgrails/issues/detail?id=142) (chanwit)  Restarting Comets
  * [issue 148](https://code.google.com/p/zkgrails/issues/detail?id=148) (chanwit)  Copy ZK logo to the 'images' directory
  * [issue 152](https://code.google.com/p/zkgrails/issues/detail?id=152) (chanwit)  Script create-zul broken if grails.project.groupId contains dots
  * [issue 154](https://code.google.com/p/zkgrails/issues/detail?id=154) (chanwit)  Create the theme directory
  * [issue 47](https://code.google.com/p/zkgrails/issues/detail?id=47)  (chanwit)  Handle relationship in scaffolding
  * [issue 131](https://code.google.com/p/zkgrails/issues/detail?id=131) (chanwit)  Implement message in GrailsComposer
  * [issue 137](https://code.google.com/p/zkgrails/issues/detail?id=137) (chanwit)  Change trigger in Comet to accept 'every', support 'beforeExecute', 'afterExecute'
  * [issue 138](https://code.google.com/p/zkgrails/issues/detail?id=138) (chanwit)  Support jQuery4j
  * [issue 140](https://code.google.com/p/zkgrails/issues/detail?id=140) (chanwit)  Sub-plugin architecture
  * [issue 144](https://code.google.com/p/zkgrails/issues/detail?id=144) (chanwit)  Improve Comet template for before/after
  * [issue 145](https://code.google.com/p/zkgrails/issues/detail?id=145) (chanwit)  Upgrade ZK to 5.0.3
  * [issue 146](https://code.google.com/p/zkgrails/issues/detail?id=146) (omadruga) Ability to disable zscript variables lookup for better performance (for ZK 5.0.3+)
  * [issue 151](https://code.google.com/p/zkgrails/issues/detail?id=151) (chanwit)  Resolve also the GORM error messages in MessageHolder
  * [issue 153](https://code.google.com/p/zkgrails/issues/detail?id=153) (chanwit)  Upgrade ZK to 5.0.4
  * [issue 130](https://code.google.com/p/zkgrails/issues/detail?id=130) (chanwit)  Test 'forward' property

## Enhancements ##
  * This version ships with ZK 5.0.4.
  * Better handling 1-1 and 1-M relationships in dynamic scaffolding.
  * Sub-plugin architecture.
  * Comet enhancement.
  * Ship jQuery4j.