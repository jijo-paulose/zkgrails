Updated for ZKGrails 1.0 and Grails 1.3.5

This is a ZKGrails port of the program written in http://docs.zkoss.org/wiki/Use_Load-On-Demand_to_Handle_Huge_Data. This tutorial is working for ZKGrails 1.0 ~~0.7.1~~ and later.

## Create a Grails project ##

You need to prepare a Grails project for this tutorial by type:

$ `grails create-app ondemand`

## Install ZKGrails ##

Next, you need to install ZKGrails. The latest version will be installed automatically, when type:

$ `grails install-plugin zk`

## Create a domain class ##

We are going to demonstrate with a simple domain class, Employee. To create domain class in Grails, simply use the command `create-domain-class`, following by your class name:

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
<window apply="ondemand.employeeComposer">

    <vbox>
        <image src="images/grails_logo.jpg"/>
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

## Edit `EmployeeComposer` ##

From the code, you may see 2 properties `lstEmployee`, and `pagEmployee`. Both are injected by `GrailsComposer`, which is a subclass of `GenericForwardComposer`. They, apparently, represents listbox and paging components from your .zul file.

You may notice that there is `afterCompose` closure. This closure is run by doAfterCompose, and it's a Groovy place to initialize your components.

The auto-wired event handle `onPaging_pagEmployee` will be called everytime you click pagEmployee to change the active page. Note that, the only argument of the handler must be `ForwardEvent` or `Event` to make it work.

I also show you the use of Groovy's default argument value declared at `redraw` method. That is, calling `redraw()` in `afterCompose` means `redraw(0)`.

Also in `redraw` method, there are two places to use dynamic methods added by ZKGrails. The first one is listbox#clear, of which removes all listitem. The second one is append, which accepts component construction via ZK Builder.

```
package ondemand

import org.zkoss.zkgrails.*
import org.zkoss.zk.ui.event.*

class EmployeeComposer extends GrailsComposer {

    def lstEmployee
    def pagEmployee

    def afterCompose = { c ->
        pagEmployee.totalSize = Employee.count()
        redraw()
    }

    def onPaging_pagEmployee(ForwardEvent fe) {
        def e = fe.origin
        redraw(e.activePage)
    }

    def redraw(page=0) {
        def list = Employee.list(offset: page * pagEmployee.pageSize,
                                 max: pagEmployee.pageSize)

        lstEmployee.items*.detach()
        lstEmployee.append {
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