package multitenant.issue

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import groovy.transform.CompileStatic
import grails.plugins.metadata.*

@CompileStatic
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        System.setProperty('gorm.tenantId', 'TESTING')
        GrailsApp.run(Application, args)
    }
}
