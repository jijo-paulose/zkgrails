class ZkGrailsPlugin {

    def version = "0.6"
    def dependsOn = [:]

    // TODO Fill in these fields
    def author = "chanwit"
    def authorEmail = ""
    def title = "ZK (3.5) for Grails"
    def description = '''\
Derived from Flyisland ZK Grails Plugin, This plugin adds ZK Ajax framework (www.zkoss.org) support into Grails applications
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/Zk+Plugin"

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }

    def doWithApplicationContext = { applicationContext ->

    }

    def doWithWebDescriptor = { xml ->
        // quick hack for page filtering
        def pageFilter = xml.filter.find { it.'filter-name' == 'sitemesh'}
        pageFilter.'filter-class'.replaceBody('org.zkoss.zkgrails.ZKGrailsPageFilter')

        def listenerElements = xml.'listener'[0]
        listenerElements + {
            'listener' {
                'display-name' ("ZK Session Cleaner")
                'listener-class' ("org.zkoss.zk.ui.http.HttpSessionListener")
            }
        }

        def servletElements = xml.'servlet'[0]
        def mappingElements = xml.'servlet-mapping'[0]

        servletElements + {
            'servlet' {
                'servlet-name' ("zkLoader")
                'servlet-class' ("org.zkoss.zk.ui.http.DHtmlLayoutServlet")
                'init-param' {
                    'param-name' ("update-uri")
                    'param-value' ("/zkau")
                }
                'load-on-startup' (0)
            }
        }

        def urls = ["*.zul", "*.zhtml", "*.svg", "*.xml2html"]
        urls.each {p ->
            mappingElements + {
                'servlet-mapping' {
                'servlet-name'("zkLoader")
                'url-pattern'("${p}")
                }
            }
        }

        servletElements + {
            'servlet' {
                'servlet-name' ("auEngine")
                'servlet-class' ("org.zkoss.zk.au.http.DHtmlUpdateServlet")
            }
        }
        mappingElements + {
            'servlet-mapping' {
            'servlet-name'("auEngine")
            'url-pattern'("/zkau/*")
            }
        }
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
