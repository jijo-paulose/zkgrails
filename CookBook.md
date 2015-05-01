### A FAQ of conventions used in ZKGrails ###

**1 How to refer to a composer from the zul page**
```
<window apply="com.nthdimenzion.composer.bookListComposer"
```

here I have a `BookListComposer.groovy` under package com.nthdimenzion.composer.

> here zkgrails automatically creates abean of BookListComposer and   assigns     it the id

```
com.nthdimenzion.composer.bookListComposer
```
, bean scope is prototype.

> To invoke methods on the composer use
```
model="@{bookListWnd$composer.allBooks}"
```

> Where bookListWnd is the window id and “$composer” is a static convention      used for all composers.

For example if window id is hello, its composer is accessed as hello$composer.allBooks

Example
```
…..
<listitem self="@{each='book'}" 
	value="@{book}" tooltiptext="Double Click here to see the details">
	<attribute name="onDoubleClick">
	bookListWnd$composer.showBookDetails(self.value);
	</attribute>
…..
```



**2	How to use ZK Grails expressions**
Use #{}
> Example
```
<button id="Save" label="Save" if="#{isAdmin}"></button>
```
Where admin is Boolean variable


**3	How to invoke a global function**
```
<zscript>
	import org.zkoss.zul.Button;
	sayHello = {button->
		alert ('Hello world ' + button.label)
	}
	</zscript>
```

```
<button label="Test" onClick="sayHello(self)"></button>
```


**4	How to define a global variable**
```
isAdmin = SpringSecurityUtils.ifAllGranted("ADMIN_ROLE");
```
Note how no type name is used

Note function here implies closure and there is no “def” keyword