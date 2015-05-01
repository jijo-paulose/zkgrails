# Details #
  * configure `grails-app/conf/BuildConfig.groovy`:
```
grails.plugin.repos.discovery.zkgrails="http://zkgrails.googlecode.com/svn/plugins"
grails.plugin.repos.resolveOrder=['zkgrails','default','core']
```
  * `grails clean`
  * `grails release -repository=zkgrails`
  * fetch plugin-meta manually (using an SVN client)
  * change https to http and remove port number