# ZKGrails: ZK plugin for Grails #

### We are raising funds to rewrite ZKGrails for Grails 2.4 and beyond ###

After rewriting, ZKGrails will be fully available on Github. Please support us. [Help us move ZKGrails forwards and being more accessible !!](https://www.bountysource.com/teams/zkgrails/fundraiser)

### ZKGrails 2.5.2 have been released !! ###

ZKGrails is a plugin for the next generation rapid Web development framework, [Grails](http://grails.org). Based on [ZK](http://zkoss.org), one of the leading RIA frameworks, ZKGrails adds and enhances its RIA development capabilities and seamlessly integrates it with Grails' infrastructures. This results in an advanced RIA framework featuring direct AJAX and convention-over-configuration.

**Looking for a demo?** Here's [Zello](http://zello.herokuapp.com/), a simple [Trello](http://trello.com)-clone developed using the latest version of ZKGrails - User: demo, Password: demo. You may notice Zello's running faster than several ZK applications you've tried. **Zello is highly optimized for responsiveness using a programming model permitted by Groovy**. Zello 0.9 is developed using Grails 2.2.2 and ZKGrails 2.2.1.

  * Latest Public Stable: [ZKGrails 2.5.2](http://repo.grails.org/grails/plugins/org/grails/plugins/zk/2.5.2/zk-2.5.2.zip) (ZK 7.0.3 & Grails 2.3 - 2.3.11)
  * [Source tar ball](https://docs.google.com/uc?export=download&id=0Bwd9Z7DnyqupM09XbWdMRUZuTE0) for 2.5.2

## Peer Support ##

You can use the mailing list [here](http://groups.google.com/group/zk-grails-user) for both support and development discussion.

## Commercial Support ##

The annual subscription for ZKGrails LTS (Long-Term Support) including the urgent bug fixing service is available [here](http://zkgrails.tumblr.com/premium-support).

&lt;wiki:gadget url="http://dl.dropbox.com/u/381580/zkgrails/intro.xml" width="450" height="350"/&gt;

## Quick Start ##
In your app's `grails-app/conf/BuildConfig.groovy`, add the Bintray repository like the following:
```
repositories {
    inherits true
    mavenRepo "http://dl.bintray.com/zkgrails/release"
    ...
}
```

Next, in the `plugins` block, put the following lines:
```
plugins {
    compile ":zk:2.5.2"              // ZK plugin
    compile ":zk-angular:1.0.0.M3"   // ZK Angular support
    compile ":zk-bootstrap:1.0.0"    // ZK Bootstrap support
    compile ":zk-atlantic:1.0.1"     // ZK Atlantic flat theme
    ...
}
```

Then
```
$ grails refresh-dependencies
```

Type
```
$ grails create-zul index
```
will give you
  * `grails-app/zul/index.zul` linked with `IndexComposer`
  * `grails-app/composers/IndexComposer.groovy`, the composer class.

Then
```
$ grails run-app
```

and point your browser to
```
http://localhost:8080/<your app>/index.zul
```

As of version 0.7, auto reloading is fully supported.

To create only a composer, you can type $ `grails create-composer <name>`.

If you are going to create zul files manually, please use this template for your .zul files. `AnnotateDataBinderInit` is for data-binding support. `DelegatingVariableResolver` is for injecting Spring beans, and `GroovyGrails` is for making Grails classes work for you.

```
<?xml version="1.0" encoding="UTF-8"?>
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
<?variable-resolver class="org.zkoss.zkplus.spring.DelegatingVariableResolver"?>

<?page zscriptLanguage="GroovyGrails"?>
```

## News ##
  * **`18-Sep-2014`** ZKGrails 2.5.1 has been released. This version added the support for .xhtml in `grails-app/zul` making you easier to work with ZK-Angular and existing themes.
  * **`08-Sep-2014`** ZKGrails 2.5.0 and ZKGrails Angular 1.0.0.M3 have been released. This version ships with ZK 7.0.3. Binding Angular.JS with ZK-MVVM is now supported by ZKGrails.
  * **`31-Aug-2014`** ZKGrails 2.5.0 will be delay a bit as we are waiting for the exciting ZK 7.0.3 release which supports ZK-Angular integration. Please stay tuned.
  * **`01-May-2014`** ZKGrails 2.4.0 has been released publicly. This version supports Grails 2.3 - 2.3.8 with ZK 7.0.1.
  * **`26-Mar-2014`** ZKGrails 2.3.4 has been released in the LTS. This version supports Grails 2.3 - 2.3.7 and ships with the new ZK 7.0.1 !!
  * **`24-Feb-2014`** ZKGrails 2.3.3 has been released in the LTS. This version supports Grails 2.3 - 2.3.6. Due to [a security exploit](http://cxsecurity.com/issue/WLB-2014020172) in Grails 2.3.5, it is **strongly** recommended for users to upgrade to Grails 2.3.6 and ZKGrails 2.3.3.
  * **`07-Feb-2014`** ZKGrails 2.3.2 has been released in the LTS.
  * **`17-Jan-2014`** ZKGrails 2.3.1 has been released on the Grails central as well as the Bintray and the LTS repository. This version contains fixes for several development issues and now supports Grails 2.3.5. Enjoy!
  * **`28-Dec-2013`** ZKGrails 2.3.0 has been released on the Grails central repository. This version ships with ZK 7. Merry X-mas and happy new year !!
  * **`21-Nov-2013`** ZKGrails 2.2.11 has been released in the LTS repository.
  * **`07-Nov-2013`** ZKGrails 2.2.10 has been released in the LTS repository. This version upgraded ZK to 6.5.4.
  * **`31-Oct-2013`** ZKGrails 2.3.0.M3 has been released in the LTS repository. This version ships with ZK 7-RC and has been tested against Grails 2.3.1.
  * **`18-Oct-2013`** ZKGrails 2.3.0.M2 has been released in the LTS repository. This version also supports Grails 2.3.1.
  * **`30-Sep-2013`** ZKGrails 2.2.9 has been released in the LTS repository. This version contains minor bug fixes.
  * **`18-Sep-2013`** ZKGrails 2.2.8 has been released in the LTS repository. This version contains ZK 6.5.3 and has been tested against Grails 2.2 - 2.2.4.
  * **`29-Aug-2013`** Because Grails 2.3 is still in the RC state, we have to postpone our ZKGrails 2.3 until Grails 2.3 is released. So we decided to release our best version of ZKGrails at the moment to the Grails central repository. ZKGrails 2.2.7 publicly released today.
  * **`19-Aug-2013`** ZKGrails 2.2.7 has been released in the LTS repository.
  * **`16-Aug-2013`** ZKGrails 2.2.6 has been released in the LTS repository.
  * **`31-Jul-2013`** ZKGrails 2.3.0.M1 has been released in the LTS repository. This is the first milestone for the 2.3 series.
  * **`12-Jul-2013`** ZKGrails 2.2.5 has been released in the LTS repository.
  * **`28-Jun-2013`** ZKGrails 2.2.4 has been released in the LTS repository.
  * **`14-Jun-2013`** ZKGrails 2.2.3 has been released in the LTS repository.
  * **`31-May-2013`** ZKGrails 2.2.2 has been released in the LTS repository with several bug fixes. It's a drop-in replacement for 2.2.1.
  * **`18-May-2013`** ZKGrails 2.2.1 has been released in the LTS repository. This version includes important bug fixes and supports Grails 2.2.2. **For production deployment, it is strongly recommended to upgrade to this version.**
  * **`28-Apr-2013`** ZKGrails 2.2.0 has been released !!
  * **`23-Mar-2013`** ZKGrails 2.2.0.M8 has been released in the LTS. This is the last milestone before the 2.2 GA.
  * **`16-Apr-2013`** ZKGrails 2.2.0.M7 (Binary identical to 2.2.0.M6) has been released in the LTS. It's the first official version to support Grails 2.2.x and this version contains ZK 6.5.2. We are moving towards the ZKGrails 2.2.
  * **`17-Mar-2013`** ZKGrails 2.2.0.M5 has been released in the LTS.
  * **`09-Feb-2013`** ZKGrails 2.2.0.M4 has been released in the LTS.
  * **`01-Feb-2013`** ZKGrails 2.2.0.M3 has been released in the LTS.
  * **`16-Jan-2013`** ZKGrails 2.2.0.M2 has been released in the LTS.
  * **`07-Jan-2013`** ZKGrails 2.2.0.M1 has been released in the LTS.
  * **`29-Dec-2012`** ZKGrails 2.1.0 has been released. This version ships with ZK 6.5.1.1.
  * **`30-Aug-2012`** ZKGrails 2.0.0 has been released. This version ships with ZK 6.0.2.
  * **`24-Jun-2012`** ZKGrails 2.0.0.M9 with ZK 6.0.1 and Live! has been released.
  * ...
  * **`19-Aug-2008`** ZK Plugin for Grails version 0.5 has been released.
[News Archive](NewsArchive.md)

© 2008-2014 The ZKGrails Project