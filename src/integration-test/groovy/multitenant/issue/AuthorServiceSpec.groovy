package multitenant.issue

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

import geb.spock.*
import spock.lang.Specification

@Integration
@Rollback
class AuthorServiceSpec extends Specification {
    AuthorService authorService

    void "tenant honored"() {
        given:
        System.setProperty('gorm.tenantId', 'TESTING')

        when:
        def result = authorService.tenantHonored()

        then:
        result.size() == 1
    }

    void "tenant not honored"() {
        given:
        System.setProperty('gorm.tenantId', 'TESTING')

        when:
        def result = authorService.tenantNotHonored()

        then:
        result.size() == 1
    }

}
