Updated to ZKGrails 2.1.0 and Grails 2.1.3

This is a ZKGrails port of the program written in http://docs.zkoss.org/wiki/Use_Load-On-Demand_to_Handle_Huge_Data. This tutorial is working for ZKGrails 2.1 ~~1.0~~ ~~0.7.1~~ and later.

For ZKGrails 1, please refer to this tutorial: LoadOnDemand.

## Create a Grails project ##

Prepare a Grails project for this tutorial by type creating the app:

$ `grails create-app ondemand`

## Install ZKGrails ##

Next, install ZKGrails. Put the following dependencies into the `plugins` block in your `conf/BuildConfig.groovy`:

```
    compile ":zk:2.1.0"
```


## Create a domain class ##

We are going to demonstrate with a simple domain class, `Employee`. To create a domain class in Grails, simply use the command `create-domain-class`, following by your class name:

$ `grails create-domain-class employee`

## Adding Properties for Employee ##

We then add two properties into domain class Employee, namely fullname and username. Both are string.

```
package ondemand

class Employee {

    String fullname
    String username

    static constraints = {
    }

}

```

## Create a zul page ##

$ `grails create-zul employee`

This will also create `grails-apps/composers/ondemand/EmployeeComposer.groovy` for you.

## Edit employee.zul ##

```
<window apply="ondemand.EmployeeComposer">

    <vbox>
        <image src="${z.resource(dir:'images', file:'grails_logo.png')}"/>
    </vbox>

    <listbox id="lstEmployee" width="100%" checkmark="true">
        <listhead sizable="true">
            <listheader label="ID" sort="auto" />
            <listheader label="Full Name" sort="auto" />
            <listheader label="User Name" sort="auto" />
        </listhead>
  </listbox>
  <paging id="pagEmployee" pageSize="30" />

</window>
```

Please note that `${z.resource(...)}` will pick an image from `web-app/ext/images` to avoid conflictions with the Resources plugin.

## Edit `EmployeeComposer.groovy` ##

From the code, you may find the use of `$(...)` in several places. It's a jQuery-like selector that accepts CSS-3 syntax and queries UI components for you. Rather than injecting UI components, using the selector works better when UI components are expected to change frequently.

Apparently, `$('#pagEmployee')` selects _all_ the paging component with `id="pagEmployee"`. Note that a selector always return a list of UI components, similar behaviour done by jQuery. So, when we would like to refer to a single component, we have to get the first one using subscription `[0]`.

You may notice that there is a closure named `afterCompose`. This closure is invoked by doAfterCompose, and it's a Groovy place to initialize your UI.

We use `.on('paging', { ... })` to wire a `Paging` event handler to `pagEmployee`. The event will be fired every time you click `pagEmployee` to change the active page. Note that, the argument of the handler will be of type `PagingEvent` which implements interface `Event`.

An interesting selector is `$('#lstEmployee listitem')` which selects all `listitem` elements inside `lstEmployee`. We select and detach them out of `lstEmployee` every time before adding a new set of `listitem` components with new data.

I also show you the use of Groovy's default argument value declared at `redraw` method. That is, calling `redraw()` in `afterCompose` means `redraw(0)`.

Also in method `redraw`, there is a call to the dynamic method `append`, which accepts component construction via the ZK Builder.

```
package ondemand


class EmployeeComposer {

    def afterCompose = { c ->

        $('#pagEmployee')[0].totalSize = Employee.count()

        $('#pagEmployee').on('paging', {
            redraw($(it).getActivePage())
        })

        redraw()
    }

    def redraw(page=0) {
        def pageSize = $('#pagEmployee').getPageSize()
        def list = Employee.list(offset: page * pageSize,
                                 max:    pageSize)

        try {
            $('#lstEmployee listitem').detach()
        } catch(ignored) { /* do nothing */ }
        $('#lstEmployee').append {
            list.each { e ->
                listitem(value: e) {
                    listcell(label: e.id)
                    listcell(label: e.fullname)
                    listcell(label: e.username)
                }
            }
        }
    }

}
```

## Testing Data ##

Before getting your application run, you need some testing data to show. Open `grails-app/conf/BootStrap.groovy`, and then add the following snippet into `init` closure.

```
     def init = { servletContext ->
        1000.times { i ->
            new Employee(fullname: "Name $i", username: "user$i").save()
        }
     }
```

With the above code, we loop 1,000 times to create 1,000 domain objects of class `Employee`.

## Run the application ##
$ `grails run-app`

and point your browser to http://localhost:8080/ondemand/employee.zul