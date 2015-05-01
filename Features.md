### Simpler way for register events ###
> Provides a more intuitive way to register events to any component with the methods onEventName, addOnEventName and removeOnEventName.

This is a sneak peek of what zkgrails does for you, using only java you register an event this way:
```
 void init(Component comp) {
     comp.addEventListener("onClick", new MyListener());
 }
 class MyListener implements org.zkoss.zk.ui.event.EventListener {
     public void onEvent(Event event) throws UiException {
         ...//processing the event
     }
 }
```

And with zkgrails your code is simplified to:
```
 void init(Component comp) {
     comp.onClick { event ->
         ...//processing the event
     }
 }
```

> more details here to came (TBD)

### Sugar syntax to add components via append method ###
> All zk components receive a dynamic method called "append" with one parameter (a Closure), it will delegated to ZkBuilder to build the components:
```
  def div = new Div()
  div.append {
      label(value: "What is your name?")
      textbox('txbName')
  }
```
> Felipe Cypriano blogged about this feature: [How to Create Components in Runtime with Builder](http://felipecypriano.com/blog/2010/03/04/grails-with-zk-how-to-create-components-in-runtime-with-the-builder)

### Sugar syntax to access zk session variables (as done with grails) (since 0.7.7 - Not yet released) ###
> You can now access zk session variables in the same way as in grails session, ie, session.variable. It's a short cut to session.getAttribute(name) and session.setAttribute(name, value)

### Simpler way the create components via ZkBuilder (since 0.7.0) ###
> ZkBuilder provides a nice way to create zk components, following groovy Builder paradigm.

> More detail on ZkBuilder (TBD)


> Enhancements (since 1.0M4)
  1. Supports adding client side events. If the parameter on onEvent it's a String, it assumes that is a client side event, if it's a Closure, then it's a server side event:
```
    textbox(onChange: "alert('Say hi from JS');"
```
  1. Supports components defined on lang-addon.xml:
> > Let's say you have a macro component called tbbdelete defined on lang.addon.xml:
```
    <component>
        <component-name>tbbdelete</component-name>
        <extends>toolbarbutton</extends>
        <component-class>package.class</component-class>
    </component>
```
> > You can then use tbbdelete on the builder:
```
    div {
        tbbdelete(label: 'delete user');
    }
```
> > The rule is just to use the same name defined on component-name. Also, if you override a zk component on lang-addon.xml, it will use your versoin.
  1. Supports the forward property (which works just like the one you use on .zul pages):
```
    textbox(forward: "onChange=onTextChange,onChange=onAnotherMethod,onChanging=onChanging")
```
> > Use the same spec from [ZK docs](http://www.zkoss.org/javadoc/5.0/zk/org/zkoss/zk/ui/metainfo/ComponentInfo.html#setForward(java.lang.String))

### build property available on composer that take advantage of ZkBuilder (since 0.7.6) ###

> You can now use the `build` property, a ZkBuilder of the current ZUL page, inside your GrailsComposer to create ZK user-interface.

### Embedding zul pages on grails gsp (since 0.7.6) ###
> You can now embed a ZUL page (as fragments) into a GSP using two tags: `<z:head/>` and `<z:body/>`. So you can leverage UrlMapping and also Sitemesh decoration for your ZUL pages. Thanks wehe@gmx.at, for this contribution.

> Both tags accept zul="your zul page" attribute, like: `<z:body zul="/test/index.zul"/>`. And by default, these tags **automatically** detect from which controller or action you're rendering. If you're rendering a page from `TestController.index`, then both tags find the `/test/index.zul` file for you. This is the same convention used by Grails' views.

### Scaffolding support (since 0.8 - not yet released) ###
> TBD