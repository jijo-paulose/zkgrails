# Introduction #

The next instruction is intended to show a basic example of using ZEST with a zkgrails project, so we can call our .zul files like this http://localhost:8080/myapp/list instead of http://localhost:8080/myapp/list.zul


# Details #

**1 -** create a grais project: _grails create-app myapp_

**2 -** install zkgrails plugin: _grails install-plugin zk-ee_ (perhaps only zk would be enough, but haven't test it yet)

**3 -** download ZEST binary from http://code.google.com/p/zest/downloads/list

**4 -** copy zest.jar from de zip file downloaded to myapp/lib

**5 -** create a groovy class, Foo for example like this:

_`package my`_

_`class Foo {`_

> _`public String execute() {`_
> > _`return "success";`_

> _`}`_

_`}`_

**6 –** create zul file with composer: _grails create-zul test_

**7 -** TestComposer.groovy and test.zul shoud be something like this:

**_`test.zul`_**

> _`<window apply="myapp.testComposer">`_

> _`<hbox>`_
> > _`<image src="${z.resource(dir:'images', file:'grails_logo.png')}"/>`_

> _`</hbox>`_

> _`<label id="lbl"/>`_

> _`</window>`_

**_`TestComposer`_**

_`import org.zkoss.zkgrails.*`_

_`class TestComposer extends GrailsComposer {`_

> _`def lbl`_

> _`def afterCompose = { window ->`_
> > _`// initialize components here`_
> > _`lbl.value="loaded!"`_

> _`}`_
_`}`_

**8 -** install templates will enable us to modify web.xml: _grails install-templates_

**9 –** open myapp/src/templates/war/web.xml and add these lines before charEncodingFilter :

_`<filter>`_
> _`<filter-name>zest</filter-name>`_
> _`<filter-class>org.zkoss.zest.sys.ZestFilter</filter-class>`_
_`</filter>`_

_`<filter-mapping>`_
> _`<filter-name>zest</filter-name>`_
> _`<url-pattern>/*</url-pattern>`_
_`</filter-mapping>`_

**10 –** create a zest.xml under myapp/web-app/WEB-INF/ with the following content:

_`<?xml version="1.0" encoding="UTF-8"?>`_

_`<zest>`_
> _`<action path="/foo" class="my.Foo">`_
> > _`<result name="success">/test.zul</result>`_

> _`</action>`_
_`</zest>`_

**11 –** run project: _grails run-app_

**12 –** call _http://localhost:8080/myapp/foo_ and will be the same as if you call  _http://localhost:8080/myapp/test.zul_

**13 –** more features about ZEST please visit http://books.zkoss.org/wiki/ZEST_Essentials

**14 –** Enjoy!