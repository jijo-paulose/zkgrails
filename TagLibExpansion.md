
```
${sec.ifAllGranted(role:'ROLE_NAME')}
```
implemented in -->
```
def ifAllGranted = { attrs, body ->
  out << '$' + "z:invoke('securityService', 'ifAllGranted', ['${attrs.remove('role')}']"
}
```
expands to -->
```
${z:invoke('securityService', 'ifAllGranted', ['ROLE_NAME'])}
```
declared as TLD -->
```
<taglib>
    <function>
        <name>browser</name>
        <function-class>org.zkoss.web.fn.ServletFns</function-class>
        <function-signature>
    boolean isBrowser(java.lang.String)
        </function-signature>
        <description>
    Whether the current request is coming from the browser of the specified
    type.
        </description>
    </function>
    <function>
        <name>l</name>
        <function-class>org.zkoss.xel.fn.CommonFns</function-class>
        <function-signature>java.lang.String getLabel(java.lang.String)</function-signature>
        <description>
        Returns the label of the specified key.
        </description>
    </function>
</taglib>
```
which actually invokes -->
```
static Object 	invokeMethod(Object object, String methodName, Object arguments) 
```